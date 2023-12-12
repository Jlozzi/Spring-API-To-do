package com.Lozi.Todo.List.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Lozi.Todo.List.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
