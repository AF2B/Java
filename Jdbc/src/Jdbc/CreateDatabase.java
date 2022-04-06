package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabase {

	public static void main(String[] args)
	{
		String connectionLocal = "jdbc:mysql:localhost:3306?verifyServerCertificate=false&useSSL=true";
		String user = "admin";
		String password = "12345";
		
		try
		{
			Connection connection = DriverManager.getConnection(connectionLocal, user, password);
			Statement stmt = connection.createStatement();
			stmt.execute("CREATE DATABASE students");
			System.out.println("successfully!");
			connection.close();
		}
		catch(SQLException e)
		{
			System.out.println("Exception " + e);
		}
	}

}
