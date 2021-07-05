package sg.roman.action;

import sg.roman.model.ComissionSalaryEmployee;
import sg.roman.model.Company;
import sg.roman.model.FixedSalaryEmployee;
import sg.roman.model.MixedSalaryEmployee;

public interface Visitor {

    Object visit(ComissionSalaryEmployee employee);

    Object visit(FixedSalaryEmployee employee);

    Object visit(MixedSalaryEmployee employee);

    Object visit(Company company);
}
