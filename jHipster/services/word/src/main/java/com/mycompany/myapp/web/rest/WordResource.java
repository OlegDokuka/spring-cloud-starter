package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.WordService;
import com.mycompany.myapp.web.rest.dto.WordDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Optional;

@RestController
@RequestMapping("/api/words")
public class WordResource {
    @Inject
    private WordService wordService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<WordDTO> get() {
        return Optional.ofNullable(wordService.get())
            .map(w -> new ResponseEntity<>(w, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}
