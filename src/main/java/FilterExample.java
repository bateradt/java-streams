import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class FilterExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Peter", "Marcelo", "Katia", "Leandra", "José Pedro");

        System.out.println("Imperative style: ");
        //método tradicional de percorrer uma lista em um array
        for (String name: names) {
            if (!name.equals("Peter")) {
                System.out.println(name);
            }
        }

        System.out.println("Functional style: ");

        names.stream().filter(FilterExample::isNotPeter).forEach(System.out::println);
    }

    private static boolean isNotPeter(String name) {
        return !name.equals("Peter");

    }

}
