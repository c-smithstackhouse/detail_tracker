package detail_tracker.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import detail_tracker.entities.Project;

import java.util.List;

public class DatabaseConnectionTest {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Project.class)
                                    .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Begin transaction
            session.beginTransaction();

            // Perform some query
            List<Project> result = session.createQuery("from Project", Project.class).getResultList();

            // Print result
            System.out.println(result);

            // Commit transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close session
            session.close();
            // Close session factory
            factory.close();
        }
    }

    
}

