import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        HashMap<String, ArrayList<SWSystem>> allSystems = SWSystemData.getAllSystems();

        StringBuilder categoryOptions = new StringBuilder();
        for (String category : allSystems.keySet()) {
            if (categoryOptions.length() > 0) {
                categoryOptions.append(" / ");
            }
            categoryOptions.append(category);
        }

        System.out.print("Enter category (" + categoryOptions + "): ");
        String selectedCategory = input.nextLine();

        ArrayList<SWSystem> systems = allSystems.get(selectedCategory);

        if (systems == null || systems.isEmpty()) {
            System.out.println("Invalid category.");
            return;
        }

        StringBuilder systemOptions = new StringBuilder();
        for (int i = 0; i < systems.size(); i++) {
            if (systemOptions.length() > 0) {
                systemOptions.append(" / ");
            }
            systemOptions.append(i + 1).append(": ").append(systems.get(i).getSystemName());
        }

        System.out.print("Select system (" + systemOptions + "): ");
        int systemChoice = input.nextInt();

        if (systemChoice < 1 || systemChoice > systems.size()) {
            System.out.println("Invalid system selection.");
            return;
        }

        SWSystem selectedSystem = systems.get(systemChoice - 1);

        System.out.println("\nEnter measured values for " + selectedSystem.getSystemName());

        for (QualityDimension dimension : selectedSystem.getDimensions()) {

            System.out.println("\n" + dimension.getName() + " [" + dimension.getIsoCode() + "]");

            for (Criterion criterion : dimension.getCriteriaList()) {

                System.out.print(criterion.getName() + " ("
                        + criterion.getUnit() + ", range: "
                        + criterion.getMinValue() + " - "
                        + criterion.getMaxValue() + "): ");

                double value = input.nextDouble();
                criterion.setMeasuredValue(value);
            }
        }

        System.out.println();
        selectedSystem.printReport();

        input.close();
    }
}