package com.example.arithmetic;

/**
 * @Description: TODO
 * @Author: geeker (geek)
 * @Date: 2018/12/21 13:45
 */
public enum ReslutCodeEnum {
	/**
	 *
	 */
	SUCCESS("success","成功"),
	FAIL("fail","失败");
	private String code;
	private String desc;
	ReslutCodeEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}





}
