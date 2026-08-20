package src.main.java.com.client.services;

import java.math.BigDecimal;
import java.util.ArrayList;

import src.main.java.com.client.model.Product;
import src.main.java.com.client.persistence.*;

public class ProductService {

    private ArrayList<Product> productsList;
    private ProductReader productReader;
    private ProductWriter productWriter;

    public ProductService() {
        productReader = new ProductReader();
        productsList = productReader.readFile();
        productWriter = new ProductWriter();
    }

    public void createProduct(String name, String description, BigDecimal price, BigDecimal tax) {

        var product = new Product(name, description, price, tax);
        productsList.add(product);
        productWriter.writeFile(productsList);
    }
    
}
