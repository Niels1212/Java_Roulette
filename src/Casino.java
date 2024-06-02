import java.io.*;
import java.util.Scanner;

public class Casino {
    private static double houseEarnings = 0.0;
    private static final String EARNINGS_FILE = "house_earnings.txt";

    public static void collectHouseEarnings(double amount) {
        houseEarnings += amount;
    }

    public static void adjustHouseEarnings(double amount) {
        houseEarnings += amount; // This can be negative, indicating a payout
    }

    public static double getHouseEarnings() {
        return houseEarnings;
    }

    public static void saveHouseEarnings() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EARNINGS_FILE))) {
            writer.write(String.valueOf(houseEarnings));
        } catch (IOException e) {
            System.out.println("Error saving house earnings: " + e.getMessage());
        }
    }

    public static void loadHouseEarnings() {
        File file = new File(EARNINGS_FILE);
        if (file.exists()) {
            try (Scanner scanner = new Scanner(file)) {
                if (scanner.hasNextDouble()) {
                    houseEarnings = scanner.nextDouble();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error loading house earnings: " + e.getMessage());
            }
        } else {
            houseEarnings = 1000.0;
            System.out.println("No previous data found for house earnings, starting at $" + houseEarnings);

        }
    }

    public static String displayHouseEarnings() {
        return "Current House Earnings: " + houseEarnings;
    }
}
