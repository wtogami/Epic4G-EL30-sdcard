/* Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tests.api.java.nio.charset;

import dalvik.annotation.TestTargetClass;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@TestTargetClass(java.nio.charset.CharsetDecoder.class)
/**
 * test gb18030 decoder
 */
public class GBCharsetDecoderTest extends AbstractCharsetDecoderTestCase {

    protected void setUp() throws Exception {
        cs = Charset.forName("gb18030");
        super.setUp();
    }

    /*
     * @see CharsetDecoderTest#tearDown()
     */
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    // // FIXME: give up this tests
    // public void testDefaultCharsPerByte(){
    // //assertEquals(1, decoder.averageCharsPerByte());
    // //assertEquals(1, decoder.maxCharsPerByte());
    // assertEquals(decoder.averageCharsPerByte(), 0.25, 0.001);
    // assertEquals(decoder.maxCharsPerByte(), 2, 0.001);
    // }

    ByteBuffer getUnmappedByteBuffer() throws UnsupportedEncodingException {
        return null;
    }

    ByteBuffer getMalformByteBuffer() throws UnsupportedEncodingException {
        ByteBuffer buffer = ByteBuffer.allocate(20);
        buffer.put(new byte[] { (byte) 0xd8, 0 });
        buffer.put(unibytes);
        buffer.flip();
        return buffer;
    }

    ByteBuffer getExceptionByteArray() throws UnsupportedEncodingException {
        return null;
    }

}
