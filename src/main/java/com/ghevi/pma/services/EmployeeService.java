package com.ghevi.pma.services;

import com.ghevi.pma.dao.EmployeeRepository;
import com.ghevi.pma.dto.EmployeeProject;
import com.ghevi.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository empRepo;

    public Employee save(Employee employee){
        return empRepo.save(employee);
    }

    public List<Employee> getAll(){
        return empRepo.findAll();
    }

    public List<EmployeeProject> employeeProjects(){
        return empRepo.employeeProjects();
    }

}

    /*

    IStaffRepository empRepo;

    public EmployeeService(@Qualifier("staffRepositoryImpl1") IStaffRepository empRepo) {
        this.empRepo = empRepo;
    }


    // Field injection
    @Autowired
    EmployeeRepository empRepo;

    // Constructor injection
    EmployeeRepository empRepo;

    public EmployeeService(EmployeeRepository empRepo){
        this.empRepo = empRepo;
    }

    // Setter injection
    EmployeeRepository empRepo;

    @Autowired
    public void setEmpRep(EmployeeRepository empRepo) {
        this.empRepo = empRepo;
    }
    */


    // Or we can put it here if we use field injection
    // @Autowired
    // @Qualifier("staffRepositoryImpl1")
    // IStaffRepository empRepo;

    //  Or we can put it in there if we use setter injection
    // @Autowired
    // @Qualifier("staffRepositoryImpl1")
    // public void setEmpRep(IStaffRepository empRepo) {
    //    this.empRepo = empRepo;
    // }


