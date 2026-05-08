/**
* Copyright 2016 IBM Corp.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.sample.service;

import java.util.HashSet;
import java.util.Set;

import org.apache.wink.common.WinkApplication;
import org.apache.wink.providers.json4j.JSON4JObjectProvider;

public class RESTApplication extends WinkApplication
{
    private static final Set<Class<?>> classes = new HashSet<Class<?>>();

    static
    {
        classes.add(GetBalance.class);
        classes.add(JSON4JObjectProvider.class);
    }

    @Override
    public Set<Class<?>> getClasses()
    {
        return classes;
    }
}
