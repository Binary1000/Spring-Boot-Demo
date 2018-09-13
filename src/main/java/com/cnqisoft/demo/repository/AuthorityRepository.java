package com.cnqisoft.demo.repository;

import com.cnqisoft.demo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    Authority findAuthorityByUsername(String username);

}
