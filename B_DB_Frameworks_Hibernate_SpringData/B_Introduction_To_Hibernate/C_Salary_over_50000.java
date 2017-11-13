import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class C_Salary_over_50000 {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Employee> employees = em.createQuery(
                "SELECT emp FROM Employee emp WHERE emp.salary > 50000")
                .getResultList();
        employees.stream().forEach(employee -> System.out.println(employee.getFirstName()));
        em.getTransaction().commit();
        em.close();
    }
}
