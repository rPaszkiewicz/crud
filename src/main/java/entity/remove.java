package entity;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns ="/remove")

public class remove extends HttpServlet {
    private UserDao dao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //dao = (UserDao) request.getAttribute("dao");
        //dao.removeUserById(id);
        //request.getSession().setAttribute("dao",dao);
        request.getRequestDispatcher("ViewUsers.jsp").forward(request,response);
    }
}
