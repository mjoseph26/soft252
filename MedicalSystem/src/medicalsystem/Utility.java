/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicalsystem;

import admin.Admin;
import doctor.Doctor;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import patient.Patient;

/**
 *
 * @author mjose
 */
public class Utility {

    
   

    public static ArrayList<UserAccount> ReadFile() {
        
        ArrayList<UserAccount> userAccounts = new ArrayList<>();

        try {
            FileReader fr = new FileReader("accounts.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] account = line.split(",");
                String id = account[0];
                String password = account[1];
                String name = account[2];
                String surname = account[3];
                String address = account[4];
                String age = "";
                String gender = "";
                
                if(id.startsWith("P")){
                    gender = account[5];
                    age = account[6];
                    UserAccount user = new Patient(id,password,name,surname,address,gender,age);
                    userAccounts.add(user);
                }

                if (id.startsWith("A")) {
                    UserAccount user = new Admin(id, password, name, surname, address);
                    userAccounts.add(user);
                }
                if (id.startsWith("D")) {
                    UserAccount user = new Doctor(id, password, name, surname, address);
                    userAccounts.add(user);
                }
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return userAccounts;
    }



//P,P,P,P,P,P,P
//1
//05/07/2019
//ill
//paracetamol
//Doctor D
//3.5
////Good Doctor
//        }
//
//    }

    public static void AddToFile(String id, String pass, String name, String lname, String address) throws IOException {
        FileWriter fw = new FileWriter("accounts.txt", true);
        fw.write(id + ",");
        fw.write(pass + ",");
        fw.write(name + ",");
        fw.write(lname + ",");
        fw.write(address + "\n");
        fw.close();
    }

    public static void AddToFile(String id, String pass, String name, String lname, String address, String gender, String age) throws IOException {
        FileWriter fw = new FileWriter("accounts.txt", true);
        fw.write(id + ",");
        fw.write(pass + ",");
        fw.write(name + ",");
        fw.write(lname + ",");
        fw.write(address + ",");
        fw.write(gender + ",");
        fw.write(age + "\n");
        fw.close();
    }
    
    public static void writeToFile(ArrayList<UserAccount> users)
    {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("accounts.txt"));
            for(UserAccount u: users)
            {
                writer.write(u.getId()+","+u.getPassword()+","+u.getName()+","+u.getSurname()+","+u.getAddress());
                writer.newLine();
            }
            writer.close();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static void removeFromFile(String uId)
    {
        ArrayList <UserAccount> users = Utility.ReadFile();
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).getId().equals(uId))
            {
                users.remove(i);
                writeToFile(users);
            }
        }
        
        
                //Rewrite the file content without the deleted element
        
//        catch(Exception e)
//        {
//            
//        }
////        try 
////        {
////            FileWriter fw = new FileWriter("accounts.txt");
////            BufferedWriter bw = new BufferedWriter(fw);
////            PrintWriter pw = new PrintWriter(bw);
////            
////            ArrayList<UserAccount> users = ReadFile();
////            UserAccount userDelete = null;
////            
////            for(int i =0; i <users.size();i++)
////            {
////                if(users.get(i).getId().equals(uId))
////                {
////                    userDelete = users.get(i);
////                    
////                }
////            }
////            users.remove(userDelete);
////            
////            for(UserAccount u:users)
////            {
////                System.out.println(u.getId());
////                pw.println(u.getId()+","+u.getPassword()+","+u.getName()+","+u.getSurname()+","+u.getAddress());
////            }
////            
////            pw.flush();
////            pw.close();
//            
//        }
//        catch(Exception e)
//        {
//            System.out.println(e);
//        }
    }

    

        
       

    



    public static void viewArrayList(ArrayList<UserAccount> a) {
        for (UserAccount b : a) {
            System.out.println(b.getId());
        }

    }

}
