

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class FeedBackServlet
 */
@WebServlet("/FeedBackServlet")
public class FeedBackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ValidationService validationService = new ValidationService();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedBackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			/*
			 * FeedBackDetails feedBackDetails = validationService
			 * .getFeedBackDetailsOnId(Integer.valueOf(request.getParameter("feedbackId")));
			 * request.setAttribute("feedback", feedBackDetails);
			 */
			ObjectMapper mapper = new ObjectMapper();
			// Converting the Object to JSONString
			//String jsonString = mapper.writeValueAsString(feedBackDetails);
			//System.out.println(jsonString);

			response.getWriter().write("{\"feedbackId\":\"FEED15\",\"id\":12,\"type\":\"Complain\",\"subject\":\"Subject1\",\"content\":\"da\",\"status\":\"NEW\",\"createdTime\":null,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":{\"userId\":1,\"name\":\"sam\",\"address\":\"chennai\",\"email\":\"sam@gmail.com\",\"mobile\":\"960098754\",\"officeMobile\":\"4556\",\"mobileHome\":\"960098754\"}}\r\n" + 
					"");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		 

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
