package agkmwimalasooriya.com;

public class EmployeeModel {
    private String firstName, secondName, nicNumber;
    private String phone;

    public EmployeeModel(String firstName, String secondName, String nicNumber, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.nicNumber = nicNumber;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getNicNumber() {
        return nicNumber;
    }

    public void setNicNumber(String nicNumber) {
        this.nicNumber = nicNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "EmployeeModel{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", nicNumber='" + nicNumber + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
