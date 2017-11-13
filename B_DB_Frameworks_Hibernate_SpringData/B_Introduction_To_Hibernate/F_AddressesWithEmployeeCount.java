import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class F_AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Address> foundAddresses = em.createQuery(
                "SELECT a FROM Address a " +
                "ORDER BY a.employees.size DESC,a.town.id")
                .setMaxResults(10)
                .getResultList();

        foundAddresses.forEach(address -> System.out.printf("%s %s - %d employees%n",
                address.getText(),
                address.getTown().getName(),
                address.getEmployees().size()));
        em.getTransaction().commit();
        em.close();
    }
}
