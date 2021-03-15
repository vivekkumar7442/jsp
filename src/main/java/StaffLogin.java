
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class StaffLogin
 */
@WebServlet("/StaffLogin")
public class StaffLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ValidationService validationService = new ValidationService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StaffLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/stafflogin.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String staffId = request.getParameter("staffid");
		String password = request.getParameter("password");

		try {
			if (validationService.isValidUser(staffId, password)) {
				
				ObjectMapper mapper = new ObjectMapper();
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
				mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);


				// Converting the Object to JSONString
				//String jsonString = mapper.writeValueAsString(validationService.getFeedBackDetails());
				
				String val="[{\"feedbackId\":\"FEED1t\",\"id\":1,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":\"1\",\"userDetail\":null},{\"feedbackId\":\"FEED2ert\",\"id\":2,\"type\":\"Complain2\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"FEED3ew\",\"id\":3,\"type\":\"Complain3\",\"subject\":null,\"content\":null,\"status\":\"completed\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"FEED1dfg\",\"id\":8,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"53\",\"id\":9,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"FEED153\",\"id\":10,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"31\",\"id\":11,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"FEED15\",\"id\":12,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"FEED34\",\"id\":13,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"FEED15\",\"id\":14,\"type\":\"Complain14\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"FEED1\",\"id\":15,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"FEED1\",\"id\":16,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"FEED1\",\"id\":17,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null},{\"feedbackId\":\"FEED1\",\"id\":18,\"type\":\"Complain\",\"subject\":null,\"content\":null,\"status\":\"NEW\",\"createdTime\":1546454520000,\"oicCreatedTime\":null,\"oicRemarks\":null,\"oicId\":null,\"userDetail\":null}]";
				FeedBackDetails[] list=mapper.readValue(val, FeedBackDetails[].class);
				//System.out.println(jsonString);
				
				request.setAttribute("feedBackList", list);
				//request.setAttribute("feedBackList", validationService.getFeedBackDetails());
				request.getRequestDispatcher("/WEB-INF/views/feedback.jsp").forward(request, response);

			} else {

				request.setAttribute("errorMessage", "Invalid Credential");

				request.getRequestDispatcher("/WEB-INF/views/stafflogin.jsp").forward(request, response);

			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		/* catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

}
