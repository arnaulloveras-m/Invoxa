package src.main.java.com.client.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.math.BigDecimal;
import src.main.java.com.client.model.Product;

public class ProductReader {

    private ArrayList<Product> products = new ArrayList<Product>();

    public ArrayList<Product> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                String id = data[0];
                int idInt = Integer.parseInt(id);
                String name = data[1];
                String description = data[2];
                BigDecimal price = new BigDecimal(data[3]);
                BigDecimal tax = new BigDecimal(data[4]);

                Product.updateNextId(idInt);
                var product = new Product(idInt, name, description, price, tax);
                products.add(product);
            }
        } catch (IOException e) {
          System.out.println("Error reading file.");
        }

        return products;
    }

    public ArrayList<Product> getProducts() {
        return new ArrayList<>(products);
    }
}