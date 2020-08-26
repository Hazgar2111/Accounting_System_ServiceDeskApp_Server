package sample;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

public class ExcelToDB_new_inventory {
    public static void save (File file) {

        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/accountingsystem?useUnicode=true&serverTimezone=UTC";
        String username = "root";
        String password = "123";
        String excelFilePath = "C:/Users/User/Desktop/Programming/Java/Server_Accounting_System_FX/src/xlsx/ob_new_sklad.xlsx";
        int batchSize = 20;
        Connection connection = null;

        try {
            long start = System.currentTimeMillis();
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO new_inventory (id, idinventory, serial_number, product_name) " +
                    "VALUES (null,?, ?, ?)"
            );

            int count = 0;

            rowIterator.next(); // skip the header row
            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();

                    if (columnIndex == 0) {
                        String idinventory = nextCell.getStringCellValue();
                        statement.setString(1, idinventory);
                    }
                    else if (columnIndex == 1) {
                        String serial_number = nextCell.getStringCellValue();
                        statement.setString(2, serial_number);
                    }
                    else if (columnIndex == 2) {
                        String product_name = nextCell.getStringCellValue();
                        statement.setString(3, product_name);

                       // String macAddress = null;
                       // statement.setString(4, macAddress);
                    }
                }

                //statement.addBatch();
                statement.executeUpdate();

                //if (count % batchSize == 0) {
                  //  statement.executeBatch();
                //}
            }

            workbook.close();
            // execute the remaining queries
           // statement.executeBatch();

            connection.commit();
            connection.close();

            long end = System.currentTimeMillis();
            System.out.printf("Import done in %d ms\n", (end - start));

        } catch (IOException ex1) {
            System.out.println("Error reading file");
            ex1.printStackTrace();
        } catch (SQLException ex2) {
            System.out.println("Database error");
            ex2.printStackTrace();
        }

    }
}
