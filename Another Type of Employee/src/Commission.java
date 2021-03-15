public class Commission extends Hourly {
    protected double totalSales;
    protected double commissionRate;

    public Commission (String eName, String eAddress, String ePhone, String socSecNumber, double rate, double commissionRate) {
        super(eName, eAddress, ePhone, socSecNumber, rate);
        this.commissionRate = commissionRate;
    }

    public void addSales (double totalSales) {
        this.totalSales = totalSales;
    }

    public double pay() {
        double payment = super.pay() + (totalSales * commissionRate);

        this.totalSales = 0;

        return payment;
    }

    public String toString() {
        return super.toString() + " \nTotal sales: " + this.totalSales;
    }

}
