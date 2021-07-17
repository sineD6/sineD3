import java.util.Scanner;

public class ProductService {
    static int COUNTER = 1;
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        System.out.println("""
                Выберите пункт меню
                1. Добавить продукт
                2. Просмотреть продукт по id
                3. Просмотреть список всех продуктов
                4. Удалить продукт
                5. Редактировать продукт
                6. Выход""");
        int select = readInt();
        switch (select){
            case 1: //добавить
                addProduct();
                break;

            case 2: //просмореть по id
                System.out.println(findById());
                menu();
                break;

            case 3: //просмотреть всё
                findAll();
                break;

            case 4: //удалить
                deleteProduct();
                menu();
                break;
            case 5: //редактировать
                updateProduct();
                break;
            case 6:
                System.out.println("Завершение программы...");
                break;

            default:
                System.out.println("Введите верное значение! ");
                menu();
        }
    }

    public String readString(){
        return scanner.nextLine();
    }

    public int readInt(){
        return Integer.parseInt(scanner.nextLine());
    }

    public double readDouble(){
        return Double.parseDouble(scanner.nextLine());
    }

    public void addProduct(){
    //    System.out.println("Введите id продукта:");
        //    int id = readInt();
        System.out.println("Введите название продукта: ");
        String name = readString();
        System.out.println("Введите категорию продукта: ");
        String category = readString();
        System.out.println("Введите цену продукта: ");
        double price = readDouble();
        Product product = createProduct(name, category, price);
        ProductRepository.dataBase().
                add(product);
        System.out.println(product);
        menu();
    }

    public static Product createProduct(String name, String category, double price){
        return new Product(COUNTER++, name, category, price);
    }

    public Product findById(){
        System.out.println("Введите id продукта: ");
        int id = readInt();
        for(Product product : ProductRepository.dataBase()){
            if(id == product.getId()){
                return product;
            }
        }
        System.out.println("Продукт не найден");
        return new Product();
    }

    public void findAll(){
        for(Product product: ProductRepository.dataBase()){
            System.out.println(product);
        }
        menu();
    }

    public void deleteProduct() {
        System.out.println("Введите id: ");
        int id = readInt();
        for(Product product : ProductRepository.dataBase()){
            if(id == product.getId()){
                ProductRepository.dataBase().remove(product);
                break;
            }
        }
        System.out.println("Продукт не найден");
    }

    public void updateProduct(){
        System.out.println("Введите id: ");
        int id = readInt();
        for(Product product : ProductRepository.dataBase()){
            if(id == product.getId()){
                menuUpdate(product);
                break;
            }
        }
        System.out.println("Продукт не найден");
        menu();
    }

    public void menuUpdate(Product product){
        System.out.println("Выберите поле для редактирования: ");
        System.out.println("1. Изменить id");
        System.out.println("2. Изменить название");
        System.out.println("3. Изменить категорию");
        System.out.println("4. Изменить цену");
        System.out.println("5. Выйти из меню редактирования");
        int select = readInt();
        switch (select){
            case 1:
                System.out.println("Введите id");
                int id = readInt();
                product.setId(id);
                System.out.println(product);
                menuUpdate(product);
            case 2:
                System.out.println("Введите название");
                String name = readString();
                product.setName(name);
                System.out.println(product);
                menuUpdate(product);
            case 3:
                System.out.println("Введите категорию");
                String category = readString();
                product.setCategory(category);
                System.out.println(product);
                menuUpdate(product);
            case 4:
                System.out.println("Введите цену");
                double price = readDouble();
                product.setPrice(price);
                System.out.println(product);
                menuUpdate(product);
            case 5: menu();
            default:
                System.out.println("Введите верное значение!");
                menuUpdate(product);
        }
    }
}
