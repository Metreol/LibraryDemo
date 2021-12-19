package com.library;

import java.util.List;

public class EBook extends Book {
    List<ElectronicDevice> devices;

    public EBook(String title, String author, String isbn, List<ElectronicDevice> devices) {
        super(title, author, isbn);
        this.devices = devices;
    }

    public List<ElectronicDevice> getDevices() {
        return devices;
    }

    public void addDevice(ElectronicDevice newDevice) {
        devices.add(newDevice);
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println("Available on the following devices:");
        for (ElectronicDevice device : devices) {
            device.printDetails();
        }
    }
}
