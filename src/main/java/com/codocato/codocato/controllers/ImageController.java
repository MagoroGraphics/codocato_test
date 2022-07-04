package com.codocato.codocato.controllers;

import com.codocato.codocato.models.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
public class ImageController {

    @Autowired
    com.codocato.codocato.controllers.ImageService imageService;

    @PostMapping("/images/add")
    public String addPhoto(@RequestParam("title") String title, // This is http:localhost:8080/images/add?title=
                           @RequestParam("image") MultipartFile image, Model model) // This is http:localhost:8080/images/add?title=something&&image=something
            throws IOException {
        String id = imageService.addImage(title, image);
        return "redirect:/images/" + id;
    }

    @GetMapping("/images/{id}")
    public String getPhoto(@PathVariable String id, Model model) {
        Image image = imageService.getImage(id);
        model.addAttribute("title", image.getTitle());
        model.addAttribute("image",
                Base64.getEncoder().encodeToString(image.getImage().getData()));
        return "image";
    }


}
