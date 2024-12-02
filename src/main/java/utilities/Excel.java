package utilities;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import java.io.FileInputStream;
import java.io.IOException;


public class Excel {

   static String filePath ="src/test/resources/testData/UserName_Password.xlsx";

    @DataProvider(name="loginData")
    public static Object[][]  readExcelData() throws IOException {

        FileInputStream fis = new FileInputStream(filePath);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheetAt(0);
//        System.out.println(sheet.getRow(0).getCell(2));
//        System.out.println(sheet.getRow(1).getCell(1));
//        System.out.println(sheet.getLastRowNum());

        XSSFRow row= sheet.getRow(0);
        int rowCount = sheet.getLastRowNum();
        int columnCount =row.getLastCellNum();

//        System.out.println(rowCount);
//        System.out.println(columnCount);

        Object[][] loginData = new Object[rowCount][columnCount];

        for (int r=0;r<rowCount;r++){
            for(int c=0;c<columnCount;c++){

                XSSFCell cell =sheet.getRow(r+1).getCell(c+1);
                if(cell != null){
                    loginData[r][c]= cell.toString();
                }
                else {
                    loginData[r][c]="";
                }
            }
        }
        workbook.close();
        fis.close();
        return loginData;
    }

}
