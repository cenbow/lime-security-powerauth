/*
 * Copyright 2016 Lime - HighTech Solutions s.r.o.
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

package io.getlime.security.powerauth.rest.api.jaxrs.filter;

import io.getlime.security.powerauth.rest.api.base.filter.PowerAuthRequestFilterBase;
import io.getlime.security.powerauth.rest.api.base.filter.ResettableStreamHttpServletRequest;

import javax.annotation.Priority;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * Request filter that intercepts the request body, forwards it to the controller 
 * as a request attribute named "X-PowerAuth-Request-Body" and resets the stream.
 *
 * @author Petr Dvorak, petr@lime-company.eu
 *
 */
@Provider
@Priority(Priorities.AUTHENTICATION)
public class PowerAuthRequestFilter implements ContainerRequestFilter {

    @Context
    private HttpServletRequest httpRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        // WORKAROUND: fix issues with @FormParam annotations
        httpRequest.getParameterMap();

        final ResettableStreamHttpServletRequest httpServletRequest = PowerAuthRequestFilterBase.filterRequest(httpRequest);
        requestContext.setEntityStream(httpServletRequest.getInputStream());
    }

}
