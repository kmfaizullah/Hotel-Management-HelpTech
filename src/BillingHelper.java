/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;


public class BillingHelper {

    private Scanner sc;
    private Scanner scan;
    private String name;
    private String price;
    private String quantity;
    private String fullnames = "";
    private double dPrice;
    private int dQuantity;
    private double multi;
    private PrintWriter pw;
    double total_bill=0;

    public double getTotal_bill() {
        return total_bill;
    }
  

    public BillingHelper() {
        openFile();
        readFile();
        closeFile();
    }

    public String getFullNames() {
        System.out.print(fullnames);
        return fullnames;
    }

    public String getTotal() {

        double totalPrice = 0;

        try {
            scan = new Scanner(new FileInputStream("storage/order.txt"));
            while (scan.hasNextLine()) {
                scan.nextLine();
                scan.nextLine();
                price = scan.nextLine();
                totalPrice += Double.valueOf(price);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return String.valueOf("Total Price is : " + totalPrice);
    }

    private void openFile() {
        try {
            scan = new Scanner(new File("storage/orderLine.txt"));
            System.out.println("File found!");
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }

    private void readFile() {
        try {
            while (scan.hasNextLine()) {
                String n = scan.nextLine();
                String a[]=n.split(",");
                total_bill+= Double.parseDouble(a[3]);
                fullnames+=n+"\n";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void closeFile() {
        scan.close();
    }
}
