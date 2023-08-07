package FinalProject;

import java.util.Date;

public class Invoice {
    private int invoiceType;
    private double amount;
    private String processDate;

    public Invoice(int invoiceType, double amount, String processDate){
        this.invoiceType = invoiceType;
        this.amount = amount;
        this.processDate = processDate;
    }

    public int getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(int invoiceType) {
        this.invoiceType = invoiceType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getProcessDate() {
        return processDate;
    }

    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }
}
