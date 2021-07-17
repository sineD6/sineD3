import java.util.ArrayList;

public class ProductRepository {

    static ArrayList<Product> list = new ArrayList<>();

    public static ArrayList<Product> dataBase (){
        return list;
    }

    static
    {
        list.add(ProductService.createProduct("клубничка", "ягоды", 5.0));
        list.add(ProductService.createProduct("огурцы", "овощи", 1.5));
        list.add(ProductService.createProduct("арбуз", "ягоды", 2.0));
        list.add(ProductService.createProduct("яблоко", "фрукты", 3.0));
    }
}
