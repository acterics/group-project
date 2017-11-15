package com.groupproject.productservice.mock;


import com.groupproject.productservice.domain.*;
import com.groupproject.productservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class ProductMockService {

    private final ProductRepository productRepository;
    private final ItemRepository itemRepository;
    private final ProductPropertyRepository productPropertyRepository;
    private final PropertyRepository propertyRepository;
    private final PropertyValueRepository propertyValueRepository;
    private final VendorRepository vendorRepository;


    @Autowired
    public ProductMockService(ProductRepository productRepository,
                              ItemRepository itemRepository,
                              ProductPropertyRepository productPropertyRepository,
                              PropertyRepository propertyRepository,
                              PropertyValueRepository propertyValueRepository,
                              VendorRepository vendorRepository) {
        this.productRepository = productRepository;
        this.itemRepository = itemRepository;
        this.productPropertyRepository = productPropertyRepository;
        this.propertyRepository = propertyRepository;
        this.propertyValueRepository = propertyValueRepository;
        this.vendorRepository = vendorRepository;
    }

    @PostConstruct
    public void mockDatabase() {
        Vendor vendor = getNewPersistedVendor();
        Property property = getNewPersistedProperty();
        Product product = getNewPersistedProduct(vendor);
        ProductProperty productProperty = getNewPersistedProductProperty(product, property);
        for (int i = 0; i < 10; i++) {
            Item item = getNewPersistedItem(product);
            PropertyValue propertyValue = getNewPersistedPropertyValue(item, property, String.valueOf(i));
        }
    }


    private Property getNewPersistedProperty() {
        Property property = new Property();
        property.setName("test_property");
        property.setPropertyType("Unknown");
        property.setTitle("Test Property");
        return propertyRepository.save(property);
    }

    private Product getNewPersistedProduct(Vendor vendor) {
        Product product = new Product();
        product.setDescription("Awesome new product");
        product.setTitle("Green Big Product");
        product.setVendor(vendor);
        return productRepository.save(product);
    }

    private ProductProperty getNewPersistedProductProperty(Product product, Property property) {
        ProductProperty productProperty = new ProductProperty();
        productProperty.setProduct(product);
        productProperty.setProperty(property);
        return productPropertyRepository.save(productProperty);
    }

    private Item getNewPersistedItem(Product product) {
        Item item = new Item();
        item.setPrice(1000.0f);
        item.setQuantity(10);
        item.setProduct(product);
        return itemRepository.save(item);
    }

    private PropertyValue getNewPersistedPropertyValue(Item item, Property property, String value) {
        PropertyValue propertyValue = new PropertyValue();
        propertyValue.setValue(value);
        propertyValue.setItem(item);
        propertyValue.setProperty(property);
        return propertyValueRepository.save(propertyValue);
    }

    private Vendor getNewPersistedVendor() {
        Vendor vendor = new Vendor();
        vendor.setName("ExpenV");
        vendor.setDescription("Expensive Vendor");

        return vendorRepository.save(vendor);
    }

}
