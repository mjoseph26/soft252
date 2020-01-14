/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicalsystem;

import java.util.ArrayList;

/**
 *
 * @author mjose
 */
public class UserAccount {
    
    private String id;
    private String password;
    private String name;
    private String surname;
    private String address;

    public UserAccount(String id, String password, String name, String surname, String address) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
    }
    
//generate userId when account is created
    //to create account take in values from text box. The id is the username and the password;
    //this should only be done by the administrator.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public static boolean checkDetails(String username, String password)
    {
        ArrayList<UserAccount> list = Utility.ReadFile();
        boolean correct = false;
        for(int i = 0; i < list.size();i++)
        {
            if((list.get(i).getId() == username)&&(list.get(i).getPassword()== password))
            {
                correct = true;
            }
        }
        
            return correct;
    }
    
}
