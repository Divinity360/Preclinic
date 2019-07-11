package olas.dao;

import java.util.Iterator;
import java.util.List;
import javax.faces.context.FacesContext;
import olas.pojo.Employees;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import util.HibernateUtil;

public class EmployeeLogin {
    private SessionFactory sessionFactory;
    
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    Session session = HibernateUtil.getSessionFactory().openSession();  
    
    public int checkEmployeeLogin(String email_id, String pwd, String position){
             int status = 1;
             Query q = session.createQuery("from Employees where email= :email and passwords = :passwords and position = :position").setString("email", email_id).setString("passwords", pwd).setString("position", position);			        
             List employeeList = q.list();
             for(Iterator it = employeeList.iterator(); it.hasNext();){
             Employees emp =(Employees)it.next();
                          
             if(emp.getEmail().equals(email_id) && emp.getPasswords().equals(pwd) && emp.getPosition().equals("Store Manager")){                 
                               
//                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("sEmail", emp.getEmail());              
                               
//                 String email_db = emp.getEmail();                                                  
//                 String positiion_db = emp.getPosition();                   
//                                  
//                 System.out.println(email_db);                                 
//                 System.out.println(positiion_db);                 
                                  
                 return status=0;
            }                          
        }    
            return status;
    }
    
        public static void main(String checkEmp[]){
        EmployeeLogin empLogin = new EmployeeLogin();
            
        System.out.println(empLogin.checkEmployeeLogin("ola@gmail.com", "123","Store Manager"));
              
    }

}
