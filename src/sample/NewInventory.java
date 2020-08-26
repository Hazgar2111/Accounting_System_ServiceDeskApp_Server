package sample;

import java.io.Serializable;

public class NewInventory implements Serializable {
    private int id;
    private String idInventory;
    private String serial_number;
    private String product_name;
    private String macAddress;

    private static final long serialVersionUID=1L;

    public NewInventory(int id, String idInventory, String serial_number, String product_name, String macAddress) {
        this.id = id;
        this.idInventory = idInventory;
        this.serial_number = serial_number;
        this.product_name = product_name;
        this.macAddress = macAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdInventory() {
        return idInventory;
    }

    public void setIdInventory(String idInventory) {
        this.idInventory = idInventory;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public NewInventory(int id, String idInventory, String serial_number, String product_name) {
        this.id = id;
        this.idInventory = idInventory;
        this.serial_number = serial_number;
        this.product_name = product_name;

    }
}
