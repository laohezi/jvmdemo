
import kotlin.collections.CollectionsKt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SychonizedDemo {

    public static void main(String[] args) {
        SychonizedDemo sychonizedDemo = new SychonizedDemo();
        new Thread(()->{
            sychonizedDemo.methodA();
        }).start();

        new Thread(()->{
            sychonizedDemo.methodB();
        }).start();

        new Thread(()->{
            sychonizedDemo.methodC();
        }).start();


    }

    void methodA()  {
        for (int i=0;i<100;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("methodA is running");
        }
    }

     void methodB(){
        synchronized (this){
            for (int i=0;i<100;i++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("methodB is running");
            }
        }

    }

    synchronized void methodC(){
        for (int i=0;i<100;i++){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("methodC is running");
        }
    }

}
