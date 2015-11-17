package database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class DBConnection {

    private static SessionFactory sessionFactory;
    private static Configuration config;

    public static Configuration getConfig() {
        if (config == null) {
            config = new Configuration();

            String packageName = DBConnection.class.getPackage().getName();
            config.configure(packageName + "/hibernate.cfg.xml");
        }
        return config;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration cfg = getConfig();
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(
                        cfg.getProperties());
                SessionFactory factory = cfg.buildSessionFactory(builder.build());
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

    public static Session getSession() {
        return getSessionFactory().openSession();
    }
}
