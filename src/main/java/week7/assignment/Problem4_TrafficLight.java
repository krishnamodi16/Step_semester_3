package week7.assignment;

class TrafficLight {
    private String color;
    private final String lightId;

    public TrafficLight(String lightId) {
        this.lightId = lightId;
        this.color = "RED";
    }

    public void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }

    public String getLightId() {
        return lightId;
    }
}

public class Problem4_TrafficLight {
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight("TL-9");
        System.out.println(light.getLightId() + ": " + light.getColor());
        light.next();
        System.out.println(light.getColor());
        light.next();
        System.out.println(light.getColor());
        light.next();
        System.out.println(light.getColor());
    }
}
