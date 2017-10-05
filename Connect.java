package CSC3610_Group_Project;

import java.sql.*;

public class Connect {
	public void initalizeDB(){
		try {
			// Load the driver
			Class.forName("com.mysql.jdbc.Driver"); System.out.println("Driver Loaded");
			
			
			//Connect to the database
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/java3Final","csc_student","csc3610");
			System.out.println("Database connected"); //Create a statement
			Statement statement = connection.createStatement();
			
			// Execute a statement
			System.out.println("Here displayed are the results of your queries: \n");
			ResultSet resultSet = statement.executeQuery("select * from Car");
			while(resultSet.next()) System.out.println(resultSet.getString(1) + "\t" + 
			resultSet.getString(2) + "\t"+ resultSet.getString(3)+ "\t"+ resultSet.getString(4)+ "\t"+ resultSet.getString(5));
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
