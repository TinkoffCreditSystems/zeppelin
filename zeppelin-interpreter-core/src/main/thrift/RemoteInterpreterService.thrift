/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

namespace java org.apache.zeppelin.interpreter.core.thrift

struct PushResult {
  1: string status,
  2: string interpreterJobUUID,
  3: string interpreterProcessUUID
}

struct CancelResult {
  1: string status,
  2: string interpreterJobUUID,
  3: string interpreterProcessUUID
}

struct PingResult {
  1: string status,
  2: string interpreterProcessUUID
}

service RemoteInterpreterService {

  PushResult push(1: string st, 2: map<string, string> noteContext, 3: map<string, string> userContext, 4:  map<string, string> configuration);
  CancelResult cancel(1: string UUID);

  PingResult ping();

  void shutdown();



}


