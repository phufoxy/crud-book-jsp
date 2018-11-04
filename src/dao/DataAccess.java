package dao;

import db.DBUtils;
import model.News;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;

public class DataAccess {
	private static Connection connection;

	public DataAccess() {
		connection = DBUtils.getConnection();
	}

	public void addNew(News n) {
		try {
			PreparedStatement ps = DBUtils.getPreparedStatement("insert into News values(?,?,?,?)");
			ps.setInt(1, n.getId());
			ps.setString(2, n.getTitle());
			ps.setString(3, n.getDate());
			ps.setString(4, n.getDescription());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<News> getAll() {
		List<News> users = new ArrayList<News>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from news");
			while (rs.next()) {
				News user = new News(rs.getInt("id"), rs.getString("title"), rs.getString("date"),
						rs.getString("description"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
