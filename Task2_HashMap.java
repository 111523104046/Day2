
import java.util.*;

public class Task2_HashMap {

    public static void main(String args[]) {

        // Parcel tracking number and scanned hubs
        HashMap<String, HashSet<String>> parcelMap =
                new HashMap<>();

        // Sample parcel scans
        String tracking[] = {
            "P101", "P102", "P103",
            "P101", "P102", "P104"
        };

        String hub[] = {
            "Chennai", "Coimbatore", "Trichy",
            "Chennai", "Madurai", "Salem"
        };

        System.out.println("PARCEL TRACKING SYSTEM");

        for (int i = 0; i < tracking.length; i++) {

            String parcel = tracking[i];
            String hubName = hub[i];

            // Create a set if parcel is new
            parcelMap.putIfAbsent(
                parcel, new HashSet<>());

            HashSet<String> scannedHubs =
                parcelMap.get(parcel);

            // Check whether parcel was scanned at same hub
            if (scannedHubs.contains(hubName)) {

                System.out.println(
                    "Duplicate Scan: " + parcel +
                    " at " + hubName);
            }
            else {

                scannedHubs.add(hubName);

                System.out.println(
                    parcel + " scanned at " + hubName);
            }
        }

        // Display complete parcel lookup
        System.out.println("\nPARCEL LOOKUP");

        for (String parcel : parcelMap.keySet()) {

            System.out.println(
                parcel + " : " + parcelMap.get(parcel));
        }
    }
}
