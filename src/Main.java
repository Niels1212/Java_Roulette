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
        Player juan = Player.loadPlayerState("Juan Perez");
        Player marce = Player.loadPlayerState("Marcelo Perez");
        Player fernando = Player.loadPlayerState("Fernando Marin");
        System.out.println();

        //Deposit (Optional)
        //juan.depositFunds(200);

        Casino.loadHouseEarnings();
        System.out.println();

        //Bets
        juan.placeBet().color("red", 20).number(5,30).build();
        marce.placeBet().column("third", 20).build();
        fernando.placeBet().dozen("first", 50).number(33, 5).build();

        //Evaluate
        juan.evaluateBets(result);
        marce.evaluateBets(result);
        fernando.evaluateBets(result);

        System.out.println();
        System.out.println(juan.getName() + " balance: $" + juan.getBalance());
        System.out.println(marce.getName() + " balance: $" + marce.getBalance());
        System.out.println(fernando.getName() + " balance: $" + fernando.getBalance());

        //House earnings
        System.out.println();
        System.out.println(Casino.displayHouseEarnings());

        //Saving Player's Balance
        juan.saveToFile();
        marce.saveToFile();
        fernando.saveToFile();

        Casino.saveHouseEarnings();


    }
}