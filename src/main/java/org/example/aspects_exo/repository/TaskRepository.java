package org.example.aspects_exo.repository;

import org.example.aspects_exo.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends BaseRepository<Task, Long> {
}