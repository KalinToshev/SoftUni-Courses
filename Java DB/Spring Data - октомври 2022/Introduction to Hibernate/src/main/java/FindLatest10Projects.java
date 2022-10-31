import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class FindLatest10Projects {

    private static final String DATABASE_NAME = "soft_uni";

    private static final String GET_LATEST_10_PROJECTS = "SELECT p FROM Project p ORDER BY p.startDate DESC";

    public static void main(String[] args) {

        final EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory(DATABASE_NAME);

        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.createQuery(GET_LATEST_10_PROJECTS, Project.class)
                .setMaxResults(10)
                .getResultList()
                .stream().sorted(Comparator.comparing(Project::getName))
                .forEach(project -> System.out.printf(

                        "Project name: " + project.getName() + "%n" +
                                "   Project Description: " + project.getDescription() + "%n" +
                                "   Project Start Date: " + project.getStartDate() + "%n" +
                                "   Project End Date: " + project.getEndDate() + "%n"

                ));

        entityManager.close();

    }

}
