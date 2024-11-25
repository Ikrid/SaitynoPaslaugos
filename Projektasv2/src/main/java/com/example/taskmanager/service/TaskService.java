package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TaskService klasė atsakinga už užduočių valdymo logiką.
 * Ši klasė naudoja TaskRepository sąsają duomenų bazės operacijoms vykdyti.
 */
@Service
public class TaskService {

    /**
     * TaskRepository objektas, atsakingas už sąveiką su duomenų baze.
     */
    @Autowired
    private TaskRepository taskRepository;

    /**
     * Sukuria naują užduotį ir išsaugo ją duomenų bazėje.
     *
     * @param task užduoties objektas, kuris turi būti sukurtas.
     * @return sukurta užduotis.
     */
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    /**
     * Grąžina visų užduočių sąrašą.
     *
     * @return užduočių sąrašas.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Grąžina užduotį pagal nurodytą ID.
     *
     * @param id užduoties unikalus identifikatorius.
     * @return užduotis su nurodytu ID arba `null`, jei užduotis nerasta.
     */
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    /**
     * Atnaujina esamą užduotį pagal nurodytą ID.
     *
     * @param id užduoties unikalus identifikatorius.
     * @param taskDetails nauji užduoties duomenys.
     * @return atnaujinta užduotis arba `null`, jei užduotis nerasta.
     */
    public Task updateTask(Long id, Task taskDetails) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setCompleted(taskDetails.isCompleted());
            return taskRepository.save(task);
        }
        return null;
    }

    /**
     * Ištrina užduotį pagal nurodytą ID.
     *
     * @param id užduoties unikalus identifikatorius.
     */
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
