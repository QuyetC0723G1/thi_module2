package view;

import model.Product;
import model.ProductManager;
import validate.ValidateProduct;

import java.util.*;

public class MenuNew {
    public static void main(String[] args) {
        MenuNew menu = new MenuNew();
        menu.showMenu();
    }

    Scanner scanner = new Scanner(System.in);
    static ProductManager productManager = new ProductManager();

    public void showMenu() {
        do {

            System.out.println("------ CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ------");
            System.out.println("\t\t1. Hiển Thị Danh Sách Sản Phẩm \n\t\t2. Thêm Mới Sản Phẩm \n\t\t3. Cập nhật Sản Phẩm \n\t\t4. Xoá Sản Phẩm \n\t\t5. Sắp Xếp\n\t\t6. Tìm Sản Phẩm Có Giá Cao Nhất  \n\t\t7. Thoát");
            int choice = ValidateProduct.inputChoice();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    getAll();
                    break;
                case 2:
                    addProductInMenu();
                    break;
                case 3:
                    showEditInMenu();
                    break;
                case 4:
                    showRemoveInMenu();
                    break;
                case 5:
                    arrangeList();
                    break;
                case 6:
                    bestPrice();
                    break;
                case 7:
                    System.exit(0);

            }
        } while (true);
    }

    public static Product getInfo() {
        System.out.println("Vui Lòng Nhập Thông Tin Về Sản Phẩm Mới !!");
        int id;
        do {
            id = ValidateProduct.inputId();
            if (productManager.findById(id) != null) {
                System.out.println("Id của sản phẩm hiện đã tồn tại, vui lòng nhập lại !!!");
            }
        } while (productManager.findById(id) != null);
        String name = ValidateProduct.inputName();
        int quantity = ValidateProduct.inputQuantity();
        int price = ValidateProduct.inputPrice();
        String describe = ValidateProduct.inputDescribe();
        return new Product(id, name, quantity, price, describe);
    }

    public void addProductInMenu() {
        Product product = getInfo();
        productManager.add(product);
        System.out.println("********Thêm Mới Sản Phẩm Thành Công ********");

    }



    public void getAll() {
        int enterCount = productManager.findAll().size() / 5 + 1;
        int count = 0;
        for (Product p : productManager.findAll()) {
            System.out.println(p);
            count++;
            if (count == 5 && enterCount > 0) {
                count = 0;
                ValidateProduct.inputEnter();
                enterCount--;
            }
        }
    }

    public void showEditInMenu() {
        String id;
        do {
            System.out.print("Nhập id sản phẩm cần cập nhật: ");
            id = scanner.nextLine();

            if (productManager.findById(Integer.parseInt(id)) == null && !id.isEmpty()) {
                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên");
            }
            if (id.isEmpty()) return;
        } while (productManager.findById(Integer.parseInt(id)) == null);
        Product product = getInfo();
        productManager.edit(Integer.parseInt(id), product);
        System.out.println("******** Cập nhật sản phẩm thành công ********");
    }

    public void showRemoveInMenu() {
        String id;
        do {
            System.out.print("Nhập id sản phẩm cần xóa: ");
            id = scanner.nextLine();
            if (productManager.findById(Integer.parseInt(id)) == null && !id.isEmpty()) {
                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên");
            }
            if (id.isEmpty()) return;
        } while (productManager.findById(Integer.parseInt(id)) == null);
        System.out.println("Bạn có muốn xóa sản phẩm không ??? Nhấn 'Y' để đồng ý , Nhấn bất kỳ để thoát : ");
        String decision = scanner.nextLine().toLowerCase();
        if (decision.equals("y")){
            productManager.remove(Integer.parseInt(id));
            System.out.println("******** Xoá sản phẩm thành công *******");
        }

    }

    public void arrangeList() {
        productManager.findAll().sort(Comparator.comparing(Product::getPrice));
        System.out.println("List Product sắp xếp theo giá tăng dần : ");
        for(Product p : productManager.findAll()){
            System.out.println(p);
        }
    }

    public void bestPrice() {
        Product maxPrice = Collections.max(productManager.findAll(), Comparator.comparing(Product::getPrice));
        System.out.println(maxPrice);
    }




}
