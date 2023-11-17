import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
    protected int accountID;
    protected String dateCreated;
    private DatabaseConnection db;
    private ResultSet rs;
    private String ID_QUERY = "SELECT * FROM accounttable where accountID = ";

    public Account(int accountID) {
        db = new DatabaseConnection();
        rs = db.getQuery(String.format(ID_QUERY + accountID));

        this.accountID = accountID;

        try {
            while (rs.next()) {
                dateCreated = rs.getString("dateCreated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Constructor
    public Account(int accountID, String dateCreated) {
        this.accountID = accountID;
        this.dateCreated = dateCreated;
    }

    // deposits funds into the account
    public void depositFunds(double amount) {

    }

    // withdraws funds from the account
    public void withdrawFunds(double amount) {

    }

    // transfers funds from this account to the other account
    public void transferFunds(Account toAccount, double amount) {

    }

    // accountID getter
    public int getAccountID() {
        return accountID;
    }

    // accountID setter
    public void setAccountID(int id) {
        accountID = id;
    }

    // dateCreated getter
    public String getDateCreated() {
        return dateCreated;
    }

    // dateCreated setter
    public void setDateCreated(String date) {
        dateCreated = date;
    }
}