package geniemoviesandgames.model.user;

import java.time.LocalDate;
import java.util.ArrayList;

import geniemoviesandgames.model.product.item;

public class guestAccount extends account {

    protected boolean promoteReady = false;


    public guestAccount(String ID, String name, String address, String phone, ArrayList<item> rentals,
            ArrayList<LocalDate> date, String username, String password,int numReturned) {
        super(ID, name, address, phone, rentals, date, LevelOfServices.Guest, username, password,numReturned);
    }

    public void setPromoteReady(boolean ready){
        promoteReady = ready;
    }
    public Boolean getPromoteReady(){
        return promoteReady;
    }
}
