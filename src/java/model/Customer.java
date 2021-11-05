package model;

import java.io.Serializable;
/**
 *
 * @author ormus
 */
public class Customer implements Serializable {
    private String email;
    private String password;
    private String mobile;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postCode;
    private String country;
    
    public Customer() {}
    
    public Customer(
            String email, String password, String mobile, 
            String firstName, String lastName, 
            String street, String city, String state, 
            String postCode, String country
    )
    {
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    @Override
    public String toString()
    {
        String str = "";
        str += "email: "+this.email;
        str += "password: "+this.password;
        str += "mobile: "+this.mobile;
        str += "firstName: "+this.firstName;
        str += "lastName: "+this.lastName;
        str += "street: "+this.street;
        str += "city: "+this.city;
        str += "state: "+this.state;
        str += "postCode: "+this.postCode;
        str += "country: "+this.country;
        return str;
    }
    
}
