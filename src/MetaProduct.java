import sun.java2d.pipe.SpanShapeRenderer;

import java.time.LocalDate;
import java.util.AbstractMap;
import java.util.Objects;

public class MetaProduct extends AbstractMap.SimpleEntry<Product,Integer> {

    MetaProduct(Product product)
    {
        super(product,0);
    }
    MetaProduct(Product product, int amount)
    {
        super(product,amount);
    }

    public int increaseByAmount(int byAmount)
    {
        this.setValue(this.getValue() + byAmount);
        return this.getValue();
    }

    public int decreaseByAmount(int byAmount)
    {
        this.setValue(this.getValue() - byAmount);
        return this.getValue();
    }

    @Override
    public boolean equals(Object o) {

        if(!(o instanceof MetaProduct))
        {
            return false;
        }
        if(((MetaProduct) o).getKey().equals(this.getKey()))
        {
            return true;
        }
        return false;

    }
}
