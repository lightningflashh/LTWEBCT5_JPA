package vn.chithanh.jpact5.services;

import vn.chithanh.jpact5.entity.Category;

import java.util.List;

public interface ICategoryService {
    void insertCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int categoryId);
    Category findCategoryById(int id);
    List<Category> findAllCategory();
    List<Category> findCategoryByName(String categoryName);
    List<Category> findAllCategory(int page, int pageSize);
    int countCategory();
}
