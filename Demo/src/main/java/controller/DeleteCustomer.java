package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ICustomerDAO;
import dao.ImplCustomerDAO;

/**
 * Servlet implementation class AddCustomer
 */
@WebServlet("/delete")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCustomer() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String deleteId = request.getParameter("id");
		
		ICustomerDAO cDao = new ImplCustomerDAO();
		
		boolean result = cDao.delete(deleteId);

		if (result)
			request.setAttribute("info", "Remove record success!");
		else
			request.setAttribute("info", "Remove record failed!");
		
		response.sendRedirect(request.getContextPath() + "/customer");

		
//		request.getRequestDispatcher("views/list-customer.jsp").forward(request, response);
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
