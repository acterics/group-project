package com.groupproject.image.model;

import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Data
public class Image {

    @NonNull
    @NotBlank
    private String url;

    @NonNull
    @NotBlank
    private Integer width;

    @NonNull
    @NotBlank
    private Integer height;

    private String resizingType = "fit";
    private String gravity = "ce";
    private Integer enlarge = 0;
    private String extension = "webp";

}
