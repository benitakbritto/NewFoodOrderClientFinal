package com.example.android.newfoodorderclient;

public class Bill {
    String itemname,itemprice;

    public Bill(){

    }

    public Bill(String itemname, String itemprice )
    {
        this.itemname = itemname;
        this.itemprice = itemprice;
    }


    public String getItemname(){
        return itemname;
    }

    public String getItemprice(){
        return itemprice;
    }


    public void setItemname(String itemname)
    {
        this.itemname = itemname;

    }


    public void setItemprice(String itemprice)
    {
        this.itemprice = itemprice;

    }



}
