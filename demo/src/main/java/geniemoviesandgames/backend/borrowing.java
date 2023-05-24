
package geniemoviesandgames.backend;

import geniemoviesandgames.model.product.item;
import geniemoviesandgames.model.product.item.LoanType;
import geniemoviesandgames.model.user.VipAccount;
import geniemoviesandgames.model.user.account;
import geniemoviesandgames.model.user.guestAccount;
import geniemoviesandgames.model.user.regularAccount;

public class borrowing {

    public static account accBorrow(account accIn, item itemsToBorrow) {
        
        if (accIn instanceof guestAccount){
            guestAccount accOut = (guestAccount) accIn;
            if (itemsToBorrow.getLoantype() == LoanType.TWO_DAY) {
                System.out.println("Guest account cannot borrow 2-day items.");
                return null;
            }else if(accOut.getItemBorrow() + 1 > 2){
                System.out.println("Guest account can only rent a maximum of 2 items at a time.");
                return null;
            }

            if (itemsToBorrow.getStock() > 0) {
                itemsToBorrow.borrowItem();
                accOut.accBorrowItem(itemsToBorrow);
                mainSystem.updateAccount(accIn, accOut);
                return accOut;
            } else {
                System.out.println("Item " + itemsToBorrow.getTitle() + " is out of stock.");
                return null;
            }
        } else if(accIn instanceof regularAccount){
            regularAccount accOut = (regularAccount) accIn;

            if (itemsToBorrow.getStock() > 0) {
                itemsToBorrow.borrowItem();
                accOut.accBorrowItem(itemsToBorrow);
                mainSystem.updateAccount(accIn, accOut);
                return accOut;
            } else {
                System.out.println("Item " + itemsToBorrow.getTitle() + " is out of stock.");
                return null;
            }
        }else {
            VipAccount accOut = (VipAccount) accIn;

            if (itemsToBorrow.getStock() > 0) {
                itemsToBorrow.borrowItem();
                accOut.accBorrowItem(itemsToBorrow);
                mainSystem.updateAccount(accIn, accOut);
                return accOut;
            } else {
                System.out.println("Item " + itemsToBorrow.getTitle() + " is out of stock.");
                return null;
            }
        } 

    }

}

