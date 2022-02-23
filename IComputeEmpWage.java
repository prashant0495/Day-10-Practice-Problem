package day10;

public interface IComputeEmpWage {
    void addCompanyEmpWage(String company, int empRatePerHr,
                           int numOfWorkingDays, int maxHrsPerMonth);
    void computeEmpWage();
    int getTotalWage(String company);
}