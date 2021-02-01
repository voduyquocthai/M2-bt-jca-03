package com.quocthai;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    List<Customer> customers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void inputCustomerInfo() {
        System.out.println("-----------------------------");
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập mã số khách hàng: ");
        String identity = scanner.nextLine();
        System.out.println("Nhập số công tơ điện cuối kì trước: ");
        int previousElectricMeterReading = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số công tơ điện hiện tại: ");
        int currentElectricMeterReading = Integer.parseInt(scanner.nextLine());
        Invoice invoice = new Invoice(identity, previousElectricMeterReading, currentElectricMeterReading);
        Customer customer = new Customer(invoice, name, address);
        customers.add(customer);
    }

    public void showCustomerInfo(Customer customer) {
        String showCustomerInfo = "Tên: " + customer.getName();
        showCustomerInfo += "\tĐịa chỉ: " + customer.getAddress();
        showCustomerInfo += "\tMã khách hàng: " + customer.getIdentity();
        showCustomerInfo += "\tSố công tơ điện cuối kì trước: " + customer.invoice.getPreviousElectricMeterReading();
        showCustomerInfo += "\tSố công tơ điện hiện tại: " + customer.invoice.getCurrentElectricMeterReading();
        System.out.println(showCustomerInfo);
    }

    public void deleteCustomer(Customer customer) {
        customers.remove(customer);
    }

    public void addMultiCustomer() {
        System.out.println("Nhập vào số lượng khách hàng mà bạn muốn thêm: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            this.inputCustomerInfo();
        }
    }

    public void showListCustomer() {
        for (Customer customer : customers) {
            showCustomerInfo(customer);
        }
    }

    public int findCustomerById(String identity) {
        int index = -1;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getIdentity().equals(identity)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateCustomerInfo(String identity, String name, String address){
        int index = findCustomerById(identity);
        customers.get(index).setName(name);
        customers.get(index).setAddress(address);
    }

    public void updateInvoiceInfo(String identity, int previousElectricMeterReading, int currentElectricMeterReading ){
        int index = findCustomerById(identity);
        customers.get(index).invoice.setPreviousElectricMeterReading(previousElectricMeterReading);
        customers.get(index).invoice.setCurrentElectricMeterReading(currentElectricMeterReading);
    }

    public double totalMoney(String identity){
        int index = findCustomerById(identity);
        double money = 0;
        if (index == -1){
            return money;
        }
        int current = customers.get(index).invoice.getCurrentElectricMeterReading();
        int previous = customers.get(index).invoice.getPreviousElectricMeterReading();
        money = (current - previous) * 750;
        return money;
    }
}
