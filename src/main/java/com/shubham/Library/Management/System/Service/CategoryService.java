package com.shubham.Library.Management.System.Service;

import com.shubham.Library.Management.System.Dto.CategoryDto;
import com.shubham.Library.Management.System.Entity.Category;
import com.shubham.Library.Management.System.Exception.CategoryNotFoundException;
import com.shubham.Library.Management.System.Repository.CategoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Page<CategoryDto> getAllCategoryData(int pageNum, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by(sortBy));
        Page<Category> categoryPage = categoryRepo.findAll(pageable);
        return categoryPage.map(Category -> modelMapper.map(Category, CategoryDto.class));
    }

    public CategoryDto getCategoryById(long categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category does not exist!"));
        return modelMapper.map(category, CategoryDto.class);
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        return modelMapper.map(categoryRepo.save(category), CategoryDto.class);
    }

    public String updateCategory(long categoryId, CategoryDto categoryDto) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category does not exist!"));
        if (categoryDto.getCategoryName() != null) {
            category.setCategoryName(categoryDto.getCategoryName());
        }
        if (categoryDto.getCategoryDesc() != null) {
            category.setCategoryDesc(categoryDto.getCategoryDesc());
        }
        categoryRepo.save(category);
        return "Category updated successfully";
    }

    public String deleteCategory(long categoryId) {
        Category category = categoryRepo.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("Category does not exist!"));
        categoryRepo.deleteById(categoryId);
        return "Category deleted successfully!";
    }
}
