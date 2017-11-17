import ingredient.basic.Mint;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();

        Mint mint = new Mint();
        em.persist(mint);

        em.getTransaction().commit();
        em.close();
        managerFactory.close();
    }
}
