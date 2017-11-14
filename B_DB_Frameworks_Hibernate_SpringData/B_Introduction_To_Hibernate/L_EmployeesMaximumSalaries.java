import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class L_EmployeesMaximumSalaries {

    private static Department d;

    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Department> departments = em.createQuery(
                "SELECT d FROM Department d " +
                        "JOIN d.employees AS e " +
                        "group BY d " +
                        "HAVING MAX(e.salary) NOT BETWEEN 30000 and 70000").getResultList();
        departments.forEach(d-> {
            System.out.printf("%s - %.2f%n",
                    d.getName(),
                    d.getEmployees().stream()
            .sorted((e1,e2)->e2.getSalary().compareTo(e1.getSalary()))
            .limit(1)
            .map(e->e.getSalary())
            .findAny()
            .get());
        });

        em.getTransaction().commit();
        em.close();
        managerFactory.close();
    }
}
