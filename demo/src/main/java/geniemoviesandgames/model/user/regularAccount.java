package geniemoviesandgames.model.user;

import java.time.LocalDate;
import java.util.ArrayList;

import geniemoviesandgames.model.product.item;

public class regularAccount extends account {

    protected boolean promoteReady = false;

    public regularAccount(String ID, String name, String address, String phone, ArrayList<item> rentals,
            ArrayList<LocalDate> date, String username, String password,int numReturned) {
        super(ID, name, address, phone, rentals, date, LevelOfServices.Regular, username, password,numReturned);
    }

    public void setPromoteReady(boolean ready){
        promoteReady = ready;
    }
    public Boolean getPromoteReady(){
        return promoteReady;
    }
}
