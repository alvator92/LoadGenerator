package ru.test.generator.service.dao.service;

import org.springframework.transaction.annotation.Transactional;
import ru.test.generator.service.dao.model.LoadGenTable;

/**
 * Service class for {@link LoadGenTable}
 *
 * @author Vladislav K.
 * @version 1.0
 */

public interface LoadGenService {

    @Transactional
    void save(LoadGenTable user);

}
