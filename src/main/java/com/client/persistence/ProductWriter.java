package src.main.java.com.client.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import src.main.java.com.client.model.Product;

public class ProductWriter {

    public void writeFile(ArrayList<Product> products) {
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/products.txt"))) {

            for (Product product : products) {
                bw.write(
                    product.getId() + ";" +
                    product.getName() + ";" +
                    product.getDescription() + ";" +
                    product.getPrice() + ";" +
                    product.getTax()
                );
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error writing file." + e);
        }
    }
}
