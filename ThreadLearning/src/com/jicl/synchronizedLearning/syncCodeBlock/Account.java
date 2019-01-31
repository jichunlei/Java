package com.jicl.synchronizedLearning.syncCodeBlock;
/**
 * 银行账户类
 * @author xianzilei
 *
 */
public class Account {
	private String name;
	private int money;
	public Account(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	//存钱
	public void saveMoney(int amount){
		money+=amount;
	}
	
	//取钱
	public void withdrawMoney(int amount){
		money-=amount;
	}
}
