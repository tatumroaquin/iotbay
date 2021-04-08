/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ormus
 */
public class Product {
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
