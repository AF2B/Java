package Jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class ExcludePeople
{
	public static void main(String[] args) throws SQLException
	{
		Connection connection = Repository.getConnection();
		
		String excludeSQL = "DELETE FROM peoples WHERE cod = ?";
		int cod = 1;
		
		PreparedStatement stmt = connection.prepareCall(excludeSQL);
		stmt.setInt(1, cod);
		
		if(stmt.executeUpdate() > 0)
		{
			System.out.println("Successfully!!!");
		}
		else
		{
			System.out.println("Error");
		}
		
		connection.close();
	}
}
