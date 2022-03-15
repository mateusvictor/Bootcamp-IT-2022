package pratica2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(18, getVehiclesList());

//        sortVehiclesByPrice(garage);
//        sortVehiclesByBrand(garage);
//        filterVehiclesByPrice1(garage);
//        filterVehiclesByPrice2(garage);
        vehiclesPriceAverage(garage);
    }

    public static void vehiclesPriceAverage(Garage garage){
        OptionalDouble average = garage.getVehicles().stream()
                .map(vehicle -> vehicle.getPrice())
                .mapToDouble(x -> x.doubleValue())
                .average();

        System.out.println(BigDecimal.valueOf(average.getAsDouble()));
    }

    public static void filterVehiclesByPrice2(Garage garage){
        garage.getVehicles().stream()
                .filter(vehicle -> vehicle.getPrice().compareTo(BigDecimal.valueOf(1000)) != -1)
                .forEach(System.out::println);
    }

    public static void filterVehiclesByPrice1(Garage garage){
        garage.getVehicles().stream()
                .filter(vehicle -> vehicle.getPrice().compareTo(BigDecimal.valueOf(1000)) != 1)
                .forEach(System.out::println);
    }

    public static void sortVehiclesByBrand(Garage garage){
        garage.getVehicles().stream()
                .sorted((x, y) -> x.getBrand().compareTo(y.getBrand()))
                .forEach(System.out::println);
    }

    public static void sortVehiclesByPrice(Garage garage){
        garage.getVehicles().stream()
                .sorted((x, y) -> x.getPrice().compareTo(y.getPrice()))
                .forEach(System.out::println);
    }

    public static ArrayList<Vehicle> getVehiclesList(){
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Fiesta", "Ford", BigDecimal.valueOf(1000)));
        vehicles.add(new Vehicle("Focus", "Ford", BigDecimal.valueOf(1200)));
        vehicles.add(new Vehicle("Explorer", "Ford", BigDecimal.valueOf(2500)));
        vehicles.add(new Vehicle("Uno", "Fiat", BigDecimal.valueOf(500)));
        vehicles.add(new Vehicle("Cronos", "Fiat", BigDecimal.valueOf(1000)));
        vehicles.add(new Vehicle("Torino", "Fiat", BigDecimal.valueOf(1250)));
        vehicles.add(new Vehicle("Aveo", "Chevrolet", BigDecimal.valueOf(1250)));
        vehicles.add(new Vehicle("Spin", "Chevrolet", BigDecimal.valueOf(2500)));
        vehicles.add(new Vehicle("Corola", "Toyota", BigDecimal.valueOf(1200)));
        vehicles.add(new Vehicle("Fortuner", "Toyota", BigDecimal.valueOf(3000)));
        vehicles.add(new Vehicle("Logan", "Renault", BigDecimal.valueOf(950)));
        return vehicles;
    }
}
