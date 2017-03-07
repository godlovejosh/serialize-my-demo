package com.caucho.hessian.serialize;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Hessian
 */
public class HessianSerializer<T> implements ISerializer<T> {

    /**
     * 序列化
     */
    public byte[] serialize(T object) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        try {
            ho.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return os.toByteArray();
    }

    /**
     * 反序列化
     */
    @SuppressWarnings("unchecked")
    public T unserialize(byte[] b) {
        ByteArrayInputStream is = new ByteArrayInputStream(b);
        HessianInput hi = new HessianInput(is);
        T object = null;
        try {
            object = (T) hi.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return object;
    }
}
