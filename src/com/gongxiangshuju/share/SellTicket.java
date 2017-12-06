package com.gongxiangshuju.share;


public class SellTicket {
	public static void main(String[] args) {
		Ticket t=new Ticket();
		new Thread(t).start();
		new Thread(t).start();
	}
}
