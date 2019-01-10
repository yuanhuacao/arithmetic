package com.example.arithmetic.good;

/**
 * @Description: TODO
 * @Author: geeker (geek)
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
