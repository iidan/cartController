package supersmart.jobTest.supersmart.Utils;

public class Utils {
    public static boolean checkNumberPrefix(Long value, String prefix) {
        return value.toString().startsWith(prefix);
    }

    public static int checkAmountOfTrueValues(Boolean...values) {
        int counter = 0;
        for(Boolean val : values){
            if(val){
                counter++;
            }
        }
        return counter;
    }
}
