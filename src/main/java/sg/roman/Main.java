package sg.roman;

import sg.roman.action.JsonPrinterVisitor;
import sg.roman.action.SalaryCalculatorVisitor;
import sg.roman.model.ComissionSalaryEmployee;
import sg.roman.model.Company;
import sg.roman.model.FixedSalaryEmployee;
import sg.roman.model.MixedSalaryEmployee;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Instant;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class Main {

    private static Random r = new Random(Instant.now().toEpochMilli());
    private static DecimalFormatSymbols decimalFormatSymbols = DecimalFormatSymbols.getInstance(
            new Locale("en", "SG"));
    private static DecimalFormat df = new DecimalFormat("#,##0.00", decimalFormatSymbols);

    public static void main(String[] args) {
        Company c = new Company();
        c.setEmployees(Arrays.asList(
                createFixedSalaryEmployee("Roman"),
                createFixedSalaryEmployee("Ivan"),
                createComissionSalaryEmployee("Vladimir"),
                createComissionSalaryEmployee("Sergei"),
                createMixedSalaryEmployee("Oleg"))
        );
        System.out.println(
                String.format("Sum of salaries = %s",
                        df.format(c.accept(new SalaryCalculatorVisitor()))));
        System.out.println(c.accept(new JsonPrinterVisitor()));
    }

    private static FixedSalaryEmployee createFixedSalaryEmployee(String name) {
        return new FixedSalaryEmployee(name, BigDecimal.valueOf(r.nextInt(10_000) + 5_000));
    }

    private static ComissionSalaryEmployee createComissionSalaryEmployee(String name) {
        return new ComissionSalaryEmployee(name,
                BigDecimal.valueOf(r.nextInt(100_000) + 20_000),
                BigDecimal.valueOf(r.nextInt(20) + 10));
    }

    private static MixedSalaryEmployee createMixedSalaryEmployee(String name) {
        return new MixedSalaryEmployee(name,
                BigDecimal.valueOf(r.nextInt(5_000) + 3_000),
                BigDecimal.valueOf(r.nextInt(100_000) + 20_000),
                BigDecimal.valueOf(r.nextInt(10) + 2));
    }
}
