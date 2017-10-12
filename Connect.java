package CSC3610_Group_Project;

import java.sql.*;
import java.util.GregorianCalendar;

public class Connect {
	Connection connection;
	PreparedStatement preparedStatement;
	public void initalizeDB(){
		try {
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver"); System.out.println("Driver Loaded");
			
			
			//Connect to the database
			connection = DriverManager.getConnection("jdbc:mysql://localhost/java3Final","csc_student","csc3610");
			System.out.println("Database connected"); //Create a statement
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	public boolean validate(String username, String password){
		 String queryString = "select * from user " +
	    			"where userName = ? ";
	    			
		// Create a statement
		try {
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, username);
		    ResultSet rset = preparedStatement.executeQuery();
		    if (rset.next()) {
		    		System.out.println("Checking password");
		    	  if(rset.getString(7).equals(password)) {
		    		  return true;
		    	  } else {
		    		  System.out.println("incorrect password");
		    	  }
		    } else { 
		    	  // Throw new exception
		    	  System.out.println("Not found in database");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void register(Customer cus) {
		String query = "insert into user values(?,?,?,?,?,?,?,?,?)";
		System.out.println("Attempting to set strings");
		System.out.println(cus);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, cus.getFirstName());
			preparedStatement.setString(2, cus.getLastName());
			preparedStatement.setString(3, cus.getPhone());
			preparedStatement.setString(4, cus.getEmail());
			preparedStatement.setString(5, cus.getAddress());
			preparedStatement.setString(6, cus.getUserName());
			preparedStatement.setString(7, cus.getPassword());
			preparedStatement.setDate(8, (Date) cus.getDOB(), new GregorianCalendar() );
			preparedStatement.setString(9, cus.getSSN());
			ResultSet rset = preparedStatement.executeQuery();
			if(rset.next()){
				System.out.println("test");
			}
			System.out.println("Customer added");
		} catch (SQLException e) {
			System.out.println("test");
			e.printStackTrace();
		}
	}
	
	public void closeDB() {
		try {
			connection.close();
			System.out.println("Database closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
