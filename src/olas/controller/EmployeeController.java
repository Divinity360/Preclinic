package olas.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import olas.dao.EmployeeDaoImp;
import olas.dao.EmployeeLogin;
import olas.pojo.Employees;
import olas.service.EmployeeServ;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "employeeController")
@SessionScoped
public class EmployeeController implements Serializable {

    @ManagedProperty(value = "#{employeeServ}")

    @Autowired
    private EmployeeServ employeeServ;
    private Employees employees;

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public EmployeeServ getEmployeeServ() {
        return employeeServ;
    }

    public void setEmployeeServ(EmployeeServ employeeServ) {
        this.employeeServ = employeeServ;
    }

    private String email;


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private Boolean status;
    private String firstName;
    private String lastName;
    private String passwords;
    private String phone;
    private String position;
    private String createdDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    private String mgsError;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getMgsError() {
        return mgsError;
    }

    public void setMgsError(String mgsError) {
        this.mgsError = mgsError;
    }

    public EmployeeController() {
    }

    EmployeeLogin el = new EmployeeLogin();

    public String save() {
        Employees e = new Employees();
        e.setEmail(email);
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setPasswords(passwords);
        e.setPhone(phone);
        e.setPosition(position);
        e.setCreatedDate(createdDate);
        e.setStatus(status);
        try {
            int message = el.checkEmployeeLogin(email, passwords, position);
            if (message != 0) {
                employeeServ.createdEmplyee(e);
                setFieldToNull();
                mgsError = "Employee Record Created!!!";
            } else if (message == 0) {
                mgsError = "Employee Record Already Exist!!!";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "/edit-employee.xhtml";
    }

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    Employees emp = new Employees();
    EmployeeDaoImp employeeDaoImp = new EmployeeDaoImp();

    public String edit() {
        Employees emp = new Employees();
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();
        String field_sl_no = params.get("action");
        System.out.println("field sl no " + field_sl_no);
        emp = employeeDaoImp.getEmployeeById(field_sl_no);
        sessionMap.put("editemployee", emp);
        return "/edit-employee.xhtml";
    }

    public String edit(Employees emp) {
        employees = emp;
        this.mgsError = "";
        return "/edit-employee.xhtml";
    }

    public String update() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
        String empId= params.get("empId");

        Employees e = employeeDaoImp.getEmployeeById(empId);
        System.out.println(email);
        System.out.println("hiiiii" + e.getEmail());
        System.out.println(firstName);
        System.out.println(e.getFirstName());
        System.out.println(lastName);
        System.out.println(e.getLastName());
        System.out.println(passwords);
        System.out.println(e.getPasswords());
        System.out.println(phone);
        System.out.println(e.getPhone());
        System.out.println(position);
        e.setEmail(email);
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setPasswords(passwords);
        e.setPhone(phone);
        e.setPosition(position);
        e.setCreatedDate(createdDate);
        e.setStatus(status);

        employeeServ.updateEmplyee(employees);
        setFieldToNull();
        mgsError = "Employee Record Updated Successfully!!!";

        return "employee_getID";
    }

    public String delete() {
//        Employees e = new Employees();
//
//        e.setEmail(email);
//        e.setFirstName(firstName);
//        e.setLastName(lastName);
//        e.setPasswords(passwords);
//        e.setPhone(phone);
//        e.setPosition(position);
//        e.setCreatedDate(createdDate);
//        e.setStatus(status);

//        employeeServ.deleteEmployee(employees);
//        setFieldToNull();
//        mgsError = "Employee Record Deleted Successfully!!!";
//
        return "employee_getID";
    }

    // Method To Fetch Particular Employee Details From The Database
    public String getEmployeeDetailsByID() {
        Employees e = new Employees();
        List<Employees> employeeList = employeeServ.listEmployeeByID(email);
        int checkId = employeeServ.checkEmployeeLogin(email);
        if (checkId == 0) {
            for (Iterator it = employeeList.iterator(); it.hasNext(); ) {
                e = (Employees) it.next();

                email = e.getEmail();
                firstName = e.getFirstName();
                lastName = e.getLastName();
                passwords = e.getPasswords();
                phone = e.getPhone();
                position = e.getPosition();
            }
        } else if (checkId != 0) {
            setMgsError("Employee Record does not Exist!!");
        }

        return "employee_edit";
    }

    // Method To Fetch All Employees Details From The Database
    public List<Employees> getEmployeeDetails() {
//        Employees e = new Employees();
        List<Employees> employeeList = employeeServ.listEmployee();
//        for (Iterator it = employeeList.iterator(); it.hasNext(); ) {
//            e = (Employees) it.next();
//            email = e.getEmail();
//            firstName = e.getFirstName();
//            lastName = e.getLastName();
//            passwords = e.getPasswords();
//            phone = e.getPhone();
//            position = e.getPosition();
//            createdDate = e.getCreatedDate();
//        }
        return employeeList;
    }


    public void setFieldToNull() {
        this.setEmail("");
        this.setFirstName("");
        this.setLastName("");
        this.setPasswords("");
        this.setPhone("");
        this.setPosition("");
        this.setCreatedDate("");
    }


}
