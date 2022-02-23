package day10;

public class CompanyEmpWage {
    public final String company;
    public final int empRatePerHr;
    public final int numOfWorkingDays;
    public final int maxHrsPerMonth;
    public int totalEmpWage;

    public CompanyEmpWage(String company, int empRatePerHr, int numOfWorkingDays, int maxHrsPerMonth) {
        this.company = company;
        this.empRatePerHr = empRatePerHr;
        this.numOfWorkingDays = numOfWorkingDays;
        this.maxHrsPerMonth = maxHrsPerMonth;
        totalEmpWage = 0;
    }

    @Override
    public String toString() {
        return "Total Emp Wage for company " + company + " is: " + totalEmpWage;
    }

    public void setTotalEmpWage(int totalEmpWage) {
        this.totalEmpWage = totalEmpWage;
    }

}
