package lfc.pojo;

import lfc.mapper.AccountMapper;
import lfc.pojo.base.BasePOJO;

import java.math.BigDecimal;
import java.util.Date;

public class Account extends BasePOJO implements lfc.pojo.ORM.POJOMapper<AccountMapper>{

        private Integer uid;
        private Integer pid;
        private Integer number;
        private BigDecimal price;
        private Date paytime;



    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }
}
