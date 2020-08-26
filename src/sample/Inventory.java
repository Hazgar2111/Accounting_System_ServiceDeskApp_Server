package sample;

import java.io.Serializable;

public class Inventory implements Serializable {
    private int id;
    private String idInventory;
    private String serial_number;
    private String product_name;
    private String kto_vydal; //Кто выдал
    private String recieved; //Кто получил
    private String location;
    private String date_of_issue;
    private String peremechenie_1C;
    private String nakladnaya_1C;
    private String REQ_number;
    private String transport_nakladnaya;
    private String description;
    private String macAddress;
    private static final long serialVersionUID=1L;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public Inventory(int id, String idInventory, String serial_number, String product_name,
                     String kto_vydal, String recieved, String location,
                     String date_of_issue, String peremechenie_1C, String nakladnaya_1C, String REQ_number,
                     String transport_nakladnaya, String description, String macAddress) {
        this.id = id;
        this.idInventory = idInventory;
        this.serial_number = serial_number;
        this.product_name = product_name;
        this.kto_vydal = kto_vydal;
        this.recieved = recieved;
        this.location = location;
        this.date_of_issue = date_of_issue;
        this.peremechenie_1C = peremechenie_1C;
        this.nakladnaya_1C = nakladnaya_1C;
        this.REQ_number = REQ_number;
        this.transport_nakladnaya = transport_nakladnaya;
        this.description = description;
        this.macAddress = macAddress;
    }


    public Inventory(String idInventory, String serial_number, String product_name,
                     String kto_vydal, String recieved, String location,
                     String date_of_issue, String peremechenie_1C, String nakladnaya_1C, String REQ_number,
                     String transport_nakladnaya, String description, String macAddress) {
        this.idInventory = idInventory;
        this.serial_number = serial_number;
        this.product_name = product_name;
        this.kto_vydal = kto_vydal;
        this.recieved = recieved;
        this.location = location;
        this.date_of_issue = date_of_issue;
        this.peremechenie_1C = peremechenie_1C;
        this.nakladnaya_1C = nakladnaya_1C;
        this.REQ_number = REQ_number;
        this.transport_nakladnaya = transport_nakladnaya;
        this.description = description;
        this.macAddress = macAddress;
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



    public String getRecieved() {
        return recieved;
    }

    public void setRecieved(String recieved) {
        this.recieved = recieved;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate_of_issue() {
        return date_of_issue;
    }

    public void setDate_of_issue(String date_of_issue) {
        this.date_of_issue = date_of_issue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKto_vydal() {
        return kto_vydal;
    }

    public void setKto_vydal(String kto_vydal) {
        this.kto_vydal = kto_vydal;
    }

    public String getPeremechenie_1C() {
        return peremechenie_1C;
    }

    public void setPeremechenie_1C(String peremechenie_1C) {
        this.peremechenie_1C = peremechenie_1C;
    }

    public String getNakladnaya_1C() {
        return nakladnaya_1C;
    }

    public void setNakladnaya_1C(String nakladnaya_1C) {
        this.nakladnaya_1C = nakladnaya_1C;
    }



    public String getREQ_number() {
        return REQ_number;
    }

    public void setREQ_number(String REQ_number) {
        this.REQ_number = REQ_number;
    }

    public String getTransport_nakladnaya() {
        return transport_nakladnaya;
    }

    public void setTransport_nakladnaya(String transport_nakladnaya) {
        this.transport_nakladnaya = transport_nakladnaya;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
