import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class H_FindLatest10Projects {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();

        List<Project> foundProjects = em.createQuery(
                "SELECT p FROM Project p " +
                        "GROUP BY p.name" +
                        " ORDER BY p.startDate DESC")
                .setMaxResults(10).getResultList();

        foundProjects.stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project ->
                        System.out.printf(
                                "Project name: %s%n" +
                                        "\t\tProject Description: %s\n" +
                                        "\t\tProject Start Date: %s\n" +
                                        "\t\tProject End Date: %s\n",
                                project.getName(),
                                project.getDescription(),
                                project.getStartDate(),
                                project.getEndDate()));

        em.getTransaction().commit();
    }
}
