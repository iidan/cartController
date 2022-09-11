package supersmart.jobTest.supersmart.Service.Impl;

import org.springframework.stereotype.Service;
import supersmart.jobTest.supersmart.Objects.Item;
import supersmart.jobTest.supersmart.Objects.ShoppingCartValidation;
import supersmart.jobTest.supersmart.Service.CartShoppingManager;

import java.util.List;

@Service("CartValidationImpl")
public class CartShoppingManagerImpl implements CartShoppingManager {

    private final ShoppingCartValidation shoppingCartValidation;

    public CartShoppingManagerImpl(ShoppingCartValidation shoppingCartValidation) {
        this.shoppingCartValidation = shoppingCartValidation;
    }

    @Override
    public boolean checkCartValidation(List<Item> itemsList) {
        return shoppingCartValidation.cartShoppingValidation(itemsList);
    }
}
