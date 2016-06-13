package br.com.unb.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionFactory {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url	 = "jdbc:mysql://localhost:3361/DB_ALOCACAO";
	private static String user	 = "root";
	private static String pwd	 = "123456";
	private static MySQLConnectionFactory factory;
	private static Connection connection;
	
	private MySQLConnectionFactory(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static MySQLConnectionFactory getInstance(){
		if(factory == null){
			factory = new MySQLConnectionFactory();
		}
		return factory;
	}
	
	public Connection getConnection(){
		return connection;
	}
}
