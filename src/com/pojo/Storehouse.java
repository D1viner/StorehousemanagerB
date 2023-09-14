package com.pojo;

public class Storehouse {
	private String no;
	private String name;
	private Integer price;
	private String num;
	private String storehouseid;
	private String inventorydate;
	
	public Storehouse(String no, String name, Integer price, String num, String storehouseid, String inventorydate) {
		this.no = no;
		this.name = name;
		this.price = price;
		this.num = num;
		this.storehouseid = storehouseid;
		this.inventorydate = inventorydate;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getStorehouseid() {
		return storehouseid;
	}

	public void setStorehouseid(String storehouseid) {
		this.storehouseid = storehouseid;
	}

	public String getInventorydate() {
		return inventorydate;
	}

	public void setInventorydate(String inventorydate) {
		this.inventorydate = inventorydate;
	}
	
	public Storehouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Student [id=" + no + ", name=" + name + ", price=" + price + ", num=" + num + ", storehouseid=" + storehouseid
				+ "]";
	}
	
}
