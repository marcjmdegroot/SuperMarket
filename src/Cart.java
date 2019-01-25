import java.util.ArrayList;

public class Cart {

    private ArrayList<Product> productList;

    Cart()
    {
        this.productList = new ArrayList<>(0);
    }

    Cart(ArrayList<Product> productList)
    {
        this.productList = productList;
    }


    boolean addProduct(Product product)
    {
        return this.productList.add(product);
    }

    boolean addProduct(Product product, int amount)
    {
        for(int i = 0; i < amount;i++)
        {
            if(!this.productList.add(product))
            {
                return false;
            }
        }
        return true;
    }


    boolean removeProduct(Product product)
    {
        return this.productList.remove(product);
    }

    void removeAllOfProduct(Product product)
    {
        while (this.productList.contains(product))
        {
            this.productList.remove(product);
        }
    }

    void emptyCart()
    {
        this.productList.clear();
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
