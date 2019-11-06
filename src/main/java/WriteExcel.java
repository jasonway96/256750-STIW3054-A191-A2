import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class WriteExcel
{
    public static void main() throws IOException
    {
        try {
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("NameList Table");


            int num=1;

            for (info info : GetHostFollowers.findAll()) {
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Total Followers");
                header.createCell(1).setCellValue("Total User Followers");
                header.createCell(2).setCellValue("Total Repo");
                header.createCell(3).setCellValue("Recently Repo");
                header.createCell(4).setCellValue("URL");

                Row row = sheet.createRow(num);

                Cell cellNo = row.createCell(0);
                cellNo.setCellValue(info.getFollowers());

                Cell cellName = row.createCell(1);
                cellName.setCellValue(info.getUserFollowers());

                Cell cellMatric = row.createCell(2);
                cellMatric.setCellValue(info.getRepo());

                Cell cellFollowing = row.createCell(3);
                cellFollowing.setCellValue(info.getSubs());

                Cell cellStar = row.createCell(4);
                cellStar.setCellValue(info.getURL());

                num++;

                if (num==0 && num<2){
                    sheet.autoSizeColumn(num);
                }
            }

            FileOutputStream output = new FileOutputStream(new File("C:\\Assignment1\\Test.xls"));
            workbook.write(output);
            output.close();
            workbook.close();
            System.out.println("Info written!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
