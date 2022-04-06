package Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO
{
	private Connection connection;
	
	public int insert(String sql, Object... atributes)
	{
		try
		{
			PreparedStatement stmt = getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			addAtributes(stmt, atributes);
			if(stmt.executeUpdate() > 0)
			{
				ResultSet result = stmt.getGeneratedKeys();
				
				if(result.next())
				{
					return result.getInt(1);
				}
			}
			
			return -1;
		}
		catch(SQLException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public void close()
	{
		try
		{
			getConnection().close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			connection = null;
		}
	}
	
	private void addAtributes(PreparedStatement stmt, Object[] atributes) throws SQLException
	{
		int indice = 1;
		
		for(Object atribute: atributes)
		{
			if(atribute instanceof String)
			{
				stmt.setString(indice, (String) atribute);
			}
			else if(atribute instanceof Integer)
			{
				stmt.setInt(indice, (Integer) atribute);
			}
			
			indice++;
		}
	}
	
	private Connection getConnection()
	{
		try
		{
			if(connection != null && !connection.isClosed())
			{
				return connection;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		connection = Repository.getConnection();
		return connection;	
	}
}