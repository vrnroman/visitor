package sg.roman.model;

import java.io.Serializable;
import java.math.BigDecimal;

public abstract class Employee implements Visitorable, Serializable {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
