import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class E_UpdatingEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();
        String inputName = scanner.nextLine().trim();

        Address address = new Address();
        address.setText("Vitoshka 15");
        em.persist(address);

        Employee employee = (Employee) em.createQuery("SELECT e FROM Employee e WHERE e.lastName = ?")
                .setParameter(0,inputName)
                .setMaxResults(1)
                .getSingleResult();
        employee.setAddress(address);

        em.getTransaction().commit();
        em.close();
    }
}
