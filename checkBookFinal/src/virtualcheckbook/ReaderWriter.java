/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualcheckbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JimmyWebb
 */
public class ReaderWriter {
    
    
    public void writeToFile() throws IOException{        
        File file = new File("abstractData.txt");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
        
        for(int i = 0; i < JTableGUI.model.getRowCount();){
            
            String cellValue0 = (String) JTableGUI.model.getValueAt(i, 0);
            String cellValue1 = (String) JTableGUI.model.getValueAt(i, 1);
            Double cellValue2 =  (Double) JTableGUI.model.getValueAt(i, 2);
            Date cellValue3 = (Date) JTableGUI.model.getValueAt(i, 3);
            Integer cellValue4 = (Integer) JTableGUI.model.getValueAt(i, 4);
            
            out.write(cellValue0 + " fish! " + cellValue1 + " fish! " + cellValue2 + " fish! " + cellValue3 + " fish! " + cellValue4 + " fish! ");
            i++;
        }
        out.close();

    }
    
    public void readFromFile(){
                                          //String name, String type, Double amnt, Date date, Integer randomID
        try {
            File file = new File("abstractData.txt");
            Scanner scanner = new Scanner(file).useDelimiter("\\s*fish!\\s*");
            while (scanner.hasNext()) {
                String name = scanner.next();
                String type = scanner.next();
                String amntString = scanner.next();
                    Double amnt = Double.parseDouble(amntString);
                
                String dateString = scanner.next();
                    long dateLong = Date.parse(dateString);
                    Date date = new Date(dateLong);
                
                String randomIDString = scanner.next();
                    Integer randomID = Integer.parseInt(randomIDString);
                
                
                
                JTableGUI.transaction(name, type, amnt, date, randomID);
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
