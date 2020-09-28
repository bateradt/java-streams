import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapperExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Peter", "Marcelo", "Katia", "Leandra", "José Pedro");

        System.out.println("Imperative style: ");
        //método tradicional de percorrer uma lista em um array
        for (String name: names) {
            if (!name.equals("Peter")) {
                User user = new User(name, 30);
                System.out.println(user);
            }
        }

        System.out.println("Functional style: ");

        names.stream()
                .filter(MapperExample::isNotPeter)
                .map(User::new) //quando o construtor da classe tem 1 parâmetro da pra usar desta forma
                .forEach(System.out::println);

        List<User> userList = names.stream()
                .filter(MapperExample::isNotPeter)
                .map(User::new)
                .collect(Collectors.toList());

        System.out.println("UserList: " + userList);
    }

    private static boolean isNotPeter(String name) {
        return !name.equals("Peter");

    }

    public static class User {
        private String name;
        private Integer age = 25;

        public User(String name) {
            this.name = name;
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
