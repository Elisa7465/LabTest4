package com.Development.Dev.repositories;

import com.Development.Dev.models.TaskLog;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskLogRepository extends CrudRepository<TaskLog, Long> {
    // Получает последние 10 записей логов задач, упорядоченных по времени выполнения
    List<TaskLog> findTop10ByOrderByExecutionTimeDesc();
    List<TaskLog> findAllByOrderByExecutionTimeDesc();
    void deleteByIdLessThan(Long id);
}
