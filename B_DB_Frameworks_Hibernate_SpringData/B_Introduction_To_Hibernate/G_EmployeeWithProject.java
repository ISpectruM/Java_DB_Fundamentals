import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.Scanner;

public class G_EmployeeWithProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();
        String emplId = scanner.nextLine().trim();

        Employee foundEmpl = (Employee) em.createQuery(
                "SELECT e FROM Employee e " +
                        "WHERE e.id = ?")
                .setParameter(0,Integer.parseInt(emplId))
                .getSingleResult();
        System.out.printf("%s %s - %s%n",
                foundEmpl.getFirstName(),
                foundEmpl.getLastName(),
                foundEmpl.getJobTitle());
        foundEmpl.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.printf("\t%s%n",
                        project.getName()));

        em.getTransaction().commit();
        em.close();
    }
}
