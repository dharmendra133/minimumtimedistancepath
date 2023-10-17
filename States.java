package com.example.Main.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="States")
public class States {
	@Id
	private int id;
	private char mode;
	private String src;
	private String dest;
	private float price;
	private float timereq;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public char getMode() {
		return mode;
	}
	public void setMode(char mode) {
		this.mode = mode;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getDest() {
		return dest;
	}
	public void setDest(String dest) {
		this.dest = dest;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTimereq() {
		return timereq;
	}
	public void setTimereq(float timereq) {
		this.timereq = timereq;
	}
	
	

}
