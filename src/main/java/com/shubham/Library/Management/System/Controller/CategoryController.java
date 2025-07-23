package com.shubham.Library.Management.System.Controller;

import com.shubham.Library.Management.System.Dto.CategoryDto;
import com.shubham.Library.Management.System.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/get")
    public ResponseEntity<Page<CategoryDto>> getAllCategories(
            @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "categoryId") String sortBy
    ) {
        return new ResponseEntity<>(categoryService.getAllCategoryData(pageNum - 1, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping("/get/{categoryId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable long categoryId) {
        return new ResponseEntity<>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @PutMapping("/put/{categoryId}")
    public ResponseEntity<String> updateCategory(@PathVariable long categoryId, @RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.updateCategory(categoryId, categoryDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable long categoryId) {
        return new ResponseEntity<>(categoryService.deleteCategory(categoryId), HttpStatus.NO_CONTENT);
    }
}
