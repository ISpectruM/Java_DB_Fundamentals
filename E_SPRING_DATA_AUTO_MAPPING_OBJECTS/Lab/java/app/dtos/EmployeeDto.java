package app.dtos;


import app.entities.Employee;
import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeeDto extends BasicDto {
        private BigDecimal salary;
        private LocalDate birthDay;
        private Employee manager;

    public BigDecimal getSalary() {
        return this.salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getBirthDay() {
        return this.birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }
}
