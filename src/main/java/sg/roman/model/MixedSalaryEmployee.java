package sg.roman.model;

import sg.roman.action.Visitor;

import java.math.BigDecimal;

public class MixedSalaryEmployee extends Employee {

    private BigDecimal basicSalary;

    private BigDecimal volume;

    private BigDecimal comissionRate;

    public MixedSalaryEmployee(String name, BigDecimal basicSalary, BigDecimal volume, BigDecimal comissionRate) {
        super(name);
        this.basicSalary = basicSalary;
        this.volume = volume;
        this.comissionRate = comissionRate;
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

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getComissionRate() {
        return comissionRate;
    }

    public void setComissionRate(BigDecimal comissionRate) {
        this.comissionRate = comissionRate;
    }

}
