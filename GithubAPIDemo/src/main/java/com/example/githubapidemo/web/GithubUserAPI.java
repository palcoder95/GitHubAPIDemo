package com.example.githubapidemo.web;

import com.example.githubapidemo.config.AppConfig;
//import com.example.githubapidemo.consumers.GitUserConsumer;
import com.example.githubapidemo.dto.GitUser;
//import com.example.githubapidemo.repo.GitRepo;

//import com.example.githubapidemo.service.GitService;
import com.example.githubapidemo.service.GitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Optional;

@RestController
@RequestMapping("/github")
public class GithubUserAPI {

//    @Autowired
//    GitUserConsumer gitUserConsumer;
    @Autowired
    GitService gitService;
    @Autowired
    AppConfig appConfig;

    @GetMapping("/getUser/{login}")
    public GitUser getUserDetailsFromGithub(@PathVariable("login") String login) {
        if(gitService.findByLogin(login).isPresent()){
            System.out.println("From DB");
            return gitService.findByLogin(login).get();
        }
        else{
            String apiUrl = "https://api.github.com/users/"+login;
            GitUser gitUser = appConfig.getWebClient()
                    .get()
                    .uri(apiUrl)
                    .retrieve()
                    .bodyToMono(GitUser.class)
                    .block();
            gitService.addGitUser(gitUser);
            return gitUser;
        }
//        GitUser gitUserFromGitHub = gitUserConsumer.getGitUserFromGitHub(login);
//        return gitUserFromGitHub;
    }

//    @GetMapping("/getUser/{login}")
//    public Mono<GitUser> getUserDetailsFromGithub(@PathVariable("login") String login){
//        WebClient webClient = WebClient.builder().build();
//        Mono<GitUser> gitUserMono = webClient.get().uri("https://api.github.com/users/" + login).retrieve().bodyToMono(GitUser.class);
//        return gitUserMono;
////        RestTemplate restTemplate = new RestTemplate();
////        GitUser response = restTemplate.getForObject("https://api.github.com/users/" + login, GitUser.class);
////        return response;
//////        GitUser resp = restTemplate.getForObject("https://api.github.com/users/" + username, GitUser.class);
//////        return resp;
//////        return "Successfully got the request for" + username;
//
//
////        if(gitService.findById(id).isPresent()){
////            return gitService.findById(id).get();
////        }
////        else{
////            RestTemplate restTemplate = new RestTemplate();
////            GitUser response = restTemplate.getForObject("https://api.github.com/users/"+id, GitUser.class);
////            gitService.addGitUser(response);
////            return response;
////
//////            return new GitUser();
////        }

//}
//    @GetMapping("/getUser/{id}")
//    public GitUser getUserById(@PathVariable Integer id){
////        RestTemplate restTemplate = new RestTemplate();
//        Optional<GitUser> gitUser = repo.findById(id);
//
//    }
}
