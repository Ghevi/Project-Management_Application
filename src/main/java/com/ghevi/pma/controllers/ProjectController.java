package com.ghevi.pma.controllers;

import com.ghevi.pma.dao.EmployeeRepository;
import com.ghevi.pma.dao.ProjectRepository;
import com.ghevi.pma.entities.Employee;
import com.ghevi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired // Inject an instance of this interface, since it is an interface, it will create an anonymous class first
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping
    public String displayProjects(Model model){
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects);

        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project aProject = new Project(); // This is why we need the empty constructor in the project class
                                          // This is an empty project and it will be populated by the user
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("project", aProject); // Add Key, Value pair to the model
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        proRepo.save(project); // This handles saving to the Database

        /*
        Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);

        for(Employee emp : chosenEmployees){
            emp.setProject(project);
            empRepo.save(emp);
        }
        */

        return "redirect:/projects"; // It prevents duplicate submissions
    }

}
