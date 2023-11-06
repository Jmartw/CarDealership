package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private String address;
    private String phone;

    //Instantiate object

    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<Vehicle>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Dealership{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

      public List<Vehicle> getVehicleByPrice(double min,double max){
        List<Vehicle> SUVs=new ArrayList<Vehicle>();

        for(Vehicle s:inventory){
            if (s.getPrice() >= min && s.getPrice() <= max) {{
                SUVs.add(s);
            }
            }
        }

        return SUVs;
        }

        public List<Vehicle> getVehicleByMakeModel(String make, String model){
        List<Vehicle>Vroom = new ArrayList<>();
        for (Vehicle v: inventory) {
            if (v.getMake().equals(make) && v.getModel().equals(model) ) {
                Vroom.add(v);
            }

            }
        return Vroom;
        }
        public List<Vehicle> getVehicleByYear (int min, int max){
        List<Vehicle>Vroom = new ArrayList<>();
                for (Vehicle v:inventory) {
                    if (v.getYear() >=min && v.getYear() <=max) {
                  Vroom.add(v);
                    }
                }
            return Vroom;
        }
        public List<Vehicle> getVehicleByColor(String color){
            List<Vehicle>Vroom = new ArrayList<>();
            for (Vehicle v:inventory) {
                if (v.getColor().equals(color)) {
                    Vroom.add(v);
                }

                }
        return Vroom;
        }
        public List<Vehicle> getVehicleByMileage(int odemeter){
            List<Vehicle>Vroom = new ArrayList<>();
            for (Vehicle v:inventory) {
                if (v.getOdometer() <=odemeter) {
                    Vroom.add(v);
                }
            }

        return Vroom;
        }

    public  List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> Vroom = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (v.getVehicleType().equals(type)) {
                Vroom.add(v);
            }
        }
        return Vroom;
    }
        public List<Vehicle> getAllVehicles(){
        return this.inventory;

        }
        public void addVehicle(Vehicle vehicle){
        this.inventory.add(vehicle);
        }

        public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);

        }
}
