package ru.test.generator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * RestController class for work with DAO
 *
 * @author Vladislav K.
 * @version 1.0
 */

@Slf4j
@RestController
public class ClientController {

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {return "Welcome to loadGen test app. Enjoy it!";}

    @RequestMapping(value = "/{operName}")
    ResponseEntity<String> Response(@PathVariable String operName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=utf-8");
        return new ResponseEntity<>("1",httpHeaders,HttpStatus.OK);
    }
}
