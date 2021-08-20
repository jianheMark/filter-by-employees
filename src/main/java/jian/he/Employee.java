package jian.he;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int id;
    private String name;
    private String email;
    private Department department;
    private List<Asset> assets = new ArrayList<>();

    public Employee(int id, String name, String email, Department department, List<Asset> assets) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.assets = assets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department=" + department +
                ", assets=" + assets +
                '}';
    }
}
