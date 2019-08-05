package com.bridgelabz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.model.LoginModel;

public class LoginDao {
	static Connection con;

	public static void getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee", "root", "linuxconfig.org");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int registration(LoginModel model) {

		int result = 0;
		getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("insert into emp values(?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getPassword());
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

	public int login(LoginModel model) {

		int count = 0;
		getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("select * from emp where email=? and password=?");
			stmt.setString(1, model.getEmail());
			stmt.setString(2, model.getPassword());
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				count++;
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
		return count;

	}

}
