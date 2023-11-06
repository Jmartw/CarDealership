package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public void Display() {

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
                case "5":
                    processGetByMileageRequest();
                    break;
                case "6":
                    processGetByVehicleTypeRequest();
                    break;
                case "7":
                    processGetAllVehicleRequest();
                    break;
                case "8":
                    processAddVehicleRequest();
                    break;
                case "9":
                    processRemoveVehicleRequest();
                    break;
                case "0":
                    running = false;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        }
        scanner.close();

    }

    private void displayVehicle(List<Vehicle> listOfVehicles) {
        if (listOfVehicles.isEmpty()) {
            System.out.println("No vehicles found. ");
        }
        for (Vehicle vehicle : listOfVehicles) {
            System.out.println(vehicle);
        }
    }

    private void init() {
        DealershipFileManager fileManager = new DealershipFileManager();
        dealership = fileManager.getDealership();
    }

    public void processGetByPriceRequest() {
        System.out.print("Enter the minimum price: ");
        double minPrice = scanner.nextDouble();
        System.out.print("Enter the maximum price: ");
        double maxPrice = scanner.nextDouble();
        List<Vehicle> vehicles = dealership.getVehicleByPrice(minPrice, maxPrice);
        displayVehicle(vehicles);
    }


    public void processGetByMakeModelRequest() {
        System.out.println("Enter the make: ");
        String make = scanner.nextLine();
        System.out.println("Enter the model: ");
        String model = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByMakeModel(make, model);
        displayVehicle(vehicles);
    }
    //call the display vehicle method

    public void processGetByYearRequest() {
        System.out.print("Enter the minimum year: ");
        int minYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the maximum year: ");
        int maxYear = scanner.nextInt();
        scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByYear(minYear, maxYear);
        displayVehicle(vehicles);
    }


    public void processGetByColorRequest() {
        System.out.println("Enter the color: ");
        String color = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehicleByColor(color);
        displayVehicle(vehicles);
    }

    public void processGetByMileageRequest() {
        System.out.print("Enter the maximum mileage: ");
        int maxMileage = scanner.nextInt();
        List<Vehicle> vehicles = dealership.getVehicleByMileage(maxMileage);
        displayVehicle(vehicles);
    }

    public void processGetByVehicleTypeRequest() {
        System.out.print("Enter the vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine();
        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicle(vehicles);
    }

    public void processGetAllVehicleRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        displayVehicle(allVehicles);

        //Add/remove vehicles within this method

    }

    public void processAddVehicleRequest() {
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Make: ");
        String make = scanner.nextLine();
        System.out.print("Enter Model: ");
        String model = scanner.nextLine();
        System.out.print("Enter Vehicle Type: ");
        String vehicleType = scanner.nextLine();
        System.out.print("Enter Color: ");
        String color = scanner.nextLine();
        System.out.print("Enter Odometer: ");
        int odometer = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        System.out.println("Vehicle added successfully!");
    }


    public void processRemoveVehicleRequest() {
            List<Vehicle> allVehicles = dealership.getAllVehicles();
        System.out.println("Enter VIN: ");
        int VIN = scanner.nextInt();
        scanner.nextLine();

        //remove vehicles from list
        boolean removed = false;
        for (Vehicle vehicle : dealership.getAllVehicles()) {

            if (vehicle.getVin() == VIN) {
                System.out.println("Vehicle removed successfully. ");
            } else {
                System.out.println("Vehicle not found or could not be removed successfully. ");

            }
        }
    }
}
