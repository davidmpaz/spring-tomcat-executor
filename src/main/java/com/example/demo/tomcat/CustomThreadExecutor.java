/*
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
package com.example.demo.tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.StandardThreadExecutor;

/**
 * Copy of class {@link org.apache.catalina.core.StandardThreadExecutor}
 *
 * Copied, pasted and renamed class just for testing/learning purposes. Only
 * logging sentences are different from original.
 */
public class CustomThreadExecutor extends StandardThreadExecutor {

    /**
     * Default name prefix for the thread name
     */
    protected String namePrefix = "custom-tomcat-exec-";

    // ---------------------------------------------- Public Methods

    /**
     * Start the component and implement the requirements of
     * {@link org.apache.catalina.util.LifecycleBase#startInternal()}.
     *
     * @exception LifecycleException if this component detects a fatal error that prevents this component from being
     *                                   used
     */
    @Override
    protected void startInternal() throws LifecycleException {
        System.out.println("CustomThreadExecutor.startInternal called");
        super.startInternal();
    }


    /**
     * Stop the component and implement the requirements of
     * {@link org.apache.catalina.util.LifecycleBase#stopInternal()}.
     *
     * @exception LifecycleException if this component detects a fatal error that needs to be reported
     */
    @Override
    protected void stopInternal() throws LifecycleException {
        super.stopInternal();
        System.out.println("CustomThreadExecutor.stopInternal called");
    }


    @Override
    public void execute(Runnable command) {
        super.execute(command);
        System.out.println("CustomThreadExecutor.execute called");
    }
}
