package carrentalsystem;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Car {
    private int id;
    private int brand;
    private String model;
    private String fuel;
    private String color;
    private String _class_;
    private int passengers;
    private String gearbox;
    private int price;
    private String air_cond;
    private String airbag;
    private String sunroof;
    private String heated_seats;
    private String nav_system;
    private String bluetooth;
    private String elec_window;
    private String gps;

    public Car() {
    }

    public Car(int _id, int _brand, String _model, String _fuel, String _color, String _class, int _passengers, String _gearbox, int _price, 
                String _air_cond, String _airbag, String _sunroof, String _heated_seats, String _nav_system, String _bluetooth, 
                String _elec_window, String _gps) {
        this.id = _id;
        this.brand = _brand;
        this.model = _model;
        this.fuel = _fuel;
        this.color = _color;
        this._class_ = _class;
        this.passengers = _passengers;
        this.gearbox = _gearbox;
        this.price = _price;
        this.air_cond = _air_cond;
        this.airbag = _airbag;
        this.sunroof = _sunroof;
        this.heated_seats = _heated_seats;
        this.nav_system = _nav_system;
        this.bluetooth = _bluetooth;
        this.elec_window = _elec_window;
        this.gps = _gps;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClass_() {
        return _class_;
    }

    public void setClass_(String _class_) {
        this._class_ = _class_;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAir_cond() {
        return air_cond;
    }

    public void setAir_cond(String air_cond) {
        this.air_cond = air_cond;
    }

    public String getAirbag() {
        return airbag;
    }

    public void setAirbag(String airbag) {
        this.airbag = airbag;
    }

    public String getSunroof() {
        return sunroof;
    }

    public void setSunroof(String sunroof) {
        this.sunroof = sunroof;
    }

    public String getHeated_seats() {
        return heated_seats;
    }

    public void setHeated_seats(String heated_seats) {
        this.heated_seats = heated_seats;
    }

    public String getNav_system() {
        return nav_system;
    }

    public void setNav_system(String nav_system) {
        this.nav_system = nav_system;
    }

    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    public String getElec_window() {
        return elec_window;
    }

    public void setElec_window(String elec_window) {
        this.elec_window = elec_window;
    }

    public String getGps() {
        return gps;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    // Getters and Setters

    public void addCar(int _id, int _brand, String _model, String _fuel, String _color, String _class, int _passengers, String _gearbox, 
                       int _price, String _air_cond, String _airbag, String _sunroof, String _heated_seats, String _nav_system, 
                       String _bluetooth, String _elec_window, String _gps) {
        String filePath = "C:\\Users\\user\\Desktop\\cars.txt"; // File path for storing car details
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // Append mode
            String carData = _id + "," + _brand + "," + _model + "," + _fuel + "," + _color + "," + _class + "," + _passengers + "," +
                             _gearbox + "," + _price + "," + _air_cond + "," + _airbag + "," + _sunroof + "," + _heated_seats + "," + 
                             _nav_system + "," + _bluetooth + "," + _elec_window + "," + _gps;
            writer.write(carData);
            writer.newLine(); // Add a new line after each car entry
            JOptionPane.showMessageDialog(null, "Car Added Successfully");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error adding car: " + e.getMessage());
        }
    }

    public void editCar(int _id, int _brand, String _model, String _fuel, String _color, String _class, int _passengers, String _gearbox, 
                        int _price, String _air_cond, String _airbag, String _sunroof, String _heated_seats, String _nav_system, 
                        String _bluetooth, String _elec_window, String _gps) {
        String filePath = "C:\\Users\\user\\Desktop\\cars.txt";
        File file = new File(filePath);
        StringBuilder updatedContent = new StringBuilder();
        boolean carFound = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] carData = line.split(",");
                if (Integer.parseInt(carData[0]) == _id) {
                    // Update the car data if the ID matches
                    line = _id + "," + _brand + "," + _model + "," + _fuel + "," + _color + "," + _class + "," + _passengers + "," +
                           _gearbox + "," + _price + "," + _air_cond + "," + _airbag + "," + _sunroof + "," + _heated_seats + "," +
                           _nav_system + "," + _bluetooth + "," + _elec_window + "," + _gps;
                    carFound = true;
                }
                updatedContent.append(line).append(System.lineSeparator()); // Add the line to updated content
            }

            if (carFound) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(updatedContent.toString()); // Write the updated content back to the file
                    JOptionPane.showMessageDialog(null, "Car Edited Successfully");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Car Not Found");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error editing car: " + e.getMessage());
        }
    }

    public void removeCar(int _id) {
        String filePath = "C:\\Users\\user\\Desktop\\cars.txt";
        File file = new File(filePath);
        StringBuilder updatedContent = new StringBuilder();
        boolean carFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] carData = line.split(",");
                if (Integer.parseInt(carData[0]) == _id) {
                    carFound = true;
                    continue; // Skip this line to remove the car
                }
                updatedContent.append(line).append(System.lineSeparator()); // Add the line to updated content
            }

            if (carFound) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(updatedContent.toString()); // Write the updated content back to the file
                    JOptionPane.showMessageDialog(null, "Car Removed Successfully");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Car Not Found");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error removing car: " + e.getMessage());
        }
    }

    public ArrayList<Car> carsList() {
        ArrayList<Car> carList = new ArrayList<>();
        String filePath = "C:\\Users\\user\\Desktop\\cars.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] carData = line.split(",");
                int id = Integer.parseInt(carData[0]);
                int brand = Integer.parseInt(carData[1]);
                String model = carData[2];
                String fuel = carData[3];
                String color = carData[4];
                String _class = carData[5];
                int passengers = Integer.parseInt(carData[6]);
                String gearbox = carData[7];
                int price = Integer.parseInt(carData[8]);
                String air_cond = carData[9];
                String airbag = carData[10];
                String sunroof = carData[11];
                String heated_seats = carData[12];
                String nav_system = carData[13];
                String bluetooth = carData[14];
                String elec_window = carData[15];
                String gps = carData[16];

                carList.add(new Car(id, brand, model, fuel, color, _class, passengers, gearbox, price, air_cond, airbag, sunroof, heated_seats, 
                                    nav_system, bluetooth, elec_window, gps));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading cars: " + e.getMessage());
        }
        return carList;
    }

    public Car getCarById(int _id) {
        ArrayList<Car> cars = carsList();
        for (Car car : cars) {
            if (car.getId() == _id) {
                return car;
            }
        }
        JOptionPane.showMessageDialog(null, "Car Not Found");
        return null;
    }
}
