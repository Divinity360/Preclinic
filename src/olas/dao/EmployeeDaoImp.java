package olas.dao;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import olas.pojo.Employees;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.HibernateUtil;

@Named
@Repository("employeeDao")
public class EmployeeDaoImp implements EmployeeDao {
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdEmplyee(Employees e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        e.setEmail(e.getEmail());                
        e.setFirstName(e.getFirstName());
        e.setLastName(e.getLastName());
        e.setPasswords(e.getPasswords());        
        e.setPhone(e.getPhone());                
        e.setPosition(e.getPosition());
        e.setCreatedDate(e.getCreatedDate());
        e.setStatus(e.getStatus());
        session.save(e);
        trans.commit();
    }

    @Override
    public void updateEmplyee(Employees e) {


        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        
        e.setEmail(e.getEmail());                
        e.setFirstName(e.getFirstName());
        e.setLastName(e.getLastName());
        e.setPasswords(e.getPasswords());        
        e.setPhone(e.getPhone());                
        e.setPosition(e.getPosition());
        e.setCreatedDate(e.getCreatedDate());
        e.setStatus(e.getStatus());
               
        session.update(e);
        trans.commit();
    }

    @Override
    public void deleteEmployee(Employees e) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        
        e.setEmail(e.getEmail());                
        e.setFirstName(e.getFirstName());
        e.setLastName(e.getLastName());
        e.setPasswords(e.getPasswords());        
        e.setPhone(e.getPhone());                
        e.setPosition(e.getPosition());
        e.setCreatedDate(e.getCreatedDate());
        e.setStatus(e.getStatus());
        
        session.delete(e);                         
        trans.commit();
    }

    @Override
    public List<Employees> listEmployeeByID(String UserId) {
        Employees eObj = new Employees();
        List<Employees> eList = new ArrayList<Employees>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from Employees where id = :id").setString("id", UserId);
        eObj = (Employees)queryObj.uniqueResult();
        eList = queryObj.list();
//        for(Employees em: eList){
////            System.out.println(em.getEmail());
////            System.out.println(em.getFirstName());            
//        }
        trans.commit();
        return eList;
    }

    @Override
    public Employees getEmployeeById(String UserId) {
        Employees eObj = new Employees();
        List<Employees> eList = new ArrayList<Employees>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from Employees where id = :id").setString("id", UserId);
        queryObj.setMaxResults(1);
        eObj = (Employees) queryObj.uniqueResult();
        trans.commit();
        return eObj;
    }

    @Override
    public List<Employees> listEmployee() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Employees> listEmployees = session.createQuery("select e from Employees e").list();

        trans.commit();
        return listEmployees;
    }

    @Override
    public int checkEmployeeLogin(String email_id) {
        int status = 1;
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction trans = session.beginTransaction();
         Query q = session.createQuery("from Employees where email= :email").setString("email", email_id);			        
         List employeeList = q.list();
         for(Iterator it = employeeList.iterator(); it.hasNext();){
         Employees emp =(Employees)it.next();

         if(emp.getEmail().equals(email_id)){                 
             return status=0;
            }             
         }              
         trans.commit();
         return status;
    }
    
    
     public static void main(String employee[]){
        EmployeeDaoImp daoImp = new EmployeeDaoImp();
        Employees e = new Employees();
//
        String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());


//     insert
//        e.setEmail("adeola@gmail.com");
//        e.setFirstName("Adeola");
//        e.setLastName("Debuger");
//        e.setPasswords("123");
//        e.setPhone("08099901122");
//        e.setPosition("Store Manager");
//        e.setCreatedDate(createdDate);
//        e.setStatus(true);
//        daoImp.createdEmplyee(e);
////////
////////getEmployeeByID
//////        System.out.println(daoImp.listEmployeeByID("oal@gmail.com"));
//////        System.out.println(daoImp.checkEmployeeLogin("oal@gmail.com"));
//////
//         List<Employees> a = daoImp.listEmployeeByID("1");
//         Employees b = a.get(0);
//         System.out.println(b.getEmail());

//////        //update
////        e.setEmail("oal@gmail.com");               
////        e.setFirstName("ade");
////        e.setLastName("ola");
////        e.setPasswords("123");        
////        e.setPhone("08099901122");                
////        e.setPosition("Store Manager");                
////        e.setCreatedDate(createdDate);
//////        daoImp.updateEmplyee(e);
////        
//////        //delete        
////        e.setEmail("oal@gmail.com");
////        daoImp.deleteEmployee(e);
//////        
//////        //getAllEmployeesDetail
//////        List<Employees> liste = daoImp.listEmployee();
//////        for(Iterator it = liste.iterator(); it.hasNext();){
//////            Employees emp = (Employees) it.next();
//////            System.out.println(emp.getEmail()+ " : "+emp.getFirstName()+ " : "+emp.getLastName());           
//////        }
//////     
    }

}
