package generics;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Wild {

    public static void main(String[] args) throws FileNotFoundException {
        List< ? super Number> list = new ArrayList<>();
        list.add(3);
        list.add(3f);
        list.addAll(new ArrayList<Integer>());
        list.get(0);

        List<? extends Number> list1 = new ArrayList<Integer>();





    }

    public  static  void add(List<? extends Number> list){
        List<Number> list1 = new ArrayList<>();

    }
}
