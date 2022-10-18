package ru.test.generator.service.dao.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.test.generator.service.dao.model.LoadGenTable;

import java.util.List;

/**
 * Interface for {@link LoadGenTable}
 *
 * @author Vladislav K.
 * @version 1.0
 */

@Repository
public interface LoadGenRepository extends JpaRepository<LoadGenTable, Long> {
    List<LoadGenTable> findAll();

}
