package org.miniprojract.domain;

import java.util.ArrayList;

public class Fertilizer {
	private String name;
	private String companyname;
	private String grade;
	private double price_per_Bag;
	private double amount;
	private int quantity;
	private double subsidy;
	private int weight;
	private int sell_quantity;
	public Fertilizer() {
		
	}
	public Fertilizer(String name, String companyname, String grade, double price_per_Bag, int quantity, double subsidy,
			int weight) {
		this.name = name;
		this.companyname = companyname;
		this.grade = grade;
		this.price_per_Bag = price_per_Bag;
		this.quantity = quantity;
		this.subsidy = subsidy;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public double getPricePerBag() {
		return price_per_Bag;
	}
	public void setPricePerBag(double price_per_Bag) {
		this.price_per_Bag = price_per_Bag;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getSubsidy() {
		return subsidy;
	}
	public void setSubsidy(double subsidy) {
		this.subsidy = subsidy;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setSell_quantity(int sell_quantity) {
		this.sell_quantity = sell_quantity;
	}
	@Override
	public String toString() {
		return String.format("%-20s%-15s%-18s%-12d%-16.2f%-13.2f%-9d",this.name, this.companyname,this.grade,this.quantity,this.price_per_Bag, this.subsidy, this.weight);
	}

	public String toString1() {
		return String.format("%-20s%-17s%-13d%-16.2f%-7.2f",this.name,this.grade,this.sell_quantity,this.price_per_Bag,this.sell_quantity*this.price_per_Bag);
	}
}
