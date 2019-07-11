package olas.service;

import java.util.List;
import olas.pojo.Employees;

public interface EmployeeServ {
    public void createdEmplyee(Employees e);
    public void updateEmplyee(Employees e);
    public void deleteEmployee(Employees e);
    public List<Employees> listEmployeeByID(String emailId);    
    public List<Employees> listEmployee(); 
    public int checkEmployeeLogin(String email_id);
    
}
