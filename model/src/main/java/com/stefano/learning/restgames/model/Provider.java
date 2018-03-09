/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stefano.learning.restgames.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Provider {
    private String providerName;
    private int gamesNumber;

    public Provider() {

    }

    public Provider(String providerName, int gamesNumber) {
        this.providerName = providerName;
        this.gamesNumber = gamesNumber;
    }

    public String getProviderName() {
        return providerName;
    }

    public int getGamesNumber() {
        return gamesNumber;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public void setGamesNumber(int gamesNumber) {
        this.gamesNumber = gamesNumber;
    }
}
