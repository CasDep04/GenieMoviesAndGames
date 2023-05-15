package geniemoviesandgames.model;

import java.util.ArrayList;

public class regular extends guest{

    
    int itemReturnedToPromote =5;
    public regular(){
        super();
    }
    public regular(String ID,String name, String address,int phone,ArrayList<item> rentals,String username,String password){
        super(ID, name, address, phone, rentals, username, password);
    }
    
    
    public regular(guest acc){
        setCustomerAddress(acc.getCustomerAddress());
        setCustomerFullname(acc.getCustomerFullname());
        setCustomerID(acc.getCustomerID());
        setCustomerPassWord(acc.getCustomerPassWord());
        setCustomerPhone(acc.getCustomerPhone());
        setCustomerUsername(acc.getCustomerUsername());
        setCustomerListofRentals(acc.getCustomerListofRentals());
        setItemReturned(acc.getItemReturned());
        setitemBorrow(acc.getitemBorrow());
    } 
}
