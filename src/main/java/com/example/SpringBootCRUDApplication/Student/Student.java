package com.example.SpringBootCRUDApplication.Student;

import jakarta.persistence.*;


@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String city;
	@Column
	private int rollNo;
	@Column
	private double percentage;
	
	public Student() {
		//TODO
	}
	
	public Student(Long id, String name, String address, String city, int rollNo, double percentage) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.rollNo = rollNo;
		this.percentage = percentage;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", rollNo=" + rollNo
				+ ", percentage=" + percentage + "]";
	}
	
	

}
