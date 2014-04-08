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

package org.obp.web.api;

import org.apache.commons.lang3.Range;
import org.obp.local.LocalObpInstance;
import org.obp.web.config.ObpConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Robert Jaremczak
 * Date: 2013-12-6
 */

@Controller
@RequestMapping(LocalObpInfo.API_PREFIX)
public class LocalObpInfo {

    public static Range<Double> supportedApiLevels = Range.between(1.0, 1.0);

    public static final String API_PREFIX = "/api";
    public static final String API_1_0_PREFIX = "/1.0";

    @Autowired
    private LocalObpInstance localObpInstance;

    @Autowired
    private ObpConfig config;

    @ResponseBody
    @RequestMapping("/{apiLevel:\\d+\\.\\d+}/info")
    public ObpInfoDto info(@PathVariable("apiLevel") double apiLevel) {
        ObpInfoDto dto = new ObpInfoDto();
        dto.apiMinLevel = supportedApiLevels.getMinimum();
        dto.apiMaxLevel = supportedApiLevels.getMaximum();
        dto.apiRequestedLevel = apiLevel;
        dto.apiRequestedLevelSupported = supportedApiLevels.contains(apiLevel);
        dto.buildId = config.getBuildId();
        dto.obpUuid = localObpInstance.getUuid();
        dto.obpName = localObpInstance.getName();
        dto.obpDescription = localObpInstance.getDescription();
        return dto;
    }

    @ResponseBody
    @RequestMapping(API_1_0_PREFIX+"/diagnostic")
    public DiagnosticDto diagnostic() {
        DiagnosticDto dto = new DiagnosticDto();
        dto.java = config.getJavaInfo();
        dto.os = config.getOsInfo();
        return dto;
    }

}
