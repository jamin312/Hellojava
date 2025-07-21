package chap6_1;

public class Book {
	// 필드 : field
	private int bookNum;
	private String bookName;
	private int price;
	
	
	
	public int getBookNum() {
		return bookNum;
	}



	public String getBookName() {
		return bookName;
	}



	public int getPrice() {
		return price;
	}



	// 생성자 : constructor
	Book(int bookNum, String bookName, int price){
		this.bookNum = bookNum;
		this.bookName = bookName;
		this.price = price;
	}
	
	// 메소드 : method
	
	
	
	
}
