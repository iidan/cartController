package supersmart.jobTest.supersmart;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import supersmart.jobTest.supersmart.Objects.Item;
import supersmart.jobTest.supersmart.Service.CartValidation;

import java.lang.reflect.Type;
import java.util.List;

@SpringBootTest
class SuperSmartApplicationTests {

    private final String JsonCartList = "[\n" +
            "    {\n" +
            "        \"type\" : 3,\n" +
            "        \"barcode\" :29345,\n" +
            "        \"name\" : \"sadqwe\",\n" +
            "        \"brande\" :\"qweqweq\",\n" +
            "        \"weight\":12,\n" +
            "        \"price\":13,\n" +
            "        \"color\":\"green\",\n" +
            "        \"section\":\"no\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"type\" : 3,\n" +
            "        \"barcode\" :12345,\n" +
            "        \"name\" : \"sadqwe\",\n" +
            "        \"brande\" :\"qweqweq\",\n" +
            "        \"weight\":12,\n" +
            "        \"price\":13,\n" +
            "        \"color\":\"green\",\n" +
            "        \"section\":\"no\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"type\" : 2,\n" +
            "        \"barcode\" :12345,\n" +
            "        \"name\" : \"sadqwe\",\n" +
            "        \"brande\" :\"qweqweq\",\n" +
            "        \"weight\":5,\n" +
            "        \"price\":13,\n" +
            "        \"color\":\"green\",\n" +
            "        \"section\":\"no\"\n" +
            "    },\n" +
            "       {\n" +
            "        \"type\" : 1,\n" +
            "        \"barcode\" :54645,\n" +
            "        \"name\" : \"sadqwe\",\n" +
            "        \"brande\" :\"qweqweq\",\n" +
            "        \"weight\":12,\n" +
            "        \"price\":13,\n" +
            "        \"color\":\"blue\",\n" +
            "        \"section\":\"no\"\n" +
            "    },\n" +
            "       {\n" +
            "        \"type\" : 3,\n" +
            "        \"barcode\" :12345,\n" +
            "        \"name\" : \"sadqwe\",\n" +
            "        \"brande\" :\"qweqweq\",\n" +
            "        \"weight\":12,\n" +
            "        \"price\":13,\n" +
            "        \"color\":\"red\",\n" +
            "        \"section\":\"no\"\n" +
            "    }\n" +
            "]";


    final CartValidation cartValidation;

    public SuperSmartApplicationTests(CartValidation cartValidation) {
        this.cartValidation = cartValidation;
    }

    @Test
    void TestIfCartShoppingValid() {
        Assert.assertEquals(cartValidation.checkCartValidation(getItemsToTest()), true);
    }

    List<Item> getItemsToTest() {
        Type listType = new TypeToken<List<Item>>() {}.getType();
        List<Item> yourList = new Gson().fromJson(JsonCartList, listType);
        return yourList;
    }
}
