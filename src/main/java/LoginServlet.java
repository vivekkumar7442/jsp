
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ValidationService validationService = new ValidationService();

	public LoginServlet() {

		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("/WEB-INF/views/stafflogin.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("password", request.getParameter("password"));

		String userName = request.getParameter("name");
		String password = request.getParameter("password");
		boolean isValid = validationService.isValidUser(userName, password);
		if (isValid) {

			request.setAttribute("toDo", validationService.getToDoList());
			request.getRequestDispatcher("/WEB-INF/views/tododetails.jsp").forward(request, response);

		} else {
			request.setAttribute("errorMessage", "Invalid Credential");

			request.getRequestDispatcher("/WEB-INF/views/stafflogin.jsp").forward(request, response);

		}

	}

}
