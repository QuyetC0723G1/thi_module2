package model;

import util.RWDataToFile;

import java.util.ArrayList;
import java.util.List;

public class ProductManager implements IManager<Product> {
    List<Product> productList;

    public ProductManager() {
        productList = RWDataToFile.readData();
    }

    @Override
    public void add(Product product) {
        productList.add(product);
        RWDataToFile.writeData(productList);
    }

    @Override
    public void edit(int id, Product product) {
        int index = findByIdToGetIndex(id);
        productList.set(index,product);
        RWDataToFile.writeData(productList);
    }

    @Override
    public void remove(int id) {
        int index = findByIdToGetIndex(id);
        productList.remove(index);
        RWDataToFile.writeData(productList);
    }

    @Override
    public Product findById(int id) {
        for (Product product :productList) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> newList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())){
                newList.add(product);
            }
        }
        return newList;
    }

    @Override
    public List<Product> findByType(String type) {
        List<Product> newList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getDescribe().equalsIgnoreCase(type)){
                newList.add(product);
            }
        }
        return newList;
    }
    public int findByIdToGetIndex(int id){
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id){
                return i;
            }
        }return -1;
    }



}
