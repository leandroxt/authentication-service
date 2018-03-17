package br.com.soig.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class EndpointController {

    @RequestMapping(value = "/endpointone", method = GET, produces = { TEXT_PLAIN_VALUE })
    public String endpointOne() {
        return "Endpoint One WORKS!";
    }

    @RequestMapping(value = "/endpointtwo", method = GET, produces = { TEXT_PLAIN_VALUE })
    public String endpointTwo() {
        return "Endpoint Two WORKS!";
    }
}
