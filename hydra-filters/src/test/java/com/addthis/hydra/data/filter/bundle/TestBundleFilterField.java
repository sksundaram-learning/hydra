/*
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
package com.addthis.hydra.data.filter.bundle;

import java.io.IOException;

import com.addthis.bundle.util.map.MapBundle;
import com.addthis.codec.config.Configs;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestBundleFilterField {

    @Test
    public void fieldTest() throws IOException {
        BundleFilterField bff = Configs.decodeObject(BundleFilterField.class, "from: foo, filter {default = bar}");
        MapBundle bundle = MapBundle.createBundle(new String[]{"dog", "food"});
        bff.filter(bundle);
        assertEquals("food", bundle.get("dog"));
        assertEquals("bar", bundle.get("foo"));
    }
}
