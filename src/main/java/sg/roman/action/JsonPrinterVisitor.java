package sg.roman.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sg.roman.model.*;

import java.io.Serializable;

public class JsonPrinterVisitor implements Visitor {

    private String beanToJsonString(Serializable bean) {
        try {
            return new ObjectMapper().writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(String.format("Cannot serialize %s to json", bean.getClass()), e);
        }
    }


    @Override
    public Object visit(ComissionSalaryEmployee employee) {
        return beanToJsonString(employee);
    }

    @Override
    public Object visit(FixedSalaryEmployee employee) {
        return beanToJsonString(employee);
    }

    @Override
    public Object visit(MixedSalaryEmployee employee) {
        return beanToJsonString(employee);
    }

    @Override
    public Object visit(Company company) {
        StringBuilder sb = new StringBuilder();
        for (Employee e : company.getEmployees()) {
            sb.append(e.accept(this)).append("\n");
        }
        return sb.toString();
    }
}
