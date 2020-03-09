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

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired // Inject an instance of this interface, since it is an interface, it will create an anonymous class first
    EmployeeRepository empRepo;

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee aEmployee = new Employee(); // This is why we need the empty constructor in the project class
        // This is an empty project and it will be populated by the user
        model.addAttribute("employee", aEmployee); // Key, Value pair
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        empRepo.save(employee); // This handles saving to the Database
        return "redirect:/employees/new"; // It prevents duplicate submissions
    }
}
