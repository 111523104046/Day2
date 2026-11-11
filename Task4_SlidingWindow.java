
public class Task4_SlidingWindow {

    public static void main(String args[]) {

        // Parcel counts for 8 hours
        int parcels[] = {
            12, 15, 10, 20, 25, 18, 30, 22
        };

        int k = 4;

        // Calculate first window sum
        int sum = 0;

        for (int i = 0; i < k; i++) {

            sum += parcels[i];
        }

        int maxSum = sum;

        int startIndex = 0;

        // Sliding Window
        for (int i = k; i < parcels.length; i++) {

            sum = sum + parcels[i] - parcels[i - k];

            if (sum > maxSum) {

                maxSum = sum;

                startIndex = i - k + 1;
            }
        }

        double average = (double) maxSum / k;

        System.out.println("SLIDING WINDOW");

        System.out.println("Window Size: " + k);

        System.out.println(
            "Maximum Parcel Count: " + maxSum);

        System.out.println(
            "Starting Hour: " + (startIndex + 1));

        System.out.println(
            "Ending Hour: " + (startIndex + k));

        System.out.println(
            "Highest Average: " + average);
    }
}
