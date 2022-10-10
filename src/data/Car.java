/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import validation.MyValidation;

/**
 *
 * @author PC
 */
public class Car extends Vehicle {

    public String type;
    public int yearOfManufacture;

    public Car() {
        type = "";
        yearOfManufacture = 0;
    }

    public Car(String type, int yearOfManufacture) {
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Car(String id, String name, String color, int price, String brand, String type, int yearOfManufacture) {
        super(id, name, color, price, brand);
        this.type = type;
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    @Override
    public String toString() {
        return "Car:" + " Id = " + id + " - Name = " + name + " - Color = " + color + " - Price = " + price + " - Brand = " + brand + " - Type = " + type + " - Year of manufacture = " + yearOfManufacture;
    }

    public void createCar() {
        id = MyValidation.getId("Input Id: ", "Input again!( Input car***, * is a number)", id, "car[0-9]{3}");
        name = MyValidation.getString("Input name :", "Input again!");
        while (true) {
            color = MyValidation.getString("Input color: ", "Input again!");
            if (color.equalsIgnoreCase("green") || color.equalsIgnoreCase("red") || color.equalsIgnoreCase("blu")) {
                break;
            }
            System.out.println("Only Input green or red or blu");
        }
        while (true) {
            price = MyValidation.getInt("Input price: ", "Input again!");
            if (price > 0) {
                break;
            }
            System.out.println("Input a number > 0, please!");
        }
        brand = MyValidation.getString("Input brand: ", "Please input again!");
        while (true) {
            type = MyValidation.getString("Input type: ", "Input again!");
            if (type.equalsIgnoreCase("sport") || type.equalsIgnoreCase("travel") || type.equalsIgnoreCase("common")) {
                break;
            }
            System.out.println("Only input sport or travel or common)");
        }
        yearOfManufacture = MyValidation.yearOfThePast("Input year of manufacture: ", "Input year < current, please!");
    }

    public void upCar() {
        this.name = MyValidation.updateString(this.name, "Input new name: ");
        while (true) {
            this.color = MyValidation.updateString(this.color, "Input new color: ");
            if (color.equalsIgnoreCase("green") || color.equalsIgnoreCase("red") || color.equalsIgnoreCase("blu")) {
                break;
            }
            System.out.println("Only input green or red or blu");
        }
        while (true) {
            this.price = MyValidation.updateInt(this.price, "Input new price: ");
            if (price > 0) {
                break;
            }
            System.out.println("Please input a number > 0");
        }
        this.brand = MyValidation.updateString(this.brand, "Input new brand: ");
        while (true) {
            this.type = MyValidation.updateString(this.type, "Input new type: ");
            if (type.equalsIgnoreCase("sport") || type.equalsIgnoreCase("travel") || type.equalsIgnoreCase("common")) {
                break;
            }
            System.out.println("Only input sport or travel or common!");
        }
        this.yearOfManufacture = MyValidation.updateyearOfThePast(this.yearOfManufacture, "Input new manufacture: ", "Input year < currnent, please!");

        if (name != null && name != "") {
            setName(name);
        }
        String priceS = Integer.toString(price);
        if (priceS != null && priceS != "") {
            setPrice(price);
        }
        if (color != null && color != "") {
            setColor(color);
        }
        if (brand != null && brand != "") {
            setBrand(brand);
        }
        if (type != null && type != "") {
            setType(type);
        }
        String yearOfManufactureS = Integer.toString(yearOfManufacture);
        if (yearOfManufactureS != null && yearOfManufactureS != "") {
            setYearOfManufacture(yearOfManufacture);
        }
    }

     

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
