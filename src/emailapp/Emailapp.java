package emailapp;

import java.util.Scanner;

public class Emailapp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get User Info
        System.out.println("Enter Your First Name: ");
        String fName = scanner.next();
        System.out.println("Enter Your Last Name: ");
        String lName = scanner.next();

        Email em1 = new Email(fName,lName);
        int choice = -1;
        do{
           System.out.println("\n ******** \n Enter your choice\n1.show Info\n2.Change password \n3.Change mailbox capacity \n4.Set Alternate mail\n5.Store data in file \n6.Display data from file \n7.Exit");
           choice = scanner.nextInt();
           switch (choice){
               case 1:
                   em1.getInfo();
                   break;
               case 2:
                   em1.setPassword();
                   break;
               case 3:
                   em1.setMailCap();
                   break;
               case 4:
                   em1.alternateEmail();
                   break;
               case 5:
                   em1.storeFile();
                   break;
               case 6:
                   em1.readFile();
                   break;
               case 7:
                   System.out.println("Thank you for using application");
                   break;
               default:
                   System.out.println("Invalid choice \nEnter proper choice again ");
           }
        }while (choice != 7);
    }
}
