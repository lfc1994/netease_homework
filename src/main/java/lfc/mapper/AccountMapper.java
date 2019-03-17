package lfc.mapper;

import lfc.pojo.Account;
import lfc.pojo.AccountExample;

import java.util.List;

public interface AccountMapper extends BaseMapper<Account, AccountExample> {
    int insert(Account record);
    List<Account> selectAllByUID(Integer uid);
    List<Account> selectByExample(AccountExample example);

    Account selectByExampleWtih2Id(AccountExample example);
}
