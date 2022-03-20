package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    private List<User> users;

    public UserController(){
        this.users = init();
    }

    private List<User> init(){
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setId(1L);
        user1.setFirstName("Jožko");
        user1.setLastName("Mrkvička");
        user1.setEmail("jozko@abc.sk");
        users.add(user1);

        User user2 = new User();
        user2.setId(2L);
        user2.setFirstName("Hanka");
        user2.setLastName("Nová");
        user2.setEmail("hanka@abc.sk");
        users.add(user2);
        return users;
    }

    @GetMapping("/api/users")
    public List<User> getUsers(@RequestParam(required = false) String User){
        if (User == null){
            return this.users;
        }
        List<User> filteredUsers = new ArrayList<>();

        for(User user : users){
            if (user.getUser().equals(User)){
                filteredUsers.add(user);
            }
        }
        return filteredUsers;

    }
    @GetMapping("/api/users/{userId}")
    public User getUser(@PathVariable Integer userId){
        return this.users.get(userId);

    }


    @PostMapping("/api/users")
    public Integer createUser(@RequestBody User user){
        this.users.add(user);

        return this.users.size() -1;
    }
    @DeleteMapping("/api/users/{userId}")
    public void deleteUser(@PathVariable Integer customerId){
        this.users.remove(this.users.get(customerId));

    }
    @PutMapping("/api/users/{userId}")
    public void updateUser(@PathVariable Integer userId, @RequestBody User user){
        this.users.get(userId).setUser(user.getUser());
    }
}


