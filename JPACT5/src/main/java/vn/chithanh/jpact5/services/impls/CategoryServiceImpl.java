package vn.chithanh.jpact5.services.impls;

import vn.chithanh.jpact5.dao.impls.CategoryDAOImplement;
import vn.chithanh.jpact5.entity.Category;
import vn.chithanh.jpact5.services.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {

    CategoryDAOImplement catDao = new CategoryDAOImplement();

    @Override
    public void insertCategory(Category category) {
        catDao.insertCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        catDao.updateCategory(category);
    }

    @Override
    public void deleteCategory(int categoryId) {
        catDao.deleteCategory(categoryId);
    }

    @Override
    public Category findCategoryById(int id) {
        return catDao.findCategoryById(id);
    }

    @Override
    public List<Category> findAllCategory() {
        return catDao.findAllCategory();
    }

    @Override
    public List<Category> findCategoryByName(String categoryName) {
        return catDao.findCategoryByName(categoryName);
    }

    @Override
    public List<Category> findAllCategory(int page, int pageSize) {
        return catDao.findAllCategory(page, pageSize);
    }

    @Override
    public int countCategory() {
        return catDao.countCategory();
    }
}
