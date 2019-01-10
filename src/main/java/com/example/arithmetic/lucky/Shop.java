package com.example.arithmetic.lucky;

/**
 * @Description: TODO
 * @Author: 曹远华 (yuanhua.cao@luckincoffee.com)
 * @Date: 2018/12/19 21:50
 */
public class Shop {


	public void buy(AbstractRequest request){
		PayRequest payRequest=(PayRequest) request;
		System.out.println(payRequest.age);

	}

	public static void main(String[] args) {
		PayRequest payRequest=new PayRequest();
		payRequest.age=18;
		payRequest.amount="2000";
		payRequest.name="小红";
		Shop shop=new Shop();
		shop.buy(payRequest);
	}
}
