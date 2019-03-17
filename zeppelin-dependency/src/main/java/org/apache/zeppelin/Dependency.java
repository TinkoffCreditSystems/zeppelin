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

package org.apache.zeppelin;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class Dependency implements Serializable {
  private final String groupArtifactVersion;
  private boolean local = false;
  private final List<String> exclusions;


  public Dependency(final String groupArtifactVersion) {
    this.groupArtifactVersion = groupArtifactVersion;
    exclusions = new LinkedList<>();
  }

  @Override
  public boolean equals(final Object o) {
    if (!(o instanceof Dependency)) {
      return false;
    } else {
      return ((Dependency) o).groupArtifactVersion.equals(groupArtifactVersion);
    }
  }

  /**
   * Don't add artifact into SparkContext (sc.addJar())
   * @return
   */
  public Dependency local() {
    local = true;
    return this;
  }

  public Dependency excludeAll() {
    exclude("*");
    return this;
  }

  /**
   *
   * @param exclusions comma or newline separated list of "groupId:ArtifactId"
   * @return
   */
  public Dependency exclude(final String exclusions) {
    for (final String item : exclusions.split(",|\n")) {
      this.exclusions.add(item);
    }

    return this;
  }


  public String getGroupArtifactVersion() {
    return groupArtifactVersion;
  }

  public boolean isDist() {
    return !local;
  }

  public List<String> getExclusions() {
    return exclusions;
  }

  public boolean isLocalFsArtifact() {
    final int numSplits = groupArtifactVersion.split(":").length;
    return !(numSplits >= 3 && numSplits <= 6);
  }
}
