package sample;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public class Request implements Serializable {
    private String operationType;
    private static DBManager manager = new DBManager();
    private ArrayList<Admin> admins;
    private ArrayList<Inventory> inventories;
    private ArrayList<NewInventory> newInventories;
    private ArrayList<InventoryBU> InventoriesBU;
    private String id;
    private static final long serialVersionUID=1L;


    public String getId() {
        return id;
    }
    public String getOperationType() {
        return operationType;
    }
    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
    public static DBManager getManager() {
        return manager;
    }
    public static void setManager(DBManager manager) {
        Request.manager = manager;
    }
    public ArrayList<Admin> getAdmins() {
        return admins;
    }
    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }
    public ArrayList<Inventory> getInventories() {
        return inventories;
    }
    public void setInventories(ArrayList<Inventory> inventories) {
        this.inventories = inventories;
    }


    public Request(String operationType, String id, int check) {
        this.operationType = operationType;
        this.id = id;

    }

    private File file;

    public File getFile() {
        return file;
    }

    public Request(String operationType, File file, long check) {
        this.operationType = operationType;
        this.file = file;
    }

    public Request(String operationType, ArrayList<InventoryBU> inventoriesBU, double check) {
        this.operationType = operationType;
        this.InventoriesBU = inventoriesBU;


    }


    public Request(String operationType,  ArrayList<Inventory> inventories, int check) {

        this.operationType = operationType;
        this.inventories = inventories;
    }


    public Request(String operationType, ArrayList<Admin> admins) {
        this.operationType = operationType;
        this.admins = admins;
    }


    public Request(String operationType,  ArrayList<NewInventory> inventories, String check) {
        this.operationType = operationType;
        this.newInventories = inventories;
    }


    public Request() {
    }


    public static ArrayList<Admin> returnAdmins(){
        ArrayList<Admin> admins;
        //manager.connect();
        admins=manager.getAdmins();
        return admins;
    }
    public static ArrayList<Inventory> returnInventory(){
        ArrayList<Inventory> inventory;
       // manager.connect();
        inventory=manager.getAllInventory();

        return inventory;
    }
    public static ArrayList<NewInventory> returnNewInventory(){
        ArrayList<NewInventory> inventory;
       // manager.connect();
        inventory=manager.getAllNewInventory();

        return inventory;
    }
    public static ArrayList<InventoryBU> returnInventoryBU(){
        ArrayList<InventoryBU> inventory;
        inventory=manager.getAllBUInventory();
        return inventory;
    }
    public ArrayList<NewInventory> getNewInventories() {
        return newInventories;
    }
    public ArrayList<InventoryBU> getInventoriesBU() {
        return InventoriesBU;
    }



    public static void addInventoryBU(InventoryBU inventoryBU)
    {
        manager.addInventoryBU(inventoryBU);
    }
    public static void addInventory(Inventory inventory)
    {
        manager.addInventory(inventory);
    }
    public static void addInventoryNew(NewInventory inventory)
    {
        manager.addInventoryNew(inventory);
    }
    public static void addAdmin(Admin admin)
    {
        manager.addAdmin(admin);
    }


    public static void deleteAdmin(String  id){
       // manager.connect();
        manager.deleteAdmin(id);
    }
    public static void deleteInventoryBU(String  id){
        // manager.connect();
        manager.deleteInventoryBU(id);
    }
    public static void deleteInventory(String  id){

        manager.deleteInventory(id);
    }
    public static void deleteNewInventory(String  id){
        // manager.connect();
        manager.deleteInventoryNew(id);
    }


    public static void updateInventory(Inventory inventory){
        manager.updateInventory(inventory);
    }
    public static void updateAdmin(Admin admin){
        manager.updateAdmin(admin);
    }

    public static void saveFileDb(File file){
        ExcelToDB_new_inventory.save(file);
    }




}
