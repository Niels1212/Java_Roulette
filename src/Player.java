import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private double balance;
    private List<Bet> bets;


    public Player(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.bets = new ArrayList<>();
    }

    public Bet.Builder placeBet(){
        Bet.Builder builder = new Bet.Builder();
        builder.player(this);
        return builder;
    }


    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void depositFunds(double deposit) {
        balance += deposit;
    }

    public void addBet(Bet bet){
        this.bets.add(bet);
    }


    public void evaluateBets(WheelResult result){
        for(Bet bet : bets){
            double payout = bet.evaluate(result);
            this.balance += payout;
            System.out.println("Evaluating " + getName() + "'s bet: \n" + bet +
                    (payout > 0 ? ", Payout: " + payout : ", Loss: " + -payout));
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.name.replace(" ", "_") + "_data.txt"))) {
            writer.write(this.name + ", " + this.balance);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static Player loadPlayerState(String playerName) {
        File file = new File(playerName.replace(" ", "_") + "_data.txt");
        try (Scanner scanner = new Scanner(file)) {
            if (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String[] playerData = data.split(",");
                return new Player(playerData[0], Double.parseDouble(playerData[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found for " + playerName + ", starting with default balance.");
        }
        return new Player(playerName, 500); // Default balance if no file found
    }

}
