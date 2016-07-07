package com.example.eureka.starter.sentence.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class SentenceResource {
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/sentence")
    public String getSentence() {
        return
                getWord("EUREKA-STARTER-SUBJECT") + " "
                        + getWord("EUREKA-STARTER-VERB") + " "
                        + getWord("EUREKA-STARTER-ARTICLE") + " "
                        + getWord("EUREKA-STARTER-ADJECTIVE") + " "
                        + getWord("EUREKA-STARTER-NOUN") + "."
                ;
    }

    public String getWord(String service) {
        List<ServiceInstance> list = client.getInstances(service);
        if (list != null && list.size() > 0) {
            URI uri = list.get(0).getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return null;
    }

}
