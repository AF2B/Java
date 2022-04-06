package Jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Repository
{
	public static Connection getConnection()
	{
		try
		{
			Properties prop = getProperties();
			
			final String url = prop.getProperty("database.url");
			final String user = prop.getProperty("database.user");
			final String password = prop.getProperty("database.password");
			
			return DriverManager.getConnection(url, user, password);
		}
		catch (SQLException | IOException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	private static Properties getProperties() throws IOException
	{
		Properties prop = new Properties();
		String path = "/Connection.properties";
		prop.load(Repository.class.getResourceAsStream(path));
		return prop;
		
	}
	
	//TODO others methods...
}
