/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.LinkedList;
/**
 *
 * @author ormus
 */
public class Products {
    private LinkedList<Product> products = new LinkedList<Product>();
    
    public Products() {}
    
    public void setup()
    {
        add(new Product("iPhone 6s", 1999.99f, "very expensive phone"));
        add(new Product("iPhone 6 Plus", 1999.99f, "another expensive phone"));
        add(new Product("Google Pixel 4A Black", 599.99f, "Google's Android SmartPhone"));
        
        add(new Product("Macbook 13-inch", 2999.99f, "expensive machine to study with"));
        add(new Product("Macbook Air", 1599.99f, "thinnest notebook on the planet"));
        add(new Product("Macbook Pro", 3999.99f, "very expensive notebook"));
        add(new Product("Mac Mini M1", 2999.99f, "Mac Mini variation with Apple's M1 processor"));
        
        add(new Product("Asus Notebook", 599.99f, "affordable by today's standards notebook"));
        add(new Product("Dell Notebook", 399.99f, "affordable notebook without selling organs."));
    }
    
    public Product find(String name)
    {
        for(Product product: products)
        {
            if(product.matches(name))
                return product;
        }
        return null;
    }
    
    public void add(Product product)
    {
        this.products.add(product);
    }
    
    public int size()
    {
        return this.products.size();
    }
}
