/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicalsystem;

import java.io.*;

/**
 *
 * @author mjose
 */
public class Utility {
    
    public void ReadFile()
    {
        
        try 
        {
            FileReader fileReader = new FileReader("accounts.json");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            
            while((line = bufferedReader.readLine()) != null)
            {
                
            }
        } catch (FileNotFoundException e) 
        {
           e.printStackTrace();
        } catch (IOException e) 
        {
           e.printStackTrace();
        }
    }
    
    public void WriteFile()
    {
        
        
        
    }
    
}
