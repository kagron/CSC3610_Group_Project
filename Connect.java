// Connect Class
package CSC3610_Group_Project;

import java.sql.*;
import java.util.GregorianCalendar;

public class Connect {
	Connection connection;
	PreparedStatement preparedStatement;
	// Start the database.  Run this method everytime you need to connect to it
	public void initalizeDB(){
		try {
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver"); System.out.println("Driver Loaded");
			
			
			//Connect to the database.  Make sure you have a user called "csc_student" with password "csc3610" or this wont work!
			connection = DriverManager.getConnection("jdbc:mysql://localhost/java3Final","csc_student","csc3610");
			System.out.println("Database connected"); 
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	// Log in validation
	public boolean validate(String username, String password){
		// Create the query that will be filled in later
		 String queryString = "select * from user " +
	    			"where userName = ? ";
	    			
		// Create a statement
		try {
			// Prepare the statement and set the ? to the username
			preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, username);
		    ResultSet rset = preparedStatement.executeQuery();
		    // Once user is found, check the password
		    if (rset.next()) {
		    		System.out.println("Checking password");
		    	  if(rset.getString(7).equals(password)) {
		    		  // Only return true if the password is the same
		    		  return true;
		    	  } else {
		    		  // This is where the incorrect password alert should pop up
		    		  System.out.println("incorrect password");
		    	  }
		    } else { 
		    	  // Throw new exception and alert
		    	  System.out.println("Not found in database");
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// Register action
	public void register(Customer cus) {
		// Will take in a customer object and create a prepared statement
		String query = "insert into user (firstName, lastName, phone, email, address, userName, password, DOB, ssn) values (?,?,?,?,?,?,?,?,?);";
		// Prepare the statement by setting the strings equal to the various getter methods
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
			// Execute the query
			preparedStatement.execute();
			// This only prints out when a customer is fully added.  Delete this line later
			System.out.println("Customer added");
		} catch (SQLException e) {
			// This exception will only happen if a SQL error occurs
			e.printStackTrace();
		}
	}
	// Close the database
	public void closeDB() {
		try {
			connection.close();
			System.out.println("Database closed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
