import java.util.*;

public class WarehouseSelection {

    /**
     * Selects k warehouses from a given set of cities such that the maximum distance
     * of any city to its nearest warehouse is minimized, using a greedy algorithm.
     *
     * @param n          The number of cities.
     * @param distances  A 2D array representing the distances between each pair of cities.
     * @param k          The number of warehouses to select.
     */
    static void selectKWarehouses(int n, int[][] distances, int k) {
        // List to store the chosen warehouses
        ArrayList<Integer> warehouses = new ArrayList<>();

        // Select the first warehouse arbitrarily
        warehouses.add(0);

        // Keep adding warehouses until we reach k
        while (warehouses.size() < k) {
            int maxDistance = Integer.MIN_VALUE;
            int cityToAdd = -1;

            // Find the city with the maximum distance to the nearest warehouse
            for (int i = 0; i < n; i++) {
                if (!warehouses.contains(i)) {
                    int minDistance = Integer.MAX_VALUE;
                    for (int warehouse : warehouses) {
                        minDistance = Math.min(minDistance, distances[i][warehouse]);
                    }
                    if (minDistance > maxDistance) {
                        maxDistance = minDistance;
                        cityToAdd = i;
                    }
                }
            }

            // Add the selected city as a warehouse
            warehouses.add(cityToAdd);
        }

        // Print the chosen warehouses
        System.out.println("Chosen warehouses: ");
        for (int warehouse : warehouses) {
            System.out.print(warehouse + " ");
        }
        System.out.println();
    }

    /**
     * Driver code to test the selectKWarehouses function.
     */
    public static void main(String[] args) {
        int n = 4;
        int[][] distances = {
            {0, 4, 8, 5},
            {4, 0, 10, 7},
            {8, 10, 0, 9},
            {5, 7, 9, 0}
        };
        int k = 2;

        // Function Call
        selectKWarehouses(n, distances, k);
    }
}
