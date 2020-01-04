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
    
        public static ArrayList<ArrayList<String>> readAppointments()
    {
        ArrayList<ArrayList<String>> appointments = new ArrayList<ArrayList<String>>();
        
        try {
            FileReader fr = new FileReader("appointments.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            String patient = "";
            while ((line = br.readLine()) != null) {
                String[] account = line.split(",");
                String date = account[0];
                String doctor = account[1];
                patient = account[2];
                String notes = account[3];
                String prescription = account[4];
                String rating = account[5];
                String feedback = account[6];
                
                ArrayList<String> info = new ArrayList<>();
                info.add(date);
                info.add(doctor);
                info.add(patient);
                info.add(notes);
                info.add(prescription);
                info.add(rating);
                info.add(feedback);
                appointments.add(info);
            
            
            }
            Patient p = (Patient)Login.getCurrentUser(patient);
            p.setMedicalHistory(appointments);
            
        
    }catch(Exception e)
    {
        System.out.println(e);
    }
        return appointments;

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
        
    }

    

        
       

    



    public static void viewArrayList(ArrayList<UserAccount> a) {
        for (UserAccount b : a) {
            System.out.println(b.getId());
        }

    }

}
