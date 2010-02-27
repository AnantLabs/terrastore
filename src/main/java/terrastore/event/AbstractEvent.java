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
package terrastore.event;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * @author Sergio Bossa
 */
public abstract class AbstractEvent implements Event {

    protected final String bucket;
    protected final String key;
    protected final byte[] value;

    public AbstractEvent(String bucket, String key, byte[] value) {
        this.bucket = bucket;
        this.key = key;
        this.value = value;
    }

    @Override
    public String getBucket() {
        return bucket;
    }

    @Override
    public final String getKey() {
        return key;
    }

    @Override
    public final byte[] getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AbstractEvent) {
            AbstractEvent other = (AbstractEvent) obj;
            return new EqualsBuilder().append(this.bucket, other.bucket).append(this.key, other.key).append(this.value, other.value).isEquals();
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.bucket).append(this.key).append(this.value).toHashCode();
    }
}