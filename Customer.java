import java.sql.ResultSet;
import java.sql.SQLException;

public class Customer {
    private int customerID;
    private String customerName;
    private String phoneNumber;
    private String emailAddress;
    private String billingAddress;

    private DatabaseConnection db;
    private ResultSet rs;
    private String ID_QUERY = "SELECT * FROM customer where customerID = ";

    public Customer(int accountID) {
        db = new DatabaseConnection();
        rs = db.getQuery(String.format(ID_QUERY + accountID));
        try {
        while (rs.next()) {
            customerID = rs.getInt("customerID");
            customerName= String.format("%s %s %s",rs.getString("firstName"), rs.getString("middleName"), rs.getString("lastName"));
            phoneNumber = rs.getString("phoneNumber");
            emailAddress = rs.getString("emailAddress");
            billingAddress = rs.getString("billingAddress");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Customer constructor
    public Customer(int customerID, String customerName, String phoneNumber, String emailAddress, String billingAddress) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.billingAddress = billingAddress;
    }

    // insertCard takes a Card as a parameter an inserts it into the ATM based on the cards type
    // public void insertCard(Card card) {

    // }

    // customer id getter
    public int getCustomerID() {

        return customerID;
    }

    // customer id setter (id auto increment, should not set)
    public void setCustomerID(int id) {
        customerID = id;
    }

    // customer name getter
    public String getCustomerName() {
        return customerName;
    }

    // customer name setter
    public void setCustomerName(String name) {
        customerName = name;
    }

    // phone number getter
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // phone number setter
    public void setPhoneNumber(String number) {
        phoneNumber = number;
    }

    // email getter
    public String getEmailAddress() {
        return emailAddress;
    }

    // email setter
    public void setEmailAddress(String email) {
        emailAddress = email;
    }

    // billing address getter
    public String getBillingAddress() {
        return billingAddress;
    }

    // email address setter
    public void setBillingAddress(String address) {
        billingAddress = address;
    }
}