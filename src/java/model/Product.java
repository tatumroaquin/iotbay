package model;

import java.io.Serializable;
/**
 *
 * @author ormus
 */
public class Product implements Serializable {
    private String name;
    private float price;
    private String desc;
    
    public Product () {}
    
    public Product(String name, float price, String desc)
    {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }
    
    public boolean matches(String name)
    {
        return this.name.equals(name);
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDescription(String desc) {
        this.desc = desc;
    }

    
    
}
