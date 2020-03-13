package com.ghevi.pma.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO for data insertion in the class projmanagapplication (the commented out part), IDENTITY let hibernate use the database id counter.
    private long employeeId;                            // The downside of IDENTITY is that if we batch a lot of employees or projects it will be much slower to update them

    private String firstName;
    private String lastName;
    private String email;

    // @ManyToOne many employees can be assigned to one project
    // Cascade, the query done on projects it's also done on children entities
    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST}, // Standard in the industry, dont use the REMOVE (if delete project delete also children) or ALL (because include REMOVE)
               fetch = FetchType.LAZY)  // LAZY is industry standard it loads project into memory, EAGER load also associated entities so it slows the app, so we use LAZY and call child entities later
    //@JoinColumn(name="project_id")  // Foreign key, creates a new table on Employee database
    @JoinTable(name = "project_employee",  // Merge the two table using two foreign keys
               joinColumns = @JoinColumn(name="employee_id"),
               inverseJoinColumns = @JoinColumn(name="project_id"))

    private List<Project> projects;

    public Employee(){

    }

    public Employee(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /* Replaced with List<Project>
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    */

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
