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
import kr.ac.jbnu.se.advweb.product.model.Order;
import kr.ac.jbnu.se.advweb.product.model.Product;
import kr.ac.jbnu.se.advweb.product.model.UserAccount;

public class DBUtils {

	public static UserAccount findUser(Connection conn, //
			String id, String password) throws SQLException {

		String sql = "Select * from user a " //
				+ " where a.id = ? and a.password= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String name = rs.getString("name");
			int birth = rs.getInt("birth");
			String gender = rs.getString("gender");
			int contact = rs.getInt("contact");
			String email = rs.getString("email");

			UserAccount user = new UserAccount();
			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setBirth(birth);
			user.setGender(gender);
			user.setContact(contact);
			user.setEmail(email);

			return user;
		}
		return null;
	}

	public static UserAccount findUser(Connection conn, String id) throws SQLException {

		String sql = "Select * from user a "//
				+ " where a.id = ? ";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, id);

		ResultSet rs = pstm.executeQuery();

		if (rs.next()) {
			String password = rs.getString("Password");
			String name = rs.getString("name");
			int birth = rs.getInt("birth");
			String gender = rs.getString("gender");
			int contact = rs.getInt("contact");
			String email = rs.getString("email");

			UserAccount user = new UserAccount();

			user.setId(id);
			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setBirth(birth);
			user.setGender(gender);
			user.setContact(contact);
			user.setEmail(email);

			return user;
		}
		return null;
	}
	
	public static void insertUser(Connection conn, UserAccount user) throws SQLException {
		String sql = "Insert into user(id, password, name, birth, gender, contact, email) values (?,?,?,?,?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, user.getId());
		pstm.setString(2, user.getPassword());
		pstm.setString(3, user.getName());
		pstm.setInt(4, user.getBirth());
		pstm.setString(5, user.getGender());
		pstm.setInt(6, user.getContact());
		pstm.setString(7, user.getEmail());

		pstm.executeUpdate();
	}
	
	public static List<UserAccount> queryUser(Connection conn) throws SQLException {
		String sql = "Select * from user a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<UserAccount> list = new ArrayList<UserAccount>();
		while (rs.next()) {
			String id = rs.getString("id");
			String password = rs.getString("password");
			String name = rs.getString("name");
			int birth = rs.getInt("birth");
			String gender = rs.getString("gender");
			int contact = rs.getInt("contact");
			String email = rs.getString("email");

			UserAccount user = new UserAccount();

			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setBirth(birth);
			user.setGender(gender);
			user.setContact(contact);
			user.setEmail(email);

			list.add(user);
		}
		return list;
	}
	
	public static List<Product> queryProduct(Connection conn) throws SQLException {
		String sql = "Select * from Product a ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String productNumber = rs.getString("productNumber");
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			String seller = rs.getString("seller");
			String description = rs.getString("description");
			int inventory = rs.getInt("inventory");

			Product product = new Product();

			product.setProductNumber(productNumber);
			product.setName(name);
			product.setPrice(price);
			product.setSeller(seller);
			product.setDescription(description);
			product.setInventory(inventory);

			list.add(product);
		}
		return list;
	}

	public static Product findProduct(Connection conn, String productNumber) throws SQLException {
		String sql = "Select * from Product a where a.productNumber=?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, productNumber);

		ResultSet rs = pstm.executeQuery();

		while (rs.next()) {
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			String seller = rs.getString("seller");
			String description = rs.getString("description");
			int inventory = rs.getInt("inventory");

			Product product = new Product(productNumber, name, price, seller, description, inventory);
			return product;
				
		}
		return null;
	}

	public static void updateProduct(Connection conn, Product product) throws SQLException {
		String sql = "Update Product set Name =?, Price=? where productNumber=? ";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.setString(3, product.getProductNumber());
		pstm.executeUpdate();
	}

	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product(productNumber, name, price, seller, description, inventory) values (?,?,?,?,?,?)";

	      PreparedStatement pstm = conn.prepareStatement(sql);

	      pstm.setString(1, product.getProductNumber());
	      pstm.setString(2, product.getName());
	      pstm.setFloat(3, product.getPrice());
	      pstm.setString(4, product.getSeller());
	      pstm.setString(5, product.getDescription());
	      pstm.setInt(6, product.getInventory());
		pstm.setString(4, product.getSeller());
		pstm.setString(5, product.getDescription());
		pstm.setInt(6, product.getInventory());

	      pstm.executeUpdate();
	   }

	public static void deleteProduct(Connection conn, String productNumber) throws SQLException {
		String sql = "Delete From Product where Code= ?";

		PreparedStatement pstm = conn.prepareStatement(sql);

		pstm.setString(1, productNumber);

		pstm.executeUpdate();
	}

	public static List<Order> queryOders(Connection conn, String orderNumber) throws SQLException {
		// TODO Auto-generated method stub
		// 주문된 정보를 가지고와 배열로 만든다.
		// 항목마다 id가 중복되서 불러와지니 레이아웃 배치를 id만 따로 하는게 좋은것 같아 보임.
		
		String sql = "Select * from orders a where a.orderNumber='" + orderNumber + "'";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Order> list = new ArrayList<Order>();
		while (rs.next()) {
			String custromerId = rs.getString("customerId");
			String productNumber = rs.getString("productNumber");
			Date date  = rs.getDate("Date");		
			int count = rs.getInt("count");		
			
			Order order = new Order();
			order.setOrderNumber(orderNumber);
			order.setCustromerId(custromerId);
			order.setProductNumber(productNumber);
			order.setDate(date);
			order.setCount(count);

			list.add(order);
		}
		return list;
	}
	
	public static List<Cart> queryCart(Connection conn, String id) throws SQLException {
		// TODO Auto-generated method stub
		// 장바구니의 정보를 가지고와 배열로 만든다.
		// 항목마다 id가 중복되서 불러와지니 레이아웃 배치를 id만 따로 하는게 좋은것 같아 보임.
		
		String sql = "Select * from cart a where a.userId='" + id + "'";

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

	public static List<Coupon> queryCoupon(Connection conn, String serialNumber) throws SQLException {
		// TODO Auto-generated method stub
		// 쿠폰 정보의 배열을 반환
		// 1. DB에 Query문 작성

		String sql = "Select * from coupon a where a.serialNumber='" + serialNumber + "'";
		// 2. Query문 실행
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		// 3. DB에서 가지고 온 정보 coupon형태의 배열로 만들어주기
		List<Coupon> list = new ArrayList<Coupon>();
		while (rs.next()) {
			
			String userId = rs.getString("userId");
			int discountRate = rs.getInt("discountRate");
			Date period = rs.getDate("period");

			Coupon coupon = new Coupon();
			coupon.setSerialNumber(serialNumber);
			coupon.setUserId(userId);
			coupon.setDiscountRate(discountRate);
			coupon.setPeriod(period);

			list.add(coupon);

		}
		// 4. 배열 반환하기
		return list;
	}

	public static List<Product> queryTodayRecommend(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		//1. 오늘의 추천으로 설정되어 있는 상품 목록 가지고 오기위한 sql문
		String sql = "Select * from product where recommend = 'true';";
		// 2. Query문 실행
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		// 3. DB에서 가지고 온 정보 Product 형태의 배열로 만들어주기
		List<Product> list = new ArrayList<Product>();
		while (rs.next()) {
			String productNumber = rs.getString("productNumber");
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			String seller = rs.getString("seller");
			String description = rs.getString("description");
			int inventory = rs.getInt("inventory");

			Product product = new Product();

			product.setProductNumber(productNumber);
			product.setName(name);
			product.setPrice(price);
			product.setSeller(seller);
			product.setDescription(description);
			product.setInventory(inventory);

			list.add(product);
		}
		// 4. 배열 반환하기
		return list;
	}

	public static void insertCoupon(Connection conn, Coupon coupon) throws SQLException {
		//관리자가 쿠폰에 대한 정보를 모두 넣는다.
		//쿠폰 sql문 작성하기
		
		// TODO Auto-generated method stub
		
		String sql = "Insert into Product(productNumber, Name,Price) values (?,?,?)";

		PreparedStatement pstm = conn.prepareStatement(sql);

		// 쿠폰 넣어야함 속성에 대한 것 넣어야함
		pstm.executeUpdate();
		
	}

	public static List<Product> querySearchWord(Connection conn, String searchWord) throws SQLException {
		// TODO Auto-generated method stub
		
		String sql = "select * from product where name like \"%" + searchWord + "%\"";
		PreparedStatement pstm = conn.prepareStatement(sql);
		List<Product> list = new ArrayList<Product>();
		// 쿠폰 넣어야함 속성에 대한 것 넣어야함
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String productNumber = rs.getString("productNumber");
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			String seller = rs.getString("seller");
			String description = rs.getString("description");
			int inventory = rs.getInt("inventory");

			Product product = new Product();

			product.setProductNumber(productNumber);
			product.setName(name);
			product.setPrice(price);
			product.setSeller(seller);
			product.setDescription(description);
			product.setInventory(inventory);

			list.add(product);
		}
		return list;
	}

	public static List<Product> queryCategory(Connection conn, String category) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from product where category='" + category + "'";
		PreparedStatement pstm = conn.prepareStatement(sql);
		List<Product> list = new ArrayList<Product>();
		// 쿠폰 넣어야함 속성에 대한 것 넣어야함
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String productNumber = rs.getString("productNumber");
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			String seller = rs.getString("seller");
			String description = rs.getString("description");
			int inventory = rs.getInt("inventory");

			Product product = new Product();

			product.setProductNumber(productNumber);
			product.setName(name);
			product.setPrice(price);
			product.setSeller(seller);
			product.setDescription(description);
			product.setInventory(inventory);

			list.add(product);
		}
		return list;
	}

	public static List<Product> queryCategoryAndSearchWord(Connection conn, String category, String searchWord) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from product where category='" + category + "', name like \"%" + searchWord + "%\"";
		PreparedStatement pstm = conn.prepareStatement(sql);
		List<Product> list = new ArrayList<Product>();
		// 쿠폰 넣어야함 속성에 대한 것 넣어야함
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String productNumber = rs.getString("productNumber");
			String name = rs.getString("name");
			float price = rs.getFloat("price");
			String seller = rs.getString("seller");
			String description = rs.getString("description");
			int inventory = rs.getInt("inventory");

			Product product = new Product();

			product.setProductNumber(productNumber);
			product.setName(name);
			product.setPrice(price);
			product.setSeller(seller);
			product.setDescription(description);
			product.setInventory(inventory);

			list.add(product);
		}
		return list;
	}


}