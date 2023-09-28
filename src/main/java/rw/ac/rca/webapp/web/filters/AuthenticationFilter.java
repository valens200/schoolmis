package rw.ac.rca.webapp.web.filters;

import javax.servlet.*;
import java.io.IOException;

public class AuthenticationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code (if needed)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Check if the user is authenticated (you need to define this logic)
        boolean isAuthenticated = request.getAttribute("authenticatedUser") != null;
        System.out.println("The user is authenticated in filter: " + isAuthenticated);

        if (isAuthenticated) {
            // If authenticated, allow the request to proceed
            chain.doFilter(request, response);
        } else {
            // If not authenticated, redirect to the login page or display an error
            // For example, you can redirect to a login page:
            request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
        }
    }

    public void destroy() {
        // Cleanup code (if needed)
    }
}
