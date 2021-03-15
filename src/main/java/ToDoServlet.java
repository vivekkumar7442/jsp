

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToDoServlet
 */
@WebServlet("/todo.add")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ValidationService validationService = new ValidationService();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("toDo", validationService.getToDoList());
		request.getRequestDispatcher("/WEB-INF/views/tododetails.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String todoName = request.getParameter("todo");
		List<ToDoDetails> todoList = validationService.addTodo(todoName);
		//request.setAttribute("toDo", todoList);
		
		response.sendRedirect("/todo.add");

		//request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request, response);
	}

}
