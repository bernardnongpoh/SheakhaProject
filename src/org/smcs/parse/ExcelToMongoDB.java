/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.smcs.parse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author bernard
 */
public class ExcelToMongoDB{
    
   public static void main(String[] args) throws FileNotFoundException, IOException{
       /**
        * Connect to MongoDB DataBase
        * 
        */
       
        MongoClient mongoclient=new MongoClient("localhost", 27017);
        
        DB db=mongoclient.getDB("schoolDB");

        DBCollection coll = db.getCollection("schoolDataSet");
       
       
       
       
       FileInputStream file = new FileInputStream(new File("Z://project//ProjectWork//SchoolVisualization//dataset/data.xls"));
       Workbook workbook= new HSSFWorkbook(file);
       Sheet sheet= workbook.getSheetAt(0);
       
      //Sheet Iterator
       Iterator<Row> rowIterator=sheet.iterator();
       
      
       
       while(rowIterator.hasNext()){
           
           //Declare Temporary Variable 
           
           String school_name="",
                  vill_name="",
                   block_name="",
                   district_name="",
                   
                   region="",
                   school_category="",
                   school_management="";
                   
                   
           int year_estd=0,pincode=0,
                   year_recognized=0;
                   
           
           
           
           
           Row row=rowIterator.next();
           
           Iterator<Cell> cellIterator=row.iterator();
           
           
           while(cellIterator.hasNext()){
               
               Cell cell=cellIterator.next();
                System.out.println(cell.getColumnIndex());
                int value=cell.getColumnIndex();
                
                
                
                switch(value){
                
                    case 0:
                            district_name=cell.getStringCellValue();
                            break;
                    case 1: 
                            block_name=cell.getStringCellValue();
                            break;
                    case 2:
                            vill_name=cell.getStringCellValue();
                            break;
                    case 3:
                            school_name=cell.getStringCellValue();
                            break;
                    case 4:
                            school_management=cell.getStringCellValue();
                            break;
                    case 5: 
                            school_category=cell.getStringCellValue();
                            break;
                    case 6: 
                            region=cell.getStringCellValue();
                            break;
                    case 7: 
                            pincode=(int)cell.getNumericCellValue();
                            break;
                    case 8:
                            year_estd=(int)cell.getNumericCellValue();
                            break;
                    case 9:
                            if(Cell.CELL_TYPE_STRING==cell.getCellType())
                            {
                            year_recognized=0;
                            }
                            else{
                            year_recognized=(int)cell.getNumericCellValue();
                            }
                            break;
                        
                            
                
               
           }
       
       }
           System.out.println("\n________________________________________________\n");
           
           
           //Insert into MongoDB dataBase
           
            BasicDBObject address = new BasicDBObject("school_name", school_name)
                .append("vill_name",vill_name)
                .append("block_name",block_name)
                .append("district_name", district_name)
                .append("pin_code",pincode);
        
        BasicDBObject coordinate=new BasicDBObject("longitude","0")
                .append("latitude","0");
        
        
        
        
        
        BasicDBObject document = new BasicDBObject("address",address)
        .append("coordinate", coordinate)
        .append("region", region)
        .append("school_category",school_category)
        .append("school_management",school_management)
        .append("year_estd",year_estd)
        .append("year_recognized",year_recognized);
           
           
           
           
           
           //End of Insertion
           
           
           coll.insert(document);
           
           
           
           
           
           
           //System.out.println(district_name + "\n" +block_name+ "\n" + vill_name+ "\n" + school_name + "\n" + school_management + "\n"+ school_category + "\n"+ region + "\n" + pincode +"\n" + year_estd + "\n" + year_recognized );
       
       
       }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
   }
    
    
}