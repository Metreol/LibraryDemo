package com.library;

public class ElectronicDevice {
    private String deviceType;
    private String location;
    private Member member;

    public ElectronicDevice(String deviceType, String location) {
        this.deviceType = deviceType; // Shouldn't be changed after instantiation.
        this.location = location;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Member getUser() {
        return member;
    }

    public void setUser(Member member) {
        this.member = member;
    }

    public boolean isAvailable() {
        return member == null;
    }

    public void printDetails() {
        String memStr = (member == null) ? "Device is Available!" : String.format("Member: %s", member);
        System.out.println(String.format("Device Type: %s%nLocation: %s%n%s", deviceType, location, memStr));
    }
    
}
