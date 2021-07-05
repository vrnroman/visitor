package sg.roman.model;

import sg.roman.action.Visitor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Company implements Visitorable, Serializable {

    private List<Employee> employees;

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

}
