package model;

import java.io.Serializable;
/**
 *
 * @author ormus
 */
public class State implements Serializable {
    private String acronym;
    private String fullName;
    
    public State() {}
    
    public State(String acronym, String fullName) 
    {
        this.acronym = acronym;
        this.fullName = fullName;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
