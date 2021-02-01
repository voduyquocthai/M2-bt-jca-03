package com.quocthai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("----------------------------------");
            System.out.println("Enter the number of your selection");
            System.out.println("1.Multi-Adding Customer");
            System.out.println("2.Display All");
            System.out.println("3.Delete");
            System.out.println("4.Search");
            System.out.println("5.Billing");
            System.out.println("6.Update Customer's Info");
            System.out.println("7.Update Customer's Invoice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    program.addMultiCustomer();
                    program.showListCustomer();
                    break;
                case 2:
                    program.showListCustomer();
                    break;
                case 3:
                    System.out.println("Enter customer's identity: ");
                    String identity = scanner.nextLine();
                    int index = program.findCustomerById(identity);
                    program.deleteCustomer(program.customers.get(index));
                    break;
                case 4:
                    System.out.println("Enter customer's identity: ");
                    identity = scanner.nextLine();
                    index = program.findCustomerById(identity);
                    program.showCustomerInfo(program.customers.get(index));
                    break;
                case 5:
                    System.out.println("Enter customer's identity: ");
                    identity = scanner.nextLine();
                    double money = program.totalMoney(identity);
                    System.out.println("Tổng tiền điện cần thanh toán của kháng hàng: "
                            + program.customers.get(program.findCustomerById(identity)).getName()
                            + "là: " + money) ;
                    break;
                case 6:
                    System.out.println("Enter customer's identity: ");
                    identity = scanner.nextLine();
                    System.out.println("Enter updated customer's name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter updated customer's address: ");
                    String address = scanner.nextLine();
                    program.updateCustomerInfo(identity, name, address);
                    program.showCustomerInfo(program.customers.get(program.findCustomerById(identity)));
                    break;
                case 7:
                    System.out.println("Enter customer's identity: ");
                    identity = scanner.nextLine();
                    System.out.println("Enter updated previous electric meter reading: ");
                    int previous = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter updated current electric meter reading: ");
                    int current = Integer.parseInt(scanner.nextLine());
                    index = program.findCustomerById(identity);
                    program.customers.get(index).invoice.setPreviousElectricMeterReading(previous);
                    program.customers.get(index).invoice.setCurrentElectricMeterReading(current);
                    System.out.println("Updated " + program.customers.get(index).invoice.toString());
                    break;
            }
        }
        while (true);
    }
}
