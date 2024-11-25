package com.example.taskmanager.repository;

import com.example.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TaskRepository sąsaja atsakinga už sąveiką su duomenų baze.
 * Ši sąsaja paveldi `JpaRepository`, kuri teikia pagrindines CRUD operacijų funkcijas.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
