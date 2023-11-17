public class Test {
    public static void main(String[] args) {
        Login l = new Login("1193670006096480");
        if (l.getCardNumber() != null) {
            System.out.println(l.getCardNumber());
            Customer c = new Customer(l.getCustomerID());
            System.out.println(c.getCustomerName());
            System.out.println(c.getBillingAddress());
            System.out.println(c.getPhoneNumber());

            Account a = new Account(l.getAccountID());
            System.out.println(a.getAccountID());
            System.out.println(a.getDateCreated());
        } else {
            System.out.print("Not found");
        }
    }
}
