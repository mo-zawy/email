package emailapp;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Email {
    public Scanner scanner = new Scanner(System.in);

    // variables (Encapsulation)

    private String fName;
    private String lName;
    private String department;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alterEmail;

    public Email(String fName , String lName ){
        this.fName = fName;
        this.lName = lName;
        System.out.println("New Employee: "+fName + " " + lName);
        // Colling methods
        this.department = this.setDepartment(); // add department
        this.password = this.generatePassword(8);
        this.email = this.generateEmail();

    }

    // Generate email method
    private String generateEmail(){
        return this.fName.toLowerCase() +
                "." + this.lName.toLowerCase() +
                "@" + this.department.toLowerCase() +
                ".company.com";
    }

    // Asking for department
    private String setDepartment(){
        System.out.println("Department codes \n 1 for sales \n 2 for Development \n 3 for Accounting \n 0 for none");
        boolean flag = false;
        do{
            System.out.println("Enter Department code");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    return "Sales";
                case 2:
                    return  "Development";
                case 3:
                    return  "Accounting";
                case 0:
                    return "None";
                default:
                    System.out.println("Invalid choice please choose it again!");
            }
        }while (!flag);

        return null;
    }

    // generate random password
    private String generatePassword(int length){
        Random random = new Random();
        String capitalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallChars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String sympols = "!@#$%^&*()_+?>";
        String values = capitalChars + smallChars + numbers + sympols;

        String password = "";

        for( int i = 0 ; i<length;i++){
            password = password + values.charAt(random.nextInt(values.length()));
        }
        return password;
    }

    // change password
    public void setPassword(){
        boolean flag = false;
        do {
            System.out.println("Do you want to change your password? (Y?N)");
            char choice = scanner.next().toLowerCase().charAt(0);
            switch (choice){
                case 'y':
                    flag = true;
                    System.out.println("Enter current password: ");
                    String temp = scanner.next();
                    if(temp.equals(this.password)){
                        System.out.println("Enter new password:");
                        this.password = scanner.next();
                        System.out.println("Password changed successfully");
                    }else {
                        System.out.println("Incorrect password");
                    }
                    break;
                case 'n':
                    flag = true;
                    System.out.println("Password changed option cancelled!");
                    break;
                default:
                    System.out.println(("Enter valid choice"));
            }
        }while (!flag);
    }

    // set mailbox capacity method
    public void setMailCap(){
        System.out.println("Current capacity = " + this.mailCapacity + " mb");
        System.out.println("Enter new mailbox capacity:");
        this.mailCapacity = scanner.nextInt();
        System.out.println("Mailbox capacity is successfully changed");
    }

    // set alternate mail
    public void alternateEmail(){
        System.out.println("Enter new alternate mail: ");
        this.alterEmail = scanner.next();
        System.out.println("Alternate email is set");
    }

    // display user information method
    public void getInfo(){
        System.out.println("New: "+ this.fName + " " + this.lName);
        System.out.println("Department: "+ this.department);
        System.out.println("Email: "+this.email);
        System.out.println("Password: "+this.password);
        System.out.println("mailbox capacity: "+this.mailCapacity+ " md");
        System.out.println("Alternate mail: "+this.alterEmail);
    }

    // Store in file
    public void storeFile(){
        try {
            FileWriter in = new FileWriter("E:\\20java\\Email\\info.txt");
            in.write("First name: " + this.fName);
            in.append("\nLast name: "+this.lName);
            in.append("\nEmail: "+this.email);
            in.append("\nPassword: "+this.password);
            in.append("\nCapacity: "+this.mailCapacity);
            in.append("\nAlternate mail: "+this.alterEmail);
            in.close();
            System.out.println("Data Stored..");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    // Reading file method
    public void readFile(){
        try {
            FileReader file = new FileReader("E:\\20java\\Email\\info.txt");
            int i;
            while((i = file.read()) != -1){
                System.out.print((char) i);
            }
            System.out.println();
            file.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
