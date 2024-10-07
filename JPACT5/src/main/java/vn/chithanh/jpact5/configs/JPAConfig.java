package vn.chithanh.jpact5.configs;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JPAConfig {

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-hibernate-mysql");
        return factory.createEntityManager();
    }

    public static void main(String[] args) {

        EntityManager enma = JPAConfig.getEntityManager();

        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

}
