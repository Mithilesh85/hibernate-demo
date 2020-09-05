
package com.mithilesh.map1;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
    
    @Id
    private int pId;
    private String pName;
    
    @ManyToMany(mappedBy = "projects")
    private List<Employee> employees;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Project(int pId, String pName, List<Employee> employees) {
        this.pId = pId;
        this.pName = pName;
        this.employees = employees;
    }

    public Project() {
    }
    
    
    
    
}
