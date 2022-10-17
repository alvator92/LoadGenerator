package ru.test.generator.service.dao.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.test.generator.configuration.JpaConfig;
import ru.test.generator.service.dao.model.LoadGenTable;

@Component
public class RespController {
    @Autowired
    private JpaConfig jpaConfig;

    public RespController() {
    }

    public void sendClientToDB(LoadGenTable loadGenTable) {
        jpaConfig.loadGenService().save(loadGenTable);

    }
}
