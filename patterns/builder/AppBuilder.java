package builder;

public class AppBuilder {
    public static void main(String[] args) {
        // Sem nome
        // User user1 = new User.UserBuilder().build();
        User user1 = new User.UserBuilder("Ricardo").build();

        System.out.println(user1);

        User user2 = new User.UserBuilder("Ricardo")
                .address("Rua ABC, 123")
                .phone("11-9999-9999")
                .build();

        System.out.println(user2);
    }
}
