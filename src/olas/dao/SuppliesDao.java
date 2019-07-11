package olas.dao;

import java.util.List;
import olas.pojo.Supplies;

public interface SuppliesDao {
    public void createdSupply(Supplies s);
    public void updateSupply(Supplies s);
    public void deleteSupply(Supplies s);
    public List<Supplies> listSupplyByID(String id);    
    public List<Supplies> listSupply(); 
    public int checkSupply(String id); 
    
}
