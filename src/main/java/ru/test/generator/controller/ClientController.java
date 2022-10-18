package ru.test.generator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.test.generator.service.dao.model.LoadGenTable;
import ru.test.generator.service.dao.response.RandomResponse;
import ru.test.generator.service.dao.response.RespController;
import ru.test.generator.service.dao.response.Response;

import java.util.List;

/**
 * RestController class for working with DAO
 *
 * @author Vladislav K.
 * @version 1.0
 */

@Slf4j
@RestController
public class ClientController {

    @Autowired
    private RespController respController;
    @Autowired
    private RandomResponse response;

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {return "Welcome to loadGen test app. Enjoy it!";}

    /**
     * RestController for working with DAO
     */
    @RequestMapping(value = "/{operName}/{num}")
    ResponseEntity<String> Response(@PathVariable String operName,
                                    @PathVariable int num) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type","application/json; charset=utf-8");

        // Формирование ответа и отправка в БД
        sendFileToDB(RandomResponse.getResponse(operName, num));

        return new ResponseEntity<>("HttpStatus.OK",httpHeaders,HttpStatus.OK);
    }

    // Проходимся по списку вытаскиеваем параметры и отправляем в бд
    private void sendFileToDB(List<Response> list) {
        for (Response br : list) {
            LoadGenTable loadGenTable = new LoadGenTable();
            loadGenTable.setStatus(br.getStatus());
            loadGenTable.setOper_code(br.getOper_code());
            loadGenTable.setOper_name(br.getOper_name());
            loadGenTable.setPersonal_id(br.getPersonal_id());
            loadGenTable.setOwner_id(br.getOwner_id());
            loadGenTable.setReg_time(br.getReg_time());
            respController.sendClientToDB(loadGenTable);
        }
    }
}
