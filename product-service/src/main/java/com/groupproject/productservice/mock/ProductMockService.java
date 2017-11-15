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
    private final CategoryRepository categoryRepository;


    @Autowired
    public ProductMockService(ProductRepository productRepository,
                              ItemRepository itemRepository,
                              ProductPropertyRepository productPropertyRepository,
                              PropertyRepository propertyRepository,
                              PropertyValueRepository propertyValueRepository,
                              VendorRepository vendorRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.itemRepository = itemRepository;
        this.productPropertyRepository = productPropertyRepository;
        this.propertyRepository = propertyRepository;
        this.propertyValueRepository = propertyValueRepository;
        this.vendorRepository = vendorRepository;
        this.categoryRepository = categoryRepository;
    }

    @PostConstruct
    public void mockDatabase() {
        Category category = getNewPersistedCategory();
        Vendor vendor = getNewPersistedVendor();
        Property property = getNewPersistedProperty();
        Product product = getNewPersistedProduct(vendor, category);
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

    private Product getNewPersistedProduct(Vendor vendor, Category category) {
        Product product = new Product();
        product.setDescription("Awesome new product");
        product.setTitle("Green Big Product");
        product.setVendor(vendor);
        product.setCategory(category);
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

    private Category getNewPersistedCategory() {
        Category category = new Category();
        category.setName("shoes");
        category.setTitle("Shoes");
        category.setDescription("Comfortable shoes for all family");
        return categoryRepository.save(category);
    }

}
