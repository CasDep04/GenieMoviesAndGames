package geniemoviesandgames.model;

abstract public class item {

    protected String itemTitle;
    protected String itemID;
    protected int itemCopies;
    protected double itemFees;
    protected Boolean itemStatus;
    protected Boolean item2DayLoan;
    /**
     * @return String return the itemTitle
     */
    public String getItemTitle() {
        return itemTitle;
    }

    /**
     * @param itemTitle the itemTitle to set
     */
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }


    /**
     * @return String return the itemID
     */
    public String getItemID() {
        return itemID;
    }

    /**
     * @param itemID the itemID to set
     */
    public void setItemID(String itemID) {
        this.itemID = itemID;
    }


    /**
     * @return int return the itemCopies
     */
    public int getItemCopies() {
        return itemCopies;
    }

    /**
     * @param itemCopies the itemCopies to set
     */
    public void setItemCopies(int itemCopies) {
        this.itemCopies = itemCopies;
    }

    /**
     * @return int return the itemFees
     */
    public double getItemFees() {
        return itemFees;
    }

    /**
     * @param itemFees the itemFees to set
     */
    public void setItemFees(double itemFees) {
        this.itemFees = itemFees;
    }


    /**
     * @return Boolean return the itemStatus
     */
    public Boolean isItemStatus() {
        return itemStatus;
    }

    /**
     * @param itemStatus the itemStatus to set
     */
    public void setItemStatus(Boolean itemStatus) {
        this.itemStatus = itemStatus;
    }


    /**
     * @return Boolean return the item2DayLoan
     */
    public Boolean isItem2DayLoan() {
        return item2DayLoan;
    }

    /**
     * @param item2DayLoan the item2DayLoan to set
     */
    public void setItem2DayLoan(Boolean item2DayLoan) {
        this.item2DayLoan = item2DayLoan;
    }
    public item(){
        setItemTitle(null);
        setItemID(null);
        setItemStatus(false);
        setItem2DayLoan(false);
        setItemCopies(0);
        setItemFees(0);
    }
    public item(String ID,String title,Boolean item2DayLoan,int copies,Double fees){
        setItemTitle(title);
        setItemID(ID);
        setItemStatus(true);
        setItem2DayLoan(item2DayLoan);
        setItemCopies(copies);
        setItemFees(fees);
    }

    public void borrowItem(){
        this.itemCopies = this.itemCopies + 1;
    }
    public void returnItem(){
        this.itemCopies = this.itemCopies -1;
        if(this.itemCopies ==0){
            itemStatus = false;
        }
    }
}
