package collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Carrey on 2018/7/30.
 * ArrayList扩容机制
 */
public class ArreyListTest {

    public static void main(String[] args) throws Exception {

        List<Integer> list = new ArrayList<Integer>();
        System.out.println("list.size = "+list.size()); //  集合中元素的个数
        int capacity = getArrayListCapacity((ArrayList<?>) list);   //  获取集合的初始容量大小
        System.out.println("list.length = "+capacity);
        System.out.println("<------------------------------------------>");
        for (int i=1 ; i <= 10 ; i++){
            list.add(i);
            System.out.println("list.size"+i+" = "+list.size());
            System.out.println("list.length"+i+" = "+getArrayListCapacity((ArrayList<?>) list));
        }
        System.out.println("<------------------------------------------>");
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        ((ArrayList<?>) list).trimToSize(); //  将集合的容量设为集合中元素的个数
        System.out.println("list.size = "+list.size());
        System.out.println("list.length = "+getArrayListCapacity((ArrayList<?>) list));
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
        System.out.println("maxValue"+maxValue);
        System.out.println("minValue"+minValue);
        List<String> linkedList = new LinkedList<String>();
        ListIterator<Integer> listIterator = list.listIterator();
        listIterator.add(120);
        Integer integer = list.get(0);
        System.out.println(integer);
        System.out.println(list.size());
    }

    public static int getArrayListCapacity(ArrayList<?> arrayList) throws Exception {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] o = (Object[]) field.get(arrayList);
        return o.length;
    }
}
