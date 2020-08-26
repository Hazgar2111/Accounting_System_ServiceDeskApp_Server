package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class DBManager {
    private static Connection connection;


    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/accountingsystem?useUnicode=true&serverTimezone=UTC","root","123"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addAdmin(Admin admin) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO admins (id, login, pass1,  name1, surname, group1) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, admin.getLogin());
            statement.setString(2, admin.getPass());
            statement.setString(3, admin.getName());
            statement.setString(4, admin.getSurname());
            statement.setString(5, admin.getGroup());
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addInventoryBU(InventoryBU inventoryBU) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO inventorybu (idinventory, serial_number, product_name,  kto_prinayl, kto_sdal) " +
                    "VALUES (?, ?, ?, ?, ?)"
            );
            statement.setString(1, inventoryBU.getIdinventory());
            statement.setString(2, inventoryBU.getSerial_number());
            statement.setString(3, inventoryBU.getProduct_name());
            statement.setString(4, inventoryBU.getKto_prinayl());
            statement.setString(5, inventoryBU.getKto_sdal());
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addInventoryNew(NewInventory inventory) {
        try {

            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO new_inventory (id, idinventory, serial_number, product_name, macAddress) " +
                    "VALUES (null, ?, ?, ?, ?)"
            );
            statement.setString(1, inventory.getIdInventory());
            statement.setString(2, inventory.getSerial_number());
            statement.setString(3, inventory.getProduct_name());
            statement.setString(4, inventory.getMacAddress());

            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void addInventory(Inventory inventory1) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO inventory (id, idinventory, serial_number, product_name, kto_vydal, recieved, location, date_of_issue, peremechenie_1C, nakladnaya_1C, REQ_number, transport_nakladnaya, description, macAddress) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, inventory1.getIdInventory());
            statement.setString(2, inventory1.getSerial_number());
            statement.setString(3, inventory1.getProduct_name());
            statement.setString(4, inventory1.getKto_vydal());
            statement.setString(5, inventory1.getRecieved());
            statement.setString(6, inventory1.getLocation());
            statement.setString(7, inventory1.getDate_of_issue());
            statement.setString(8, inventory1.getPeremechenie_1C());
            statement.setString(9, inventory1.getNakladnaya_1C());
            statement.setString(10, inventory1.getREQ_number());
            statement.setString(11, inventory1.getTransport_nakladnaya());
            statement.setString(12, inventory1.getDescription());
            statement.setString(13, inventory1.getMacAddress());


            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Admin> getAdmins() {
        ArrayList<Admin> adminsList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM admins");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String pass = resultSet.getString("pass1");
                String name = resultSet.getString("name1");
                String surname = resultSet.getString("surname");
                String group = resultSet.getString("group1");

                adminsList.add(new Admin(id, login, pass, name, surname, group));
                //System.out.println(adminsList.get(0).getLogin());
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminsList;
    }


    public ArrayList<Inventory> getAllInventory() {
        ArrayList<Inventory> allInventory = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM inventory");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt("id");
                String idInventory = resultSet.getString("idinventory");
                String serial_number = resultSet.getString("serial_number");
                String product_name = resultSet.getString("product_name");
                String kto_vydal = resultSet.getString("kto_vydal");
                String recieved = resultSet.getString("recieved");
                String location = resultSet.getString("location");
                String date_of_issue = resultSet.getString("date_of_issue");
                String number_peremechenie_1C = resultSet.getString("peremechenie_1C");
                String nakladnaya_peremechenie_1C = resultSet.getString("nakladnaya_1C");
                String REQ_number = resultSet.getString("REQ_number");
                String transport_nakladnaya = resultSet.getString("transport_nakladnaya");
                String description = resultSet.getString("description");
                String macAddress = resultSet.getString("macAddress");

                allInventory.add(new Inventory(id, idInventory, serial_number, product_name, kto_vydal,
                        recieved, location, date_of_issue, number_peremechenie_1C, nakladnaya_peremechenie_1C, REQ_number,
                        transport_nakladnaya, description, macAddress));

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allInventory;
    }


    public ArrayList<InventoryBU> getAllBUInventory() {
        ArrayList<InventoryBU> allInventory = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM inventorybu");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String idInventory = resultSet.getString("idinventory");
                String serial_number = resultSet.getString("serial_number");
                String product_name = resultSet.getString("product_name");
                String kto_prinayl = resultSet.getString("kto_prinayl");
                String kto_sdal = resultSet.getString("kto_sdal");
                String macAddress = resultSet.getString("macAddress");

                allInventory.add(new InventoryBU(idInventory, serial_number, product_name, kto_prinayl,kto_sdal, macAddress));

            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allInventory;
    }


    public ArrayList<NewInventory> getAllNewInventory() {
        ArrayList<NewInventory> allInventory = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM new_inventory");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id =resultSet.getInt("id");
                String idInventory = resultSet.getString("idinventory");
                String serial_number = resultSet.getString("serial_number");
                String product_name = resultSet.getString("product_name");
                String macAddress = resultSet.getString("macAddress");

                allInventory.add(new NewInventory(id, idInventory, serial_number, product_name, macAddress));


            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allInventory;
    }


    public void deleteAdmin(String id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM admins WHERE id = ?"
            );
            int id1 = Integer.parseInt(id);
            statement.setInt(1, id1);
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteInventory(String id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM inventory WHERE idinventory = ?"
            );

            statement.setString(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteInventoryBU(String id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM inventorybu WHERE idinventory = ?"
            );
            statement.setString(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteInventoryNew(String id) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM new_inventory WHERE idinventory = ?"
            );
            statement.setString(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void updateInventory(Inventory inventory){
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE inventory SET idinventory=?, serial_number=?, product_name=?, kto_vydal=?, recieved=?," +
                            " location=?, date_of_issue=?, peremechenie_1C=?, nakladnaya_1C=?, REQ_number=?," +
                            " transport_nakladnaya=?, description=?, macAddress=? where idinventory=?");



            statement.setString(1, inventory.getIdInventory());
            statement.setString(2, inventory.getSerial_number());
            statement.setString(3, inventory.getProduct_name());
            statement.setString(4, inventory.getKto_vydal());
            statement.setString(5, inventory.getRecieved());
            statement.setString(6, inventory.getLocation());
            statement.setString(7, inventory.getDate_of_issue());
            statement.setString(8, inventory.getPeremechenie_1C());
            statement.setString(9, inventory.getNakladnaya_1C());
            statement.setString(10, inventory.getREQ_number());
            statement.setString(11, inventory.getTransport_nakladnaya());
            statement.setString(12, inventory.getDescription());
            statement.setString(13, inventory.getMacAddress());

            statement.setString(14, inventory.getIdInventory());

            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void updateAdmin(Admin admin){
        try{
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE admins SET login=?, pass1=?, name1=?, surname=?, group1=?  where id=?");
            statement.setString(1, admin.getLogin());
            statement.setString(2, admin.getPass());
            statement.setString(3, admin.getName());
            statement.setString(4, admin.getSurname());
            statement.setString(5, admin.getGroup());
            statement.setInt(6, admin.getId());
            int rows = statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

