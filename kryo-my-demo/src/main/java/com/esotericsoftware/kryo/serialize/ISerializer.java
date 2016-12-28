package com.esotericsoftware.kryo.serialize;

public interface ISerializer<T> {

	/**
	 * 序列化
	 */
	public byte[] serialize(T object);
	
	/**
	 * 反序列化
	 */
	public T unserialize(byte[] b);
	
}
