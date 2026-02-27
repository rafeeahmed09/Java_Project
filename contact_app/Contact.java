package contact_app;

public class Contact {
    private String name;
    private String phone;
    private String personalEmail;
    private String workEmail;
    private String address;

    public Contact(String name, String phone, String personalEmail, String workEmail, String address) {
        this.name = name;
        this.phone = phone;
        this.personalEmail = personalEmail;
        this.workEmail = workEmail;
        this.address = address;
    }

    // get and set name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonalEmail() {
        
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
