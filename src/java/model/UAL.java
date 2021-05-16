package model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author ormus
 */
public class UAL implements Serializable {
    private int id;
    private Date loginDate;
    private Time loginTime;
    private Date logoutDate;
    private Time logoutTime;
    
    public UAL() {}
    
    public UAL(int id, Date loginDate, Time loginTime, Date logoutDate, Time logoutTime) 
    {
        this.id = id;
        this.loginDate = loginDate;
        this.loginTime = loginTime;
        this.logoutDate = logoutDate;
        this.logoutTime = logoutTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Time getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Time loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutDate() {
        return logoutDate;
    }

    public void setLogoutDate(Date logoutDate) {
        this.logoutDate = logoutDate;
    }

    public Time getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Time logoutTime) {
        this.logoutTime = logoutTime;
    }

}
