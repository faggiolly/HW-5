package org.example;

public class Investment {
    private double monthlyInvestment;
    private double monthlyInterestRate;
    private int years;
    private int months;
    private double futureValueCalculation;

    public Investment () {
        this.setMonthlyInvestment(0);
        this.setMonthlyInterestRate(0);
        this.setYears(0);
        this.setMonths(0);
        this.futureValueCalculation = 0;

    }

    public Investment (double monthlyInvestment, double interestRate, int years ) {
        this.setMonthlyInvestment(monthlyInvestment);
        this.setMonthlyInterestRate(interestRate);
        this.setYears(years);
        this.setMonths(years);
    }


    public double getMonthlyInvestment() {
        return monthlyInvestment;
    }

    public void setMonthlyInvestment(double monthlyInvestment) {
        this.monthlyInvestment = monthlyInvestment;
    }

    public double getMonthlyInterestRate() {
        return monthlyInterestRate;
    }

    public void setMonthlyInterestRate(double monthlyInterestRate) {
        this.monthlyInterestRate = (monthlyInterestRate / 100) / 12;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int years) {
        this.months = years * 12;
    }

    public double getFutureValueCalculation() {
        return futureValueCalculation;
    }

    public void setFutureValueCalculation() {

        for (int i = 1; i <= getMonths(); i++) {
            futureValueCalculation =
                        (futureValueCalculation + getMonthlyInvestment()) *
                                (1 + getMonthlyInterestRate());
            }
        }


    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
}

