package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.DataAccess;
import model.News;

public class DBUtils {
	public static PreparedStatement getPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = null;
		Class.forName("com.mysql.jdbc.Driver");
		// since you have to connect to database you have to connect through to
		// database server with url(where localhost signifies your current
		// system and 3306 is a port)
		String url = "jdbc:mysql://localhost:3306/university";
		// credentials required to connect
		String userName = "root";
		String password = "123456";
		Connection con = DriverManager.getConnection(url, userName, password);
		ps = con.prepareStatement(sql);
		return ps;
	}

	private static Connection connection = null;

	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/university";
				String user = "root";
				String password = "123456";
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
				System.out.println("Ket noi thanh cong");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		

	}
}
