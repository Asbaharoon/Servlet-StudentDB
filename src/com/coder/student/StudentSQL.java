package com.coder.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentSQL {

	public static Connection getConnection() {
		
		final String host = "jdbc:mysql://localhost/studentDB";
		final String user = "onur";
		final String pass = "onurdb958";
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(host, user, pass);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return connection;
	}
	
	public static boolean Save(Student student) {
		int st = 0;
		boolean status = false;
		String SQL = "INSERT INTO `studentInfo`(`name`, `password`, `email`, `country`) VALUES (?,?,?,?)";

		try {
			Connection connection = StudentSQL.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getPassword());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setString(4, student.getCountry());
			
			st = preparedStatement.executeUpdate();
			if(st > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean Update(Student student) {
		int st = 0;
		boolean status = false;
		String SQL = "UPDATE `studentInfo` SET `name`=?,`password`=?,`email`=?,`country`=? WHERE `id`=?";

		try {
			Connection connection = StudentSQL.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getPassword());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setString(4, student.getCountry());
			preparedStatement.setInt(5, student.getId());
			
			st = preparedStatement.executeUpdate();
			if(st > 0) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean Delete(int Id) {
		int st = 0;
		boolean status = false;
		String SQL = "DELETE FROM `studentInfo` WHERE `id`=?";
		
		try {
			Connection connection = StudentSQL.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, Id);
			
			st = preparedStatement.executeUpdate();
			if (st > 0 ) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static Student ReadOneStudent(int Id) {
		Student student = new Student();
		
		try {
			String SQL = "SELECT * FROM `studentInfo` WHERE `id`=?";
			Connection connection = StudentSQL.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			preparedStatement.setInt(1, Id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setPassword(resultSet.getString(3));
				student.setEmail(resultSet.getString(4));
				student.setCountry(resultSet.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	public static List<Student> AllStudents() {
		List<Student> list = new ArrayList<Student>();
		try {
			String SQL = "SELECT * FROM `studentInfo`";
			Connection connection = StudentSQL.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SQL);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Student student = new Student();
				student.setId(resultSet.getInt(1));
				student.setName(resultSet.getString(2));
				student.setPassword(resultSet.getString(3));
				student.setEmail(resultSet.getString(4));
				student.setCountry(resultSet.getString(5));
				list.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
