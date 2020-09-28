import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapperExample {

    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Peter", 20, Arrays.asList("1", "2")),
                new User("Marcelo", 33, Arrays.asList("3", "4", "5")),
                new User("Katia", 30, Arrays.asList("6", "7")),
                new User("Leandra", 10, Arrays.asList("8", "5")),
                new User("José Pedro", 2, Arrays.asList("10", "12")));

        System.out.println("Functional style: ");

        ///Busca todos os Phones dos usuário, percorre eles e depois usando FlatMap percorre novamente filtrando os users com o telefone igual a 5 e retorna um Optional, pois pode não vir vazia a lista
        Optional<String> stringOptional = users.stream()
                .map(user -> user.getPhones().stream())
                .flatMap(stringStream -> stringStream.filter(phone -> phone.equals("5")))
                .findAny();

       stringOptional.ifPresent(System.out::println); //se tiver alguma informação ela será printada na tela.

//        System.out.println("UserList: " + userList);
    }

    private static boolean isNotPeter(String name) {
        return !name.equals("Peter");

    }

    public static class User {
        private String name;
        private Integer age = 25;
        private List<String> phones;

        public User(String name) {
            this.name = name;
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public User(String name, Integer age, List<String> phones) {
            this.name = name;
            this.age = age;
            this.phones = phones;
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

        public List<String> getPhones() {
            return phones;
        }

        public void setPhones(List<String> phones) {
            this.phones = phones;
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
