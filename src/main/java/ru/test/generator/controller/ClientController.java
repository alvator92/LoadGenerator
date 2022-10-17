package ru.test.generator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.test.generator.configuration.JpaConfig;
import ru.test.generator.service.dao.model.LoadGenTable;
import ru.test.generator.service.dao.repository.LoadGenRepository;
import ru.test.generator.service.dao.response.Response;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * RestController class for work with DAO
 *
 * @author Vladislav K.
 * @version 1.0
 */

@Slf4j
@RestController
//@EnableJpaRepositories( basePackages = {"ru.test.generator.service.dao.repository"},
//        entityManagerFactoryRef = "apossEntityManager",
//        transactionManagerRef = "apossTransactionManager")
public class ClientController {

    @Autowired
    private JpaConfig jpaConfig;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {return "Welcome to loadGen test app. Enjoy it!";}

    @RequestMapping(value = "/{operName}")
    ResponseEntity<String> Response(@PathVariable String operName) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=utf-8");
        Response response = new Response.Builder()
                .withOperCode("1").build();
        LoadGenTable loadGenTable = new LoadGenTable();
        loadGenTable.setStatus(1);
        loadGenTable.setOper_code("1");
        loadGenTable.setOper_name("1");
        loadGenTable.setPersonal_id("1");
        loadGenTable.setOwner_id("1");
        loadGenTable.setReg_time(new Date());

        jpaConfig.loadGenService().save(loadGenTable);
//        loadGenRepository.saveAndFlush(loadGenTable);
        return new ResponseEntity<>("1",httpHeaders,HttpStatus.OK);
    }
}
