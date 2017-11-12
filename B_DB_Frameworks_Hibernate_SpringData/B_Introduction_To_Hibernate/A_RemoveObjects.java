import entities.Town;

import javax.persistence.*;
import java.util.List;

public class A_RemoveObjects {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Town> result = em.createQuery(
                "SELECT name FROM Town name", Town.class)
                .getResultList();
        for (Town town : result) {
            if (town.getName().length() > 5) {
                em.detach(town);
            } else {
                town.setName(town.getName().toLowerCase());
            }
            em.merge(town);
        }
        em.getTransaction().commit();
        em.close();
    }
}
