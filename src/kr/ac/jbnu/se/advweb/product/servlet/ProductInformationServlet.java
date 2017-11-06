package kr.ac.jbnu.se.advweb.product.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
 * Servlet implementation class ProductInformationServlet
 * 제품의 상세 정보를 보여주기 위한 서블릿
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1. 고객이 선택한 상품의 정보를 가지고 온다.
		//2. 통계를 내기 위해 상품을 본 고객의 성별 퍼센트, 조회수, 나이대별 조회수 퍼센트 등등을 집계한다.
		//3. 정리한 내용을 상세보기 화면으로 넘겨준다.
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
        
        
		
        request.setAttribute("product", product);
        request.setAttribute("staticDatas", staticDatas);
        
		RequestDispatcher dispatcher  = this.getServletContext().getRequestDispatcher("/WEB-INF/views/productInfomationView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
