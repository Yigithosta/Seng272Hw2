public class Criterion {
    private String name;
    private double weight;
    private String direction;
    private double minValue;
    private double maxValue;
    private String unit;
    private double measuredValue;

    public Criterion(String name, double weight, String direction,
                     double minValue, double maxValue, String unit) {
        this.name = name;
        this.weight = weight;
        this.direction = direction;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unit = unit;
        this.measuredValue = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public String getDirection() {
        return direction;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public String getUnit() {
        return unit;
    }

    public double getMeasuredValue() {
        return measuredValue;
    }

    public void setMeasuredValue(double measuredValue) {
        this.measuredValue = measuredValue;
    }

    public double calculateScore() {
        double score;

        if (maxValue == minValue) {
            score = 1.0;
        } else if (direction.equalsIgnoreCase("higher")) {
            score = 1 + ((measuredValue - minValue) / (maxValue - minValue)) * 4.0;
        } else {
            score = 5 - ((measuredValue - minValue) / (maxValue - minValue)) * 4.0;
        }

        if (score < 1.0) score = 1.0;
        if (score > 5.0) score = 5.0;

        score = Math.round(score * 2.0) / 2.0;

        return score;
    }

    @Override
    public String toString() {
        String betterText = direction.equalsIgnoreCase("higher")
                ? "Higher is better"
                : "Lower is better";

        return String.format("%s: %.1f %s -> Score: %.1f (%s)",
                name, measuredValue, unit, calculateScore(), betterText);
    }
}