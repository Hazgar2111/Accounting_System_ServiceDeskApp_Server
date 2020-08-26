package sample;

import java.io.Serializable;

public class InventoryBU implements Serializable {
    private String 	idinventory;
    private String 	serial_number;
    private String 	product_name;
    private String 	kto_prinayl;
    private String 	kto_sdal;
    private String macAddress;
    private static final long serialVersionUID=1L;


    public String getIdinventory() {
        return idinventory;
    }

    public void setIdinventory(String idinventory) {
        this.idinventory = idinventory;
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

    public String getKto_prinayl() {
        return kto_prinayl;
    }

    public void setKto_prinayl(String kto_prinayl) {
        this.kto_prinayl = kto_prinayl;
    }

    public String getKto_sdal() {
        return kto_sdal;
    }

    public void setKto_sdal(String kto_sdal) {
        this.kto_sdal = kto_sdal;
    }

    public InventoryBU(String idinventory, String serial_number, String product_name, String kto_prinayl, String kto_sdal, String macAddress) {
        this.idinventory = idinventory;
        this.serial_number = serial_number;
        this.product_name = product_name;
        this.kto_prinayl = kto_prinayl;
        this.kto_sdal = kto_sdal;
        this.macAddress = macAddress;
    }


}
