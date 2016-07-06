package com.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "teams", itemResourceRel = "team")
public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findByName(@Param("name") String name);
}
