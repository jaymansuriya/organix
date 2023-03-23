package com.college.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.college.model.Faculty;

public class FacultyDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/college_db";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_FACULTY_SQL = "INSERT INTO faculty " + "  ( faculty_name, faculty_dept, faculty_salary) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_FACULTY_BY_ID = "select *  from faculty where f_id =?";
	private static final String SELECT_ALL_FACULTY = "select * from faculty";
	private static final String DELETE_FACULTY_SQL = "delete from faculty where  f_id = ?;";
	private static final String UPDATE_FACULTY_SQL = "update faculty set faculty_name= ?, faculty_dept =?, faculty_salary =? where f_id = ?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public void insertFaculty (Faculty faculty) throws SQLException {
		System.out.println(INSERT_FACULTY_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_FACULTY_SQL)) {
			preparedStatement.setString(1, faculty.getName());
			preparedStatement.setString(2, faculty.getDepartment());
			preparedStatement.setInt(3, faculty.getSalary());
			
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public Faculty selectFaculty(int id) {
		Faculty faculty = null;
		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FACULTY_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString(2);
				int salary = Integer.parseInt(rs.getString(4));
				String dept = rs.getString(3);
				
				faculty = new Faculty(id, name, dept, salary);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return faculty;
	}
	
	public List<Faculty> selectAllFaculty() {

		List<Faculty> faculty = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_FACULTY);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int salary = Integer.parseInt(rs.getString(4));
				String dept = rs.getString(3);
				
				
				faculty.add(new Faculty(id, name, dept, salary));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return faculty;
	}
	
	
	public boolean updateFaculty(Faculty faculty) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FACULTY_SQL);) {
			preparedStatement.setString(1, faculty.getName());
			preparedStatement.setString(2, faculty.getDepartment());
			preparedStatement.setInt(3, faculty.getSalary());
			preparedStatement.setInt(4, faculty.getId());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean deleteFaculty(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_FACULTY_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
