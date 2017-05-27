package strada.com.simpletipcalculator;

/**
 * Created by GrayOwl on 5/26/17.
 */
public class Tipper {
    private double billAmount = 0;
    private double tipPercentage = 0.0;
    private double tipAmount = 0;
    private int splitNumber = 1;
    private double total = 0;
    private double totalEach = 0;

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public double getTipPercentage() {
        return tipPercentage;
    }

    public void setTipPercentage(double tipPercentage) {
        this.tipPercentage = tipPercentage;
    }

    public double getTipAmount() {
        return tipAmount;
    }

    public void setTipAmount(double tipAmount) {
        this.tipAmount = tipAmount;
    }

    public int getSplitNumber() {
        return splitNumber;
    }

    public void setSplitNumber(int splitNumber) {
        this.splitNumber = splitNumber;
    }

    public double tipAmount(double tipPercentage){
        tipAmount = billAmount * tipPercentage;
        return tipAmount;
    }

    public double total(double tipAmount, double billAmount){
        total = billAmount + tipAmount;
        return total;
    }


    public double totalEach(double total){
        totalEach = total/getSplitNumber();
        return totalEach;
    }


}
