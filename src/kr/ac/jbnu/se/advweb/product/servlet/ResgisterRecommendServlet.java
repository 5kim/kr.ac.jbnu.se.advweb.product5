package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jbnu.se.advweb.product.utils.DBUtils;
import kr.ac.jbnu.se.advweb.product.utils.MyUtils;

/**
 * Servlet implementation class ResgisterRecommendServlet
 */
@WebServlet("/resgisterRecommend")
public class ResgisterRecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResgisterRecommendServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 상품번호를 이용하여 추천 항목에 넣어야 하므로 제품 번호를 받아온다.
		String productNumber = request.getParameter("productNumber");
		//2. DB에 상품 번호를 이용하여 recommend를 1로 바꾸어 준다.
		Connection conn = MyUtils.getStoredConnection(request);
		try {
			DBUtils.updateProductToRecommend(conn, productNumber);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3. 다시 추천 상품 등록으로 들어간다.
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerRecommendView.jsp");
		dispatcher.forward(request, response);
	}

}
