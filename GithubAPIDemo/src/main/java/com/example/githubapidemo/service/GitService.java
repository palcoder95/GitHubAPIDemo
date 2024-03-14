package com.example.githubapidemo.service;

import com.example.githubapidemo.dto.GitUser;
import com.example.githubapidemo.repo.GitRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GitService {
    @Autowired
    private GitRepo gitRepo;

    public Optional<GitUser> findByLogin(String login){

        Optional<GitUser> byLogin = gitRepo.findByLogin(login);
        return byLogin;
    }

    public void addGitUser(GitUser user){

        gitRepo.save(user);
    }
}
