package lfc.service;

import lfc.pojo.Account;
import lfc.util.ProductUtil;

import java.util.List;

public interface AccountService extends BaseService {
    void addBatch (List<ProductUtil> productUtilList, int uid) throws Exception;
    List<Account> getByUid(int uid) throws Exception;
    List listALL() throws Exception;
    Account getByUidPid(int uid,int pid) throws Exception;
}
