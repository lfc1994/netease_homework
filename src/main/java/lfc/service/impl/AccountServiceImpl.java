package lfc.service.impl;

import lfc.mapper.AccountMapper;
import lfc.pojo.Account;
import lfc.pojo.AccountExample;
import lfc.pojo.base.BaseExample;
import lfc.service.AccountService;
import lfc.util.ProductUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl extends BaseServiceImpl<AccountMapper, AccountExample> implements AccountService {

   public void addBatch (List<ProductUtil> productUtilList, int uid) throws Exception{
       for (ProductUtil productUtil: productUtilList
            ) {
           Account account = new Account();
           account.setUid(uid);
           account.setPid(productUtil.getId());
           account.setNumber(productUtil.getNumber());
           account.setPaytime(new Date());
           account.setPrice(BigDecimal.valueOf(productUtil.getPrice()));
           mapper.insertSingle(account);
       }
   }

    @Override
    public List<Account> getByUid(int uid) throws Exception {
        List<Account> accounts = mapper.selectAllByUID(uid);
        return accounts;
    }

    public List listALL() throws Exception {
        BaseExample example = getExample();
        example.setOrderByClause("id");
        List result = mapper.selectByExampleALL(example);
        return result;
    }

    @Override
    public Account getByUidPid(int uid, int pid) throws Exception {
        AccountExample example = new AccountExample();
        example.setPid(pid);
        example.setUid(uid);
        return  (Account) mapper.selectByExampleWtih2Id(example);
    }
}
