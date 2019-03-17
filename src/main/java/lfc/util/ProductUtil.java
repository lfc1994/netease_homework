package lfc.util;

import java.util.List;

public class ProductUtil {
    private List<ProductUtil> productUtils;
    private int id;
    private double price;
    private String title;
    private int number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ProductUtil> getProductUtils() {
        return productUtils;
    }

    public void setProductUtils(List<ProductUtil> productUtils) {
        this.productUtils = productUtils;
    }
}
