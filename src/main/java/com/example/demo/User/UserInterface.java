package com.example.demo.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserInterface extends CrudRepository<UserEntity, Long>{
}
