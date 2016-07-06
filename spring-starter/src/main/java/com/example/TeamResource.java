package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@RestController
@RequestMapping("/teams")
public class TeamResource {
    @Autowired
    private TeamRepository teamRepository;

    @RequestMapping
    @Transactional
    public ResponseEntity<List<Team>> getTeams() {
        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    @Transactional
    public ResponseEntity<Team> getTeam(@PathVariable Long id) {
        return Optional.ofNullable(teamRepository.findOne(id))
                .map(it -> new ResponseEntity<>(it, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
