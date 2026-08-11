package src.main.java.com.client.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import src.main.java.com.client.model.Product;
import java.math.BigDecimal;

public class ProductReader {

    private ArrayList<Product> products = new ArrayList<Product>();

    public void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/products.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] data = line.split(";");
                String name = data[0];
                String description = data[1];
                BigDecimal price = new BigDecimal(data[2]);
                BigDecimal tax = new BigDecimal(data[3]);

                var product = new Product(name, description, price, tax);
                products.add(product);
            }
        } catch (IOException e) {
          System.out.println("Error reading file.");
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }
}