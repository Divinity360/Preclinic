package olas.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import olas.dao.EmployeeLogin;

@ManagedBean(name="employeeLoginController")
@RequestScoped
public class EmployeeLoginController {
    private String email; // = "ola@gmail.com";
    private String password; // = "123";    
    private static final String position ="Store Manager";        
    private String email_Error;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_Error() {
        return email_Error;
    }

    public void setEmail_Error(String email_Error) {
        this.email_Error = email_Error;
    }

    public EmployeeLoginController() {
    }
    
    public String submitAction(){
    EmployeeLogin empLogin = new EmployeeLogin();

    int msgStore = empLogin.checkEmployeeLogin(email, password, position);    

    if(msgStore==0){            
        setFieldToNull();
        return "store";
    }           
    else if(msgStore!=0)            
        setEmail_Error("Employee Record Doesn't Exists. Try again");                                   
        setFieldToNull();
        return "index";          
}
    
    public void setFieldToNull(){
        this.setEmail("");        
        this.setPassword("");
    //    this.setEmail_Error("");
    }
    
//        public static void main(String EmployeeLogin[]){
//        EmployeeLoginController empCon = new EmployeeLoginController();
//        System.out.println(empCon.submitAction());        
//    }


    
}
