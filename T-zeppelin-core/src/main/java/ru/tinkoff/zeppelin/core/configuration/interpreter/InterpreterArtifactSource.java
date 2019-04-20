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

package ru.tinkoff.zeppelin.core.configuration.interpreter;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import java.io.Serializable;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.StringJoiner;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Interpreter source. Installs at runtime by maven artifact.
 *
 * @see ru.tinkoff.zeppelin.engine.server.InterpreterInstaller
 */
public class InterpreterArtifactSource implements Serializable {

  /**
   * Types of interpreter processes.
   */
  public enum Status {
    NOT_INSTALLED,
    INSTALLED
  }

  @Nonnull
  private String interpreterName;

  @Nonnull
  private String artifact;

  /**
   * {@code null} if source is not installed, absolute path otherwise.
   */
  @Nullable
  private String path;

  @Nonnull
  private Status status;

  /**
   * if {@code true} - source would be reinstalled on app restart.
   */
  private boolean reinstallOnStart;

  public InterpreterArtifactSource(@Nonnull final String interpreterName,
                                   @Nonnull final String artifact,
                                   @Nullable final String path,
                                   @Nonnull final Status status,
                                   final boolean reinstallOnStart) {
    Preconditions.checkArgument(isValidAbsolutePathOrNull(path), "Wrong path: %s", path);
    Preconditions.checkNotNull(status);
    Preconditions.checkNotNull(interpreterName);
    Preconditions.checkNotNull(artifact);

    //TODO(egorklimov): add regexp check for artifact
    this.interpreterName = interpreterName;
    this.artifact = artifact;
    this.path = path;
    this.status = status;
    this.reinstallOnStart = reinstallOnStart;
  }

  public InterpreterArtifactSource(@Nonnull final String interpreterName,
                                   @Nonnull final String artifact) {
    //TODO(egorklimov): add regexp check for artifact
    Preconditions.checkNotNull(interpreterName);
    Preconditions.checkNotNull(artifact);

    this.interpreterName = interpreterName;
    this.artifact = artifact;
    this.status = Status.NOT_INSTALLED;
    this.reinstallOnStart = false;
  }

  @Nonnull
  public String getInterpreterName() {
    return interpreterName;
  }

  public void setInterpreterName(@Nonnull final String interpreterName) {
    this.interpreterName = interpreterName;
  }

  @Nonnull
  public String getArtifact() {
    return artifact;
  }

  public void setArtifact(@Nonnull final String artifact) {
    //TODO(egorklimov): add regexp check for artifact
    this.artifact = artifact;
  }

  @Nullable
  public String getPath() {
    return path;
  }

  /**
   * Sets path to downloaded .jar, {@code null} when source is not installed
   *
   * @param path New aboslute path to .jar or {@code null}.
   */
  public void setPath(@Nullable final String path) {
    Preconditions.checkArgument(isValidAbsolutePathOrNull(path), "Wrong path: %s", path);
    this.path = path;
  }

  // Status, везде через enum
  @Nonnull
  public Status getStatus() {
    return status;
  }

  public void setStatus(@Nonnull final Status status) {
    Preconditions.checkNotNull(status);
    this.status = status;
  }

  /**
   * Validates path.
   *
   * @param path absolute path to .jar or {@code null} if source is not installed.
   * @return {@code true} if correct path or {@code null}, {@code false} otherwise.
   */
  private static boolean isValidAbsolutePathOrNull(@Nullable final String path) {
    try {
      if (path != null) {
        return Paths.get(path).isAbsolute();
      }
      return true;
    } catch (final InvalidPathException | NullPointerException ex) {
      return false;
    }
  }

  public boolean isReinstallOnStart() {
    return reinstallOnStart;
  }

  public void setReinstallOnStart(final boolean reinstallOnStart) {
    this.reinstallOnStart = reinstallOnStart;
  }

  public static InterpreterArtifactSource fromJson(@Nonnull final String json) {
    Preconditions.checkNotNull(json);
    final InterpreterArtifactSource source = new Gson().fromJson(json, InterpreterArtifactSource.class);
    Preconditions.checkNotNull(source);
    Preconditions.checkNotNull(source.artifact);
    Preconditions.checkNotNull(source.interpreterName);

    if (source.status == null) {
      source.setStatus(Status.NOT_INSTALLED);
    }

    Preconditions.checkNotNull(source.status);
    Preconditions.checkState(isValidAbsolutePathOrNull(source.getPath()), "Wrong path: %s", source.getPath());
    //TODO(egorklimov): add regexp check for artifact

    return source;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "{", "}")
        .add("interpreterName='" + interpreterName + "'")
        .add("artifact='" + artifact + "'")
        .add("path='" + path + "'")
        .add("status='" + status + "'")
        .add("reinstallOnStart='" + reinstallOnStart + "'")
        .toString();
  }
}
