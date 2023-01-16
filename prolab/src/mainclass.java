import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class mainclass {

    public static void method(String path) throws IOException{
        File file = new File(path); // creating a new file instance
        FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
        // creating Workbook instance that refers to .xlsx file
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0); // creating a Sheet object to retrieve object
        Iterator<Row> iterator = sheet.iterator(); // iterating over excel file
        while (iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                switch (cell.getCellType()){  
                    case Cell.CELL_TYPE_STRING:    //field that represents string cell type  
                        hider(cell.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type 
                        if(cell.getNumericCellValue()<250)
                            hider(String.valueOf(cell.getNumericCellValue()));
                        else{
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");    
                            hider(sdf.format(cell.getDateCellValue()));
                        }
                        break;
                    default:
                        hider(null);
                        break;
                    } 
                
                }
            }
        workbook.close();
    }
    
    static List<String> mylist = new ArrayList<>();
    
    public static void hider(String string){
        mylist.add(string);
    }
    
   
    public static void main(String args[]) throws IOException, ParseException{
        Scanner scanner = new Scanner(System.in,"ISO-8859-9");
        method("YOUR PATH");
        int a=mylist.size();
        int i=0;
        List<person> anything = new ArrayList<person>();
        while(a>i){
            if(i%12==0) 
                System.out.println();
            System.out.print(mylist.get(i)+"\t");
            i++;
        }
        i=12;
        while(a>i){
            if(i%12==0) {
                if(mylist.get(i)==null&&mylist.get(i+1)==null)break;
                person kisi=new person(mylist.get(i),mylist.get(i+1),mylist.get(i+2),mylist.get(i+3),mylist.get(i+4),mylist.get(i+5),mylist.get(i+6),mylist.get(i+7),mylist.get(i+8),mylist.get(i+9),mylist.get(i+10),mylist.get(i+11));
                anything.add(kisi);
            }
            i+=12;
        }
        i=2;
        person erkek=new person();
        tree tree=new tree();

        tree.insertfm(anything.get(0),anything.get(1));
        while(anything.size()>i){
            erkek=anything.get(i);
            tree.insert(erkek);
            i++;
        }
        System.out.println();
        tree.print();
        System.out.println("----------------");
        tree.deepfa(250);
        System.out.println("-------1.ister:---------");
        tree.sortage();
        System.out.println("-------3. ister:---------");
        tree.searchblood("A(");
        System.out.println("---------4.ister-------");
        i=2;
        while(anything.size()>i){
            erkek=anything.get(i);
            if(erkek.job!=null){
                tree.searchjob(erkek);
            }
            i++;
        }
        System.out.println("-------5.ister---------");
        i=0;
        while(anything.size()>i){
            erkek=anything.get(i);
            tree.searchsamename(erkek);
            i++;
        }
        /*
        System.out.println("-------6.ister---------");
        String name1=scanner.nextLine();
        String name2=scanner.nextLine();
        List<erkek> find_person = new ArrayList<erkek>();
        i=0;
        while(anything.size()>i){
            String gecici=anything.get(i).namesurname();
           // System.out.println(gecici);
            if(gecici.contains(name1)||gecici.contains(name2))
                find_person.add(anything.get(i));
            i++;
        }
        SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
        Date date1=format.parse(find_person.get(0).date);
        Date date2=format.parse(find_person.get(1).date);
        System.out.println(date1+" "+find_person.get(0).name);
        System.out.println(date2+" "+find_person.get(1).name);
        if(date1.after(date2))
            tree.howclose(find_person.get(1),find_person.get(0),3);
        else    
            tree.howclose(find_person.get(0), find_person.get(1),3);
        
            */
        
        System.out.println("-------8.ister---------");
        tree.howmuchfamily();   
        System.out.println("-------9.ister---------");
        System.out.println("isim:");
        String name3=scanner.nextLine();
        System.out.println("soy isim:");
        String lastname = scanner.nextLine();
        name3=name3+" "+lastname;
        person erkek3=new person();
        i=0;
        while(anything.size()>i){
            String gecici=anything.get(i).namesurname();
            if(gecici.equals(name3))
                erkek3=anything.get(i);
            i++;
        }
        int max = tree.howmuchfamilyaftername(erkek3,5);
        System.out.println(erkek3.name+" "+erkek3.sname+" dan sonra gelen nesil sayısı: "+max);
        
    }
}
