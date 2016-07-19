package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class SpringStarterApplication {
    @Autowired
    private TeamRepository teamRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringStarterApplication.class, args);
    }

    @Transactional
    @PostConstruct
    public void init() {
        List<Team> list = new ArrayList<>();

        Team team = new Team();
        team.setLocation("Harlem");
        team.setName("Globetrotters");
        team.setPlayers(new HashSet<>(Arrays.asList(new Player(), new Player())));
        list.add(team);

        team = new Team();
        team.setLocation("Washington");
        team.setName("Generals");
        list.add(team);

        teamRepository.save(list);
    }
}
