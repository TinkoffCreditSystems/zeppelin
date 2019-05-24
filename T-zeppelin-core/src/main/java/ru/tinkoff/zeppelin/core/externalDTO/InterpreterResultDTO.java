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
package ru.tinkoff.zeppelin.core.externalDTO;

import java.util.LinkedList;
import java.util.List;

public class InterpreterResultDTO {

    public static class Message {
        String type;
        String data;

        public Message(String type, String data) {
            this.type = type;
            this.data = data;
        }

        public String getType() {
            return type;
        }

        public String getData() {
            return data;
        }
    }

    private String code;
    private List<Message> msg = new LinkedList<>();

    public InterpreterResultDTO() {
    }

    public InterpreterResultDTO(final String code, final List<Message> msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Message> getMsg() {
        return msg;
    }

    public void setMsg(List<Message> msg) {
        this.msg = msg;
    }
}
