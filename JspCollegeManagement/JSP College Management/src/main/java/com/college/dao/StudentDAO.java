package com.college.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.college.model.Student;





public class StudentDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/college_db";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	
	private static final String INSERT_STUDENT_SQL = "INSERT INTO student " + "  (student_roll_no, student_name, student_dept, student_sem) VALUES "
			+ " (?, ?, ?, ?);";

	private static final String SELECT_STUDENT_BY_ID = "select student_roll_no, student_name, student_dept, student_sem  from student where student_id =?";
	private static final String SELECT_ALL_STUDENTS = "select * from student";
	private static final String DELETE_STUDENT_SQL = "delete from student where student_id = ?;";
	private static final String UPDATE_STUDENT_SQL = "update student set student_roll_no = ?,student_name= ?, student_dept =?, student_sem =? where student_id = ?;";
	
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
	
	
	public void insertStudent(Student student) throws SQLException {
		System.out.println(INSERT_STUDENT_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
			preparedStatement.setInt(1, student.getRollNo());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getDepartment());
			preparedStatement.setInt(4, student.getSem());
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	public Student selectStudent(int id) {
		Student student = null;
		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString(2);
				int rno = Integer.parseInt(rs.getString(1));
				String dept = rs.getString(3);
				int sem = Integer.parseInt(rs.getString(4));
				student = new Student(id, rno, name, dept, sem);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return student;
	}
	
	public List<Student> selectAllStudent() {

		List<Student> students = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(5);
				String name = rs.getString(2);
				int rno = rs.getInt(1);
				int sem = rs.getInt(4);
				
				String dept = rs.getString(3);
				
				students.add(new Student(id, rno, name, dept, sem));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return students;
	}
	
	
	public boolean updateStudent(Student student) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL);) {
			preparedStatement.setInt(1, student.getRollNo());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setString(3, student.getDepartment());
			preparedStatement.setInt(4, student.getSem());
			preparedStatement.setInt(5, student.getId());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean deleteStudent(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);) {
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
