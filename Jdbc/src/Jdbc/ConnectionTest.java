package Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest
{
	public static void main(String[] args) 
	{
		//&requireSSL=true after "useSSL=true"
		final String connectionLocal = "jdbc:mysql://localhost:3306?verifyServerCertificate=false&useSSL=true";
		final String user = "admin";
		final String password = "12345";
		
		try
		{
			Connection connection = DriverManager.getConnection(connectionLocal, user, password);
			System.out.println("successfully!");
			connection.close();
		}
		catch (SQLException e)
		{
			System.out.println("Exception " + e);
		}
	}
}
