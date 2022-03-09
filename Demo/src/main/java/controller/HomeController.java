package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ICustomerDAO;
import dao.ImplCustomerDAO;
import utils.Customer;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/customer")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		ICustomerDAO cDao = new ImplCustomerDAO();

		String sql = "SELECT * FROM Customer WHERE id IS NOT NULL";

		String s_name = request.getParameter("s_name");
		String s_gender = request.getParameter("s_gender");
		String order_by = request.getParameter("order_by");

		if (s_name != null && !"".equals(s_name))
			sql += " AND name LIKE '%" + s_name + "%'";
		request.setAttribute("s_name", s_name);
		
		if (s_gender != null && !"".equals(s_gender))
			sql += " AND gender = " + s_gender;
		request.setAttribute("s_gender", s_gender);

		if (order_by != null && !"".equals(order_by))
			sql += " ORDER BY id " + order_by;
		request.setAttribute("order_by", order_by);
		
		List<Customer> listCus = cDao.list(sql);

		request.setAttribute("listCus", listCus);

		request.getRequestDispatcher("views/list-customer.jsp").forward(request, response);
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
