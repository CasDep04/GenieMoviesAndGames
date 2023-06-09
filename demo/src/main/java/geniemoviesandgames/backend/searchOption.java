package geniemoviesandgames.backend;

import geniemoviesandgames.model.product.item;
import geniemoviesandgames.model.user.account;

public class searchOption {
    
    public static item searchItemByID(String id) {
        for (item i : mainSystem.getListOfItems()) {
            if ((i.getID()).equals(id)) {
                return i;
            }
        }
        return null;
    }

    public static account searchAccountByID(String id) {
        for (account a : mainSystem.getListOfAccounts()) {
            if ((a.getID()).equals(id)) {
                return a;
            }
        }
        return null;
    }

    public static item searchItemByTitle(String name) {
        for (item i : mainSystem.getListOfItems()) {
            if ((i.getTitle()).equals(name)) {
                return i;
            }
        }
        return null;
    }

    public static account searchAccountByName(String name) {
        for (account a : mainSystem.getListOfAccounts()) {
            if ((a.getFullname()).equals(name)) {
                return a;
            }
        }
        return null;
    }
}
