package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import app.entities.Task;
import app.repositories.TaskRepository;

@Controller    
public class IndexController {
    @Autowired 
    private TaskRepository taskRepository;

    /*@GetMapping(path={"/", "/tasks"})
    public String  getAllTasks(Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks"; 
    }*/

    @PostMapping(path="/tasks")
    public String  nouveau() {
        return "redirect:/tasks"; 
    }

    // @GetMapping(value = "/tasks/{id}")
    // public String getOneTask(@PathVariable("id") int id, Model model) {
    //     model.addAttribute("tasks", taskRepository.findById(id));
    //     return "tasks";
    // }

    // @GetMapping(value = "/tasks/{id}")
    // public String getOneTask(@PathVariable("id") int id, Model model) {
    //     model.addAttribute("tasks", taskRepository.findById(id));
    //     return "tasks";
    // }
}

