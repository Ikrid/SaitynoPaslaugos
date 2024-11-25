package com.example.taskmanager.controller;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TaskController klasė atsakinga už užduočių valdymą naudojant HTTP užklausas.
 * Ši klasė apdoroja CRUD operacijas užduotims (`Task`).
 */
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    /**
     * TaskService objektas, atsakingas už užduočių valdymo logiką.
     */
    @Autowired
    private TaskService taskService;

    /**
     * Grąžina visų užduočių sąrašą.
     *
     * @return užduočių sąrašas.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * Grąžina užduotį pagal nurodytą ID.
     *
     * @param id užduoties unikalus identifikatorius.
     * @return užduotis su nurodytu ID.
     */
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    /**
     * Sukuria naują užduotį.
     *
     * @param task užduoties objektas, kuris bus sukurtas.
     * @return sukurta užduotis.
     */
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    /**
     * Atnaujina esamą užduotį pagal nurodytą ID.
     *
     * @param id užduoties unikalus identifikatorius.
     * @param taskDetails užduoties duomenys, kurie bus atnaujinti.
     * @return atnaujinta užduotis.
     */
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    /**
     * Ištrina užduotį pagal nurodytą ID.
     *
     * @param id užduoties unikalus identifikatorius.
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
