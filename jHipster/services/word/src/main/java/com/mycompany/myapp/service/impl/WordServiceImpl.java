package com.mycompany.myapp.service.impl;


import com.mycompany.myapp.repository.WordRepository;
import com.mycompany.myapp.service.WordService;
import com.mycompany.myapp.web.rest.dto.WordDTO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class WordServiceImpl implements WordService {
    @Inject
    private WordRepository wordRepository;

    @Override
    public WordDTO get() {
        return new WordDTO(wordRepository.get());
    }
}
