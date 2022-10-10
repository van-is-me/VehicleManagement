/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package using;

import data.Car;
import data.File;
import data.I_List;
import data.Moto;
import data.VehicleList;
import java.util.List;
import validation.MyValidation;

/**
 *
 * @author PC
 */
public class Tester implements I_List {

    private static boolean pushData;

    public static void main(String[] args) {
        VehicleList vList = new VehicleList();
        int userChoice;
        int index = -1;

        do {
            VehicleList.menu();
            userChoice = MyValidation.getInt("Input your choice: ", "Input again!");
            switch (userChoice) {
                case 1: {

                    if (pushData == false) {
                        List<String> listLine = File.fileReader();
                        int listLineSize = listLine.size();
                        for (int i = 0; i < listLineSize; i++) {
                            System.out.println(listLine.get(i));
                            try {
                                String[] lineSplit = listLine.get(i).split(", ");
                                if (lineSplit[0].startsWith("c")) {
                                    Car ca = new Car(lineSplit[0], lineSplit[1], lineSplit[2], Integer.parseInt(lineSplit[3]), lineSplit[4], lineSplit[5], Integer.parseInt(lineSplit[6]));
                                    vList.addCar(ca);
                                } else if (lineSplit[0].startsWith("m")) {
                                    Moto mo = new Moto(lineSplit[0], lineSplit[1], lineSplit[2], Integer.parseInt(lineSplit[3]), lineSplit[4], Integer.parseInt(lineSplit[5]), lineSplit[6]);
                                    vList.addMoto(mo);
                                }
                            } catch (Exception e) {
                                System.out.println("You have entered the wrong format of the data in the vehicle.txt file. Let's check it again");
                            }
                        }
                        pushData = true;
                    } else {
                        System.out.println("You have already downloaded the data from the file");
                    }
                }
                break;
                case 2:
                    int addVehicleChoice;
                    do {

                        VehicleList.addVehicleMenu();
                        addVehicleChoice = MyValidation.getInt("Input your choice: ", "Input again!");
                        switch (addVehicleChoice) {
                            case 1:
                                Car car = new Car();
                                car.createCar();
                                index = vList.indexOfCarId(car.getId());
                                if (index == -1) {
                                    vList.addCar(car);
                                    System.out.println("Added successfully!");
                                } else {
                                    System.out.println("Added failed!");
                                }
                                break;
                            case 2:
                                Moto moto = new Moto();
                                moto.createMoto();
                                index = vList.indexOfMotoId(moto.getId());
                                if (index == -1) {
                                    vList.addMoto(moto);
                                    System.out.println("Added successfully!");
                                } else {
                                    System.out.println("Added failed!");
                                }
                                break;
                        }
                    } while (addVehicleChoice > 0 && addVehicleChoice < 3);
                    break;
                case 3:
                    String updateId = MyValidation.getString("Input Id to update: ", "Please input again!");
                    if (updateId.startsWith("moto")) {
                        vList.updateMoto(updateId);
                    } else if (updateId.startsWith("car")) {
                        vList.updateCar(updateId);
                    } else {
                        System.out.println("This Id is in the wrong format");
                    }
                    break;
                case 4:
                    String deleteId = MyValidation.getString("Input Id to delete: ", "Please input again!");
                    if (deleteId.startsWith("car")) {
                        vList.deleteCar(deleteId);
                    } else if (deleteId.startsWith("moto")) {
                        vList.deleteMoto(deleteId);
                    } else {
                        System.out.println("This Id is in the wrong format");
                    }
                    break;
                case 5:
                    int searchVehicleChoice;
                    do {

                        VehicleList.searchVehicleMenu();
                        searchVehicleChoice = MyValidation.getInt("Input your choice: ", "Input again!");
                        switch (searchVehicleChoice) {
                            case 1:
                                vList.searchByName();
                                break;

                            case 2:
                                vList.searchById();
                                break;
                        }
                    } while (searchVehicleChoice > 0 && searchVehicleChoice < 3);
                    break;
                case 6:
                    int showVehicleChoice;
                    do {
                        VehicleList.showVehicleMenu();
                        showVehicleChoice = MyValidation.getInt("Input your choice: ", "Input again!");
                        switch (showVehicleChoice) {
                            case 1:
                                vList.isEmpty();
                                vList.printCar();
                                vList.printMotobike();
                                break;
                            case 2:
                                vList.sortByPrice();

                                break;
                        }
                    } while (showVehicleChoice > 0 && showVehicleChoice < 3);
                    break;
                case 7:
                    vList.fileWriterAll();
                    break;

                default:
                    System.out.println("----Good Bye----");
                    break;

            }
        } while (userChoice > 0 && userChoice < 8);

    }

}
