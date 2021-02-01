package com.quocthai;

public class Customer {
    public Invoice invoice;
    private String name;
    private  String address;
    private String identity;

    public Customer() {
    }

    public Customer(Invoice invoice, String name, String address) {
        this.invoice = invoice;
        this.name = name;
        this.address = address;
        this.identity = this.invoice.getIdentity();
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

}
