package com.example.githubapidemo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class GitUser {
    private String login;
    @Id
    private Long id; //id:151100086
    private String node_id;
    private String avatar_url;
//    private String gravatar_id;
    private String url;
    private String html_url;
//    private String followers_url;
    private String following_url;
    private String gists_url;
//    private String starred_url;
    private String subscriptions_url;
    private String organizations_url;
    private String repos_url;
//    private String starred_url;
    private String events_url;
//    private String received_events_url;
//    private String type;
//    private String site_admin;
//    private String name;
//    private String company;
//    private String blog;
//    private String location;
//    private String email;
//    private String hireable;
//    private String bio;
//    private String twitter_username;
//    private String public_repos;
//    private String public_gists;
//    private String followers;
//    private String following;
//    private String created_at;
//    private String updated_at;







}
