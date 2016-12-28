package com.esotericsoftware.kryo.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * 
 * 使用kyro序列化
 *
 */
public class KryoSerializer<T> implements ISerializer<T> {

	/**
	 * 
	 * 序列化
	 *
	 */
	public byte[] serialize(T object){
		Kryo kryo = new Kryo();
	    Output output = new Output(new ByteArrayOutputStream());
	    kryo.writeClassAndObject(output, object);
	    byte[] b = output.toBytes();
	    output.close();
	    return b;
	}
	
	/**
	 * 
	 * 反序列化
	 *
	 */
	@SuppressWarnings("unchecked")
	public T unserialize(byte[] b) {
		Kryo kryo = new Kryo();
		Input input = new Input(new ByteArrayInputStream(b));
		Object object = kryo.readClassAndObject(input);
	    input.close();
	    return (T)object;
	}
	
}
