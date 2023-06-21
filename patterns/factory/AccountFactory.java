package factory;

public class AccountFactory {
    public static Account getAccount(AccountType type) {
        if (type == AccountType.PERSONAL) {
            return new PersonalAccount();
        }
        if (type == AccountType.BUSINESS) {
            return new BusinessAccount();
        }
        return null;
    }
}
