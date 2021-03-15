
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserManagement
 */
@WebServlet("/user")
public class UserManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserManagement() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Connection con = DBconnection.initializeDatabase();
			java.sql.Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select * from user");
			
			java.util.List<ToDoDetails> user=new ArrayList<ToDoDetails>();

			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");

				String name = rs.getString("name");
				String address = rs.getString("address");
				user.add(new ToDoDetails(name, id, address));
		
				
				
			}
			request.setAttribute("user", user);
			request.getRequestDispatcher("/WEB-INF/views/usermanagement.jsp").forward(request, response);


		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
	}

}
