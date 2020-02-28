/**
 * Copyright (c) 2019- Charles R. Severance
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 * <p>
 * Author: Charles Severance <csev@umich.edu>
 */
package org.sakaiproject.oidc.lti11;

/* This does not use the request filter because it needs full control of response headers.
       But this also means that no work that should be in a session should be done in this servlet.
       In particular, never use ThreadLocal in this servlet.
 */

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

/**
 * This is a servlet that does LTI 1.1 things where the user does not need to be logged in
 */
@Slf4j
@Controller
// @RequestMapping(value = "/zap/*")
public class ZapServlet {

    // @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    @RequestMapping(value = "/zap/")
	@ResponseBody
    public String zapWorld() {
        log.info("IMSOIDC ZAP WORLD");
        return "Zap ";
    }
}
