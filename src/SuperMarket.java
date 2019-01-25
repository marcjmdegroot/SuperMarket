public class SuperMarket {
    public static void main(String[] args) {
        Register register = new Register();

        Product	robijn	= new Product("robijn",3.00);
        Product	brinta	= new Product("brinta",2.50);
        Product	groente	= new Product("groente",5.00);
        Product	kwark	= new Product("kwark",2.00);
        Product	luiers	= new Product("luiers",10.00);

        Cart shoppingCart = new Cart();
        shoppingCart.addProduct(robijn,3);
        shoppingCart.addProduct(brinta,1);
        shoppingCart.addProduct(groente,2);
        shoppingCart.addProduct(kwark,4);
        shoppingCart.addProduct(luiers,5);

        register.checkOut(shoppingCart.getProductList(),100);
    }
}
