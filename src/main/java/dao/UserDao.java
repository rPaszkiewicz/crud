package dao;

import bean.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserDao {

    //private final String ADD_EMPLOYEE="INSERT INTO employee (name, last_name, email) VALUES (?,?,?)";

    public Connection getConnection() {
        Connection connection=null;
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbc = "jdbc:mysql://localhost:3306/employee_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(jdbc, user, password);
        }
        catch (SQLException  e){
            e.printStackTrace();
        }
        return connection;
    }
    public int addEmployee(Employee emp){
        int result=0;
        try{
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO employee (name, Last_name, email) VALUES ('" + emp.getName() +"', '"+ emp.getLastName()+"', '"+emp.getEmail()+"')");
           /* ps.setString(1,emp.getName());
            ps.setString(2,emp.getLastName());
            ps.setString(3,emp.getEmail());*/
            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public List<Employee> getAllEmployees(){
        List<Employee> list = new ArrayList<>();
        try{
            Connection connection = getConnection();
            String GET_EMPLOYEES = "SELECT * FROM employee";
            PreparedStatement ps = connection.prepareStatement(GET_EMPLOYEES);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Employee emp = new Employee();
                emp.setName(rs.getString("name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setEmail(rs.getString("email"));
                emp.setId(rs.getInt("id"));
                list.add(emp);
            }
        }catch (SQLException | NullPointerException e){
            e.printStackTrace();
        }
        list.sort(Comparator.comparing(Employee::getId));
        return list;
    }
    public int removeById(int id){
        int result = 0;
        try{
            Connection connection = getConnection();
            String DELETE_EMPLOYEE = "DELETE FROM employee WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(DELETE_EMPLOYEE);
            ps.setInt(1,id);
            result = ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public Employee getById(){
        Employee emp = new Employee();
        try {
            Connection connection = getConnection();
            String GET_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(GET_EMPLOYEE_BY_ID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                emp.setName(rs.getString("name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setEmail(rs.getString("email"));
                emp.setId(rs.getInt("id"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return emp;
    }
    public int updateEmployee(Employee emp){
        int result=0;
        try{
            Connection connection = getConnection();
            String UPDATE_EMPLOYEE = "UPDATE employee set name=?, last_name=?, email=? WHERE id=?";
            PreparedStatement ps = connection.prepareStatement(UPDATE_EMPLOYEE);
            ps.setString(1,emp.getName());
            ps.setString(2,emp.getLastName());
            ps.setString(3,emp.getEmail());
            ps.setInt(4,emp.getId());
            result = ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
}