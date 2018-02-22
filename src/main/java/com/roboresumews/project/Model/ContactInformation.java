package com.roboresumews.project.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String infofirstName;
    private String infolastName;
    private long phoneNumber;
    private String infoemail;

    public ContactInformation() {
    }

    public ContactInformation(String infofirstName, String infolastName, long phoneNumber, String infoemail) {
        this.infofirstName = infofirstName;
        this.infolastName = infolastName;
        this.phoneNumber = phoneNumber;
        this.infoemail = infoemail;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getInfofirstName() {
        return infofirstName;
    }

    public void setInfofirstName(String infofirstName) {
        this.infofirstName = infofirstName;
    }

    public String getInfolastName() {
        return infolastName;
    }

    public void setInfolastName(String infolastName) {
        this.infolastName = infolastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInfoemail() {
        return infoemail;
    }

    public void setInfoemail(String infoemail) {
        this.infoemail = infoemail;
    }
}
