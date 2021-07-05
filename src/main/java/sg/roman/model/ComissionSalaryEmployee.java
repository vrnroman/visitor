package sg.roman.model;

import sg.roman.action.Visitor;

import java.math.BigDecimal;

public class ComissionSalaryEmployee extends Employee {

    private BigDecimal volume;

    private BigDecimal comissionRate;

    public ComissionSalaryEmployee(String name, BigDecimal volume, BigDecimal comissionRate) {
        super(name);
        this.volume = volume;
        this.comissionRate = comissionRate;
    }

    @Override
    public Object accept(Visitor visitor) {
        return visitor.visit(this);
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
