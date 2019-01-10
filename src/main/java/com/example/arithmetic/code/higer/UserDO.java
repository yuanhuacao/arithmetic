package com.example.arithmetic.code.higer;

import java.util.PrimitiveIterator;

/**
 * @Description: TODO
 * @Author: caoyuanhua
 * @Date: 2018/11/30 15:08
 */
public class UserDO extends PersonDO {

	// 年龄
	private Integer age;
	// 姓名
	private String name;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override public String toString() {
		return "UserDO{" + "age=" + age + ", name='" + name + '\'' + '}';
	}

	public static void main(String[] args) {
		System.out.println(new UserDO());
	}
}
