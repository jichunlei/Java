package com.jicl.synchronizedLearning.syncCodeBlock;
/**
 * �����˻���
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
	
	//��Ǯ
	public void saveMoney(int amount){
		money+=amount;
	}
	
	//ȡǮ
	public void withdrawMoney(int amount){
		money-=amount;
	}
}
