public class Wheel {

    public Wheel() {
    }

    public WheelResult spin(int number){
        return new WheelResult(number, color(number),
                evenOdd(number), half(number), dozen(number), column(number));
    }
    private String color(int number){
        if((number>0 && number<=10) || (number>18 && number<=28)){
            if(number%2==0){
                return "black";
            }else{ return "red";}
        }

        if((number>10 && number<=18) || (number>28 && number<=36)){
            if(number%2==0){
                return "red";
            }else{ return "black";}
        }else{return "none";}
    }

    private String evenOdd(int number){
        if(number==0){
            return "none";
        }
        if(number%2==0){
            return "even";
        }else{
            return "odd";
        }
    }

    private String half(int number){
        if(number>0 && number<=18){
            return "first";
        }else if(number>18 && number<=36){
            return"second";
        }else{
            return "none";
        }
    }

    private String column(int number) {
        if (number == 0) {
            return "none";
        }

        return switch ((number - 1) % 3) {
            case 0 -> "first";
            case 1 -> "second";
            case 2 -> "third";
            default -> "none";  // It's impossible to get here but required by syntax.
        };
    }
    private String dozen(int number){
        if(number>0 && number<=12){
            return "first";
        }else if(number>12 && number<=24){
            return "second";
        }else if(number>24 && number<=36){
            return "third";
        }else{ return "none";}
    }

}
