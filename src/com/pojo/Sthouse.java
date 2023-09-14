package com.pojo;

public class Sthouse {
	private String storehouseid;
	private String storehousename;
	private String storehouseaddress;
	
	public Sthouse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sthouse(String storehouseid, String storehousename, String storehouseaddress) {
		this.storehouseid = storehouseid;
		this.storehousename = storehousename;
		this.storehouseaddress = storehouseaddress;
	}
	
	public String getStorehouseid() {
		return storehouseid;
	}

	public void setStorehouseid(String storehouseid) {
		this.storehouseid = storehouseid;
	}

	public String getStorehousename() {
		return storehousename;
	}

	public void setStorehousename(String storehousename) {
		this.storehousename = storehousename;
	}

	public String getStorehouseaddress() {
		return storehouseaddress;
	}

	public void setStorehouseaddress(String storehouseaddress) {
		this.storehouseaddress = storehouseaddress;
	}


	@Override
	public String toString() {
		return "Sthouse [storehouseid=" + storehouseid + ", storehousename=" + storehousename + ", storehouseaddress="
				+ storehouseaddress + "]";
	}
	
	
	
}
