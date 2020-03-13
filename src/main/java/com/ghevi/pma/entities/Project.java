package com.ghevi.pma.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//This is an entity that will be mapped to tables in the Database
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Hibernate annotation
    private long projectId; // Doesn't need to be in the constructor because we set it from the Database

    private String name;

    private String stage; // Categorize a project as NOTSTARTED, COMPLETED, INPROGRESS

    private String description;

    // @ManyToOne(mappedBy = "project") // One project can have many employes assigned to it
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, // Standard in the industry, dont use the REMOVE (if delete project delete also children) or ALL (because include REMOVE)
                fetch = FetchType.LAZY)
    @JoinTable(name = "project_employee",  // Merge the two table using two foreign keys
               joinColumns = @JoinColumn(name="project_id"),
               inverseJoinColumns = @JoinColumn(name="employee_id"))
    private List<Employee> employees;

    public Project(){

    }

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    // convenience method:

    public void addEmployee(Employee emp){
        if(employees==null){
            employees = new ArrayList<>();
        }
        employees.add(emp);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
