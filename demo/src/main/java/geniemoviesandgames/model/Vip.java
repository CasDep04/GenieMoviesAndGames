package geniemoviesandgames.model;

import java.util.ArrayList;

public class Vip extends guest{
    private int freeRent=0;
    private int pointRewards=0;
    final int pointRewardsForfreeRent =100;
    final int pointRewardsEachReturn =10;
    
    /**
     * @return int return the freeRent
     */
    public int getFreeRent() {
        return freeRent;
    }

    /**
     * @param freeRent the freeRent to set
     */
    public void setFreeRent(int freeRent) {
        this.freeRent = freeRent;
    }

    /**
     * @return int return the pointRewards
     */
    public int getPointRewards() {
        return pointRewards;
    }

    /**
     * @param pointRewards the pointRewards to set
     */
    public void setPointRewards(int pointRewards) {
        this.pointRewards = pointRewards;
    }
    public Vip(){
        super();
    }
    public Vip(String ID,String name, String address,int phone,ArrayList<item> rentals,String username,String password){
        super(ID, name, address, phone, rentals, username, password);
    }
    public Vip(regular acc){

        setCustomerAddress(acc.getCustomerAddress());
        setCustomerFullname(acc.getCustomerFullname());
        setCustomerID(acc.getCustomerID());
        setCustomerPassWord(acc.getCustomerPassWord());
        setCustomerPhone(acc.getCustomerPhone());
        setCustomerUsername(acc.getCustomerUsername());
        setCustomerListofRentals(acc.getCustomerListofRentals());
        setItemReturned(acc.getItemReturned());
        setitemBorrow(acc.getitemBorrow());
        setFreeRent(0);
        setPointRewards(0);
    }
}
