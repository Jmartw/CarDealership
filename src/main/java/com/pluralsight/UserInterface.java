package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public UserInterface() {

    }
 public void Display(){
     Scanner scanner = new Scanner(System.in);
     boolean running = true;

     while (running) {
         System.out.println("Main menu. Please select an option: ");
         System.out.println("1)Find vehicles within a price range ");
         System.out.println("2) Find vehicles by your make/model ");
         System.out.println("3) Find vehicle by year range");
         System.out.println("4) Find vehicle by color ");
         System.out.println("5) Find vehicle by mileage range");
         System.out.println("6) Find vehicle type (car, truck, SUV, van) ");
         System.out.println("7) List ALL vehicles: ");
         System.out.println("8) Add a vehicle ");
         System.out.println("9) Remove a vehicle ");
         System.out.println("99) Quit");

         String input = scanner.nextLine().trim();

         switch (input.toUpperCase()) {
             case "1":
                 processGetByPriceRequest();
                 break;
             case "2":
                 processGetByMakeModelRequest();
                 break;
             case "3":
                 processGetByYearRequest();
                 break;
             case "4":
                 processGetByColorRequest();
                 break;
             case "5"
                processGetByMilageRequest();
             break;
             case "6"
                 processGetByVehicleTypeRequest();
             break;
             case "7"
                 processGetAllVehicleRequest();
             break;
             case "8"
                 processAddVehicleRequest();
             break;
             case "9"
                 processRemoveVehicleRequest();
             break;
             case "0"
                 running = false;
             default:
                 System.out.println("Invalid option");
                 break;
         }
     }


 }
 private void displayVehicle (List<Vehicle> listOfVehicles){
        if (listOfVehicles.isEmpty()){
            System.out.println("No vehicles found. ");
        }
        for (Vehicle vehicle: listOfVehicles){
            System.out.println(vehicle);
 }
private void init(){
            DealershipFileManager fileManager = new DealershipFileManager();
            dealership = fileManager.getDealership();
     }
        public void processGetByPrice(){
            List<Vehicle> vehiclesByPrice =
            displayVehicle(());

     }
        public void processByMakeModeRequest(){

     }
        public void processGetByYearRequest(){

     }
        public void processGetbyColorRequest(){

     }
        public void processGetByMileageRequest(){

     }
        public void processGetByVehicleTypeRequest(){

     }
        public void processGetBy
}

