package designpatterns.creational.builder;

import java.util.Objects;

public class Loan {
    // Required Parameters
    private  String customerPAN;
    private Long customerMobile;
    private LoanType customerLoanType;
    private Double rateOfInterest;
    // Optional parameters
    private Long aadhaarNumber;
    private String customerEmail;
    // applicable only for Home & Education loan only
    private Double taxExemptionPercentage;
    // optional - by default it will be False - account not required
    private Boolean customerAccountCreation;


    public static LoanBuilder builder() {
        return new LoanBuilder();
    }

    public static class LoanBuilder {
        // Required Parameters
        private String customerPAN;
        private Long customerMobile;
        private LoanType customerLoanType;
        private Double rateOfInterest;
        // Optional parameters
        private Long aadhaarNumber;
        private String customerEmail;
        // applicable only for Home & Education loan only
        private Double taxExemptionPercentage;
        // optional - by default itb will be False - account not required
        private Boolean customerAccountCreation;

        public LoanBuilder rateOfInterest(final Double rateOfInterest) {
            this.rateOfInterest = rateOfInterest;
            return this;
        }
        public LoanBuilder customerPAN(final String customerPAN) {
            this.customerPAN = customerPAN;
            return this;
        }
        public LoanBuilder aadhaarNumber(final Long aadhaarNumber) {
            this.aadhaarNumber = aadhaarNumber;
            return this;
        }
        public LoanBuilder customerEmail(final String customerEmail) {
            this.customerEmail = customerEmail;
            return this;
        }
        public LoanBuilder customerMobile(final Long customerMobile) {
            this.customerMobile = customerMobile;
            return this;
        }
        public LoanBuilder taxExemptionPercentage(final Double taxExemptionPercentage) {
            this.taxExemptionPercentage = taxExemptionPercentage;
            return this;
        }
        public LoanBuilder customerLoanType(final LoanType customerLoanType) {
            this.customerLoanType = customerLoanType;
            return this;
        }
        public LoanBuilder customerAccountCreation(final Boolean customerAccountCreation) {
            this.customerAccountCreation = customerAccountCreation;
            return this;
        }
        public Loan build() {
            if (!Objects.nonNull(this.rateOfInterest) || !Objects.nonNull(this.customerMobile)
                    || !Objects.nonNull(customerPAN) || !Objects.nonNull(this.customerLoanType)) {
                throw new RuntimeException("Required parameters are missing");
            }
            Loan loan = new Loan();
            loan.rateOfInterest = rateOfInterest;
            loan.customerPAN = customerPAN;
            loan.customerMobile = customerMobile;
            loan.customerLoanType = customerLoanType;
            loan.aadhaarNumber = aadhaarNumber;
            loan.customerEmail = customerEmail;
            loan.taxExemptionPercentage = taxExemptionPercentage;
            loan.customerAccountCreation = customerAccountCreation;
            return loan;
        }
    }
}
