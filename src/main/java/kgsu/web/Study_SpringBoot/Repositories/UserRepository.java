package kgsu.web.Study_SpringBoot.Repositories;

import kgsu.web.Study_SpringBoot.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
