package model;

import java.util.UUID;

public class User {

    private final String name;
    private final String email;
    private final String password;

    public User(String password) {
        String uniqueId = UUID.randomUUID().toString().substring(0, 8);

        this.name = "user_" + uniqueId;
        this.email = uniqueId + "@yandex.ru";
        this.password = password;

        System.out.println(
                "User name: " + this.getName() +
                " email: " + this.getName() +
                " password: " + this.getName() );
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

}
