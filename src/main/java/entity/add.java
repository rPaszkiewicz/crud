package entity;

import bean.Employee;
import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns ="/add")
public class add extends HttpServlet {

    private UserDao dao = new UserDao();
    private Employee emp = new Employee();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        emp.setName(request.getParameter("name"));
        emp.setLastName(request.getParameter("lastName"));
        emp.setEmail(request.getParameter("email"));
        try {
            dao.addEmployee(emp);
            if (dao.addEmployee(emp) > 0 ){
                out.print("działa");
            }else
                out.print("nie działa...");
           /* String result = dao.addEmployee(emp) > 0 ? "added" : "not added";
            out.print(result);*/
        }catch (NullPointerException e){
           out.print("gówno nie działa! " + e.getMessage());
        }
        //out.print(result);
        request.getRequestDispatcher("AddUser.jsp").include(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("AddUser.jsp");
    }
}
