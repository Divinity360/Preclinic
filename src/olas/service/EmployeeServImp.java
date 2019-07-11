package olas.service;

import java.util.List;
import javax.inject.Named;
import olas.dao.EmployeeDao;
import olas.pojo.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("employeeServ")
@Transactional(readOnly = true)
public class EmployeeServImp implements EmployeeServ{
    @Autowired
    EmployeeDao employeeDao; 

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void createdEmplyee(Employees e) {
        employeeDao.createdEmplyee(e);
    }

    @Override
    public void updateEmplyee(Employees e) {
        employeeDao.updateEmplyee(e);
    }

    @Override
    public void deleteEmployee(Employees e) {
        employeeDao.deleteEmployee(e);
    }

    @Override
    public List<Employees> listEmployeeByID(String emailId) {
        return employeeDao.listEmployeeByID(emailId);
    }

    @Override
    public List<Employees> listEmployee() {
        return employeeDao.listEmployee();
    }

    @Override
    public int checkEmployeeLogin(String email_id) {
        return employeeDao.checkEmployeeLogin(email_id);
    }
    
}
