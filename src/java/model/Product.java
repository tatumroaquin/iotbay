package model;

import java.io.Serializable;

/**
 *
 * @author ormus
 */
public class Product implements Serializable {

    private String name;
    private float price;
    private int quantity;
    private int supplier;
    private String desc;

    public Product() {
    }

    public Product(String name, float price, int quantity, int supplier, String desc) {
        this.supplier = supplier;
        this.name = name;
        this.desc = desc;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean matches(String name) {
        return this.name.equals(name);
    }

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
