package lfc.service;

import lfc.pojo.Account;
import lfc.pojo.Product;
import org.springframework.ui.Model;

import java.util.List;

public interface ProductService extends BaseService {
    List listALL() throws Exception;
    Integer lastOne() throws Exception;
    Product getById(int id) throws Exception;
    void fillAccountModel(Model model, List<Account> accounts)throws Exception;
}