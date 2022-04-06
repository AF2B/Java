package Jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateTablePeoples {

	public static void main(String[] args) throws SQLException
	{
		Connection conn = Repository.getConnection();
		
		String sql = "CREATE TABLE peoples ("
				+ "cod INT AUTO_INCREMENT PRIMARY KEY,"
				+ "nome VARCHAR(80) NOT NULL"
				+ ")";
		
		Statement stmt = conn.createStatement();//not recommended. Because this is vulnerable a sqlinjection!!!
		stmt.execute(sql);
		
		System.out.println("Successfully!");
		
		conn.close();
	}

}
