public class WheelResult {
    private final int number;
    private final String color;
    private final String evenOdd;
    private final String dozen;
    private final String half;
    private final String column;

    public WheelResult(int number, String color, String evenOdd, String dozen, String half, String column) {
        this.number = number;
        this.color = color;
        this.evenOdd = evenOdd;
        this.dozen = dozen;
        this.half = half;
        this.column = column;
    }

    public int getNumber() {
        return number;
    }

    public String getColor() {
        return color;
    }

    public String getEvenOdd() {
        return evenOdd;
    }

    public String getDozen() {
        return dozen;
    }

    public String getHalf() {
        return half;
    }

    public String getColumn() {
        return column;
    }

    @Override
    public String toString() {
        return "WheelResult{" +
                "number=" + number +
                ", color='" + color + '\'' +
                ", evenOdd='" + evenOdd + '\'' +
                ", dozen='" + dozen + '\'' +
                ", half='" + half + '\'' +
                ", column='" + column + '\'' +
                '}';
    }
}
