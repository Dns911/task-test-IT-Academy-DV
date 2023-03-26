package com.itacademy.tasktest.repository;

import com.itacademy.tasktest.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
