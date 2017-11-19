package com.groupproject.image.model;

import lombok.Data;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Data
public class Image {

    private String url;
    private Integer width;
    private Integer height;
    private String resizingType;
    private String gravity;
    private Integer enlarge;
    private String extension;

    public String getUrl() {
        if(url == null) {
            throw new NullPointerException();
        }
        return url;
    }

    public Integer getWidth() {
        if(width == null) {
            throw new NullPointerException();
        }
        return width;
    }

    public Integer getHeight() {
        if(height == null) {
            throw new NullPointerException();
        }
        return height;
    }

    public String getResizingType() {
        if(resizingType == null) {
            return "fit";
        }
        return resizingType;
    }

    public String getGravity() {
        if(gravity == null) {
            return "ce";
        }
        return gravity;
    }

    public Integer getEnlarge() {
        if(enlarge == null) {
            return 0;
        }
        return enlarge;
    }

    public String getExtension() {
        if(extension == null) {
            return "webp";
        }
        return extension;
    }

}
