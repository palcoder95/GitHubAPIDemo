package com.example.githubapidemo.repo;

import com.example.githubapidemo.dto.GitUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GitRepo extends JpaRepository<GitUser, Long> {
    public Optional<GitUser> findByLogin(String login);

}
