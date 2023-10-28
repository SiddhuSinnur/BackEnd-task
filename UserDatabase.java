package hashmap_task;

import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private Map<String, User> users = new HashMap<>();

    public boolean addUser(String username, String name, String email) {
        if (users.containsKey(username)) {
            return false; // User already exists
        }

        User newUser = new User(username, name, email);
        users.put(username, newUser);
        return true; // User added successfully
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public boolean updateUser(String username, String name, String email) {
        if (!users.containsKey(username)) {
            return false; // User does not exist
        }

        User updatedUser = users.get(username);
        updatedUser.setName(name);
        updatedUser.setEmail(email);
        return true; // User updated successfully
    }

    public boolean deleteUser(String username) {
        if (users.containsKey(username)) {
            users.remove(username);
            return true; // User deleted successfully
        }

        return false; // User does not exist
    }

    public void listUsers() {
        for (User user : users.values()) {
            System.out.println(user);
        }
    }

    public static void main(String[] args) {
        UserDatabase db = new UserDatabase();

        // Adding users
        db.addUser("Ganesh1", "Ganesh pote", "ganesh@gmail.com");
        db.addUser("Mahesh2", "Mahesh lodde", "mahesh@gmail.com");

        // Retrieving and printing user information
        System.out.println(db.getUser("Ganesh1"));
        System.out.println(db.getUser("Mahesh2")); 
    }
}

class User {
    private String username;
    private String name;
    private String email;

    public User(String username, String name, String email) {
        this.username = username;
        this.name = name;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "welcome, \n" +"   username :: " + username +"\n   name :: " + name +"\n   email :: " + email ;
    }
}

