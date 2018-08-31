package collection;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by Carrey on 2018/8/30.
 */
public class HashMapTest {

    public static void main(String[] args) throws Exception {
        HashMap<String,Object> map = new HashMap<String,Object>();
        for (int i = 1;i<=12;i++){
            map.put(String.valueOf(i),i);
        }
        map.put("13",13);
        System.out.println(map.size());
        System.out.println(getHashMapCapcity(map));
        Thread t = new Thread();
        Thread t2 = new Thread();
        t.join();
    }
    public static int getHashMapCapcity(HashMap<String,Object> map) throws Exception {
        Field table = HashMap.class.getDeclaredField("table");
        table.setAccessible(true);
        Object[] o = (Object[]) table.get(map);
        return o.length;
    }
}
