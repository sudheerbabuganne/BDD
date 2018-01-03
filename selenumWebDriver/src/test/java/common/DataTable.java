package common;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataTable 
{
	
	public FileInputStream fis=null;
	
	public XSSFWorkbook workbook=null;
	
	public XSSFSheet sheet=null;
	
	public XSSFRow row=null;
	
	public XSSFCell cell=null;
	
	public DataTable(String filename) throws IOException
	{
		fis=new FileInputStream(System.getProperty("user.dir")+"//Data//"+filename);
		
		workbook=new XSSFWorkbook(fis);
		
		fis.close();
		
	}
	
	
	public String getcelldata(String sheetName,String columnName,int rowNumber)
	{
		try
		{
			int columnNumber=-1;
			
			sheet=workbook.getSheet(sheetName);
			
			row=sheet.getRow(0);
			
			
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().trim().equals(columnName))
				
				columnNumber=i;
			}
			
			
			row=sheet.getRow(rowNumber-1);
			
			cell=row.getCell(columnNumber);
			
			return cell.getStringCellValue();
						
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			return "CoulumnName "+ columnName +"Not found";
			
		}
		
	}
	
	public String getCellData(String sheetName,int columnNumber,int rowNumber)
	{
		
		try
		{
			sheet=workbook.getSheet(sheetName);
			
			row=sheet.getRow(0);
			
			cell=row.getCell(columnNumber);
			
			return cell.getStringCellValue();
		}
		
		catch (Exception e) 
		{
			// TODO: handle exception
			
			e.printStackTrace();
			
			return "column Number"+ columnNumber+" not found";
		}
				
	}
}
	


