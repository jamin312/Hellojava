package com.yedam.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// 조회, 등록, 수정, 삭제
public class BookDAO {
	// 단건조회(findById), 반환값(boolean)
	
	// 삭제, 매개값(int bno), 반환값(boolean)
	public boolean delete(int bno) {
		Connection conn = DBUtil.getConnect();
		String query = "delete from book "
						+ "where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, bno); // ? 네 번째에 값을 지정
			
			int r = stmt.executeUpdate(); // 실행된 쿼리의 결과 개수(count 반환)
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 수정, 매개값(int bno, int price), 반환값(boolean)
	public boolean update(int bno, int price) {
		Connection conn = DBUtil.getConnect();
		String query = "update book "
						+ "set price = ? "
						+ "where id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setInt(1, price); // ? 네 번째에 값을 지정
			stmt.setInt(2, bno); // ? 네 번째에 값을 지정
			
			int r = stmt.executeUpdate(); // 실행된 쿼리의 결과 개수(count 반환)
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 등록, 매개값(Book), 반환값(boolean)
	public boolean insert(Book book) {
		Connection conn = DBUtil.getConnect();
		String query = "insert into book(id, title, author, price)"
				+ "values(?,?,?,?)";
//		System.out.println(query);
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, book.getId()); // ? 첫 번째에 값을 지정
			stmt.setString(2, book.getTitle()); // ? 두 번째에 값을 지정
			stmt.setString(3, book.getAuthor()); // ? 세 번째에 값을 지정
			stmt.setInt(4, book.getPrice()); // ? 네 번째에 값을 지정
			
			int r = stmt.executeUpdate(); // 실행된 쿼리의 결과 개수(count 반환)
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 목록조회(다건)
	public ArrayList<Book> findAll() {
		Connection conn = DBUtil.getConnect();
		ArrayList<Book> list = new ArrayList<Book>(); // 컬렉션(Book)
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book");
			//반복
			while(rs.next()) {
				Book book = new Book(); // 기본생성자가 없으면 에러 표시
				book.setId(rs.getInt("id")); // id -> id 필드에 할당
				book.setTitle(rs.getString("title")); // title -> title 필드에 할당
				book.setAuthor(rs.getString("author")); // author -> author 필드에 할당
				book.setPrice(rs.getInt("price")); // price -> price 필드에 할당
				// 컬렉션에 추가
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//end findAll
	
}// end class
