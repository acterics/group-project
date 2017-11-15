package com.groupproject.productservice.mapper;


import com.groupproject.productservice.domain.PropertyValue;
import com.groupproject.productservice.model.response.PropertyResponse;
import org.springframework.stereotype.Component;

@Component
public class PropertyResponseMapper {


    public PropertyResponse map(PropertyValue propertyValue) {
        PropertyResponse propertyResponse = new PropertyResponse();
        propertyResponse.setId(propertyValue.getProperty().getId());
        propertyResponse.setTitle(propertyValue.getProperty().getTitle());
        propertyResponse.setValue(propertyValue.getValue());
        return propertyResponse;
    }
}
