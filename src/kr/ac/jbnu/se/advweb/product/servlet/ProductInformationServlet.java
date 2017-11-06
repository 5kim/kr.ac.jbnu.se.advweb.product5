package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jbnu.se.advweb.product.model.Order;
import kr.ac.jbnu.se.advweb.product.model.Product;
import kr.ac.jbnu.se.advweb.product.model.StaticData;
import kr.ac.jbnu.se.advweb.product.model.UserAccount;
import kr.ac.jbnu.se.advweb.product.utils.DBUtils;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

/**
 * Servlet implementation class ProductInformationServlet 제품의 상세 정보를 보여주기 위한 서블릿
 */
@WebServlet(urlPatterns = { "/productinfo" })
public class ProductInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductInformationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 고객이 선택한 상품의 정보를 가지고 온다.
		// 2. 통계를 내기 위해 상품을 본 고객의 성별 퍼센트, 조회수, 나이대별 조회수 퍼센트 등등을 집계한다.
		// 3. 정리한 내용을 상세보기 화면으로 넘겨준다.
		Connection conn = MyUtils.getStoredConnection(request);

		String productNumber = request.getParameter("code");

		Product product = null;
		String errorString = null;
		List<StaticData> staticDatas = null;

		try {
			product = DBUtils.findProduct(conn, productNumber);
			staticDatas = DBUtils.queryOrdersByProductNumber(conn, product.getProductNumber());
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}

		int total = staticDatas.size();
		int manCount = 0;
		int m10 = 0;
		int m20 = 0;
		int m30 = 0;
		int m40 = 0;
		int m50 = 0;
		int m60 = 0;
		int f10 = 0;
		int f20 = 0;
		int f30 = 0;
		int f40 = 0;
		int f50 = 0;
		int f60 = 0;
		Calendar calendar = Calendar.getInstance();
		for (StaticData staticData : staticDatas) {
			if (staticData.getGender().equals("m")) {
				int temp = calendar.YEAR - staticData.getBirth().getYear();
				int generation = temp / 10;
				switch (generation) {
				case 1:
					m10++;
					break;
				case 2:
					m20++;
					break;
				case 3:
					m30++;
					break;
				case 4:
					m40++;
					break;
				case 5:
					m50++;
					break;
				case 6:
					m60++;
				default:
					m60++;
					break;
				}
			}else {
				int temp = calendar.YEAR - staticData.getBirth().getYear();
				int generation = temp / 10;
				switch (generation) {
				case 1:
					f10++;
					break;
				case 2:
					f20++;
					break;
				case 3:
					f30++;
					break;
				case 4:
					f40++;
					break;
				case 5:
					f50++;
					break;
				case 6:
					f60++;
				default:
					f60++;
					break;
				}
			}
		}
		request.setAttribute("m10", m10);
		request.setAttribute("m20", m20);
		request.setAttribute("m30", m30);
		request.setAttribute("m40", m40);
		request.setAttribute("m50", m50);
		request.setAttribute("m60", m60);
		
		request.setAttribute("f10", f10);
		request.setAttribute("f20", f20);
		request.setAttribute("f30", f30);
		request.setAttribute("f40", f40);
		request.setAttribute("f50", f50);
		request.setAttribute("f60", f60);
		
		request.setAttribute("product", product);
		request.setAttribute("staticDatas", staticDatas);

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/productInfomationView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
