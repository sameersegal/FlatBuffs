package frogermcs.io.flatbuffersparser;

import java.nio.ByteBuffer;

/**
 * Created by Miroslaw Stanek on 04.11.2015.
 */
public class FlatBuffersParser {

    static {
        System.loadLibrary("FlatBuffersParser");
    }

    public ByteBuffer parseJson(String json, String schema) {
        final byte[] bytes = parseJsonNative(json, schema);
        return ByteBuffer.wrap(bytes);
    }

    public String parseBinary(byte[] binary, String schema) {
        final byte[] bytes = parseBinaryNative(binary, schema);
        return new String(bytes);
    }

    private native byte[] parseJsonNative(String json, String schema);

    private native byte[] parseBinaryNative(byte[] binary, String schema);
}
