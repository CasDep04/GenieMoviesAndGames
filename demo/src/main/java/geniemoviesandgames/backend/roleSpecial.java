package geniemoviesandgames.backend;

import geniemoviesandgames.model.user.VipAccount;
import geniemoviesandgames.model.user.account;
import geniemoviesandgames.model.user.guestAccount;
import geniemoviesandgames.model.user.regularAccount;

public class roleSpecial {

    public static account promoteAcc(account accIn) {
        if (accIn instanceof regularAccount) {
            VipAccount v1 = new VipAccount(accIn.getID(), accIn.getFullname(), accIn.getAddress(),
                    accIn.getPhone(), accIn.getListOfRentals(), accIn.getListOfDates(), accIn.getUsername(),
                    accIn.getPassword(), 0);

            v1.setItemReturned(0);
            v1.setFreeRent(0);
            v1.setPoints(0);
            mainSystem.updateAccount(accIn, v1);
            return v1;
        } else if (accIn instanceof guestAccount) {
            regularAccount r1 = new regularAccount(accIn.getID(), accIn.getFullname(), accIn.getAddress(),
                    accIn.getPhone(), accIn.getListOfRentals(), accIn.getListOfDates(), accIn.getUsername(),
                    accIn.getPassword(), 0);

            r1.setItemReturned(0);
            r1.setItemBorrow(0);
            r1.setListOfRentals(accIn.getListOfRentals());
            mainSystem.updateAccount(accIn, r1);
            return r1;
        } else {
            return null;
        }

    }
}
