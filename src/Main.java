import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Creating roulette
        Wheel roulette = new Wheel();
        Random random = new Random();
        int number = random.nextInt(37);
        WheelResult result = roulette.spin(number);
        System.out.println(result);

        //Creating Players
        Player player = Player.loadPlayerState("Example Player");

        //Deposit (Optional)
//        player.depositFunds(400);

        Casino.loadHouseEarnings();

        //Bets
        player.placeBet().color("red", 50).dozen("first", 50).build();
        System.out.println();

        //Evaluate
        player.evaluateBets(result);
        System.out.println();

        System.out.println(player.getName() + " balance: $" + player.getBalance());

        //House earnings
        System.out.println();
        System.out.println(Casino.displayHouseEarnings());

        //Saving Player's Balance
        player.saveToFile();

        Casino.saveHouseEarnings();

    }
}