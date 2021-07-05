package sg.roman.action;

import sg.roman.model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryCalculatorVisitor implements Visitor {


    @Override
    public Object visit(ComissionSalaryEmployee employee) {
        return employee.getVolume().multiply(employee.getComissionRate())
                .divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
    }

    @Override
    public Object visit(FixedSalaryEmployee employee) {
        return employee.getBasicSalary();
    }

    @Override
    public Object visit(MixedSalaryEmployee employee) {
        return employee.getVolume()
                .multiply(employee.getComissionRate())
                .divide(new BigDecimal(100), 2, RoundingMode.HALF_UP)
                .add(employee.getBasicSalary());
    }

    @Override
    public Object visit(Company company) {
        return company.getEmployees().stream()
                .map(e -> (BigDecimal) e.accept(this))
                .peek(System.out::println) //debug
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
