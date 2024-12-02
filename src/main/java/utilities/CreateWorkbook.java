package utilities;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
//import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateWorkbook {


    public void createWorkbook_xls() {
        try {
            Workbook wb = new HSSFWorkbook();
            FileOutputStream fis = new FileOutputStream("src/test/resources/testData/UserName_Password.xlsx");
            wb.write(fis);
            fis.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
