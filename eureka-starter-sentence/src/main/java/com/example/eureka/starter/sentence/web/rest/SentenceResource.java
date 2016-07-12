package com.example.eureka.starter.sentence.web.rest;

import com.example.eureka.starter.sentence.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class SentenceResource {
    //    @Autowired
//    private LoadBalancerClient client;
    @Autowired
    private SentenceService sentenceService;

    @RequestMapping("/sentence")
    public String getSentence() {
        return sentenceService.get()
                .collect(StringBuilder::new, StringBuilder::append)
                .toBlocking()
                .first()
                .toString();
    }

//    @RequestMapping("/sentence")
//    public String getSentence() {
//        return
//                getWord("EUREKA-STARTER-SUBJECT") + " "
//                        + getWord("EUREKA-STARTER-VERB") + " "
//                        + getWord("EUREKA-STARTER-ARTICLE") + " "
//                        + getWord("EUREKA-STARTER-ADJECTIVE") + " "
//                        + getWord("EUREKA-STARTER-NOUN") + "."
//                ;
//    }
//
//    public String getWord(String service) {
//        ServiceInstance instance = client.choose(service);
//        if (instance != null) {
//            URI uri = instance.getUri();
//            if (uri != null) {
//                return (new RestTemplate()).getForObject(uri, String.class);
//            }
//        }
//        return null;
//    }

}
