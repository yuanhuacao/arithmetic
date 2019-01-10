package com.example.arithmetic.lucky;

/**
 * @Description: TODO
 * @Author: 曹远华 (yuanhua.cao@luckincoffee.com)
 * @Date: 2018/12/19 21:49
 */
public class PayRequest extends  AbstractRequest {
	public Integer age;

	@Override public String toString() {
		return "PayRequest{" + "age=" + age + ", name='" + name + '\'' + ", amount='" + amount + '\'' + '}';
	}
}
