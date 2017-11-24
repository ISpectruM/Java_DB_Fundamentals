package app;

import app.dtos.EmployeeDto;
import app.entities.Address;
import app.entities.Employee;
import app.repositories.AddressRepository;
import app.repositories.EmployeeRepository;
import app.dtos.ManagerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private AddressRepository addressRepository;
    private EmployeeRepository employeeRepository;

    @Autowired
    public ConsoleRunner(AddressRepository addressRepository, EmployeeRepository employeeRepository) {
        this.addressRepository = addressRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedAddress();
//        seedEmployee();

//        ---1.	Simple Mapping
        Employee one = this.employeeRepository.findOne(1L);
        ModelMapper mapper = new ModelMapper();
        EmployeeDto dto = mapper.map(one,EmployeeDto.class);
//
//        System.out.println(dto.getSalary());

//        ---2.	Advanced Mapping
        ManagerDto managerDto = mapper.map(one,ManagerDto.class);

        System.out.printf("%s %s | Employees: %d%n",
                managerDto.getFirstName(),
                managerDto.getLastName(),
                managerDto.getServants().size());
        for (EmployeeDto eDto : managerDto.getServants()) {
            System.out.printf("- %s %s %.2f%n",
                    eDto.getFirstName(),
                    eDto.getLastName(),
                    eDto.getSalary());
        }

//        ---3.	Projection
        List<Employee> employees = this.employeeRepository
                .findAllByBirthDateBeforeOrderBySalaryDesc(
                        LocalDate.parse("1990-01-01"));
        for (Employee employee : employees) {
            EmployeeDto dto1 = mapper.map(employee,EmployeeDto.class);
            System.out.printf("%s %s %.2f - Manager: %s%n",
                    dto1.getFirstName(),
                    dto1.getLastName(),
                    dto1.getSalary(),
                    dto1.getManager() != null ?
                            dto1.getManager().getLastName() : "[no manager]");
        }

    }

    private void seedEmployee() {
        Address address = this.addressRepository.findOne(1L);
        Employee employee = new Employee();
        employee.setFirstName("Gacho");
        employee.setLastName("Peev");
        employee.setAddress(address);
        employee.setSalary(new BigDecimal("1350"));
        this.employeeRepository.save(employee);
    }

    private void seedAddress() {
        Address address = new Address();
        address.setCity("Pomo");
        address.setCountry("BGN");

        this.addressRepository.save(address);
    }
}
