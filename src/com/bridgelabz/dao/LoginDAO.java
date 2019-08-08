package com.bridgelabz.dao;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.bridgelabz.model.LoginUserRequest;
import com.bridgelabz.model.RegisterUserRequest;

public class LoginDAO {
	private static Connection con;
	private static String driver;
	private static String connectionURL;
	private static String user;
	private static String password;

	static {
		try (InputStream input = new FileInputStream(
				"/home/admin237/Desktop/MYNewWS/WebApp/src/com/bridgelabz/property/config.properties")) {

			Properties prop = new Properties();
			prop.load(input);
			driver = prop.getProperty("db.driver");
			user = prop.getProperty("db.user");
			password = prop.getProperty("db.password");
			connectionURL = prop.getProperty("db.connectionURL");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void getConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(connectionURL, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int userRegistration(RegisterUserRequest user) {
		getConnection();
		int result = 0;
		String sql = "insert into userTable values(?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getPassword());
			result = stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public String userLogin(LoginUserRequest user) {
		getConnection();

		String sql = "select * from userTable where Email=? and Password=?";
		String name = null;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getEmail());
			stmt.setString(2, user.getPassword());
			ResultSet result = stmt.executeQuery();
			if (result.next()) {
				name = result.getString(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return name;

	}

}
