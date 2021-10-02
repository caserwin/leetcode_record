package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: caserwin
 * Date: 2021/10/2 10:12 上午
 * Description:
 */
public class Code1436 {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();

        List<String> list1 = new ArrayList<>();
        list1.add("pYyNGfBYbm");
        list1.add("wxAscRuzOl");

        List<String> list2 = new ArrayList<>();
        list2.add("kzwEQHfwce");
        list2.add("pYyNGfBYbm");

        list.add(list1);
        list.add(list2);

        System.out.println(new Code1436().destCity(list));
    }

    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        for (List<String> list : paths) {
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) {
                    if (!map.containsKey(list.get(i))) {
                        map.put(list.get(i), null);
                    }
                    continue;
                }
                map.put(list.get(i), list.get(i + 1));
            }
        }

        for (Map.Entry<String, String> en : map.entrySet()) {
            if (en.getValue() == null) {
                return en.getKey();
            }
        }
        return "";
    }
}
