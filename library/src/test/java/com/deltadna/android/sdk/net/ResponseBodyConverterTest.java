/*
 * Copyright (c) 2016 deltaDNA Ltd. All rights reserved.
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

package com.deltadna.android.sdk.net;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static com.google.common.truth.Truth.assertThat;

@RunWith(JUnit4.class)
public final class ResponseBodyConverterTest {
    
    @Test
    public void voidInstance() throws Exception {
        assertThat(ResponseBodyConverter.NULL.convert(new byte[] {0}))
                .isEqualTo(null);
    }
    
    @Test
    public void string() throws Exception {
        assertThat(ResponseBodyConverter.STRING.convert(new byte[] {-16, -97, -104, -124}))
                .isEqualTo("\uD83D\uDE04");
    }
    
    @Test
    public void json() throws Exception {
        assertThat(ResponseBodyConverter.JSON.convert("{\"key\" : \"value\"}".getBytes()).toString())
                .isEqualTo(new JSONObject().put("key", "value").toString());
    }
}