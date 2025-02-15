/*
 * (c) Copyright 2019 Palantir Technologies Inc. All rights reserved.
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

package com.palantir.conjure.java.api.errors;

import static org.assertj.core.api.Assertions.assertThat;

import com.palantir.logsafe.SafeArg;
import org.junit.jupiter.api.Test;

class UnknownRemoteExceptionTest {

    @Test
    public void testMessage() {
        UnknownRemoteException exception = new UnknownRemoteException(404, "not found");
        assertThat(exception.getMessage())
                .isEqualTo("Error 404. (Failed to parse response body as SerializableError.)");
        assertThat(exception.getLogMessage())
                .isEqualTo("Failed to parse response body as SerializableError.");
    }

    @Test
    public void testArgsContainsStatus() {
        UnknownRemoteException exception = new UnknownRemoteException(404, "not found");
        assertThat(exception.getArgs()).containsOnly(SafeArg.of("status", 404));
    }

}
