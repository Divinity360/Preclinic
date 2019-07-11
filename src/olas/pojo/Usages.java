package olas.pojo;
// Generated Apr 24, 2019 11:19:43 PM by Hibernate Tools 4.3.1



/**
 * Usages generated by hbm2java
 */
public class Usages  implements java.io.Serializable {


     private String usageCode;
     private Employees employees;
     private Supplies supplies;
     private Integer usageQuantity;
     private String usageDate;
     private String createdDate;

    public Usages() {
    }

	
    public Usages(String usageCode) {
        this.usageCode = usageCode;
    }
    public Usages(String usageCode, Employees employees, Supplies supplies, Integer usageQuantity, String usageDate, String createdDate) {
       this.usageCode = usageCode;
       this.employees = employees;
       this.supplies = supplies;
       this.usageQuantity = usageQuantity;
       this.usageDate = usageDate;
       this.createdDate = createdDate;
    }
   
    public String getUsageCode() {
        return this.usageCode;
    }
    
    public void setUsageCode(String usageCode) {
        this.usageCode = usageCode;
    }
    public Employees getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
    public Supplies getSupplies() {
        return this.supplies;
    }
    
    public void setSupplies(Supplies supplies) {
        this.supplies = supplies;
    }
    public Integer getUsageQuantity() {
        return this.usageQuantity;
    }
    
    public void setUsageQuantity(Integer usageQuantity) {
        this.usageQuantity = usageQuantity;
    }
    public String getUsageDate() {
        return this.usageDate;
    }
    
    public void setUsageDate(String usageDate) {
        this.usageDate = usageDate;
    }
    public String getCreatedDate() {
        return this.createdDate;
    }
    
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }




}


