import entities.Employee;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class D_EmployeesFromDepartment {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager em = managerFactory.createEntityManager();
        em.getTransaction().begin();
        List<Employee> employees = em.createQuery(
                "SELECT e FROM Employee e " +
                        "JOIN Department d ON e.department.id = d.id" +
                        " WHERE d.name = 'Research and Development'" +
                        "ORDER BY e.salary,e.id").getResultList();

        employees.forEach(e ->
                System.out.printf("%s %s from %s - $%.2f%n",
                        e.getFirstName(),
                        e.getLastName(),
                        e.getDepartment().getName(),
                        e.getSalary()));

        em.getTransaction().commit();
        em.close();
    }
}
