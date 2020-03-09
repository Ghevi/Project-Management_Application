package com.ghevi.pma.controllers;

import com.ghevi.pma.dao.ProjectRepository;
import com.ghevi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired // Inject an instance of this interface, since it is an interface, it will create an anonymous class first
    ProjectRepository proRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project(); // This is why we need the empty constructor in the project class
                                          // This is an empty project and it will be populated by the user
        model.addAttribute("project", aProject); // Key, Value pair
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        proRepo.save(project); // This handles saving to the Database
        return "redirect:/projects/new"; // It prevents duplicate submissions
    }

}
