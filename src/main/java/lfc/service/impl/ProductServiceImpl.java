package lfc.service.impl;

import lfc.mapper.ProductMapper;
import lfc.pojo.Account;
import lfc.pojo.Product;
import lfc.pojo.ProductExample;
import lfc.pojo.base.BaseExample;
import lfc.pojo.base.BasePOJO;
import lfc.service.ProductService;
import lfc.util.AccoutUtil;
import lfc.util.ProductUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.rmi.NoSuchObjectException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductMapper, ProductExample> implements ProductService {
    public List listALL() throws Exception {
        BaseExample example = getExample();
        example.setOrderByClause("id");
        List result = mapper.selectByExampleALL(example);
        return result;
    }

    public Integer lastOne() throws  Exception{
        BaseExample example = getExample();
        example.setOrderByClause("id");
         return mapper.selectByExampleSingle(example);

    }

    public Product getById(int id) throws Exception {
        Product product = (Product) mapper.selectByPrimaryKeySingle(id);
        if (product == null) {
            throw new NoSuchObjectException("访问的id不存在或已经被删除");
        }
        return product;
    }


    public void fillAccountModel(Model model, List<Account> accounts) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        BigDecimal totalPrice = new BigDecimal(0);
        List<AccoutUtil> accountUtilList = new ArrayList<>();
        for (Account account: accounts
             ) {
            int pid = account.getPid();
            Product product = (Product)mapper.selectByPrimaryKeySingle(pid);
            AccoutUtil accoutUtil = new AccoutUtil();
            accoutUtil.setPid(pid);
            accoutUtil.setFilePath("/img/"+product.getFile());
            accoutUtil.setName(product.getName());
            accoutUtil.setDatetime(account.getPaytime());
            accoutUtil.setTimeString(dateFormat.format(account.getPaytime()));
            accoutUtil.setNum(account.getNumber());
            accoutUtil.setPrice(account.getPrice());
            totalPrice = totalPrice.add(accoutUtil.getPrice().multiply(BigDecimal.valueOf(account.getNumber())));
            accountUtilList.add(accoutUtil);
        }
        model.addAttribute("accountUtilList",accountUtilList);
        model.addAttribute("totalPrice",totalPrice);
    }
}