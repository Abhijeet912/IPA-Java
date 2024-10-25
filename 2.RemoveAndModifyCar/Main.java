/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

***************************************************************************/
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Car[] cars=new Car[4];
        for(int i=0;i<4;i++){
            int id=sc.nextInt(); sc.nextLine();
            String name=sc.nextLine();
            String fuelType=sc.nextLine();
            cars[i]=new Car(id,name,fuelType);
        }
        int givenId=sc.nextInt();
        
        ArrayList<Car> list=removeAndRearrange(cars,givenId);
        for(Car car:list){
            System.out.println(car.getId()+" : "+car.getName());
        }
    }
    public static ArrayList<Car> removeAndRearrange(Car[] cars,int givenId){
        ArrayList<Car> list=new ArrayList<>();
        for(Car car:cars){
            if(car.id==givenId){
                continue;
            }
            else{
                list.add(car);
            }
        }
        list.sort((c1,c2)->Integer.compare(c1.id,c2.id));
        for(int i=1;i<list.size();i++){
            Car prevCar=list.get(i-1);
            if((list.get(i).getId()-prevCar.getId())>1){
                list.get(i).setId(prevCar.getId()+1);
            }
        }
        return list;
    }
}

class Car{
    int id;
    String name;
    String fuelType;
    
    public Car(int id, String name, String fuelType){
        this.id=id;
        this.name=name;
        this.fuelType=fuelType;
    }
    public String getName(){
        return this.name;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int newId){
        this.id=newId;
    }
}
