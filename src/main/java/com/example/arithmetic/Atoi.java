package com.example.arithmetic;

/**
 * @Description: 字符串转整数
 * @Author: geeker (geek)
 * @Date: 2019/1/8 17:32
 */
public class Atoi {

	public  static  Integer atoi(String str){
		Long tempLong=0L;
		if (str==null||"".equals(str)){
			return 0;
		}

		String temp[]=str.split(".");

		str=str.substring(0,str.indexOf("."));
		for (int i=0;i<str.length();i++){
			if (str.charAt(i)>'9'|| str.charAt(i)<'0'){
				return 0;
			}
		}
		if (str.length()>10){
			return 0;
		}
		tempLong=Long.parseLong(str);
		if (tempLong>Integer.MAX_VALUE){
			return  0;
		}
		return tempLong.intValue();
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	     Integer a=	Atoi.atoi("0.0.0");
		System.out.println(a);
		String str="0000.0.0";
		boolean b=str.contains(".");
		System.out.println(b);
	}

}
