package Utils;

import java.util.List;

public class UtilityClass {
    public String listToString(List<Object> list) {
        String stringList = list.toString();
        stringList = stringList.replace("[", "");
        stringList = stringList.replace("]", "");
        return stringList;
    }
}
