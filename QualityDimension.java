import java.util.ArrayList;

public class QualityDimension {
    private String name;
    private String isoCode;
    private double weight;
    private ArrayList<Criterion> criteriaList;

    public QualityDimension(String name, String isoCode, double weight) {
        this.name = name;
        this.isoCode = isoCode;
        this.weight = weight;
        this.criteriaList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public double getWeight() {
        return weight;
    }

    public ArrayList<Criterion> getCriteriaList() {
        return criteriaList;
    }

    public void addCriterion(Criterion criterion) {
        criteriaList.add(criterion);
    }

    public double calculateDimensionScore() {
        if (criteriaList.isEmpty()) {
            return 0.0;
        }

        double weightedSum = 0.0;
        double totalWeight = 0.0;

        for (Criterion c : criteriaList) {
            weightedSum += c.calculateScore() * c.getWeight();
            totalWeight += c.getWeight();
        }

        if (totalWeight == 0) {
            return 0.0;
        }

        double score = weightedSum / totalWeight;
        return Math.round(score * 10.0) / 10.0;
    }

    public String getQualityLabel() {
        double score = calculateDimensionScore();

        if (score >= 4.5) {
            return "Excellent Quality";
        } else if (score >= 3.5) {
            return "Good Quality";
        } else if (score >= 2.5) {
            return "Needs Improvement";
        } else {
            return "Poor Quality";
        }
    }

    public double getQualityGap() {
        return Math.round((5.0 - calculateDimensionScore()) * 10.0) / 10.0;
    }

    @Override
    public String toString() {
        return String.format("%s [%s] (Weight: %.0f)", name, isoCode, weight);
    }
}