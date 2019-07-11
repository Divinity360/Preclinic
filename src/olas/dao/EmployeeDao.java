package olas.dao;

import java.util.List;
import olas.pojo.Employees;

public interface EmployeeDao {
    public void createdEmplyee(Employees e);
    public void updateEmplyee(Employees e);
    public void deleteEmployee(Employees e);
    public List<Employees> listEmployeeByID(String emailId);    
    public List<Employees> listEmployee(); 
    public int checkEmployeeLogin(String email_id);
    public Employees getEmployeeById(String id);
}
