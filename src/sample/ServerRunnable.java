package sample;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;


public class ServerRunnable extends Thread implements Serializable {

    private Socket socket;
    public ServerRunnable(Socket socket){
        this.socket = socket;
    }


    public void run(){
        Request request=new Request();
        Request r;
        try{
            ObjectOutputStream outStream =
                    new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inStream=
                    new ObjectInputStream(socket.getInputStream());


            while((r=(Request)inStream.readObject())!=null)
            {
                if(r.getOperationType().equals("LIST_INVENTORIES"))
                {
                    ArrayList<Inventory> inventories = Request.returnInventory();
                    Request data = new Request("LIST_INVENTORIES", inventories,1);
                    outStream.writeObject(data);
                }
                else if(r.getOperationType().equals("LIST_ADMINS"))
                {
                    ArrayList<Admin> admins = Request.returnAdmins();
                    Request data1 = new Request("LIST_ADMINS", admins);
                    outStream.writeObject(data1);
                }
                else if(r.getOperationType().equals("LIST_NEW_INVENTORIES"))
                {
                    ArrayList<NewInventory> newInventories = Request.returnNewInventory();
                    Request data1 = new Request("LIST_NEW_INVENTORIES", newInventories,"1");
                    outStream.writeObject(data1);
                }

                else if(r.getOperationType().equals("LIST_BU_INVENTORIES"))
                {
                    ArrayList<InventoryBU> InventoriesBU = Request.returnInventoryBU();
                    Request data1 = new Request("LIST_BU_INVENTORIES", InventoriesBU,1.0);
                    outStream.writeObject(data1);
                }
                else  if(r.getOperationType().equals("DELETE_INVENTORY")){
                    Request.deleteInventory(r.getId());
                }
                else  if(r.getOperationType().equals("DELETE_NEW_INVENTORY")){
                    Request.deleteNewInventory(r.getId());
                }
                else  if(r.getOperationType().equals("DELETE_BU_INVENTORY")){
                    Request.deleteInventoryBU(r.getId());
                }
                else  if(r.getOperationType().equals("ADD_BU_INVENTORY")){
                    Request.addInventoryBU(r.getInventoriesBU().get(0));
                }
                else  if(r.getOperationType().equals("ADD_INVENTORY")){
                    System.out.println("Test in Runnable");
                    Request.addInventory(r.getInventories().get(0));
                }
                else  if(r.getOperationType().equals("ADD_NEW_INVENTORY")){
                    Request.addInventoryNew(r.getNewInventories().get(0));
                }
                else  if(r.getOperationType().equals("UPDATE_INVENTORY")){
                    Request.updateInventory(r.getInventories().get(0));
                }
                else  if(r.getOperationType().equals("UPDATE_ADMIN")){
                    Request.updateAdmin(r.getAdmins().get(0));
                }
                else  if(r.getOperationType().equals("ADD_ADMIN")){
                    Request.addAdmin(r.getAdmins().get(0));
                }
                else  if(r.getOperationType().equals("DELETE_ADMIN")){
                    Request.deleteAdmin(r.getId());
                }
                else  if(r.getOperationType().equals("ADD_NEW_INVENTORY_FILE")){
                   Request.saveFileDb(r.getFile());
                }

            }
            inStream.close();
            outStream.close();
            socket.close();
        }catch (Exception ignored) {

        }



    }

}
