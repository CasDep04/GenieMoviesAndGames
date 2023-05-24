package geniemoviesandgames.backend;

import geniemoviesandgames.model.product.item;
import geniemoviesandgames.model.user.VipAccount;
import geniemoviesandgames.model.user.account;
import geniemoviesandgames.model.user.guestAccount;
import geniemoviesandgames.model.user.regularAccount;

public class returning {

    public static account accReturn(account accIn, item itemIn) {
        
        if(accIn instanceof guestAccount){
            guestAccount accReturn = (guestAccount) accIn;
            if (accReturn.getListOfRentals().contains(itemIn)) {
                itemIn.returnItem();
                accReturn.accReturnItem(itemIn);
                // Check if guest customer is eligible for promotion to regular customer
                if (accReturn.getItemReturned() >= 3) {
                    accReturn.setPromoteReady(true);
                }
                mainSystem.updateAccount(accIn, accReturn);
                return accReturn;
            } else {
                System.out.println("Item " + itemIn.getTitle() + " is not currently rented by the guest account.");
                return null;
            }
        }else if(accIn instanceof regularAccount){

            regularAccount accReturn = (regularAccount) accIn;
            if (accReturn.getListOfRentals().contains(itemIn)) {
                itemIn.returnItem();
                accReturn.accReturnItem(itemIn);
    
                // Check if regular customer is eligible for promotion to VIP customer
                if (accReturn.getItemReturned() > 5) {
                    accReturn.setPromoteReady(true);
                }
                mainSystem.updateAccount(accIn, accReturn);
                return accReturn;
            } else {
                System.out.println("Item " + itemIn.getID() + " is not currently rented by the regular account.");
                return null;
            }
        }else{
            VipAccount accReturn = (VipAccount) accIn;
            if (accIn.getListOfRentals().contains(itemIn)) {
                itemIn.returnItem();
                accReturn.accReturnItem(itemIn);;
                mainSystem.updateAccount(accIn, accReturn);
                return accReturn;
            } else {
                System.out.println("Item " + itemIn.getID() + " is not currently rented by the VIP account.");
                return null;
            }
        }       
    }        
}
