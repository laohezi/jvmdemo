
import kotlin.collections.CollectionsKt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SychonizedDemo {

    public static void main(String[] args) {
        SychonizedDemo testJ = new SychonizedDemo();
        new Thread(() -> {
           while (true){
               testJ.list.add(1);
               System.out.println("add");
           }
        }).start();
        new Thread(() -> {
            while (true){
                testJ.sleep(300);
                synchronized (testJ.list){
                    System.out.println("foreach start--" + testJ.list.size());
                    CollectionsKt.firstOrNull(testJ.list, integer ->{
                        System.out.println(integer);
                        return true ;
                    } );
                    System.out.println("foreach end");
                }
            }
        }).start();
        new Thread(() -> {
            while (true){
                if (testJ.list.size()>0){
                    testJ.list.remove(0);
                    System.out.println("remove");
                }
            }
        }).start();


    }


    List<Integer> list = Collections.synchronizedList(new ArrayList<>());

    void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
