package olas.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import olas.pojo.Employees;
import olas.pojo.Supplies;
import olas.service.SuppliesService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "suppliesController")
@RequestScoped
public class SuppliesController implements Serializable {

    @ManagedProperty(value="#{suppliesService}") 
    
    @Autowired
    private SuppliesService suppliesService;

    public SuppliesService getSuppliesService() {
        return suppliesService;
    }

    public void setSuppliesService(SuppliesService suppliesService) {
        this.suppliesService = suppliesService;
    }
    
     private String itemCode = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
     private String itemCodes;
     private Employees employees;
     private String itemName;
     private String itemType;
     private String supplyName;
     private String supplyEmail;
     private String supplyPhone;
     private Double unitPrice;
     private Integer quantity;
     private Double totalPrice;
     private String manufacturedDate;
     private String expireDate;
     private String receiveDate;
     private String createdDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date()); // new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
     //for storing combox value
     private String empEmail; //primary key on the table
     private String mgsError;

    public String getItemCodes() {
        return itemCodes;
    }

    public void setItemCodes(String itemCodes) {
        this.itemCodes = itemCodes;
    }

    
    public String getMgsError() {
        return mgsError;
    }

    public void setMgsError(String mgsError) {
        this.mgsError = mgsError;
    }
     
    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }
     
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public String getSupplyEmail() {
        return supplyEmail;
    }

    public void setSupplyEmail(String supplyEmail) {
        this.supplyEmail = supplyEmail;
    }

    public String getSupplyPhone() {
        return supplyPhone;
    }

    public void setSupplyPhone(String supplyPhone) {
        this.supplyPhone = supplyPhone;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getManufacturedDate() {
        return manufacturedDate;
    }

    public void setManufacturedDate(String manufacturedDate) {
        this.manufacturedDate = manufacturedDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
     
    public SuppliesController() {
    }
    
    public String saveSupply(){                 
        Supplies s = new Supplies();
        Employees e = new Employees(empEmail);                                

        totalPrice = unitPrice * quantity;
        
        s.setItemCode(itemCode);
        s.setEmployees(e);
        s.setItemName(itemName);
        s.setItemType(itemType);
        s.setSupplyEmail(supplyEmail);
        s.setSupplyName(supplyName);
        s.setSupplyPhone(supplyPhone);
        s.setUnitPrice(unitPrice);
        s.setQuantity(quantity);
        s.setTotalPrice(totalPrice);
        s.setManufacturedDate(manufacturedDate);
        s.setExpireDate(expireDate);
        s.setReceiveDate(receiveDate);
        s.setCreatedDate(createdDate);
                       
        suppliesService.createdSupply(s);
        setFieldToNull();
        mgsError="Store Record Created!!!";

        return "store";
    }
    
    public String updateSupply(){
        Supplies s = new Supplies();
        Employees e = new Employees(empEmail);                                
        
        totalPrice = unitPrice * quantity;
                
        int mgs = suppliesService.checkSupply(itemCodes);
        if(mgs ==0){                      
            s.setItemCode(itemCodes);
            s.setEmployees(e);
            s.setItemName(itemName);
            s.setItemType(itemType);
            s.setSupplyEmail(supplyEmail);
            s.setSupplyName(supplyName);
            s.setSupplyPhone(supplyPhone);
            s.setUnitPrice(unitPrice);
            s.setQuantity(quantity);
            s.setTotalPrice(totalPrice);
            s.setManufacturedDate(manufacturedDate);
            s.setExpireDate(expireDate);
            s.setReceiveDate(receiveDate);
            s.setCreatedDate(createdDate);

            suppliesService.updateSupply(s);
            setFieldToNull();
            mgsError="Store Record Update!!!";                      
        }
            else if(mgs !=0){
            mgsError="Store Record Does Not Exist!!!"; 
        }
        return "store_edit";
    }
    
    public String deleteSupply(){
        Supplies s = new Supplies();
        Employees e = new Employees(empEmail);                               
                        
        int mgs = suppliesService.checkSupply(itemCodes);
        if(mgs ==0){
           
            s.setItemCode(itemCodes);
            s.setEmployees(e);
            s.setItemName(itemName);
            s.setItemType(itemType);
            s.setSupplyEmail(supplyEmail);
            s.setSupplyName(supplyName);
            s.setSupplyPhone(supplyPhone);
            s.setUnitPrice(unitPrice);
            s.setQuantity(quantity);
            s.setTotalPrice(totalPrice);
            s.setManufacturedDate(manufacturedDate);
            s.setExpireDate(expireDate);
            s.setReceiveDate(receiveDate);
            s.setCreatedDate(createdDate);
            
            suppliesService.deleteSupply(s);
            setFieldToNull();
            mgsError="Store Record Deleted!!!";                      
        }
            else if(mgs !=0){
            mgsError="Store Record Does Not Exist!!!"; 
        }        
        return "store_edit";
    }
    
    // Method To Fetch Particular Bar Details From The Database
	public String getSupplyDetailsByID() { 
        Supplies s = new Supplies();
//        Employees e = new Employees(empEmail);
//        e.setEmail(empEmail);
                               
       try{                                 
        List<Supplies> sList = suppliesService.listSupplyByID(itemCodes);
                System.out.println(itemCodes);
            int checkSupplyId = suppliesService.checkSupply(itemCodes);                
                if(checkSupplyId==0){                   
		for(Iterator it = sList.iterator(); it.hasNext();) {                    
                    s = (Supplies)it.next();                                       
                    
                    itemCodes = s.getItemCode();
                    empEmail = s.getEmployees().getEmail();
                    itemName = s.getItemName();
                    itemType = s.getItemType();
                    supplyEmail = s.getSupplyEmail();
                    supplyName = s.getSupplyName();
                    supplyPhone = s.getSupplyPhone();
                    unitPrice = s.getUnitPrice();
                    quantity = s.getQuantity();
                    totalPrice = s.getTotalPrice();
                    manufacturedDate = s.getManufacturedDate();
                    expireDate = s.getExpireDate();
                    receiveDate = s.getReceiveDate();
                    createdDate = s.getCreatedDate();                    
		}
                }else if(checkSupplyId!=0){
                    setMgsError("Store Record does not Exist!!");                                                          
                } 
       }catch(Exception ex){
           ex.printStackTrace();
       }
		return "store_edit";
    }
        
    public List<Supplies> getSupplyDetails() {            
        Supplies s = new Supplies();

        List<Supplies> sList = suppliesService.listSupply();
            for(Iterator it = sList.iterator();it.hasNext();) {                    
                s = (Supplies)it.next();

                itemCode = s.getItemCode();
                empEmail = s.getEmployees().getEmail();
                itemName = s.getItemName();
                itemType = s.getItemType();
                supplyEmail = s.getSupplyEmail();
                supplyName = s.getSupplyName();
                supplyPhone = s.getSupplyPhone();
                unitPrice = s.getUnitPrice();
                quantity = s.getQuantity();
                totalPrice = s.getTotalPrice();
                manufacturedDate = s.getManufacturedDate();
                expireDate = s.getExpireDate();
                receiveDate = s.getReceiveDate();
                createdDate = s.getCreatedDate();
            }               
            return sList;
    }
        
    public void setFieldToNull(){                                
        this.setItemCode("");        
        this.setEmployees(null);
        this.setItemName("");
        this.setItemType("");
        this.setSupplyEmail("");
        this.setSupplyName("");
        this.setSupplyPhone("");
        this.setUnitPrice(0.0);
        this.setQuantity(0);
        this.setTotalPrice(0.0);
        this.setManufacturedDate("");
        this.setExpireDate("");
        this.setReceiveDate("");
        this.setCreatedDate("");
        this.setEmpEmail("");        
    }
}
