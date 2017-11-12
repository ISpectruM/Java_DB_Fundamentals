import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class B_ContainsEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory managerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();

        String[] input = scanner.nextLine().trim().split(" ");
        String firstName = input[0];
        String lastName = input[1];

        List<Employee> foundEmpl = em.createQuery(
                "SELECT e FROM Employee e " +
                        "where e.firstName LIKE ? " +
                        "AND e.lastName LIKE ?")
                .setParameter(0,firstName)
                .setParameter(1,lastName)
                .getResultList();
        if (foundEmpl.size() > 0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        em.getTransaction().commit();
        em.close();
    }
}
