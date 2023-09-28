package rw.ac.rca.webapp.web.course;

import rw.ac.rca.webapp.dao.CourseDAO;
import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
import rw.ac.rca.webapp.orm.Course;
import rw.ac.rca.webapp.util.Util;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateCourse
 */
public class CreateCourse extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CourseDAO courseDAO = CourseDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
        request.getRequestDispatcher("WEB-INF/pages/createcourse.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO register course

        Course course = new Course();
        String courseName = request.getParameter("courseName");
        String courseCode = request.getParameter("courseCode");
        Course savedCourse = courseDAO.getCourseByNameAndCode(courseName, courseCode);
        if (savedCourse == null) {
            course.setName(courseName);
            course.setCode(courseCode);
            course.setMaxStudent(Integer.parseInt(request.getParameter("maxStudent")));
            course.setMinStudent(Integer.parseInt(request.getParameter("minStudent")));
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            Date start = Util.parseDate(startDate);
            Date end = Util.parseDate(endDate);
            course.setStart(start);
            course.setEnd(end);
            courseDAO.saveCourse(course);
            request.setAttribute("message", "Course created successfully");
        } else {
            request.setAttribute("message", "Course already exists");
        }

        List<Course> courses = courseDAO.getAllCourses();
        request.setAttribute("courses", courses);
        request.getRequestDispatcher("WEB-INF/pages/course/listcourse.jsp").forward(request, response);
    }
}
