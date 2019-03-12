/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zeppelin.shell;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.lang3.StringUtils;
import org.apache.zeppelin.interpreter.core.Interpreter;
import org.apache.zeppelin.interpreter.core.InterpreterContext;
import org.apache.zeppelin.interpreter.core.InterpreterResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Shell interpreter for Zeppelin.
 */
public class ShellInterpreter extends Interpreter {
  private static final Logger LOGGER = LoggerFactory.getLogger(ShellInterpreter.class);

  private static final String TIMEOUT_PROPERTY = "shell.command.timeout.millisecs";
  private String defaultTimeoutProperty = "60000";

  private static final String DIRECTORY_USER_HOME = "shell.working.directory.user.home";
  private final boolean isWindows = System.getProperty("os.name").startsWith("Windows");
  private final String shell = isWindows ? "cmd /c" : "bash -c";
  ConcurrentHashMap<String, DefaultExecutor> executors;

  public ShellInterpreter(Properties property) {
    super(property);
  }

  @Override
  public void open() {
    LOGGER.info("Command timeout property: {}", getProperty(TIMEOUT_PROPERTY));
    executors = new ConcurrentHashMap<>();
  }

  @Override
  public void close() {
    for (String executorKey : executors.keySet()) {
      DefaultExecutor executor = executors.remove(executorKey);
      if (executor != null) {
        try {
          executor.getWatchdog().destroyProcess();
        } catch (Exception e){
          LOGGER.error("error destroying executor for paragraphId: " + executorKey, e);
        }
      }
    }
  }


  @Override
  public InterpreterResult interpret(String originalCmd, InterpreterContext contextInterpreter) {
    //String cmd = Boolean.parseBoolean(getProperty("zeppelin.shell.interpolation")) ?
    //        interpolate(originalCmd, contextInterpreter.getResourcePool()) : originalCmd;

    String cmd = originalCmd;
    LOGGER.debug("Run shell command '" + cmd + "'");
    OutputStream outStream = new ByteArrayOutputStream();
    
    CommandLine cmdLine = CommandLine.parse(shell);
    // the Windows CMD shell doesn't handle multiline statements,
    // they need to be delimited by '&&' instead
    if (isWindows) {
      String[] lines = StringUtils.split(cmd, "\n");
      cmd = StringUtils.join(lines, " && ");
    }
    cmdLine.addArgument(cmd, false);

    try {
      DefaultExecutor executor = new DefaultExecutor();
      //executor.setStreamHandler(new PumpStreamHandler(contextInterpreter.out, contextInterpreter.out));

      executor.setWatchdog(new ExecuteWatchdog(
          Long.valueOf(getProperty(TIMEOUT_PROPERTY, defaultTimeoutProperty))));
      executors.put(contextInterpreter.getParagraphId(), executor);
      if (Boolean.valueOf(getProperty(DIRECTORY_USER_HOME))) {
        executor.setWorkingDirectory(new File(System.getProperty("user.home")));
      }

      int exitVal = executor.execute(cmdLine);
      LOGGER.info("Paragraph " + contextInterpreter.getParagraphId() 
          + " return with exit value: " + exitVal);
      return new InterpreterResult(InterpreterResult.Code.SUCCESS, outStream.toString());
    } catch (ExecuteException e) {
      int exitValue = e.getExitValue();
      LOGGER.error("Can not run " + cmd, e);
      InterpreterResult.Code code = InterpreterResult.Code.ERROR;
      String message = outStream.toString();
      if (exitValue == 143) {
        code = InterpreterResult.Code.INCOMPLETE;
        message += "Paragraph received a SIGTERM\n";
        LOGGER.info("The paragraph " + contextInterpreter.getParagraphId()
            + " stopped executing: " + message);
      }
      message += "ExitValue: " + exitValue;
      return new InterpreterResult(code, message);
    } catch (IOException e) {
      LOGGER.error("Can not run " + cmd, e);
      return new InterpreterResult(InterpreterResult.Code.ERROR, e.getMessage());
    } finally {
      executors.remove(contextInterpreter.getParagraphId());
    }
  }

  @Override
  public void cancel(InterpreterContext context) {
    DefaultExecutor executor = executors.remove(context.getParagraphId());
    if (executor != null) {
      try {
        executor.getWatchdog().destroyProcess();
      } catch (Exception e){
        LOGGER.error("error destroying executor for paragraphId: " + context.getParagraphId(), e);
      }
    }
  }

  @Override
  public FormType getFormType() {
    return FormType.SIMPLE;
  }

  @Override
  public int getProgress(InterpreterContext context) {
    return 0;
  }


//  @Override
//  public List<InterpreterCompletion> completion(String buf, int cursor,
//                                                InterpreterContext interpreterContext) {
//    return null;
//  }

//  @Override
//  protected boolean runKerberosLogin() {
//    try {
//      createSecureConfiguration();
//      return true;
//    } catch (Exception e) {
//      LOGGER.error("Unable to run kinit for zeppelin", e);
//    }
//    return false;
//  }
//
//  public void createSecureConfiguration() throws InterpreterException {
//    Properties properties = getProperties();
//    CommandLine cmdLine = CommandLine.parse(shell);
//    cmdLine.addArgument("-c", false);
//    String kinitCommand = String.format("kinit -k -t %s %s",
//        properties.getProperty("zeppelin.shell.keytab.location"),
//        properties.getProperty("zeppelin.shell.principal"));
//    cmdLine.addArgument(kinitCommand, false);
//    DefaultExecutor executor = new DefaultExecutor();
//    try {
//      executor.execute(cmdLine);
//    } catch (Exception e) {
//      LOGGER.error("Unable to run kinit for zeppelin user " + kinitCommand, e);
//      throw new InterpreterException(e);
//    }
//  }

//  @Override
//  protected boolean isKerboseEnabled() {
//    if (!StringUtils.isAnyEmpty(getProperty("zeppelin.shell.auth.type")) && getProperty(
//        "zeppelin.shell.auth.type").equalsIgnoreCase("kerberos")) {
//      return true;
//    }
//    return false;
//  }

}
