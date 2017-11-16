package com.groupproject.productservice.repository;

import com.groupproject.productservice.domain.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
