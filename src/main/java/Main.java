import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Referee r = new Referee(
                    new Playboard(),
                    new HumanPlayer("Gandalf", sc),
                    new BotPlayer("Dumbledore"));

            r.start();
    }

}
