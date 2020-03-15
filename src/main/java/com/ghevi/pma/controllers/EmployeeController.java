package com.ghevi.pma.controllers;

import com.ghevi.pma.dao.EmployeeRepository;
import com.ghevi.pma.dao.ProjectRepository;
import com.ghevi.pma.entities.Employee;
import com.ghevi.pma.entities.Project;
import com.ghevi.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller // Spring knows it needs to component scan this class and inject dependencies (every annotation in import org.springframework.stereotype.)
@RequestMapping("/employees")
public class EmployeeController {

    /*
    // Constructor injection, we dont need @Autowired, we just need @Controller above
    EmployeeRepository empRepoUsingField;
    public EmployeeController(EmployeeRepository empRepo){
        this.empRepoUsingField = empRepo;
    }


    // Setter injection
    EmployeeRepository empRepoUsingSetterInjection;
    @Autowired // this time we need an @Autowired
    public void setEmpRepoUsingSetterInjection(EmployeeRepository empRepoUsingSetterInjection) {
        this.empRepoUsingSetterInjection = empRepoUsingSetterInjection;
    }


    @Autowired // Field injection (also there are constructor and setter injection) : Inject an instance of this interface, since it is an interface, it will create an anonymous class first
    EmployeeRepository empRepo;

     */

    @Autowired
    EmployeeService empService;


    @GetMapping
    public String displayEmployees(Model model){
        List<Employee>  employees = empService.getAll();
        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee aEmployee = new Employee(); // This is why we need the empty constructor in the project class
        // This is an empty project and it will be populated by the user
        model.addAttribute("employee", aEmployee); // Key, Value pair
        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        empService.save(employee); // This handles saving to the Database
        return "redirect:/employees/new"; // It prevents duplicate submissions
    }

}
