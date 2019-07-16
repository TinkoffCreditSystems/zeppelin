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
package ru.tinkoff.zeppelin.interpreter.jdbc.simple;

import ru.tinkoff.zeppelin.commons.jdbc.AbstractJDBCInterpreter;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;


public class JDBCSimpleInterpreter extends AbstractJDBCInterpreter {

  @Override
  public Iterator<String> getStatementIterator(@Nonnull final String statements) {
    return Arrays.stream(statements.split(";"))
        .filter(s -> !s.trim().isEmpty())
        .collect(Collectors.toList())
        .iterator();
  }
}
