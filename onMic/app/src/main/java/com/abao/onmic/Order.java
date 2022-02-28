package com.abao.onmic;

public class Order {

    public String name, address, phonenumber, itemordered, total, id, time;

    public Order(String name, String address, String phonenumber, String itemordered, String total, String id, String time) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.itemordered = itemordered;
        this.total = total;
        this.id = id;
        this.time = time;
    }

    public Order(){

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getItemordered() {
        return itemordered;
    }

    public String getTotal() {
        return total;
    }

    public String getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

}
