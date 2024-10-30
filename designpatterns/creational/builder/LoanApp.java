package designpatterns.creational.builder;

public class LoanApp {
    public static void main(String[] args) {
        // HomeLoan requires taxExemptionPercentage as it is mandatory parameter to set
        Loan homeLoan = Loan.builder()
                .customerPAN("BNFPB5812G")
                .customerMobile(9701253415L)
                .customerLoanType(LoanType.HOME_LOAN)
                .rateOfInterest(8.5)
                .taxExemptionPercentage(12.5)
                .build();

        // Personal Loan doesn't require taxExemptionPercentage parameter as it is optional
        Loan personalLoan = Loan.builder()
                .customerPAN("SERUB9120W")
                .customerMobile(9701253415L)
                .customerLoanType(LoanType.PERSONAL_LOAN)
                .rateOfInterest(11.5)
                .build();
    }
}
