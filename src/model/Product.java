package model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private int price;
    private String describe;

    public Product(int id, String name, int quantity, int price, String describe) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.describe = describe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setType(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Product : " +
                "Id : " + id +
                ", Name : " + name +
                ", Quantity : " + quantity +
                ", Price : " + price +
                ", Describe : " + describe
                ;
    }

    public String getDataToWrite(){
        return id + "," + name + "," + quantity + "," + price + "," + describe +"\n";

    }
}
