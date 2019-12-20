/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicalsystem;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author mjose
 */
public class Utility {
    
    public ArrayList<UserAccount> ReadFile()
    {
        ArrayList<UserAccount> userAccounts = new ArrayList<>();
        
        try 
        {
            FileReader fileReader = new FileReader("accounts.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            
            while((line = bufferedReader.readLine()) != null)
            {
                String[] accounts = line.split("<>");
                String id = accounts[0];
                String password = accounts[1];
                String name = accounts[2];
                String surname = accounts[3];
                String address = accounts[4];
                UserAccount user = new UserAccount(id,password,name,surname,address);
                userAccounts.add(user);
            }
        } catch (FileNotFoundException e) 
        {
           e.printStackTrace();
        } catch (IOException e) 
        {
           e.printStackTrace();
        }
        return userAccounts;
    }
    
    public void WriteFile()
    {
        
        
        
    }
    
}
