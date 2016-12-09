package cez.carshop;
/**
 *
 * @author anirudh
 */
public class Car {

    private int carID;
    private String make;
    private String model;
    private String year;
    private String current_owner;
    private double price;

    public Car(int carID, String make, String model, String year, String current_owner, double price) {
        this.carID = carID;
        this.make = make;
        this.model = model;
        this.year = year;
        this.current_owner = current_owner;
        this.price = price;
    }

    public int getCarID() {
        return carID;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getCurrent_owner() {
        return current_owner;
    }

    public double getPrice() {
        return price;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setCurrent_owner(String current_owner) {
        this.current_owner = current_owner;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" + "carID=" + carID + ", make=" + make + ", model=" + model + ", year=" + year + ", current_owner=" + current_owner + ", price=" + price + '}';
    }

}
