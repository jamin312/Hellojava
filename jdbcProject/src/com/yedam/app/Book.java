package com.yedam.app;

public class Book {
	//필드
	private int id;
	private String title;
	private String author;
	private int price;
	
	//생성자 우클릭 source -> generate Constructor using field
	public Book() {}
	public Book(int id, String title, String author, int price) {
//		super(); // 부모 클래스의 생성자 호출(상속)
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	//메소드 getter setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}// end class
