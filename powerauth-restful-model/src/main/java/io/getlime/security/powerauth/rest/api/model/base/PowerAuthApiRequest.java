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
package io.getlime.security.powerauth.rest.api.model.base;

/**
 * Generic class for all PowerAuth RESTful API Requests.
 *
 * @author Petr Dvorak
 *
 * @param <T> Type used as a request object in the request.
 */
public class PowerAuthApiRequest<T> {

    /**
     * Request encryption type
     */
    public class Encryption {

        /**
         * None
         */
        public static final String NONE = "none";

        /**
         * Personalized
         */
        public static final String PERSONALIZED = "personalized";

        /**
         * Non-personalized
         */
        public static final String NON_PERSONALIZED = "nonpersonalized";

    }

    private String encryption;
    private T requestObject;

    /**
     * Default constructor
     */
    public PowerAuthApiRequest() {
    }

    /**
     * Constructor with a given request object
     * @param requestObject Request object
     */
    public PowerAuthApiRequest(T requestObject) {
        this.encryption = Encryption.NONE;
        this.requestObject = requestObject;
    }

    /**
     * Constructor with a given request object
     * @param encryption Request encryption type, use static constant from {@link Encryption} class.
     * @param requestObject Request object
     */
    public PowerAuthApiRequest(String encryption, T requestObject) {
        this.encryption = encryption;
        this.requestObject = requestObject;
    }

    /**
     * Get encryption type.
     * @return Encryption type.
     */
    public String getEncryption() {
        return encryption;
    }

    /**
     * Set encryption type.
     * @param encryption Encryption type.
     */
    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    /**
     * Get request object
     * @return Request object
     */
    public T getRequestObject() {
        return requestObject;
    }

    /**
     * Set request object
     * @param requestObject Request object
     */
    public void setRequestObject(T requestObject) {
        this.requestObject = requestObject;
    }

}
