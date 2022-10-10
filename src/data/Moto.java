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
public class Moto extends Vehicle {

    public int speed;
    protected String license;

    public Moto() {
        speed = 0;
        license = "";
    }

    public Moto(int speed, String license) {
        this.speed = speed;
        this.license = license;
    }

    public Moto(String id, String name, String color, int price, String brand, int speed, String license) {
        super(id, name, color, price, brand);
        this.speed = speed;
        this.license = license;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Moto:" + " Id = " + id + " - Name = " + name + " - Color = " + color + " - Price = " + price + " - Brand = " + brand + " - Speed = " + speed + " - License = " + license;
    }

    public void createMoto() {
        id = MyValidation.getId("Input Id: ", "Input again!( Input moto***, * is a number)", id, "moto[0-9]{3}");
        name = MyValidation.getString("Input name: ", "Input again!");
        while (true) {
            color = MyValidation.getString("Input color: ", "Input again!");
            if (color.equalsIgnoreCase("green") || color.equalsIgnoreCase("red") || color.equalsIgnoreCase("blu")) {
                break;
            }
            System.out.println("Only input green or red or blue)");
        }
        while (true) {
            price = MyValidation.getInt("Input price: ", "Input again!");
            if (price > 0) {
                break;
            }
            System.out.println("Input a number > 0,please!");
        }
        brand = MyValidation.getString("Input brand: ", "Please input again!");
        while (true) {
            speed = MyValidation.getInt("Input speed: ", "Input again!");
            if (speed > 0) {
                break;
            }
            System.out.println("Please Input > 0!)");
        }
        license = MyValidation.yesNo("License or not ?", "Only input yes or no");

    }

    public void makeSound() {
        System.out.println("Ting Ting Ting");
    }

    public void upMoto() {
        this.name = MyValidation.updateString(this.name, "Input new name: ");
        while (true) {
            color = MyValidation.updateString(this.color, "Input new color: ");
            if (color.equalsIgnoreCase("green") || color.equalsIgnoreCase("red") || color.equalsIgnoreCase("blu")) {
                break;
            }
            System.out.println("Only input green or red or blu");
        }
        while (true) {
            price = MyValidation.updateInt(this.price, "Input new price:");
            if (price > 0) {
                break;
            }
            System.out.println("Please input a number > 0!)");
        }
        this.brand = MyValidation.updateString(this.brand, "Input new brand: ");
        while (true) {
            this.speed = MyValidation.updateInt(this.speed, "Input new speed: ");
            if (speed > 0) {
                break;
            }
            System.out.println("Please input a number > 0!)");
        }
        this.license = MyValidation.updataYesNo(this.license, "Input new license: ", "Only input yes or no");
        if (name != null && name != "") {
            setName(name);
        }
        String priceN = Integer.toString(price);
        if (priceN != null && priceN != "") {
            setPrice(price);
        }
        if (color != null && color != "") {
            setColor(color);
        }
        if (brand != null && brand != "") {
            setBrand(brand);
        }

        String speedN = Integer.toString(price);
        if (speedN != null && speedN != "") {
            setSpeed(speed);
        }

        if (license != null && license != "") {
            setLicense(license);
        }

    }

    @Override
    public int compare(Vehicle o1, Vehicle o2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
