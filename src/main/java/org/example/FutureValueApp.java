package org.example;

public class FutureValueApp {

    public static void main(String[] args) {

        // create a Calculations List to save results
        Calculations calculations = new Calculations();

        // display a welcome message
        System.out.println("Welcome to the Future Value Calculator" + "\n\n"
                            + "To Start, first you need to create an account");
        System.out.println();

        // set selection default
        String selection = "y";

        while (selection.equalsIgnoreCase("y")) {

            // ask inputs to create a new customer
            String customerName = Console.getString("Please enter your full name: ");
            String customerEmail = Console.getString("Please enter your email address: ");
            long customerPhoneNumber = Console.getPhoneNumber("Please enter your phone number: ");
            System.out.println();



            // create a new customer and pass object to Calculations
            Customer customer = new Customer(customerName, customerEmail, customerPhoneNumber);
            calculations.setCustomer(customer);

            // create an investment with future value = 0 and pass object to Calculations
            Investment investment = new Investment();
            calculations.setInvestment(investment);

            // print created customer info
            printCustomerInfo(customer, "created");


            // display account options

            String nestedSelection = "Y";

            while (nestedSelection.equalsIgnoreCase("Y")) {

                System.out.println(customer.getName() + " Please select what you want to do with your account:\n");

                int accountMenu = Console.getInt("1. Request or update a Future Value of an Investment Projection" + "\n"
                        + "2. Update my personal information" + "\n"
                        + "3. Exit personal account menu" + "\n");


                switch (accountMenu) {

                    case 1:
                        System.out.println("Please enter your investment information");
                        System.out.println();

                        double monthlyInvestment = (Console.getDouble("Enter your projected monthly investment: ", 1, 1000000000));
                        double interestRate = (Console.getDouble("Enter your projected interest rate: ", 0.1, 50));
                        int years = (Console.getInt("Enter your projected investment period (years): ", 1, 30));
                        System.out.println();

                        investment = new Investment(monthlyInvestment, interestRate, years);

                        // calculate future value
                        investment.setFutureValueCalculation();

                        // pass investment to Calculations
                        calculations.setInvestment(investment);

                        // print investment information
                        printInvestmentInfo(investment);

                        break;


                    case 2:

                        // ask for information to update
                        customer.setName(Console.getString("Please enter your full name: "));
                        customer.setEmail(Console.getString("Please enter your email address : "));
                        customer.setPhoneNumber(Console.getInt("Please enter your phone number: "));

                        //  pass updated customer information to Calculations
                        calculations.setCustomer(customer);

                        // print updated information
                        printCustomerInfo(customer, "updated");

                        break;

                    case 3:
                        nestedSelection = "N";
                        break;

                    default:
                        System.out.println("\nInvalid Selection please try again\n");
                }

            }

            // add results to Calculations Array
            calculations.addResultsToArray();

            // ask if user wants to add a new customer
            selection = Console.getString("Would you like to add a new customer? Y/N: ");


        }


        // print results and exit FutureValueApp
        calculations.printCalculationsResults();
        System.out.println("Thank you for using the FutureValueApp");
        System.out.println();

    }

    public static void printCustomerInfo (Customer customer, String status) {
        System.out.println("Your Account has been " + status + " with the following information:\n");
        System.out.println("Name: " + customer.getName());
        System.out.println("Email: " + customer.getEmail());
        System.out.println("Phone Number: " + customer.getPhoneNumber());
        System.out.println();
    }

    public static void printInvestmentInfo (Investment investment) {
        System.out.println("Your Investment information is:\n");
        System.out.println("Monthly Investment: " + investment.getMonthlyInvestment());
        System.out.println("Interest Rate: " + investment.getMonthlyInterestRate() * 12);
        System.out.println("Years: " + investment.getYears());
        System.out.println("Future Value: " + investment.getFutureValueCalculation());
        System.out.println();
    }
}
