package ru.aberezhnoy.register;

public class Registry {

    private final static Registry registry = new Registry();
    private final ProductService productService = new ProductService();
    private final BrandService brandService = new BrandService();
    private final UserService userService = new UserService();

    public static Registry getInstance() {
        return registry;
    }

    public ProductService getProductService() {
        return this.productService;
    }

    public BrandService getBrandService() {
        return this.brandService;
    }

    public UserService getUserService() {
        return this.userService;
    }

    public <T> T findService(String name, Class<T> clazz) {
        switch (name) {
            case "productService":
                return clazz.cast(productService);
            case "brandService":
                return clazz.cast(brandService);
            case "userService":
                return clazz.cast(userService);
            default:
                throw new IllegalArgumentException("Unknown service");
        }
    }
}
