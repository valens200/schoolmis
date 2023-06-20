package rw.ac.rca.webapp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rw.ac.rca.webapp.dao.*;
import rw.ac.rca.webapp.dao.impl.*;
import rw.ac.rca.webapp.orm.*;
import rw.ac.rca.webapp.orm.Student;
import rw.ac.rca.webapp.util.UserRole;
import rw.ac.rca.webapp.util.Util;

/**
 * Servlet implementation class CreateUser
 */
public class DeleteResource extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO = UserDAOImpl.getInstance();
    private MarkDAO markDAO = MarkDAOImpl.getInstance();
    private StudentDAO studentDAO = StudentDAOImpl.getInstance();
    private CourseDAO courseDAO = CourseDAOImpl.getInstance();
    private ManagerDAO managerDAO = ManagerDAOImpl.getInstance();
    private EmployeeDAO employeeDAO = EmployeeDAOImpl.getInstance();
    private InstructorDAO instructorDAO = InstructorDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteResource() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        String pageRedirect = request.getPathInfo().substring(1);
        int  id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("page");

        switch (action){
            case "deleteMark":
                request.setAttribute("message", "Are you sure do you want to delete this mark record?");
                request.setAttribute("id", id);
                request.setAttribute("path", "marks.php?page=marks&action=list");
                request.setAttribute("page", "deleteMark");
                request.getRequestDispatcher("WEB-INF/pages/validator/sure.jsp").forward(request, response);
                break;
            case "deleteStudent":
                request.setAttribute("message", "Are you sure do you want to delete this student?");
                request.setAttribute("id", id);
                request.setAttribute("page", "deleteStudent");
                request.setAttribute("path", "students.php");
                request.getRequestDispatcher("WEB-INF/pages/validator/sure.jsp").forward(request, response);
                break;
            case "deleteCourse":
                request.setAttribute("message", "Are you sure do you want to delete this course?");
                request.setAttribute("id", id);
                request.setAttribute("page", "deleteCourse");
                request.setAttribute("path", "listcourse.php");
                request.getRequestDispatcher("WEB-INF/pages/validator/sure.jsp").forward(request, response);
                break;
            case "deleteManager":
                request.setAttribute("message", "Are you sure do you want to delete this manager?");
                request.setAttribute("id", id);
                request.setAttribute("page", "deleteManager");
                request.setAttribute("path", "managers.php?page=managers&action=list");
                request.getRequestDispatcher("WEB-INF/pages/validator/sure.jsp").forward(request, response);
                break;
            case "deleteEmployee":
                request.setAttribute("message", "Are you sure do you want to delete this employee?");
                request.setAttribute("id", id);
                request.setAttribute("path", "employees.php?page=employees&action=list");
                request.setAttribute("page", "deleteEmployee");
                request.getRequestDispatcher("WEB-INF/pages/validator/sure.jsp").forward(request, response);
                break;
            case "deleteUser":
                request.setAttribute("message", "Are you sure do you want to delete this user?");
                request.setAttribute("id", id);
                request.setAttribute("path", "listuser.php");
                request.setAttribute("page", "deleteUser");
                request.getRequestDispatcher("WEB-INF/pages/validator/sure.jsp").forward(request, response);
                break;
            case "deleteInstructor":
                request.setAttribute("message", "Are you sure do you want to delete this instructor?");
                request.setAttribute("id", id);
                request.setAttribute("page", "deleteInstructor");
                request.setAttribute("path", "instructors.php?page=instructors&action=list");
                request.getRequestDispatcher("WEB-INF/pages/validator/sure.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("WEB-INF/pages/notfound.jsp").forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int  id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("page");

        switch (action){
            case "deleteMark":
                Mark availableMark = markDAO.getMarkById(id);
                markDAO.deleteMarkById(availableMark);
                request.setAttribute("responseMessage", "Mark deleted successfully");
                request.setAttribute("marks", markDAO.getAllMarks());
                request.getRequestDispatcher("WEB-INF/pages/marks.jsp").forward(request, response);
                break;
            case "deleteStudent":
                Student availableStudent = studentDAO.getStudentById(id);
                studentDAO.deleteStudent(availableStudent);
                request.setAttribute("responseMessage", "Student deleted successfully");
                request.setAttribute("students", studentDAO.getAllStudents());
                request.getRequestDispatcher("WEB-INF/pages/students.jsp").forward(request, response);
                break;
            case "deleteCourse":
                Course course = courseDAO.getCourseById(id);
                courseDAO.deleteCourse(course);
                request.setAttribute("responseMessage", "Course deleted successfully");
                request.setAttribute("courses", courseDAO.getAllCourses());
                request.getRequestDispatcher("WEB-INF/pages/courses.jsp").forward(request, response);
                break;
            case "deleteManager":
                Manager manager = managerDAO.getManagerById(id);
                managerDAO.deleteManager(manager);
                request.setAttribute("responseMessage", "Manager was deleted successfully");
                request.setAttribute("managers", managerDAO.getAllManagers());
                request.getRequestDispatcher("WEB-INF/pages/managers.jsp").forward(request, response);
                break;
            case "deleteEmployee":
                Employee employee = employeeDAO.getEmployeeById(id);
                employeeDAO.deleteEmployee(employee);
                request.setAttribute("responseMessage", "Employee deleted successfully");
                request.setAttribute("employees", employeeDAO.getAllEmployees());
                request.getRequestDispatcher("WEB-INF/pages/employees.jsp").forward(request, response);
                break;
            case "deleteUser":
                User user = userDAO.getUserById(id);
                userDAO.deleteUser(user);
                request.setAttribute("responseMessage", "User deleted successfully");
                request.setAttribute("users", userDAO.getAllUsers());
                request.getRequestDispatcher("WEB-INF/pages/users.jsp").forward(request, response);
                break;
            case "deleteInstructor":
                Instructor instructor = instructorDAO.getInstructorById(id);
                instructorDAO.deleteInstructor(instructor);
                request.setAttribute("responseMessage", "Instructor deleted successfully");
                request.setAttribute("instructors", instructorDAO.getAllInstructors());
                request.getRequestDispatcher("WEB-INF/pages/instructors.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("WEB-INF/pages/notfound.jsp").forward(request, response);
        }
    }
}


