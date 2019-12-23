package com.myservs.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.myservs.demo.Dto.PostDTO;

@Repository
public interface PostRepository extends JpaRepository<PostDTO, Integer> {

}
