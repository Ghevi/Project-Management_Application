package com.ghevi.pma.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//This is an entity that will be mapped to tables in the Database
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Hibernate annotation
    private long projectId; // Doesn't need to be in the constructor because we set it from the Database

    private String name;

    private String stage; // Categorize a project as NOTSTARTED, COMPLETED, INPROGRESS

    private String description;

    public Project(){

    }

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
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
