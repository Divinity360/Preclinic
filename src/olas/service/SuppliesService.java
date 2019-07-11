package olas.service;

import java.util.List;
import olas.pojo.Supplies;

public interface SuppliesService {
    public void createdSupply(Supplies s);
    public void updateSupply(Supplies s);
    public void deleteSupply(Supplies s);
    public List<Supplies> listSupplyByID(String id);    
    public List<Supplies> listSupply(); 
    public int checkSupply(String id);
    
}
