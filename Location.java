package carrentalsystem;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Location {
    private int id;
    private String city;
    private String address;

    public Location() {
    }

    public Location(int _id, String _city, String _address) {
        this.id = _id;
        this.city = _city;
        this.address = _address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Function to add a new location to the file
    public void addLocation(int _id, String _city, String _address) {
        String filePath = "C:\\Users\\user\\Desktop\\locations.txt"; // Specify the location file path
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) { // 'true' appends to the file
            String locationData = _id + "," + _city + "," + _address;
            writer.write(locationData);
            writer.newLine(); // Add a new line after each location entry
            JOptionPane.showMessageDialog(null, "Location Added Successfully");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error adding location: " + e.getMessage());
        }
    }

    // Function to edit an existing location in the file
 public void editLocation(int _id, String _city, String _address) {
        String filePath = "C:\\Users\\user\\Desktop\\locations.txt"; // Specify the location file path
        File file = new File(filePath);
        StringBuilder updatedContent = new StringBuilder(); // StringBuilder to store the updated content
        boolean locationFound = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] locationData = line.split(",");
                if (Integer.parseInt(locationData[0]) == _id) {
                    // If the ID matches, update the location data
                    line = _id + "," + _city + "," + _address;
                    locationFound = true;
                }
                updatedContent.append(line).append(System.lineSeparator()); // Add the line to updated content
            }

            if (locationFound) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(updatedContent.toString()); // Write the updated content back to the file
                    JOptionPane.showMessageDialog(null, "Location Edited Successfully");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Location Not Found");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error editing location: " + e.getMessage());
        }
    }

    // Function to remove a location from the file
    public void removeLocation(int _id) {
        String filePath = "C:\\Users\\user\\Desktop\\locations.txt"; // Specify the location file path
        File file = new File(filePath);
        StringBuilder updatedContent = new StringBuilder(); // StringBuilder to store the updated content
        boolean locationFound = false;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] locationData = line.split(",");
                if (Integer.parseInt(locationData[0]) == _id) {
                    locationFound = true;
                    continue; // Skip this line to effectively remove it
                }
                updatedContent.append(line).append(System.lineSeparator()); // Add the line to updated content
            }

            if (locationFound) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(updatedContent.toString()); // Write the updated content back to the file
                    JOptionPane.showMessageDialog(null, "Location Removed Successfully");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Location Not Found");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error removing location: " + e.getMessage());
        }
    
    }

    // Function to read all locations from the file and return as an ArrayList
    public ArrayList<Location> locationsList() {
        ArrayList<Location> locList = new ArrayList<>();
        String filePath = "C:\\Users\\user\\Desktop\\locations.txt"; // Specify the location file path
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] locationData = line.split(",");
                int id = Integer.parseInt(locationData[0]);
                String city = locationData[1];
                String address = locationData[2];
                locList.add(new Location(id, city, address));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading locations: " + e.getMessage());
        }
        return locList;
    }

    // Function to get location by ID from the file
    public Location getLocationById(int _id) {
        String filePath = "C:\\Users\\user\\Desktop\\locations.txt"; // Specify the location file path
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] locationData = line.split(",");
                int id = Integer.parseInt(locationData[0]);
                if (id == _id) {
                    String city = locationData[1];
                    String address = locationData[2];
                    return new Location(id, city, address);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error retrieving location: " + e.getMessage());
        }
        return null; // Return null if location not found
    }
}
