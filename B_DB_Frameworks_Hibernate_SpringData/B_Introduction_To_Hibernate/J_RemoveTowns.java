import entities.Address;
import entities.Town;
import jdk.nashorn.internal.ir.IfNode;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class J_RemoveTowns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();
        String townToDelete = scanner.nextLine().trim();

        List<Address> addresses = em.createQuery("SELECT a FROM Address a WHERE a.town.name = ?")
                .setParameter(0,townToDelete)
                .getResultList();
        addresses.forEach(address -> {
            address.getEmployees().forEach(e -> e.setAddress(null));
            em.flush();
            em.remove(address);
        });

        Town town = (Town) em.createQuery("SELECT t FROM Town t WHERE t.name = ?")
                .setParameter(0,townToDelete)
                .getSingleResult();
        em.remove(town);

        if (addresses.size() > 1){
            System.out.printf("%d addresses in %s deleted", addresses.size(),townToDelete);
        }else {
            System.out.printf("1 address in %s deleted",townToDelete);
        }

        em.getTransaction().commit();
        em.close();
    }
}
