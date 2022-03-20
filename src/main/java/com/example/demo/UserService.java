package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users;

    public UserService(){
        this.users = init();
    }

    public List<User> init(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(Long.valueOf("c"));
        user1.setFirstName("aa");
        user1.setLastName("bb");
        user1.setEmail("cc");
        users.add(user1);

        User user2 = new User();
        user2.setId(Long.valueOf("w"));
        user2.setFirstName("a");
        user2.setLastName("b");
        user2.setEmail("c");
        users.add(user2);
        return users;
    }

    @GetMapping("/api/users") //filtered users with user last name
    public List<User> getUsers(String userlastName){
        if (userlastName == null){
            return this.users;
        }

        List<User> filteredUsers = new ArrayList<>();

        for (User user : users){
            if (user.getLastName().equals(userlastName)){
                filteredUsers.add(user);
            }
        }

        return filteredUsers;
    }

    @GetMapping("/api/userid") //filtered users with user last name
    public List<User> getUsersId(String userId){
        if (userId == null){
            return this.users;
        }

        List<User> filteredUsers = new ArrayList<>();

        for (User user : users){
            if (user.getId().equals(userId)){
                filteredUsers.add(user);
            }
        }

        return filteredUsers;
    }

    @PostMapping("/api/users") //creating new user
    public List<User> createUser(User user){
        this.users.add(user);

        return users;
    }

    @PutMapping("/api/users/{userId}")
    public List<User> putUser(Integer userId, User user){
        this.users.get(userId).setId(user.getId());
        this.users.get(userId).setFirstName(user.getFirstName());
        this.users.get(userId).setLastName(user.getLastName());
        this.users.get(userId).setEmail(user.getEmail());
        return users;
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(Integer userId){
        this.users.remove(this.users.get(userId));
    }
}