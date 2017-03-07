package com.caucho.hessian.serialize;

/**
 * 
 * 序列化和反序列化接口
 *
 */
public interface ISerializer<T> {

	/**
	 * 序列化
	 * @param object
	 * @return
	 */
	byte[] serialize(T object);

	/**
	 * 反序列化
	 * @param b
	 * @return
	 */
	T unserialize(byte[] b);
	
}
