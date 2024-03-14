package servlet;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import service.CustomerService;

/**
 * implementation class CustomerRegistrationServlet
 */
@WebServlet("/customer-registration")

public class CustomerRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		
		CustomerService customerService = new CustomerService();
	        boolean success = customerService.registerCustomer(name, mobile, age, sex);
	        if (success) {
	            response.sendRedirect("customer_login.html");
	        } else {
	            // Handle registration failure
	            response.getWriter().println("Registration failed. Please try again.");
	        }
		doGet(request, response);
	}

}
