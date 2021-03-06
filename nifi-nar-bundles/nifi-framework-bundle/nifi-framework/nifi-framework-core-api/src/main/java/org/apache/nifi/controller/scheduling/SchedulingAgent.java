/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.nifi.controller.scheduling;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.apache.nifi.connectable.Connectable;
import org.apache.nifi.controller.ReportingTaskNode;

public interface SchedulingAgent {

    void schedule(Connectable connectable, LifecycleState scheduleState);

    void scheduleOnce(Connectable connectable, LifecycleState scheduleState, Callable<Future<Void>> stopCallback);

    void unschedule(Connectable connectable, LifecycleState scheduleState);

    void onEvent(Connectable connectable);

    void schedule(ReportingTaskNode taskNode, LifecycleState scheduleState);

    void unschedule(ReportingTaskNode taskNode, LifecycleState scheduleState);

    void setMaxThreadCount(int maxThreads);

    void incrementMaxThreadCount(int toAdd);

    void setAdministrativeYieldDuration(String duration);

    String getAdministrativeYieldDuration();

    long getAdministrativeYieldDuration(TimeUnit timeUnit);

    void shutdown();
}
