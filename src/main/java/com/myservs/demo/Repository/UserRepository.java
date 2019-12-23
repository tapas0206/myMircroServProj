package com.myservs.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myservs.demo.Dto.UserDTO;

@Repository
public interface UserRepository extends JpaRepository<UserDTO, Integer> {

}
