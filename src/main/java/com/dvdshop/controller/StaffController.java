package com.dvdshop.controller;


import com.dvdshop.model.Staff;
import com.dvdshop.repository.StaffRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Staff controller")
@AllArgsConstructor
@RequestMapping(value = StaffController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class StaffController {
    static final String REST_URL = "/staff";

    private StaffRepository staffRepository;

    @GetMapping(value = "/{id}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Staff findById(@PathVariable Long id) {
        return staffRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Персонал с указаным ID %d не найден", id)));
    }

}
