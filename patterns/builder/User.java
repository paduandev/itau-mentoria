package builder;

public class User {
    private String name, phone, address;
    private int age;

    public User(UserBuilder builder) {
        this.name = builder.name;
        this.phone = builder.phone;
        this.address = builder.address;
        this.age = builder.age;
    }

    public static class UserBuilder {
        private String name, phone, address;
        private int age;

        public UserBuilder(String name) {
            this.name = name;
        }

        // Se o nome não fosse obrigatório
        // Remove o construtor e acrescenta 
        // o método name

        // public UserBuilder(String name) {
        //     this.name = name;
        // }

        // public UserBuilder name(String name) {
        //     this.name = name;
        //     return this;
        // }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            User user = new User(this);
            return user;
        }
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", phone=" + phone + ", address=" + address + ", age=" + age + "]";
    }

}
