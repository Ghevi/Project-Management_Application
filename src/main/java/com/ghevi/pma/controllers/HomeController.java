package com.ghevi.pma.controllers;

import com.ghevi.pma.dao.EmployeeRepository;
import com.ghevi.pma.dao.ProjectRepository;
import com.ghevi.pma.entities.Employee;
import com.ghevi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model){

        //We are querying the database for projects
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects); // Key, value. The key is the same as in the home.html form

        //We are querying the database for employees
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employees", employees);


        return "main/home";
    }

}
