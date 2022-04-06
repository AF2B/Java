package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdatePeople throws SQLException //FIXME
{
	Connection connection = Repository.getConnection();
	
	String selectSQL = "SELECT * FROM peoples WHERE cod = ?";
	String updateSQL = "UPDATE peoples SET name = ? WHERE cod = ?";
	String newName = "Filipe";
	int cod = 1;
	
	
	PreparedStatement stmt = connection.prepareStatement(selectSQL);
	stmt.setInt(1, cod);
	ResultSet result = stmt.executeQuery();
	
	if(result.next() == true)
	{
		Peoples peoples = new Peoples(result.getString(2), result.getInt(1));
		
		System.out.println("Name: " + peoples.getName());
		
		stmt.close();
		
		stmt = connection.prepareStatement(updateSQL);
		stmt.setString(1, newName);
		stmt.setInt(2, cod);
		stmt.execute();
		
		System.out.println("Successfully!!!");
		
		stmt.close();
	}
	else
	{
		System.out.println("can't find...");
	}
	
	
	connection.close();
}
