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


