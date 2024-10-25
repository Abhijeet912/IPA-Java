//Time taken to solve :37mins

import java.util.*;

class Codechef {
    public static void main(String[] args) {
        AutoCar[] cars = new AutoCar[4];
        Scanner sc = new Scanner(System.in);
        
        // Input for each car
        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt(); sc.nextLine();
            String brand = sc.nextLine();
            int noOfTestsConducted = sc.nextInt(); sc.nextLine();
            int testPassed = sc.nextInt(); sc.nextLine();
            String environment = sc.nextLine();
            cars[i] = new AutoCar(id, brand, noOfTestsConducted, testPassed, environment);
        }
        
        // Input environment and brand
        String givenEnv = sc.nextLine();
        String givenBrand = sc.nextLine();
        
        int sum = findTestPassedByEnv(cars, givenEnv);
        if (sum == 0) {
            System.out.println("No car for given env");
        } else {
            System.out.println(sum);
        }
        
        ArrayList<AutoCar> list = updateCarGrade(cars, givenBrand);
        if (list.size() == 0) {
            System.out.println("There are no tests passed");
        } else {
            for (AutoCar car : list) {
                System.out.println(car.getBrand() + "::" + car.getGrade());
            }
        }
        sc.close();
    }
    
    public static int findTestPassedByEnv(AutoCar[] cars, String givenEnv) {
        int sum = 0;
        for (AutoCar car : cars) {
            if (givenEnv.equalsIgnoreCase(car.getEnv())) {
                sum += car.getTestPassed();
            }
        }
        return sum;
    }
    
    public static ArrayList<AutoCar> updateCarGrade(AutoCar[] cars, String givenBrand) {
        ArrayList<AutoCar> list = new ArrayList<>();
        for (AutoCar car : cars) {
            if (car.getBrand().equalsIgnoreCase(givenBrand)) {
                int rating = (car.getTestPassed() * 100) / car.getTestConducted();
                String grade = rating >= 80 ? "A1" : "B2";
                
                AutoCar carWithGrade = new AutoCar(car, grade);
                list.add(carWithGrade);
            }
        }
        return list;
    }
}

class AutoCar {
    int id;
    String brand;
    int testConducted;
    int testPassed;
    String environment;
    String grade;
    
    public AutoCar(int id, String brand, int testConducted, int testPassed, String environment) {
        this.id = id;
        this.brand = brand;
        this.testConducted = testConducted;
        this.testPassed = testPassed;
        this.environment = environment;
    }
    
    // Constructor to create a new AutoCar with a grade
    public AutoCar(AutoCar car, String grade) {
        this.id = car.id;
        this.brand = car.brand;
        this.testConducted = car.testConducted;
        this.testPassed = car.testPassed;
        this.environment = car.environment;
        this.grade = grade;
    }
    
    public String getEnv() {
        return this.environment;
    }
    
    public int getTestPassed() {
        return this.testPassed;
    }
    
    public int getTestConducted() {
        return this.testConducted;
    }
    
    public String getBrand() {
        return this.brand;
    }
    
    public String getGrade() {
        return this.grade;
    }
}
