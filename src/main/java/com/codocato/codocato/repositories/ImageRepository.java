package com.codocato.codocato.repositories;

import com.codocato.codocato.models.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {

}

