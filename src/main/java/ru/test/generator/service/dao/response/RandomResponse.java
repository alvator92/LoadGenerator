package ru.test.generator.service.dao.response;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Class prepare response {@link ru.test.generator.controller.ClientController}(Example)
 *
 * @author Vladislav K.
 * @version 1.0
 */

@Service
public class RandomResponse {

    private static Response builder = new Response();
    private static List<Response> list = new ArrayList<>();
    private static Random random = new Random();

    public static List<Response> getResponse(String operName, int operNum) {
        for (int i = 0; i < operNum; i++) {
            list.add(i, new Response.Builder()
                            .withStatus(1)
                            .withOperCode("1")
                            .withOperName(operName)
                            .withPersonalId(getRandomString(10))
                            .withOwnerId(getRandomString(8))
                            .withRegTime(new Date())
                    .build());
        }
        return list;
    }

    public static String getRandomString(int length) {
        String characters = "12345679ABCDEF";
        char[] text = new char[length];
        for(int i = 0; i < text.length; i ++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
        return new String(text);
    }
}
