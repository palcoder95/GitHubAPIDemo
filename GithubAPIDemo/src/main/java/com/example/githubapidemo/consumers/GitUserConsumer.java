package com.example.githubapidemo.consumers;

import com.example.githubapidemo.dto.GitUser;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name="GitUserConsumer", url="https://api.github.com/")
//public interface GitUserConsumer {
//    @GetMapping("users/{login}")
////    GitUser getGitUserFromGitHub(@PathVariable("login") String login);
//    GitUser getGitUser(@RequestParam("login") String login);
//}


