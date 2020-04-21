package entity;

import bean.Employee;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/viewServlet")
public class viewServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> list = new UserDao().getAllEmployees();
        if(list.isEmpty()){
            response.setContentType("text/html");
            response.getWriter().print("list is empty " + list.size());
        }else {
            request.setAttribute("emp",list);
            request.getRequestDispatcher("ViewUsers.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
