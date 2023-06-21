package factory;

public enum AccountType {
    PERSONAL(1),
    BUSINESS(2);

    private final int type;

    AccountType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

}
