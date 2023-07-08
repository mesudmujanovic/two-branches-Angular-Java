package com.landMark.landMark.Repository;

import com.landMark.landMark.Entity.Image;
import com.landMark.landMark.Enum.Importance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findByImportance(Importance importance);

}
