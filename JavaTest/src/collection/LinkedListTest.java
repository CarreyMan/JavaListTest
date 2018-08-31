package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Carrey on 2018/8/15.
 * 由此可见，遍历LinkedList时，
 * 使用removeFist()或removeLast()效率最高。
 * 但用它们遍历时，会删除原始数据；若单纯只读取，而不删除，应该使用第3种遍历方式。
 * 无论如何，千万不要通过随机访问去遍历LinkedList！
 */
public class LinkedListTest {

    public static void main(String[] args){


        /**
         *  ArrayList的遍历方式及效率
         */
        //  ArrayList通过迭代器遍历
        iteratorThroughIterator(getArrayList());
        //  ArrayList通过for循环遍历
        iteratorThroughFor2(getArrayList());
        //  ArrayList通过随机访问，通过索引值去遍历
        iteratorThroughRandomAccess(getArrayList());


        /**
         * LinkedList的遍历方式，及效率
         */
        //  迭代器便利
        cycleIterator(getLinkedList());
        // 通过快速随机访问遍历
        cycleQuick(getLinkedList());
        // 通过另外一种for循环遍历
        cycleOtherInteger(getLinkedList());
        // 通过pollFirst()来遍历LinkedList
        cycleByPollFirst(getLinkedList());
        // 通过pollLast()来遍历LinkedList
        cycleByPollLast(getLinkedList());
        // 通过removeFirst()来遍历LinkedList
        cycleByRemoveFirst(getLinkedList());
        // 通过removeLast()来遍历LinkedList
        cycleByRemoveLast(getLinkedList());

    }

    //  获取集合ArrayList
    public static ArrayList<Integer> getArrayList(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1;i <= 100000;i++){
            arrayList.add(i);
        }
        return arrayList;
    }
    //  ArrayList通过迭代器遍历
    public static void iteratorThroughIterator(ArrayList<Integer> arrayList){
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Iterator iter = arrayList.iterator(); iter.hasNext(); ) {
            iter.next();
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughIterator：" + interval+" ms");
    }
    //  ArrayList通过for循环遍历
    public static void iteratorThroughFor2(ArrayList<Integer> arrayList){
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Integer integer:arrayList){

        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughFor2：" + interval+" ms");
    }
    //  ArrayList通过随机访问，通过索引值去遍历
    public static void iteratorThroughRandomAccess(ArrayList<Integer> arrayList){
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (int i=0; i<arrayList.size(); i++) {
            arrayList.get(i);
        }
        endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println("iteratorThroughRandomAccess：" + interval+" ms");
    }


    //  获取集合LinkedList
    public static LinkedList<Integer> getLinkedList(){
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        for (int i = 1;i <= 100000;i++){
            linkedList.add(i);
        }
        return linkedList;
    }
    //  迭代器便利
    public static void cycleIterator(LinkedList<Integer> linkedList){
        long before = System.currentTimeMillis();
        System.out.println("迭代器遍历之前系统毫秒值："+before);
        for (Iterator<Integer> iterator = linkedList.iterator(); iterator.hasNext();){
            iterator.next();
        }
        long after = System.currentTimeMillis();
        System.out.println("迭代器遍历之后系统毫秒值："+after);
        System.out.println("迭代器遍历差值："+(after-before));
        System.out.println("-------------------------------------");
    }
    //  通过快速随机访问遍历
    public static void cycleQuick(LinkedList<Integer> linkedList){
        long before = System.currentTimeMillis();
        System.out.println("通过快速随机访问遍历之前系统毫秒值："+before);
        int size = linkedList.size();
        for (int i = 0;i < size;i++){
            linkedList.get(i);
        }
        long after = System.currentTimeMillis();
        System.out.println("通过快速随机访问遍历之后系统毫秒值："+after);
        System.out.println("通过快速随机访问遍历差值："+(after-before));
        System.out.println("-------------------------------------");
    }
    //  通过另外一种for循环遍历
    public static void cycleOtherInteger(LinkedList<Integer> linkedList){
        long before = System.currentTimeMillis();
        System.out.println("通过另外一种for循环遍历之前系统毫秒值："+before);
        for (Integer integer:linkedList){
//            System.out.print(integer);
        }
        long after = System.currentTimeMillis();
        System.out.println("通过另外一种for循环遍历之后系统毫秒值："+after);
        System.out.println("通过另外一种for循环遍历差值："+(after-before));
        System.out.println("-------------------------------------");
    }
    //  通过pollFirst()来遍历LinkedList
    public static void cycleByPollFirst(LinkedList<Integer> linkedList){
        long before = System.currentTimeMillis();
        System.out.println("通过pollFirst()来遍历之前系统毫秒值："+before);
        while (linkedList.pollFirst()!=null){
//            System.out.print(linkedList.pollFirst()+";");
        }
        long after = System.currentTimeMillis();
        System.out.println("通过pollFirst()来遍历之后系统毫秒值："+after);
        System.out.println("通过pollFirst()来遍历差值："+(after-before));
        System.out.println("-------------------------------------");
    }
    //  通过pollLast()来遍历LinkedList
    public static void cycleByPollLast(LinkedList<Integer> linkedList){
        long before = System.currentTimeMillis();
        System.out.println("通过pollLast()来遍历LinkedList之前系统毫秒值："+before);
        while (linkedList.pollLast()!=null){
//            System.out.print(linkedList.pollLast()+";");
        }
        long after = System.currentTimeMillis();
        System.out.println("通过pollLast()来遍历LinkedList之后系统毫秒值："+after);
        System.out.println("通过pollLast()来遍历差值："+(after-before));
        System.out.println("-------------------------------------");
    }
    //  通过removeFirst()来遍历LinkedList
    public static void cycleByRemoveFirst(LinkedList<Integer> linkedList)throws NoSuchElementException{
        long before = System.currentTimeMillis();
        System.out.println("size："+linkedList.size());
        System.out.println("linkedList.removeFirst()："+linkedList.removeFirst());
        try {
            while (linkedList.removeFirst()!=null){
//                System.out.print(linkedList.removeFirst()+"============================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long after = System.currentTimeMillis();
        System.out.println("通过removeFirst()来遍历之后系统毫秒值："+after);
        System.out.println("通过removeFirst()来遍历差值："+(after-before));
        System.out.println("-------------------------------------");
    }
    //  通过removeLast()来遍历LinkedList
    public static void cycleByRemoveLast(LinkedList<Integer> linkedList)throws NoSuchElementException{
        long before = System.currentTimeMillis();
        System.out.println("通过removeLast()来遍历之前系统毫秒值："+before);
        try {
            while (linkedList.removeFirst()!=null){
//                System.out.print(linkedList.removeFirst()+";");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        long after = System.currentTimeMillis();
        System.out.println("通过removeLast()来遍历之后系统毫秒值："+after);
        System.out.println("通过removeLast()来遍历差值："+(after-before));
        System.out.println("-------------------------------------");
    }
}
