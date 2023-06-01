import javax.xml.catalog.CatalogFeatures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBockQueue<T> {

    private List<T> queue;
    private int head;
    private int tail;

    private int capacity;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public MyBockQueue(int capacity){
        queue = new ArrayList<>();
        this.capacity=capacity;
    }

    public void put(T t) throws InterruptedException {
        lock.lock();
        while (queue.size() == capacity) {
            notFull.await();
        }
        
        queue.add(queue.size(), t);
        notEmpty.signal();
        System.out.println("put" + t + " " + queue.size());
        lock.unlock();
    }

    public T take() throws InterruptedException {
        lock.lock();
        while (queue.size() == 0) {
            notEmpty.await();
        }
        T t = queue.get(0);
        queue.remove(0);
        notFull.signal();
        System.out.println("take" + t + " " + queue.size());
        lock.unlock();
        return t;
    }

    public static void main(String[] args) {
        MyBockQueue<Integer> myBockQueue = new MyBockQueue<>(10);
        new Thread(()->{
            for (int i=0;i<100;i++){
                try {
                    myBockQueue.put(i);
                   // System.out.println("put" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       /* new Thread(()->{
            for (int i=100;i<1100;i++){
                try {
                    myBockQueue.put(i);
                   // System.out.println("put" +i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });*/

        new Thread(()->{
            for (int i=0;i<100;i++){
                try {
                    myBockQueue.take();
                    System.out.println("take position" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
