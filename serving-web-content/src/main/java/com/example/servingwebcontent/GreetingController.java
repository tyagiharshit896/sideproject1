package com.example.servingwebcontent;

import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller

public class GreetingController {
	
	  private String firstName;
      private String lastName;
      private String password;
      private String department;
      private String email;
      private int defaultPassLength = 10;
      private int mailboxCapacity = 500;
      private String CS = "emailproject.com";
      private String alternateEmail;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="fname", required=false, defaultValue="World") String fname,@RequestParam(name="lname", required=false, defaultValue="World") String lname,
			@RequestParam(name="departName", required=false, defaultValue="World") String departName, Model model) {
		model.addAttribute("fname", fname);
	    this.firstName = fname;
        this.lastName = lname;

        // calling to setFunction
        this.department = setDepartment(departName);


        // calling password function
        this.password = randomPass(defaultPassLength);
        System.out.println("Your Password is: " + this.password);

        // combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + CS;
		return "greeting";
	}
	// Ask for the department

    private String setDepartment(String departName) {
        System.out.println("New Employees: " + firstName + ",Department Codes:\n1: for Sales\n2: for Development\n ");
        System.out.println("Your department is "+departName);
       
            return departName;
        
    }

    private String randomPass(int length) {
        String pass = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * pass.length());
            password[i] = pass.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String pas) {
        this.password = pas;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "MB";
    }
}
	

