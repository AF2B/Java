package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewPeoples {

	public static void main(String[] args) throws SQLException
	{
		Connection connection = Repository.getConnection();
		
		String nome = "Fulano de tal";
		
		//String sql = "INSERT INTO peoples(nome) VALUES ('" + nome + "')"; Not recommended, vunerable SQLInjection
		String sql = "INSERT INTO peoples(nome) VALUES (?)";
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, nome);
		stmt.execute();
		
		connection.close();
	}

}
