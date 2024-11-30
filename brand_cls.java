package carrentalsystem;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.Base64;

public class brand_cls {
    private int id;
    private String name;
    

    private static final String FILE_PATH = "C:\\Users\\user\\Desktop\\brands.txt";

    public brand_cls() {}

    public brand_cls(int _id, String _name) {
        this.id = _id;
        this.name = _name;
        
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    

    // Add a new brand to the file
    public void addBrand(int _id, String _name) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
           
            writer.write(_id + "," + _name );
            writer.newLine();
            JOptionPane.showMessageDialog(null, "Brand Added Successfully");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error adding brand: " + e.getMessage());
        }
    }

    // Edit an existing brand in the file
    public void editBrand(int _id, String _name) {
        List<brand_cls> brands = brandsList();
        boolean found = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (brand_cls brand : brands) {
                if (brand.getId() == _id) {
                    brand.setName(_name);
                    
                    found = true;
                }
                
                writer.write(brand.getId() + "," + brand.getName() );
                writer.newLine();
            }
            if (found) {
                JOptionPane.showMessageDialog(null, "Brand Edited Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Brand Not Found");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error editing brand: " + e.getMessage());
        }
    }

    // Remove a brand from the file
    public void removeBrand(int _id) {
        List<brand_cls> brands = brandsList();
        boolean found = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (brand_cls brand : brands) {
                if (brand.getId() != _id) {
                   
                    writer.write(brand.getId() + "," + brand.getName() );
                    writer.newLine();
                } else {
                    found = true;
                }
            }
            if (found) {
                JOptionPane.showMessageDialog(null, "Brand Removed Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Brand Not Found");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error removing brand: " + e.getMessage());
        }
    }

    // List all brands from the file
     public List<brand_cls> brandsList() {
        List<brand_cls> brands = new ArrayList<>();
        String filePath = "C:\\Users\\user\\Desktop\\brands.txt"; // Update with correct path
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming the format "id,name"
                String[] brandData = line.split(",");
                if (brandData.length == 2) {
                    int id = Integer.parseInt(brandData[0].trim());
                    String name = brandData[1].trim();
                    brand_cls brand = new brand_cls(id, name); // Assuming no logo (null)
                    brands.add(brand);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return brands;
    }

    // Get a brand by its ID
    public brand_cls getBrandById(int _id) {
        for (brand_cls brand : brandsList()) {
            if (brand.getId() == _id) {
                return brand;
            }
        }
        JOptionPane.showMessageDialog(null, "Brand Not Found");
        return null;
    }

    // Create a HashMap of brands (ID, Name)
   public HashMap<Integer, String> brandsHashMap() {
        HashMap<Integer, String> brandsMap = new HashMap<>();
        String filePath = "C:\\Users\\user\\Desktop\\brands.txt"; // Update the file path accordingly

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Assuming the file format is "id,name" per line
                String[] brandData = line.split(",");
                if (brandData.length == 2) {
                    int id = Integer.parseInt(brandData[0].trim());
                    String name = brandData[1].trim();
                    brandsMap.put(id, name);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return brandsMap;
    }
}
