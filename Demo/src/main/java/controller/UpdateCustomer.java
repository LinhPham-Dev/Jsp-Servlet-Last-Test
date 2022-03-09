package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ICustomerDAO;
import dao.ImplCustomerDAO;
import utils.Customer;

/**
 * Servlet implementation class EditCustomer
 */
@WebServlet("/update")
public class UpdateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCustomer() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
		Date birthday = Date.valueOf(request.getParameter("birthday"));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String hometown = request.getParameter("hometown");

		Customer c = new Customer(id, name, gender, birthday, hometown, email, phone);

		ICustomerDAO cDao = new ImplCustomerDAO();
		cDao.update(c);

		response.sendRedirect(request.getContextPath() + "/customer");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
