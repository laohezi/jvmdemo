import javax.swing.plaf.basic.BasicColorChooserUI;
import java.util.HashSet;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        Test test = new Test("liming");
        test.update(test);
        System.out.println(test.name);

    }

    Test(String name) {
        this.name = name;
    }


    String name = "";

    void update(Test test) {
       test.name = "xiaolei";
    }


    static class Parent {
        public Parent() {
            System.out.println("Parent");
        }

        public void say() {
        }
    }

    static class Child extends Parent {
        {
            System.out.println("代码块");
        }

        public Child(String name) {
            System.out.println();
        }

        public Child() {
            super();
            System.out.println("Child");
        }
    }
}
