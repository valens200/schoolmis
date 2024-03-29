package rw.ac.rca.webapp.web.course;

import rw.ac.rca.webapp.dao.CourseDAO;
import rw.ac.rca.webapp.dao.UserDAO;
import rw.ac.rca.webapp.dao.impl.CourseDAOImpl;
import rw.ac.rca.webapp.orm.Course;
import rw.ac.rca.webapp.orm.User;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateCourse
 */
public class UpdateCourse extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private  CourseDAO courseDAO = CourseDAOImpl.getInstance();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String pageRedirect = request.getPathInfo().substring(1);
        String id = request.getParameter("id");
        HttpSession httpSession = request.getSession();
        Object user = httpSession.getAttribute("authenticatedUser");
        System.out.println("The user in session is: " + user);
        request.getRequestDispatcher("WEB-INF/updateCourse.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageRedirect = request.getParameter("page");
        HttpSession httpSession = request.getSession();
        if(pageRedirect != null){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            if(pageRedirect.equals("createcourse")){
                Course course = null;
                try {
                    course = new Course(
                            request.getParameter("name"),
                            request.getParameter("code"),
                            Integer.parseInt(request.getParameter("min")),
                            Integer.parseInt(request.getParameter("max")),
                            simpleDateFormat.parse(request.getParameter("start")),
                            simpleDateFormat.parse(request.getParameter("end")),
                            false
                    );
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                // updating  the course;
                try {
                    courseDAO.saveOrUpdateCourse(course);
                    request.setAttribute("success" , "Successfully updated the Course" );
                    request.getRequestDispatcher("WEB-INF/courses.jsp").forward(request , response);
                }catch (Exception e){
                    request.setAttribute("error" , "Failed to create the Course" );
                    request.getRequestDispatcher("WEB-INF/createCourse.jsp").forward(request , response);
                }
            }else{
                request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
            }
        }else{
            request.getRequestDispatcher("WEB-INF/login.jsp").forward(request , response);
        }
    }
}
