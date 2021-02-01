package com.quocthai;

public class Invoice {
    private String identity;

    int previousElectricMeterReading;

    int currentElectricMeterReading;

    public Invoice() {
    }

    public Invoice(String identity, int previousElectricMeterReading, int currentElectricMeterReading) {
        this.identity = identity;
        this.previousElectricMeterReading = previousElectricMeterReading;
        this.currentElectricMeterReading = currentElectricMeterReading;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getPreviousElectricMeterReading() {
        return previousElectricMeterReading;
    }

    public void setPreviousElectricMeterReading(int previousElectricMeterReading) {
        this.previousElectricMeterReading = previousElectricMeterReading;
    }

    public int getCurrentElectricMeterReading() {
        return currentElectricMeterReading;
    }

    public void setCurrentElectricMeterReading(int currentElectricMeterReading) {
        this.currentElectricMeterReading = currentElectricMeterReading;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "identity='" + identity + '\'' +
                ", previousElectricMeterReading=" + previousElectricMeterReading +
                ", currentElectricMeterReading=" + currentElectricMeterReading +
                '}';
    }
}
