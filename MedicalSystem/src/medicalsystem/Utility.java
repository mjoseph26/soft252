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
    
    public static ArrayList<UserAccount> userAccounts = new ArrayList<>();
    
    public static ArrayList<UserAccount> ReadFile()
    {
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
    
    public static void AddToFile(String id,String pass,String name, String lname,String address) throws IOException
    {
        FileWriter fw = new FileWriter("accounts.txt",true);
        fw.write(id+"<>");
        fw.write(pass+"<>");
        fw.write(name+"<>");
        fw.write(lname+"<>");
        fw.write(address+"\n");
        fw.close();
    }
    
    public static void RemoveFromFile() throws IOException
    {
        //Rewrite the file content without the deleted element
        FileWriter fw = new FileWriter("accounts.txt");
        for(UserAccount a : userAccounts)
        {
            fw.write(a.getId()+"<>");
            fw.write(a.getPassword()+"<>");
            fw.write(a.getName()+"<>");
            fw.write(a.getSurname()+"<>");
            fw.write(a.getAddress()+"\n");
        }
        
            fw.close();
        
    }
    
    public static UserAccount currentUser(String id)
    {
        //PASS THE ID ENTERED INTO THE LOG IN FORM
        //FIND THE OBJECT WITH THAT ID AND SET THAT AS THE CURRENT OBJECT
        UserAccount u = null;
        for(int i = 0; i < userAccounts.size();i++)
        {
            System.out.println(userAccounts.get(i).getId());
            if(userAccounts.get(i).getId() == null ? id == null : userAccounts.get(i).getId().equals(id))
            {
                u = Utility.userAccounts.get(i);
            }
        }
        return u;
    }


}

    
    

