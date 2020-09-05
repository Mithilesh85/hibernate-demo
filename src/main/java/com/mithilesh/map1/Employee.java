package com.mithilesh.map1;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

    @Id
    private int eId;
    private String eName;
    
    @ManyToMany
    @JoinTable(
            
            name="mithilesh",
            joinColumns = {@JoinColumn(name="emp")},
            inverseJoinColumns = {@JoinColumn(name="prj")})
    
    
    private List<Project> projects;

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Employee(int eId, String eName, List<Project> projects) {
        this.eId = eId;
        this.eName = eName;
        this.projects = projects;
    }

    public Employee() {
    }
    
    
}
