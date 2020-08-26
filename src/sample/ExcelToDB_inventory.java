package sample;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.xmlbeans.impl.regex.ParseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class ExcelToDB_inventory {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://127.0.0.1:3306/accountingsystem?useUnicode=true&serverTimezone=UTC";
        String username = "root";
        String password = "123";
        String excelFilePath = "C:/Users/User/Desktop/Programming/Java/Server_Accounting_System_FX/src/xlsx/Inv_last.xlsx";
        int batchSize = 20;
        Connection connection = null;

        try {
            long start = System.currentTimeMillis();
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet firstSheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = firstSheet.iterator();
            connection = DriverManager.getConnection(jdbcURL, username, password);
            connection.setAutoCommit(false);


            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO inventory (id, idinventory, serial_number, product_name, kto_vydal, recieved, " +
                    "location, date_of_issue, peremechenie_1C, nakladnaya_1C, REQ_number, transport_nakladnaya, description) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            int count = 0;

            rowIterator.next(); // skip the header row

            while (rowIterator.hasNext()) {
                Row nextRow = rowIterator.next();
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell nextCell = cellIterator.next();
                    int columnIndex = nextCell.getColumnIndex();
                    switch (columnIndex) {
                        case 0:
                            String idinventory = nextCell.getStringCellValue();
                            statement.setString(1, idinventory);
                            continue;
                        case 1:
                            String serial_number = nextCell.getStringCellValue();
                            statement.setString(2, serial_number);
                            continue;
                        case 2:
                            String product_name = nextCell.getStringCellValue();
                            statement.setString(3, product_name);
                            continue;
                        case 3:
                            String recieved = nextCell.getStringCellValue();
                            statement.setString(5, recieved);
                            continue;
                        case 4:
                            String location = nextCell.getStringCellValue();
                            statement.setString(6, location);
                            continue;
                        case 5:
                            try
                            {
                                SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
                                String date_of_issue = sdf.format(nextCell.getDateCellValue());
                                statement.setString(7, date_of_issue);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            continue;
                        case 6:
                            double peremechenie_1C = nextCell.getNumericCellValue();
                            int temp1 = (int) peremechenie_1C;
                            String temp = String.valueOf(temp1);

                            if (temp.isEmpty()) {
                                temp = null;
                            }
                            statement.setString(8, temp);
                            continue;
                        case 7:
                            String nakladnaya_1C = nextCell.getStringCellValue();
                            if (nakladnaya_1C.isEmpty()) {
                                nakladnaya_1C = null;
                            }
                            statement.setString(9, nakladnaya_1C);
                            continue;
                        case 8:
                            String kto_vydal = nextCell.getStringCellValue();
                            statement.setString(4, kto_vydal);
                            continue;
                        case 9:
                            String REQ_number = nextCell.getStringCellValue();
                            if (REQ_number.isEmpty()) {
                                REQ_number = null;
                            }
                            statement.setString(10, REQ_number);
                            continue;
                        case 10:
                            String transport_nakladnaya = nextCell.getStringCellValue();
                            if (transport_nakladnaya.isEmpty()) {
                                transport_nakladnaya = null;
                            }
                            statement.setString(11, transport_nakladnaya);
                            continue;
                        case 11:
                            String description = nextCell.getStringCellValue();
                            if (description.isEmpty()) {
                                description = null;
                            }
                            statement.setString(12, description);

                    }
                }

                //statement.addBatch();
               // statement.executeUpdate();

               // if (count % batchSize == 0) {
               //    statement.executeBatch();
                //}
            }

            workbook.close();
            //statement.executeBatch();

            //connection.commit();
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



