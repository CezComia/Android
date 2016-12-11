package cez.carshop;
/**
 *
 * @author anirudh
 */
public class Car {

    private int carID;
    private String model;
    private String current_owner;
    private double price;

    public Car(int carID, String model, String current_owner, double price) {
        this.carID = carID;
        this.model = model;
        this.current_owner = current_owner;
        this.price = price;
    }

    public int getCarID() {
        return carID;
    }


    public String getModel() {
        return model;
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


    public void setModel(String model) {
        this.model = model;
    }


    public void setCurrent_owner(String current_owner) {
        this.current_owner = current_owner;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
