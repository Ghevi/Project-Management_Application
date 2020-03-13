package com.ghevi.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghevi.pma.dao.EmployeeRepository;
import com.ghevi.pma.dao.ProjectRepository;
import com.ghevi.pma.dto.ChartData;
import com.ghevi.pma.dto.EmployeeProject;
import com.ghevi.pma.entities.Employee;
import com.ghevi.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {

        Map<String, Object> map = new HashMap<>();

        //We are querying the database for projects
        List<Project> projects = proRepo.findAll();
        model.addAttribute("projects", projects); // Key, value. The key is the same as in the home.html form

        List<ChartData> projectData = proRepo.getProjectStatus();

        // Convert projectData object into a json structure for use in javascript
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(projectData);
        // ["NOTSTARTED", 1] , ["INPROGRESS", 2], ["COMPLETED", 1]  we will have 3 arrays [lable, value] shown in the json if we printed this string

        model.addAttribute("projectStatusCount", jsonString);

        //We are querying the database for employees
        List<EmployeeProject> projectCount = empRepo.employeeProjects();
        model.addAttribute("employeesListProjectsCount", projectCount);


        return "main/home";
    }

}
