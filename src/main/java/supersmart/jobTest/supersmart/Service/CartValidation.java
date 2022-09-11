package supersmart.jobTest.supersmart.Service;

import org.springframework.stereotype.Service;
import supersmart.jobTest.supersmart.Objects.Item;

import java.util.List;

@Service
public interface CartValidation {
    boolean checkCartValidation(List<Item> itemsList);
}
