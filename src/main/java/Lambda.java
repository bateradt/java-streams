import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda {

    public static void main(String[] args) {
        //imperative style
        Game football = new Game() {
            @Override
            public void play() {
                System.out.println("Football");
            }
        };

        football.play();

        Game voleyball = new Game() {
            @Override
            public void play() {
                System.out.println("Voleyball");
            }
        };

        voleyball.play();

        //functional style using lambda
        Game footballLambda = () -> System.out.println("Football with lambda");

        footballLambda.play();

        Game tennisLambda = () -> System.out.println("tennis with lambda");

        tennisLambda.play();

        Series gotSeries = (type) -> System.out.println("The serie " + type + " with lambda");
        gotSeries.play("Teste");

        List<String> players = Arrays.asList("Ronaldo", "Ronaldinho", "Cristiano Ronaldo", "Neymar", "Alex", "Romário", "Bebeto", "Rivaldo");

        for (String player : players) {
            if (player.equals("Cristiano Ronaldo")) {
                System.out.println("Melhor do mundo");
            }
        };

        players.stream()
                .filter(player -> player.equals("Cristiano Ronaldo"))
                .forEach(player -> System.out.println("The GOAT"));

        Optional<String> playersOptional = players.stream()
                .filter(player -> player.equals("Cristiano Ronaldo"))
                .findFirst();

        if (playersOptional.isPresent()) {
            System.out.println("The GOAT is present");
        }

    }

    interface Game {
        void play();
    }

    interface Series {
        void play(String type);
    }
}
