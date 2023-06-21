package factory;

public class AppFactory {
    public static void main(String[] args) {
        Account account1 = AccountFactory.getAccount(AccountType.PERSONAL);
        Account account2 = AccountFactory.getAccount(AccountType.BUSINESS);

        System.out.println(account1.getDescription());
        System.out.println(account2.getDescription());
    }
}
