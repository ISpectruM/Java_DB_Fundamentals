import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class K_FindEmployeesbyFirstName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();
        String input = scanner.nextLine().trim();

        List<Employee> employees = em.createQuery(
                "SELECT e FROM Employee e " +
                "WHERE e.firstName LIKE CONCAT(?,'%')")
                .setParameter(0,input)
                .getResultList();

        employees.forEach(e->
                System.out.printf("%s %s - %s - ($%.2f)%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getJobTitle(),
                        e.getSalary()));
        em.getTransaction().commit();
        em.close();
        managerFactory.close();
    }
}
