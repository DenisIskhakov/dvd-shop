package com.dvdshop.controller;


import com.dvdshop.model.Category;
import com.dvdshop.repository.CategoryRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@Tag(name = "Category controller")
@AllArgsConstructor
@RestController
@RequestMapping(value = CategoryController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

    static final String REST_URL = "/category";
    private CategoryRepository categoryRepository;

    @GetMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Category findById(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Категория с указаным ID %d не найден", id)));
    }

    @GetMapping("/getByName")
    public Category getCategoryByName(@RequestParam(name = "name") String name) {
        return categoryRepository.findByName(name);
    }
}
