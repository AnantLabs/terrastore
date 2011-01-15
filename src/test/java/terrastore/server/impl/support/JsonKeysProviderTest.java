/**
 * Copyright 2009 - 2010 Sergio Bossa (sergio.bossa@gmail.com)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package terrastore.server.impl.support;

import terrastore.store.Key;
import java.io.ByteArrayOutputStream;

import org.junit.Test;

import terrastore.server.Keys;
import terrastore.util.collect.Sets;

import static org.junit.Assert.*;

/**
 * @author Sven Johansson
 */
public class JsonKeysProviderTest {

    private static final String KEYS_JSON = "[\"key1\",\"key2\",\"key3\"]";

    @Test
    public void testWrite() throws Exception {
        JsonKeysProvider provider = new JsonKeysProvider();
        Keys keysToWrite = new Keys(Sets.linked(new Key("key1"), new Key("key2"), new Key("key3")));

        ByteArrayOutputStream jsonOutputStream = new ByteArrayOutputStream();
        provider.writeTo(keysToWrite, null, null, null, null, null, jsonOutputStream);

        assertEquals(new String(KEYS_JSON.getBytes(), "UTF-8"), new String(jsonOutputStream.toByteArray(), "UTF-8"));
    }

}