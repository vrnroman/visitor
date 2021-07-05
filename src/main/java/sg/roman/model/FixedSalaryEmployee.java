package sg.roman.model;

import sg.roman.action.Visitor;

import java.math.BigDecimal;

public class FixedSalaryEmployee extends Employee {

    private BigDecimal basicSalary;

    public FixedSalaryEmployee(String name, BigDecimal basicSalary) {
        super(name);
        this.basicSalary = basicSalary;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }
}
