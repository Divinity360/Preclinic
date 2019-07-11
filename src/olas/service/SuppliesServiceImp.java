package olas.service;

import java.util.List;
import javax.inject.Named;
import olas.dao.SuppliesDao;
import olas.pojo.Supplies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Named
@Service("suppliesService")
@Transactional(readOnly = true)
public class SuppliesServiceImp implements SuppliesService{
    @Autowired
    SuppliesDao suppliesDao; 

    @Override
    public void createdSupply(Supplies s) {
        suppliesDao.createdSupply(s);
    }

    @Override
    public void updateSupply(Supplies s) {
        suppliesDao.updateSupply(s);
    }

    @Override
    public void deleteSupply(Supplies s) {
        suppliesDao.deleteSupply(s);
    }

    @Override
    public List<Supplies> listSupplyByID(String id) {
        return suppliesDao.listSupplyByID(id);
    }

    @Override
    public List<Supplies> listSupply() {
        return suppliesDao.listSupply();
    }

    @Override
    public int checkSupply(String id) {
        return suppliesDao.checkSupply(id);
    }
    
}
