package entity;

import bean.Employee;
import dao.UserDao;

import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
        UserDao dao = new UserDao();
        if (dao.getConnection()!=null){
            System.out.println("connected");
        }else{
            System.out.println("not...");
        }
        List<Employee>list = dao.getAllEmployees();
        list.forEach(System.out::println);
    }
}
