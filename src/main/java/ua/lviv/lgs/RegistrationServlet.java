package ua.lviv.lgs;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = UserService.getUserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

         String firstName = request.getParameter("firstName");
         String lastName = request.getParameter("lastName");
         String email = request.getParameter("email");
         String password = request.getParameter("password");

         userService.saveUser(new User(firstName,lastName,email, password));

         HttpSession session = request.getSession(true);
         session.setAttribute("email", email);

         request.getRequestDispatcher("cabinet.jsp").forward(request,response);
    }
}
