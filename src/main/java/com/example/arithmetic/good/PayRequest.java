package com.example.arithmetic.good;

/**
 * @Description: TODO
 * @Author: geeker (geek)
 * @Date: 2018/12/19 21:49
 */
public class PayRequest extends  AbstractRequest {
	public Integer age;

	@Override public String toString() {
		return "PayRequest{" + "age=" + age + ", name='" + name + '\'' + ", amount='" + amount + '\'' + '}';
	}
}
