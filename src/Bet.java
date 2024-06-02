import java.util.ArrayList;
import java.util.List;


public class Bet {

    private final List<BetType> betTypes = new ArrayList<>();
    private Player player;

    public Bet() {

    }

    public Bet(Builder builder) {
        this.betTypes.addAll(builder.betTypes);
        this.player = builder.player;
    }

    public static class Builder {
        private final List<BetType> betTypes = new ArrayList<>();
        private Player player;
        private double totalStake = 0;


        public Builder() {
        }

        public Builder player(Player player) {
            this.player = player;
            return this;
        }

        public Builder number(int number, double stake) {
            if (canPlaceBet(stake)) {
                betTypes.add(new BetType("number", number, stake, 35));
                totalStake += stake;
            } else {
                System.out.println("Insufficient funds to place Bet");
            }
            return this;
        }

        public Builder color(String color, double stake) {
            if (canPlaceBet(stake)) {
                betTypes.add(new BetType("color", color, stake, 1));
                totalStake += stake;
            } else {
                System.out.println("Insufficient funds to place Bet");
            }
            return this;
        }

        public Builder evenOdd(String evenOdd, double stake) {
            if (canPlaceBet(stake)) {
                betTypes.add(new BetType("evenOdd", evenOdd, stake, 1));
                totalStake += stake;
            } else {
                System.out.println("Insufficient funds to place Bet");
            }
            return this;
        }

        public Builder dozen(String dozen, double stake) {
            if (canPlaceBet(stake)) {
                betTypes.add(new BetType("dozen", dozen, stake, 2));
                totalStake += stake;
            } else {
                System.out.println("Insufficient funds to place Bet");
            }
            return this;
        }

        public Builder half(String half, double stake) {
            if (canPlaceBet(stake)) {
                betTypes.add(new BetType("half", half, stake, 1));
                totalStake += stake;
            } else {
                System.out.println("Insufficient funds to place Bet");
            }
            return this;
        }

        public Builder column(String column, double stake) {
            if (canPlaceBet(stake)) {
                betTypes.add(new BetType("column", column, stake, 2));
                totalStake += stake;
            } else {
                System.out.println("Insufficient funds to place Bet");
            }
            return this;
        }

        private boolean canPlaceBet(double stake) {
            return (player.getBalance() - totalStake >= stake);
        }


        public void build() {
            Bet newBet = new Bet(this);
            this.player.addBet(newBet);
        }
    }

    public static class BetType {
        String type;
        Object value;
        double stake;
        double payoutMultiplier;
        Boolean won = null;

        public BetType(String type, Object value, double stake, double payoutMultiplier) {
            this.type = type;
            this.value = value;
            this.stake = stake;
            this.payoutMultiplier = payoutMultiplier;
        }

        public Boolean getWon() {
            return won;
        }

        public void setWon(Boolean won) {
            this.won = won;
        }

        @Override
        public String toString() {
            return type + " " + value + " $" + stake;
        }
    }

    public double evaluate(WheelResult result) {
        double totalPayout = 0;
        for (BetType betType : betTypes) {
            boolean resultMatch = match(result, betType);
            betType.setWon(resultMatch);
            if (resultMatch) {
                double payoutAmount = betType.stake * betType.payoutMultiplier;
                totalPayout += payoutAmount;
                Casino.adjustHouseEarnings(-payoutAmount);
            } else {
                totalPayout -= betType.stake;
                Casino.adjustHouseEarnings(betType.stake);
            }
        }
        return totalPayout;
    }


    public boolean match(WheelResult result, BetType betType){
        return switch (betType.type) {
            case "number" -> result.getNumber() == (int) betType.value;
            case "color" -> result.getColor().equals(betType.value);
            case "evenOdd" -> result.getEvenOdd().equals(betType.value);
            case "dozen" -> result.getDozen().equals(betType.value);
            case "half" -> result.getHalf().equals(betType.value);
            case "column" -> result.getColumn().equals(betType.value);
            default -> false;
        };
    }

    @Override
    public String toString() {
        StringBuilder betDetails = new StringBuilder();
        for (BetType betType : betTypes) {
            String result = betType.getWon() ? "Won!" : "Try again :/";
            betDetails.append(player.getName()).append("' bet: ")
                    .append(betType.type).append(" ")
                    .append(betType.value)
                    .append(" $").append(betType.stake)
                    .append(". Resultado: ")
                    .append(result)
                    .append("\n");

        }
        return betDetails.toString();
    }


}
