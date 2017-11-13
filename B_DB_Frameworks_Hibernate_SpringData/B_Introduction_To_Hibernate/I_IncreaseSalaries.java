import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class I_IncreaseSalaries {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Employee> foundEmpl = em.createQuery(
                "SELECT e FROM Employee e " +
                "WHERE e.department.name = 'Engineering'" +
                        "OR e.department.name = 'Tool Design'" +
                        "OR e.department.name = 'Marketing'" +
                        "OR e.department.name = 'Information Services'" +
                        "order by e.id")
                .getResultList();
        foundEmpl.forEach(employee -> {
            employee.setSalary(employee
                .getSalary()
                .multiply(BigDecimal.valueOf(1.12)));
            System.out.printf("%s %s ($%.2f)%n",
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getSalary());
        });

        em.getTransaction().commit();
        em.close();
    }
}
