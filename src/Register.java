import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class Register {
    private double subTotal;
    private double totalDiscount;
    private ArrayList<MetaProduct> scannedProducts;
    private double cashInRegister;

    public Register()
    {
        this.cashInRegister = 0;
        this.scannedProducts = new ArrayList<MetaProduct>(0);
    }

    public double checkOut(ArrayList<Product> productList, double cash)
    {
        scanProducts(productList);
        System.out.printf("Your subtotal is: €%.2f \n",this.subTotal);
        calculateTotalDiscount(LocalDate.of(2019,1,30));
        System.out.printf("Your discount is: €%.2f \n",this.totalDiscount);
        double total = (this.subTotal - this.totalDiscount);
        System.out.printf("You have to pay: €%.2f \n",total);
        this.cashInRegister += total;
        return cash - total;
    }

    public double scanProducts(ArrayList<Product> productList)
    {
        for(Product product : productList )
        {
            System.out.println("Beep");
            addProduct(product);
            this.subTotal += product.getPrice();
        }
        return this.subTotal;
    }

    private boolean addProduct(Product product)
    {
        for(MetaProduct metaProduct: scannedProducts)
        {
            if(product.equals(metaProduct.getKey()))
            {
                metaProduct.increaseByAmount(1);
                return true;
            }
        }
        return scannedProducts.add(new MetaProduct(product,1));
    }

    public double calculateDiscount(LocalDate date,Product product, int amount)
    {
        if(product.getName().equals("robijn"))
        {
            return (amount - (amount % 2)) * (product.getPrice()*0.40);
        } else if(product.getName().equals("luiers")) {
            return (amount - (amount % 4)) * (product.getPrice()*0.25);
        } else if(product.getName().equals("kwark") && (date.getDayOfWeek() == DayOfWeek.WEDNESDAY))
        {
            return amount;
        }
        return 0;
    }

    public double calculateTotalDiscount(LocalDate date)
    {
        double totalDiscount = 0;
        for(MetaProduct metaProduct : this.scannedProducts)
        {
            totalDiscount += calculateDiscount(date,metaProduct.getKey(),metaProduct.getValue());
        }
        this.totalDiscount = totalDiscount;
        return totalDiscount;
    }

    public double calculateTotalDiscount()
    {
        double totalDiscount = 0;
        for(MetaProduct metaProduct : this.scannedProducts)
        {
            totalDiscount += calculateDiscount(LocalDate.now(),metaProduct.getKey(),metaProduct.getValue());
        }
        return totalDiscount;
    }


}
