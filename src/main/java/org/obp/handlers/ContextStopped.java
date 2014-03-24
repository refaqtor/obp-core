/*
 * Copyright 2013-2014 MARSEC-XL International Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.obp.handlers;

import org.obp.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Robert Jaremczak
 * Date: 2013-10-25
 */

@Component
public class ContextStopped implements ApplicationListener<ContextClosedEvent> {

    private volatile boolean stopped = false;
    @Autowired
    private LogService logService;

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        if(!stopped) {
            logService.logSystemStop();
            stopped = true;
        }
    }
}
