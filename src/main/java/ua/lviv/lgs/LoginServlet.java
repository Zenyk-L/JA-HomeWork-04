package ua.lviv.lgs;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserService userService = UserService.getUserService();
        User user = userService.getUser(login);

        if (user == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else if (user.getPassword().equals(password)){
            request.setAttribute("email", login);
            request.getRequestDispatcher("cabinet.jsp").forward(request,response);

        }else request.getRequestDispatcher("login.jsp").forward(request,response);


    }
}
