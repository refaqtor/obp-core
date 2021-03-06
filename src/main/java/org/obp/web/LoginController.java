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

package org.obp.web;

import org.obp.log.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Robert Jaremczak
 * Date: 2013-10-16
 */
@Controller
public class LoginController {

    @Autowired
    private LogService logService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/loginFailed")
    public String loginFailed(ModelMap model) {
        model.addAttribute("failed",true);
        return "login";
    }

    @RequestMapping("/loginSucceeded")
    public String loginSucceeded() {
        return "welcome";
    }

    @RequestMapping("/logoff")
    public String logout(ModelMap model) {
        model.addAttribute("loggedOut",true);
        logService.logUserLoggedOut(SecurityContextHolder.getContext().getAuthentication().getName());
        return "login";
    }
}