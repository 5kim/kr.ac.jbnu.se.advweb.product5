package kr.ac.jbnu.se.advweb.product.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kr.ac.jbnu.se.advweb.product.model.Cart;
import kr.ac.jbnu.se.advweb.product.model.Coupon;
import kr.ac.jbnu.se.advweb.product.model.Product;
import kr.ac.jbnu.se.advweb.product.model.UserAccount;

public class DBUtils {

	public static UserAccount findUser(Connection conn, //
			String userName, String password) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a " //
				+ " where a.User_Name = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String userName) throws SQLException {

		String sql = "Select a.User_Name, a.Password, a.Gender from User_Account a "//
				+ " where a.User_Name = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}

	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price from Product a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			list.add(product);
		}
		return list;
	}

	public static Product findProduct(Connection conn, String code) throws SQLException {
		String sql = "Select a.Code, a.Name, a.Price from Product a where a.Code=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product(code, name, price);
			return product;
		}
		return null;
	}

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set Name =?, Price=? where Code=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.setString(3, product.getCode());
		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product(Code, Name,Price) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getCode());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());

		pstm.executeUpdate();
	}

	public static void deleteProduct(Connection conn, String code) throws SQLException {
		String sql = "Delete From Product where Code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, code);

		pstm.executeUpdate();
	}

	public static List<Cart> queryCart(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		// 장바구니의 정보를 가지고와 배열로 만든다.
		String sql = "Select * from cart where id='" + id + "'";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Cart> list = new ArrayList<Cart>();
		while (rs.next()) {
			int count = rs.getInt("count");
			String productNumber = rs.getString("productNumber");
			String userId = rs.getString("userId");
			Cart cart = new Cart();
			cart.setCount(count);
			cart.setUserId(userId);
			cart.setProductNumber(productNumber);
			list.add(cart);
		}
		return list;
	}

	public static List<Coupon> queryCoupon(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		// 쿠폰 정보의 배열을 반환
		//1. DB에 Query문 작성
		String sql = "Select * from coupon where id='" + id + "'";
		//2. Query문 실행
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		//3. DB에서 가지고 온 정보 coupon형태의 배열로 만들어주기
		List<Coupon> list = new ArrayList<Coupon>();
		while (rs.next()) {
			int discountRate = rs.getInt("discountRate");
			Date period = rs.getDate("period");
			String serialNumber = rs.getString("serialNumber");
			String userId = rs.getString("userId");
			Coupon coupon = new Coupon();
			coupon.setDiscountRate(discountRate);
			coupon.setPeriod(period);
			coupon.setSerialNumber(serialNumber);
			coupon.setUserId(userId);

			list.add(coupon);
		}
		//4. 배열 반환하기
		return list;
	}

}