package geniemoviesandgames.model;

import java.time.LocalDate;

import geniemoviesandgames.model.product.item;
import geniemoviesandgames.model.product.item.LoanType;
import geniemoviesandgames.model.user.account;

public class returnCheck {


    public enum deadLine{
        LATE,EARLY,ON_TIME,
    }
    protected deadLine userDeadline;
    protected LocalDate dateBorrow;
    protected LocalDate dateReturn;
    
    public LocalDate getDateBorrow(){
        return dateBorrow;
    }
    public void setDateBorrow(LocalDate date){
        dateBorrow = date;
    }

    public LocalDate getDateReturn(){
        return dateReturn;
    }
    public void setDateReturn(LocalDate date){
        dateReturn = date;
    }

    public deadLine getUserDeadline(){
        return userDeadline;
    }
    public void setUserDeadline(deadLine userDeadLine){
        this.userDeadline = userDeadLine;
    }
    
    public returnCheck(account accIn, item itemIn) {
        if(accIn.getListOfRentals().contains(itemIn)){
            int a = accIn.getListOfRentals().indexOf(itemIn);
            setDateBorrow(accIn.getListOfDates().get(a));
            if (itemIn.getLoantype() == LoanType.ONE_WEEK) {
                setDateReturn(accIn.getListOfDates().get(a).plusDays(7));
            } else if (itemIn.getLoantype() == LoanType.TWO_DAY) {
                setDateReturn(accIn.getListOfDates().get(a).plusDays(2));
            }
            
        }

        int compareValue = dateReturn.compareTo(LocalDate.now());
        if (compareValue > 0) {
            System.out.println("You are early");
            setUserDeadline(deadLine.EARLY);
        } else if (compareValue < 0) {
            System.out.println("You are late");
            setUserDeadline(deadLine.LATE);
        } else {
            System.out.println("You are just on time");
            setUserDeadline(deadLine.ON_TIME);
        }
    }
    
}
