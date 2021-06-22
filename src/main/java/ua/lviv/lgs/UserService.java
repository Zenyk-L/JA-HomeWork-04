package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UserService {

    private Set<User> listOfUsers = new HashSet<>();
    private static UserService userService;

    private UserService(){}

    public static UserService getUserService() {
        if (userService == null)
            userService = new UserService();

        return userService;
    }

    public Set<User> getListOfUsers() {
        return listOfUsers;
    }

    public void saveUser(User user){
        listOfUsers.add(user);
    }

    public User getUser(String email){
        return listOfUsers.stream().filter(user->user.getEmail().equals(email)).findAny().orElse(null);
    }
}
