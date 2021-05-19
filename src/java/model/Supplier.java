package model;

import java.io.Serializable;
/**
 *
 * @author ormus
 */
public class Supplier implements Serializable {
    
    String companyName;
    String email;
    String firstName;
    String lastName;
    String mobile;
    
    public Supplier() {}
    public Supplier(String companyName, String email, String firstName, String lastName, String mobile)
    {
        this.companyName = companyName;
        this.email       = email;
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.mobile      = mobile;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
