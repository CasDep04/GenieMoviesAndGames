package geniemoviesandgames.model.account;

import java.util.ArrayList;

import geniemoviesandgames.backend.promote;
import geniemoviesandgames.model.item.item;

public class guestAccount extends account{

    protected int itemBorrowAllow =2;
    protected int itemReturnedToPromote =3;
    
    public guestAccount(String ID,String name, String address,int phone,ArrayList<item> rentals,String username,String password){
        super(ID, name, address, phone, rentals,LevelOfServices.Guest, username, password);
    }

    public void CustomerBorrow(item itemIn) {
        if(itemBorrow <= itemBorrowAllow){
            itemIn.borrowItem();
            if (itemIn.getItemStock() != 0) {
                itemIn.setItemStock(itemIn.getItemStock() - 1);
                accountListOfRentals.add(itemIn);
                itemBorrow++;
            }
        }

    }

    public void CustomerReturn(item itemIn) {
        itemIn.returnItem();
        itemIn.setItemStock(itemIn.getItemStock() + 1);
        itemReturned++;
        itemBorrow--;
        if(itemReturned==itemReturnedToPromote){
            promote.guestToRegular(this);
        }
    }
}