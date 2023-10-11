package util;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RWDataToFile {
    static File file = new File("data/products.csv");
    public static void writeData(List<Product> products){
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Product product: products) {
                line += product.getDataToWrite();
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static List<Product> readData(){
        List<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] data = line.split(",");
                Product product = new Product(Integer.parseInt(data[0]),data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]),data[4]);
                products.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } return products;

    }
}
