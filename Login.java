
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Input card number to compare against database
 */
public class Login {
    final String SEARCH_CARD = "SELECT * FROM card where cardNumber = ";
    final String LOCK_CARD = "UPDATE card SET lockStatus = true WHERE cardNumber = ";
    final String SEARCH_CUSTOMER = "SELECT customerID FROM accounttable where accountID = ";

    private DatabaseConnection db;
    private ResultSet rs;


    private String cardNumber;
    private int accountID;
    private int customerID;
    private int pin;
    private int lockCounter;
    private boolean cardLock;

    public Login(String cardNumber) {
        this.cardNumber = null;
        lockCounter = 0;

        db = new DatabaseConnection();
        rs = db.getQuery(String.format(SEARCH_CARD + cardNumber));

        try {
            while (rs.next()) {
                this.cardNumber = rs.getString("CardNumber");
                accountID = rs.getInt("accountID");
                pin = rs.getInt("fourDigitPin");
                cardLock = rs.getBoolean("lockStatus");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (this.cardNumber != null) {
            rs = db.getQuery(String.format(SEARCH_CUSTOMER + accountID));
            try {
                while (rs.next()) {
                    customerID = rs.getInt("customerID");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



    // Loop for pin input, if fail 3 times, lock the card
    public boolean loopPin() {
        boolean correctPIN = false;
        while (lockCounter < 4 && correctPIN == false) {
            correctPIN = pinVerification(pin);
            lockCounter++;
        }
        if (lockCounter == 3) {
            lockCard();
        }
        return correctPIN;
    }

    private boolean pinVerification(int pin) {
        boolean result = false;

        if (this.pin == pin) {
            result = true;
        }
        return result;
    }

    // Lock card
    private void lockCard() {
        rs = db.getQuery(String.format(LOCK_CARD + cardNumber));
    }

    public boolean isLocked() {
        return cardLock;
    }

    public String getCardNumber() {
        return cardNumber;
    }
    public int getAccountID() {
        return accountID;
    }
    public int getCustomerID() {
        return customerID;
    }

}
