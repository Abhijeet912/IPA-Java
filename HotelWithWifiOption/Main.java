import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel[] hotels = new Hotel[4];
        
        // Input hotel details
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            String name = sc.nextLine();
            String dob = sc.nextLine();
            int rooms = sc.nextInt();
            sc.nextLine(); // consume newline
            String wifi = sc.nextLine();
            double totalBill = sc.nextDouble();
            sc.nextLine(); // consume newline
            hotels[i] = new Hotel(id, name, dob, rooms, wifi, totalBill);
        }
        
        String givenMonth = sc.nextLine();
        String givenWifi = sc.nextLine();
        
        // First function call
        int count = noOfRoomsBookedInGivenMonth(hotels, givenMonth);
        if (count == 0) {
            System.out.println("No rooms booked in the given month");
        } else {
            System.out.println(count);
        }
        
        // Second function call
        ArrayList<Hotel> list = searchHotelByWifiOption(hotels, givenWifi);
        if (list.size() < 2) {
            System.out.println("No such option available");
        } else {
            System.out.println(list.get(1).getId());
        }
    }

    public static int noOfRoomsBookedInGivenMonth(Hotel[] hotels, String givenMonth) {
        int countRooms = 0;
        for (Hotel hotel : hotels) {
            if (hotel.getMonth().equalsIgnoreCase(givenMonth)) {
                countRooms += hotel.getNoOfRooms();
            }
        }
        return countRooms;
    }

    public static ArrayList<Hotel> searchHotelByWifiOption(Hotel[] hotels, String givenWifi) {
        ArrayList<Hotel> list = new ArrayList<>();
        for (Hotel hotel : hotels) {
            if (hotel.getWifi().equalsIgnoreCase(givenWifi)) {
                list.add(hotel);
            }
        }
        list.sort((h1, h2) -> Double.compare(h2.totalBill, h1.totalBill));
        return list;
    }
}

class Hotel {
    private int id;
    private String name;
    private String dob;
    private int noOfRooms;
    private String wifi;
    double totalBill;

    // Constructor
    public Hotel(int id, String name, String dob, int noOfRooms, String wifi, double totalBill) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.noOfRooms = noOfRooms;
        this.wifi = wifi;
        this.totalBill = totalBill;
    }

    // Getter methods
    public int getId() {
        return this.id;
    }

    public String getMonth() {
        return this.dob.substring(3, 6);
    }

    public int getNoOfRooms() {
        return this.noOfRooms;
    }

    public String getWifi() {
        return this.wifi;
    }
}
