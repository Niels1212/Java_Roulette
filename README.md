# 🎰 Roulette Game

Welcome to the Roulette Game! This guide will help you understand how to play the game step-by-step.

## **How to Play**

### 1. 🛠️**Clone the Project**:
- First, clone the project repository from the source provided.

### 2. 📝**Boilerplate Code in Main**:
- The `Main.java` file contains the main logic to run the game. Here's what the code looks like:

   ```java
   import java.util.Random;

   public class Main {
       public static void main(String[] args) {
           // 🎡 Creating roulette
           Wheel roulette = new Wheel();
           Random random = new Random();
           int number = random.nextInt(37);
           WheelResult result = roulette.spin(number);
           System.out.println(result);

           // 🧑‍🤝‍🧑 Creating Players
           Player player = Player.loadPlayerState("Example Player");

           // 💵 Deposit (Optional)
           // player.depositFunds(400);

           Casino.loadHouseEarnings();

           // 💸 Bets
           player.placeBet().color("red", 50).dozen("first", 50).build();
           System.out.println();

           // ✅ Evaluate
           player.evaluateBets(result);
           System.out.println();

           System.out.println(player.getName() + " balance: $" + player.getBalance());

           // 🏦 House earnings
           System.out.println();
           System.out.println(Casino.displayHouseEarnings());

           // 💾 Saving Player's Balance
           player.saveToFile();

           Casino.saveHouseEarnings();
       }
   }
   ```
### 3. 🧑‍🤝‍🧑**Creating Players**:
- You can create players by loading their state from a file. Replace variable `"player"` and `"Example Player"` with the desired player's name:
  ```java
  Player player = Player.loadPlayerState("Example Player");
  ```
- You can create multiple players by repeating this process with different names.

### 4. 💵**Deposit Funds (Optional)**:
- If you want to add funds to a player's balance, uncomment and modify the deposit line:
  ```java
  player.depositFunds(400);
  ```
- Replace `400` with the amount you want to deposit.
- Comment the line after making the deposit.

### 5. **💸 Placing Bets**:
- Players can place bets using the `placeBet()` method. For example, to place a bet on red and the first dozen:
  ```java
  player.placeBet().color("red", 50).dozen("first", 50).build();
  ```
- The above line places a $50 bet on red and another $50 bet on the first dozen.
- You can add more bet types by chaining additional methods like `number`, `evenOdd`, `half`, and `column`.
- ***Add `.build();` at the end of all your bets.***

### 6. **✅ Evaluating Bets**:
- The placed bets are evaluated against the spin result:
  ```java
  player.evaluateBets(result);
  ```
- This will update the player's balance based on the outcome of their bets.

### 7. **🏦 Displaying Player Balance**:
- The updated balance of the player is printed out:
  ```java
  System.out.println(player.getName() + " balance: $" + player.getBalance());
  ```

### 8. **🔄 Displaying House Earnings**:
- The current earnings of the house are displayed:
  ```java
  System.out.println(Casino.displayHouseEarnings());
  ```

### 9. **💾 Saving Player's Balance**:
- The player's balance is saved to a file to keep track of their state:
  ```java
  player.saveToFile();
  ```

### 10. **🔒 Saving House Earnings**:
- The house's earnings are also saved:
  ```java
  Casino.saveHouseEarnings();
  ```

### 11. **💾 Saving Player's Balance**:
- The player's balance is saved to a file to keep track of their state:
  ```java
  player.saveToFile();
  ```

### 12. **💾 Saving House Earnings**:
- The house's earnings are also saved:
  ```java
  Casino.saveHouseEarnings();
  ```

## Output
   ```plaintext
   WheelResult{number=21, color='red', evenOdd='odd', dozen='second', half='second', column='third'}
   No previous data found for Example Player, starting with default balance.
   
   Evaluating Example Player's bet: 
   Example Player' bet: color red $50.0. Resultado: Won!
   Example Player' bet: dozen first $50.0. Resultado: Try again :/
   , Loss: -0.0
   
   Example Player balance: $500.0
   
   Current House Earnings: 930.0
   ```
### Explanation

1. **Spin Result**:
    - The wheel spin resulted in the number 21, which is red, odd, in the second dozen, in the second half, and in the third column.
    - `WheelResult{number=21, color='red', evenOdd='odd', dozen='second', half='second', column='third'}`

2. **Player Initialization**:
    - Since no previous data was found for "Example Player," a new player is created with the default balance of $500.
    - `No previous data found for Example Player, starting with default balance.`

3. **Evaluating Bets**:
    - The player's bets are evaluated against the spin result:
        - The bet on color red for $50 won.
        - The bet on the first dozen for $50 lost.
    - `Evaluating Example Player's bet:`
        - `Example Player's bet: color red $50.0. Resultado: Won!`
        - `Example Player's bet: dozen first $50.0. Resultado: Try again :/`
    - Since the total payout and loss balance out, the player's balance remains unchanged.
    - `, Loss: -0.0`

4. **Player Balance**:
    - The player's balance remains $500 after evaluating the bets.
    - `Example Player balance: $500.0`

5. **House Earnings**:
    - The current earnings of the house are $930.
    - `Current House Earnings: 930.0`
## Summary

- **🎡 Create and Spin Roulette**: Automatically handled by the program.
- **🧑‍🤝‍🧑 Create Players**: Load players by name.
- **💵 Deposit Funds**: Optional step to add funds to a player's balance.
- **💸 Place Bets**: Specify the type and amount of bets.
- **✅ Evaluate Bets**: Determine winnings or losses based on the spin result.
- **🏦 Display Balances and Earnings**: Show updated balances for players and the casino.
- **💾 Save States**: Save the current state of players and the house for future reference.

Enjoy playing the Roulette Game! 🎉