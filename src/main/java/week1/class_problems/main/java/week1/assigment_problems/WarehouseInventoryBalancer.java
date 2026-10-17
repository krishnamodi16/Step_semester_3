package week1.assigment_problems;

public class WarehouseInventoryBalancer {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Both sections must have equal array lengths.");
            return;
        }

        int totalA = 0, totalB = 0;
        int max = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > max) {
                max = sectionA[i];
                maxSection = "Section A";
                maxIndex = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > max) {
                max = sectionB[i];
                maxSection = "Section B";
                maxIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        System.out.println("Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status);
        if (maxIndex == -1) {
            System.out.println("No inventory items provided.");
        } else {
            System.out.println("Highest Quantity: " + max + " ("
                    + maxSection + ", Item " + maxIndex + ")");
        }
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }
}
