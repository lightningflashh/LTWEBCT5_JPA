package vn.chithanh.jpact5.dao.impls;

import vn.chithanh.jpact5.configs.JPAConfig;
import vn.chithanh.jpact5.dao.ICategoryDAO;
import vn.chithanh.jpact5.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CategoryDAOImplement implements ICategoryDAO {
    @Override
    public void insertCategory(Category category) {
        EntityManager enma = JPAConfig.getEntityManager();

        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();
            enma.persist(category);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void updateCategory(Category category) {
        EntityManager enma = JPAConfig.getEntityManager();

        EntityTransaction trans = enma.getTransaction();

        try {
            trans.begin();
            enma.merge(category);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void deleteCategory(int categoryId) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            Category category = enma.find(Category.class, categoryId);
            enma.remove(category);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public Category findCategoryById(int id) {
        EntityManager enma = JPAConfig.getEntityManager();
        Category category = enma.find(Category.class, id);
        return category;
    }

    @Override
    public List<Category> findAllCategory() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
        return query.getResultList();
    }

    @Override
    public List<Category> findCategoryByName(String categoryName) {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT c FROM Category c WHERE c.categoryName = :categoryName";
        TypedQuery<Category> query = enma.createQuery(jpql, Category.class);
        query.setParameter("categoryName", "%" + categoryName + "%");
        return query.getResultList();
    }

    @Override
    public List<Category> findAllCategory(int page, int pageSize) {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Category> query = enma.createNamedQuery("Category.findAll", Category.class);
        query.setFirstResult((page - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }

    @Override
    public int countCategory() {
        EntityManager enma = JPAConfig.getEntityManager();
        String jpql = "SELECT COUNT(c) FROM Category c";
        Query query = enma.createQuery(jpql);
        return ((Long)query.getSingleResult()).intValue();
    }
}
