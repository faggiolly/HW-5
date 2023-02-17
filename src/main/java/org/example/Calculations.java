package org.example;

import java.text.NumberFormat;
import java.util.LinkedList;

public class Calculations {
    LinkedList<String>calculations;
    private Customer customer;
    private Investment investment;

    public Calculations () {
        calculations = new LinkedList<>();

    }


    public void printCalculationsResults() {
        String header =    "Name" + "\t | \t "
                            + "Email" + "\t | \t "
                            + "Telephone" + "\t | \t "
                            + "MonthlyInv" + "\t | \t "
                            + "Rate" + "\t | \t "
                            + "Years" + "\t | \t "
                            + "Future Value " + "\n";

        System.out.println(header);
        while (calculations.size() > 0) {
            String results = calculations.removeLast();
            System.out.println(results);
            System.out.println();
        }
    }

    public void addResultsToArray() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        NumberFormat percent = NumberFormat.getPercentInstance();
        percent.setMinimumFractionDigits(1);


        String result = customer.getName() + " \t | \t "
                    + customer.getEmail() + " \t | \t "
                    + customer.getPhoneNumber() + "\t | \t "
                    + currency.format(investment.getMonthlyInvestment()) + "\t | \t "
                    + percent.format(investment.getMonthlyInterestRate() * 12) + "\t | \t "
                    + Integer.toString(investment.getYears()) + "\t | \t "
                    + checkEmptyFutureValue(investment.getFutureValueCalculation()) + "\n";

        calculations.add(result);
    }

    public String checkEmptyFutureValue(double futureValue) {

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String results;

        if (futureValue == 0) {
            results = "Future Value has not been calculated";
        }
        else {
            results = String.valueOf(currency.format(futureValue));
        }
        return results;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Investment getInvestment() {
        return investment;
    }

    public void setInvestment(Investment investment) {
        this.investment = investment;
    }
}

