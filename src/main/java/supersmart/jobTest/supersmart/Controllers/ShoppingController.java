package supersmart.jobTest.supersmart.Controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import supersmart.jobTest.supersmart.Objects.Item;
import supersmart.jobTest.supersmart.Service.CartShoppingManager;

import java.util.List;

@RestController
public class ShoppingController {

    private Logger log = LogManager.getLogger(ShoppingController.class.getName());

    final CartShoppingManager cartShoppingManager;

    public ShoppingController(CartShoppingManager cartShoppingManager) {
        this.cartShoppingManager = cartShoppingManager;
    }

    @PostMapping(value = "/get-shopping-cart")
    public Boolean getShoppingCart(@RequestBody List<Item> items) {
        try {
            return cartShoppingManager.checkCartValidation(items);
        } catch (Exception e) {
            log.error("Unable to validate shopping cart", e, true);
        }
        return null;
    }
}
