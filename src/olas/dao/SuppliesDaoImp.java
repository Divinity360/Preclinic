package olas.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.inject.Named;
import olas.pojo.Employees;
import olas.pojo.Supplies;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import util.HibernateUtil;

@Named
@Repository("suppliesDao")
public class SuppliesDaoImp implements SuppliesDao {
    
    private SessionFactory sessionFactory;

    @Autowired        
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public void createdSupply(Supplies s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();                
        session.save(s);
        trans.commit();
    }

    @Override
    public void updateSupply(Supplies s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();        
        session.update(s);
        trans.commit();
    }

    @Override
    public void deleteSupply(Supplies s) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();               
        session.delete(s);
        trans.commit();
    }

    @Override
    public List<Supplies> listSupplyByID(String id) {
        Supplies sObj = new Supplies();
        List<Supplies> resList = new ArrayList<Supplies>();        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query queryObj = session.createQuery("from Supplies where itemCode  = :itemCode").setString("itemCode", id);
        sObj = (Supplies)queryObj.uniqueResult();        
        resList = queryObj.list();        
        trans.commit();
        return resList;
    }

    @Override
    public List<Supplies> listSupply() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        List<Supplies> listBar = session.createQuery("select s from Supplies s").list();
        
        trans.commit();
        return listBar;
    }

    @Override
    public int checkSupply(String id) {
        int status = 1;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        Query q = session.createQuery("from Supplies where itemCode = :itemCode").setString("itemCode", id);			        
        List stList = q.list();
        for(Iterator it = stList.iterator(); it.hasNext();){
        Supplies s =(Supplies)it.next();
        if(s.getItemCode().equals(id)){                 
             return status=0;
            }             
          }              
          trans.commit();
          return status;
    }
    
        public static void main(String employee[]){
        SuppliesDaoImp daoImp = new SuppliesDaoImp();
        Employees e = new Employees();
        e.setEmail("vhv");
        Supplies s = new Supplies();

        String createdDate =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()); 

//      itemCode;   employees;  itemName;  itemType;   supplyName;   supplyEmail;    supplyPhone;  unitPrice; 
//      quantity;      totalPrice;    manufacturedDate;    expireDate;      receiveDate;     createdDate;
        
        
//     insert        
        s.setEmployees(e);    
        s.setItemCode("001");
        s.setItemName("White Flour");
        s.setItemType("Flour");
        s.setSupplyName("Mr. Adekanbi");
        s.setSupplyEmail("adekanbi@yahoo.com");
        s.setSupplyPhone("0908912344");
        s.setUnitPrice(25000.0);
        s.setQuantity(20);
        s.setTotalPrice(25000.0 * 20);
        s.setManufacturedDate("2018-08-08");
        s.setExpireDate("2020-09-09");
        s.setReceiveDate(createdDate);
        s.setCreatedDate(createdDate);
        daoImp.createdSupply(s);
        
//     update        
//        s.setEmployees(e);
//        s.setItemCode("001");
//        s.setItemName("White Flour");
//        s.setItemType("Flour");
//        s.setSupplyName("Adebola");
//        s.setSupplyEmail("adebola@yahoo.com");
//        s.setSupplyPhone("0908912344");
//        s.setUnitPrice(25000.0);
//        s.setQuantity(20);
//        s.setTotalPrice(25000.0 * 20);
//        s.setManufacturedDate("2018-08-08");
//        s.setExpireDate("2020-09-09");
//        s.setReceiveDate(createdDate);
//        s.setCreatedDate(createdDate);
//        daoImp.updateSupply(s);
////
//////getEmployeeByID
//        List<Supplies> listS = daoImp.listSupplyByID("001");
//        for(Iterator it = listS.iterator(); it.hasNext();){
//            Supplies rm = (Supplies) it.next();
//            System.out.println(rm.getEmployees().getEmail()+ " : "+ rm.getItemCode()+ " : "+rm.getItemType());           
//        }
//        System.out.println(daoImp.checkSupply("oal@gmail.com"));
////        
////        //update
//        e.setEmail("oal@gmail.com");               
//        e.setFirstName("ade");
//        e.setLastName("ola");
//        e.setPasswords("123");        
//        e.setPhone("08099901122");                
//        e.setPosition("Store Manager");                
//        e.setCreatedDate(createdDate);
////        daoImp.updateEmplyee(e);
//        
////        //delete        
//        e.setEmail("oal@gmail.com");
//        daoImp.deleteEmployee(e);
////        
////        //getAllEmployeesDetail
////        List<Employees> liste = daoImp.listEmployee();
////        for(Iterator it = liste.iterator(); it.hasNext();){
////            Employees emp = (Employees) it.next();
////            System.out.println(emp.getEmail()+ " : "+emp.getFirstName()+ " : "+emp.getLastName());           
////        }
////     
    }

    
}
