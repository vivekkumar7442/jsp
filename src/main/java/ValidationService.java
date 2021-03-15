import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ValidationService {

	private static List<ToDoDetails> details = new ArrayList<ToDoDetails>();

	static {
		details.add(new ToDoDetails("HTML", 1,"test"));
		details.add(new ToDoDetails("JSP", 2,"test"));
		details.add(new ToDoDetails("SERVLET", 3,"test"));
		details.add(new ToDoDetails("REST", 4,"test"));
		details.add(new ToDoDetails("JSOn", 5,"test"));
	}

	public boolean isValidUser(String userName, String password) {
		if (userName.equalsIgnoreCase("sam12") && password.equalsIgnoreCase("1234")) {
			return true;

		}
		return false;
	}

	public java.util.List<ToDoDetails> getToDoList() {

		return details;

	}

	public java.util.List<ToDoDetails> addTodo(String name) {
		details.add(new ToDoDetails(name, 6,"test"));
		

		return details;

	}

	public void delete(String name) {
		details.remove(new ToDoDetails(name, 1,"test"));
		
	}
	
	public boolean isValidStaff(String userName, String password) throws ClassNotFoundException, SQLException {
		Connection connection = DBconnection.initializeDatabase();
		String query = "SELECT * FROM staff WHERE staff_id = ? and password=?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, userName);
		preparedStatement.setString(2, password);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {

			String staffId = resultSet.getString("staff_id");
			String passworddetails = resultSet.getString("password");

			if (staffId == null && passworddetails == null) {
				return false;
			} else {
				return true;
			}

		}

		return false;
	}
	
	public List<FeedBackDetails> getFeedBackDetails() throws ClassNotFoundException, SQLException, ParseException {
		Connection connection = DBconnection.initializeDatabase();
		List<FeedBackDetails> backDetails = new ArrayList<FeedBackDetails>();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM feedback ");

		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			FeedBackDetails bDetails = new FeedBackDetails();
			bDetails.setId(resultSet.getInt("id"));
			bDetails.setFeedbackId(resultSet.getString("feedback"));
			bDetails.setType(resultSet.getString("type"));
			bDetails.setStatus(resultSet.getString("status"));
			bDetails.setOicId(resultSet.getString("oicid"));

			Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(resultSet.getString("created_time"));
			bDetails.setCreatedTime((date1));
			backDetails.add(bDetails);

		}

		return backDetails;
	}
	
	public FeedBackDetails getFeedBackDetailsOnId(Integer feedBackId) throws ClassNotFoundException, SQLException {
		Connection connection = DBconnection.initializeDatabase();
		List<FeedBackDetails> backDetails = new ArrayList<FeedBackDetails>();

		String query = "SELECT * FROM feedback  WHERE id = ? ";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, feedBackId);
		FeedBackDetails bDetails = new FeedBackDetails();

		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			bDetails.setId(resultSet.getInt("id"));
			bDetails.setFeedbackId(resultSet.getString("feedback"));
			bDetails.setType(resultSet.getString("type"));
			bDetails.setStatus(resultSet.getString("status"));
			bDetails.setSubject(resultSet.getString("subject"));
			bDetails.setContent(resultSet.getString("feedbackcontent"));
			bDetails.setOicId(resultSet.getString("oicid"));
			bDetails.setOicRemarks(resultSet.getString("oicremarks"));
			String userFetchQuery = "SELECT * FROM user WHERE user_id=?";

			PreparedStatement userprep = connection.prepareStatement(userFetchQuery);
			userprep.setInt(1, resultSet.getInt("userid"));
			ResultSet userResult = userprep.executeQuery();
			UserDetails userDetails = new UserDetails();
			while (userResult.next()) {
				userDetails.setUserId(userResult.getInt("user_id"));
				userDetails.setAddress(userResult.getString("address"));
				userDetails.setEmail(userResult.getString("email"));
				userDetails.setMobile(userResult.getString("mobile_number"));
				userDetails.setName(userResult.getString("name"));
				userDetails.setOfficeMobile(userResult.getString("office_number"));
				userDetails.setMobileHome(userResult.getString("mobile_number"));
				bDetails.setUserDetail(userDetails);

			}

			backDetails.add(bDetails);

		}

		return bDetails;
	}

}
