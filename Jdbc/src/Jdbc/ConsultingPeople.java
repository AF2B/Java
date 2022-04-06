package Jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultingPeople {

	public static void main(String[] args) throws SQLException
	{
		Connection connection = Repository.getConnection();
		
		String sql = "SELECT * FROM peoples";
		
		Statement stmt = connection.createStatement();
		ResultSet result = stmt.executeQuery(sql);
		
		List<Peoples> peoples = new ArrayList<>();
		
		while(result.next())
		{
			//TODO
		}
		
		for(Peoples p: peoples)
		{
			//TODO
		}
		
		connection.close();
	}

}
