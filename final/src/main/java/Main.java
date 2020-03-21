import com.example.demo.model.Department;
import com.example.demo.model.User;
import org.apache.hadoop.hbase.mapreduce.WALInputFormat;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.util.Map;


/**
 * Have no idea of what is the purpose of this code and whether it is executed :/
 *
 *
 */

public class Main {
    private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            //System.out.println(ex.getLocalizedMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {




            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }


            // Creating some entities
            Department witchcraftDepartment = new Department();
            witchcraftDepartment.setId(666);
            witchcraftDepartment.setName("Witchcraft Department");

            User anna = new User();
            anna.setId(1);
            anna.setFirstName("Anna");
            anna.setLastName("Czarnaroba");
            anna.setEmail("oldhut@moogle.lol");
            anna.setDepartmentId(666);

            User george = new User();
            george.setId(2);
            george.setFirstName("Grzegorz");
            george.setLastName("Boilpot");
            george.setEmail("wizard666@moogle.lol");
            george.setDepartmentId(666);

            User kate = new User();
            kate.setId(3);
            kate.setFirstName("Katarzyna");
            kate.setLastName("Siemegrzech");
            kate.setEmail("nightspirit@moogle.lol");
            kate.setDepartmentId(666);

            // Transaction
            session.beginTransaction();

            session.save(witchcraftDepartment);
            session.save(anna);
            session.save(george);
            session.save(kate);

            session.getTransaction().commit();


        } finally {
            session.close();
        }

        System.out.println("!!!!!!!!!!!!!!!!!!!!");
    }
}