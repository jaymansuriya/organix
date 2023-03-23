package com.college.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.college.dao.FacultyDAO;
import com.college.dao.StudentDAO;
import com.college.model.Faculty;
import com.college.model.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;
	private FacultyDAO facultyDAO;


	public ServletController() {
		this.studentDAO = new StudentDAO();
		this.facultyDAO = new FacultyDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getServletPath();

		try {
			switch (action) {
			
			case "/newFaculty":
				showNewFacultyForm(request, response);
				break;
			case "/insertFaculty":
				insertFaculty(request, response);
				break;
			case "/deleteFaculty":
				deleteFaculty(request, response);
				break;
			case "/editFaculty":
				showEditFacultyForm(request, response);
				break;
			case "/updateFaculty":
				updateFaculty(request, response);
				break;
			case "/new":
				showNewStudentForm(request, response);
				break;
			case "/insert":
				insertStudent(request, response);
				break;
			case "/delete":
				deleteStudent(request, response);
				break;
			case "/edit":
				showEditStudentForm(request, response);
				break;
			case "/update":
				updateStudent(request, response);
				break;
			case "/listFaculty":
				listFaculty(request, response);
				break;
			
			default:
				listStudent(request, response);
				
				
				
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
	}
	private void listFaculty(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Faculty> listFaculty = facultyDAO.selectAllFaculty();
		request.setAttribute("listFaculty", listFaculty);
		RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Student> listStudent = studentDAO.selectAllStudent();
		request.setAttribute("listStudent", listStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditStudentForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent = studentDAO.selectStudent(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		request.setAttribute("student", existingStudent);
		dispatcher.forward(request, response);

	}

	private void insertStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("sname");
		int rno = Integer.parseInt(request.getParameter("srno"));
		String dept = request.getParameter("sdept");
		int sem = Integer.parseInt(request.getParameter("ssem"));
		Student newStudent = new Student(rno, name, dept, sem);
		studentDAO.insertStudent(newStudent);
		response.sendRedirect("list");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		
		String name = request.getParameter("sname");
		int rno = Integer.parseInt(request.getParameter("srno"));
		String dept = request.getParameter("sdept");
		int sem = Integer.parseInt(request.getParameter("ssem"));

		Student student = new Student(id, rno, name, dept, sem);
		studentDAO.updateStudent(student);
		response.sendRedirect("list");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		studentDAO.deleteStudent(id);
		response.sendRedirect("list");

	}
	
	
	private void showNewFacultyForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-form.jsp");
		dispatcher.forward(request, response);
	}



	private void showEditFacultyForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Faculty existingFaculty = facultyDAO.selectFaculty(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("faculty-form.jsp");
		request.setAttribute("faculty", existingFaculty);
		dispatcher.forward(request, response);

	}

	private void insertFaculty(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("fname");
		int slary = Integer.parseInt(request.getParameter("fsalary"));
		String dept = request.getParameter("fdept");
		Faculty newFaculty = new Faculty(name, dept, slary);
		facultyDAO.insertFaculty(newFaculty);
		response.sendRedirect("listFaculty");
	}

	private void updateFaculty(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("fname");
		int slary = Integer.parseInt(request.getParameter("fsalary"));
		String dept = request.getParameter("fdept");

		Faculty student = new Faculty(id, name, dept, slary);
		facultyDAO.updateFaculty(student);

		response.sendRedirect("listFaculty");
	}

	private void deleteFaculty(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		facultyDAO.deleteFaculty(id);
		response.sendRedirect("listFaculty");

	}
	
	

}
