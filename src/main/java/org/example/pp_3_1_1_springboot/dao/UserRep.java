package org.example.pp_3_1_1_springboot.dao;

import org.example.pp_3_1_1_springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User, Long> {
}
