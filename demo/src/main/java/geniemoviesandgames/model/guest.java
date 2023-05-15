package geniemoviesandgames.model;

import java.util.ArrayList;

public class guest extends account{
    protected int itemBorrowAllow =2;
    protected int itemReturnedToPromote =3;
    protected int itemBorrow =0;
    protected int itemReturned=0;
       
    public guest(){
        super();
        itemBorrow=0;
        itemReturned=0;
    }
    public guest(String ID,String name, String address,int phone,ArrayList<item> rentals,String username,String password){
        super(ID, name, address, phone, rentals, username, password);
    }
    public void Customerborrow(item itemIn){

        if(itemIn.getItemCopies() !=0){
            itemIn.setItemCopies(itemIn.getItemCopies()-1);
            customerListofRentals.add(itemIn);
            itemBorrow++;
        }
    }
    public void Customerreturn(item itemIn){
        itemIn.setItemCopies(itemIn.getItemCopies()+1);
        itemReturned++;
        itemBorrow--;
    }
    

    /**
     * @return int itemBorrow return the 
     */
    public int getitemBorrow() {
        return this.itemBorrow;
    }

    /**
     * @param  the  to set
     */
    public void setitemBorrow(int itemBorrow ) {
        this.itemBorrow = itemBorrow ;
    }

    /**
     * @return int return the itemReturned
     */
    public int getItemReturned() {
        return itemReturned;
    }

    /**
     * @param itemReturned the itemReturned to set
     */
    public void setItemReturned(int itemReturned) {
        this.itemReturned = itemReturned;
    }
    
}
