package src.main.java.com.client.init;

import src.main.java.com.client.persistence.ProductReader;

public class Main {

    public static void main(String[] args) {

        ProductReader productReader = new ProductReader();

        productReader.readFile();
    }
}