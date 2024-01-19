import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Program {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Course javaJunior = new Course("JavaJunior", 5);
        Course linux = new Course("Linux", 10);
        Course git = new Course("Git", 3);

        addCourseToDb(javaJunior, sessionFactory);
        addCourseToDb(linux, sessionFactory);
        addCourseToDb(git, sessionFactory);

        Course retrievedJavaJunior = getCourseByID(javaJunior.getID(), sessionFactory);
        System.out.println("Java Junior course retrieved from DB AFTER CREATION:");
        System.out.println(retrievedJavaJunior);

        updateCourse(javaJunior.getID(), sessionFactory);
        Course retrievedJavaJuniorAfterUpdate = getCourseByID(javaJunior.getID(), sessionFactory);
        System.out.println("Java Junior course retrieved from AFTER UPDATE:");
        System.out.println(retrievedJavaJuniorAfterUpdate);

        deleteCourseById(git.getID(), sessionFactory);
    }

    static void addCourseToDb(Course newCourse, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(newCourse);
            session.getTransaction().commit();
        }
    }

    static Course getCourseByID(int id, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Course retrievedCourse = session.get(Course.class, id);
            session.getTransaction().commit();
            return retrievedCourse;
        }
    }

    static void updateCourse(int id, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Course retrievedCourse = session.get(Course.class, id);
            retrievedCourse.updateTitle();
            retrievedCourse.updateDuration();
            session.update(retrievedCourse);
            session.getTransaction().commit();
        }
    }

    static void deleteCourseById(int id, SessionFactory sessionFactory) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(session.get(Course.class, id));
            session.getTransaction().commit();
        }
    }

}
