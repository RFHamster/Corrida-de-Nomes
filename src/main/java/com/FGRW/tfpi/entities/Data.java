package com.FGRW.tfpi.entities;

import java.util.Objects;

public class Data {
	private String date;
	private String name;
	private String category;
	private String value;
	
	public Data() {
	}
	
	public Data(String date, String name, String category, String value) {
		this.date = date;
		this.name = name;
		this.category = category;
		this.value = value;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public int hashCode() {
		return Objects.hash(category, date, name, value);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		return Objects.equals(category, other.category) && Objects.equals(date, other.date)
				&& Objects.equals(name, other.name) && Objects.equals(value, other.value);
	}
	@Override
	public String toString() {
		return "Data [date=" + date + ", name=" + name + ", category=" + category + ", value=" + value + "]";
	}
	
	
}
