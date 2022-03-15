package pratica2;

import java.util.ArrayList;

public class Garage {
    private int id;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public Garage(int id, ArrayList<Vehicle> vehicles) {
        this.id = id;
        this.vehicles = vehicles;
    }

    public Garage(int id) {
        this.id = id;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public int getId() {
        return id;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

}
