import javax.swing.plaf.basic.BasicColorChooserUI;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Parent p = new Child("jj");
        p.say();
        p.say();

        Set<Integer> set = new HashSet<>();
        Integer[] array = set.toArray(new Integer[0]);
    }



   static class  Parent{
        public Parent() {
            System.out.println("Parent");
        }
        public void say(){}
    }

    static class Child extends Parent{
        {
            System.out.println("代码块");
        }
        public Child(String name){
            System.out.println();
        }
        public Child() {
            super();
            System.out.println("Child");
        }
    }
}
