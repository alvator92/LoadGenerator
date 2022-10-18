package ru.test.generator.service.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.test.generator.service.dao.model.LoadGenTable;
import ru.test.generator.service.dao.repository.LoadGenRepository;

/**
 * Implementation of {@link LoadGenService} interface
 *
 * @author Vladislav K.
 * @version 1.0
 */

public class LoadGenServiceImpl implements LoadGenService {

    @Autowired
    private LoadGenRepository loadGenRepository;

    @Override
    public void save(LoadGenTable user) {
        loadGenRepository.save(user);

    }
}
