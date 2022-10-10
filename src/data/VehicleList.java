/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import validation.MyValidation;

/**
 *
 * @author PC
 */
public class VehicleList {

    protected ArrayList<Car> carList = new ArrayList<>();
    protected ArrayList<Moto> motoList = new ArrayList<>();
    protected ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public static void menu() {
        System.out.println("----------------------------");
        System.out.println("welcome to the vehicle management!");
        System.out.println("1. Load data from file");
        System.out.println("2. Add new vehicle");
        System.out.println("3. Update vehicle by ID");
        System.out.println("4. Delete vehicle by ID");
        System.out.println("5. Search vehicle");
        System.out.println("6. Show vehicle list");
        System.out.println("7. Store data to file");
        System.out.println("8. Quit");
    }

    public void fileWriterAll() {
        String line = null;
        try {
            FileWriter fw = new FileWriter("vehicles.txt");
            BufferedWriter bf = new BufferedWriter(fw);
            for (Car car : carList) {
                line = car.getId() + ", " + car.getName() + ", " + car.getColor() + ", "
                        + car.getPrice() + ", " + car.getBrand() + ", " + car.getType() + ", " + car.getYearOfManufacture();
                bf.write(line);
                bf.newLine();
            }
            for (Moto moto : motoList) {
                line = moto.getId() + ", " + moto.getName() + ", " + moto.getColor() + ", "
                        + moto.getPrice() + ", " + moto.getBrand() + ", " + moto.getSpeed() + ", " + moto.getLicense();
                bf.write(line);
                bf.newLine();
            }
            bf.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void writeCar() {
        String line = null;
        File.fileWriter("---- Next version of car ----");
        for (Car car : carList) {
            line = car.getId() + ", " + car.getName() + ", " + car.getColor() + ", "
                    + car.getPrice() + ", " + car.getBrand() + ", " + car.getType() + ", " + car.getYearOfManufacture();
            File.fileWriter(line);
        }
    }

    public void writeMoto() {
        String line = null;
        File.fileWriter("---- Next version of motobike ----");
        for (Moto moto : motoList) {
            line = moto.getId() + ", " + moto.getName() + ", " + moto.getColor() + ", "
                    + moto.getPrice() + ", " + moto.getBrand() + ", " + moto.getSpeed() + ", " + moto.getLicense();
            File.fileWriter(line);
        }
    }

    public void vehicleListItem() {
        for (int i = 0; i < carList.size(); i++) {
            vehicleList.add(carList.get(i));
        }
        for (int j = 0; j < motoList.size(); j++) {
            vehicleList.add(motoList.get(j));
        }
        Collections.sort(vehicleList, new Vehicle() {
            @Override
            public int compare(Vehicle obj, Vehicle obj1) {
                if (obj.getId().compareTo(obj1.getId()) > 0) {
                    obj1.getId();
                    return -1;
                }
                return 1;
            }
        });
    }

    public boolean addCar(Car c) {
        return carList.add(c);
    }

    public boolean addMoto(Moto m) {
        return motoList.add(m);
    }

    public void vehicleEmptyListItem() {
        vehicleList.removeAll(vehicleList);
    }

    public int indexOfCarId(String id) {
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfMotoId(String id) {
        for (int i = 0; i < motoList.size(); i++) {
            if (motoList.get(i).getId().equalsIgnoreCase(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void addVehicleMenu() {
        System.out.println("1. Add new car");
        System.out.println("2. Add new motobike");
        System.out.println("3. Quit");
    }

    public static void showVehicleMenu() {
        System.out.println("1. Show all");
        System.out.println("2. Show all (descending by price)");
        System.out.println("3. Quit");
    }

    public static void searchVehicleMenu() {
        System.out.println("1. Search by name");
        System.out.println("2. Search by id");
        System.out.println("3. Quit");
    }

    public void updateCar(String id) {
        boolean finded = false;
        for (Car car : carList) {
            if (car.getId().equalsIgnoreCase(id)) {
                car.upCar();
                finded = true;
                System.out.println("update success!");
                System.out.println(car);
            }
        }
        if (finded == false) {
            System.out.println("Id cannot be found!");
        }
    }

    public void updateMoto(String id) {
        boolean checked = false;
        for (Moto moto : motoList) {
            if (moto.getId().equalsIgnoreCase(id)) {
                moto.upMoto();
                checked = true;
                System.out.println("Update success!");
                System.out.println(moto);
            }
        }
        if (checked = false) {
            System.out.println("Id cannot be found!");
        }
    }

    public boolean deleteCar(String id) {
        String sure;
        boolean finded = false;
        for (Car c : carList) {
            if (c.getId().equalsIgnoreCase(id)) {
                sure = MyValidation.yesNo("Are you sure?", "Only input yes or no ");
                if (sure.equalsIgnoreCase("yes")) {
                    carList.remove(c);
                    System.out.println("Delete success");
                    finded = true;
                    return true;
                }
                return true;
            }
        }
        if (finded == false) {
            System.out.println("ID could not be found to delete car");
        }
        return false;
    }

    public boolean deleteMoto(String id) {
        String sure;
        boolean finded = false;
        for (Moto m : motoList) {
            if (m.getId().equalsIgnoreCase(id)) {
                sure = MyValidation.yesNo("Are you sure?", "Only input yes or no ");
                if (sure.equalsIgnoreCase("yes")) {
                    motoList.remove(m);
                    System.out.println("Delete success");
                    finded = true;
                    return true;
                }
                return true;
            }
        }
        if (finded == false) {
            System.out.println("ID could not be found to delete motobike");
        }
        return false;
    }

    public void searchByName() {
        vehicleListItem();
        String name = MyValidation.getString("Input name to search: ", "Please input again");
        if (vehicleList.isEmpty()) {
            System.out.println("Empty list");
        } else {
            for (int i = 0; i < vehicleList.size(); i++) {
                if (vehicleList.get(i).getName().contains(name)) {
                    System.out.println(vehicleList.get(i));
                }
            }
        }

        vehicleEmptyListItem();
    }

    public void searchByCarId(String id) {
        boolean finded = false;
        for (int a = 0; a < carList.size(); a++) {
            if (carList.get(a).getId().equalsIgnoreCase(id)) {
                System.out.println(carList.get(a));
                finded = true;
            }
        }
        if (finded == false) {
            System.out.println("ID could not be found");
        }
    }

    public void searchByMotoId(String id) {
        boolean finded = false;
        for (int m = 0; m < motoList.size(); m++) {
            if (motoList.get(m).getId().equalsIgnoreCase(id)) {
                System.out.println(motoList.get(m));
                finded = true;
            }
        }
        if (finded == false) {
            System.out.println("ID could not be found");
        }
    }

    public void searchById() {
        String searchId = MyValidation.getString("Input ID to search: ", "Please input again!");
        if (searchId.startsWith("car")) {
            searchByCarId(searchId);
        } else if (searchId.startsWith("moto")) {
            searchByMotoId(searchId);
        } else {
            System.out.println("This ID is in the wrong format");
        }
    }

    public void isEmpty() {
        if (carList.isEmpty()) {
            System.out.println("No car here");
        }
        if (motoList.isEmpty()) {
            System.out.println("No motobike here");
        }
    }

    public void printCar() {
        int size = carList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(carList.get(i));
        }
    }

    public void printMotobike() {
        int size = motoList.size();
        for (int i = 0; i < size; i++) {
            System.out.println(motoList.get(i));
            Moto mt = new Moto();
            mt.makeSound();
        }

    }

    public void sortByPrice() {
        for (int i = 0; i < carList.size(); i++) {
            vehicleList.add(carList.get(i));

        }
        for (int j = 0; j < motoList.size(); j++) {
            vehicleList.add(motoList.get(j));
        }
        Collections.sort(vehicleList, new Vehicle() {
            @Override
            public int compare(Vehicle obj, Vehicle obj1) {
                if (obj.getPrice() > obj1.getPrice()) {

                    return -1;
                }
                return 1;
            }
        });

        for (int k = 0; k < vehicleList.size(); k++) {
            System.out.println(vehicleList.get(k));
            if (vehicleList.get(k).getId().startsWith("moto")) {

            }
        }
        vehicleEmptyListItem();

    }
}
