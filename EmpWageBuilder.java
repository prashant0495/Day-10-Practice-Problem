package day10;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class EmpWageBuilder implements IComputeEmpWage {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    private int numOfCompany = 0;
    private LinkedList<CompanyEmpWage> companyEmpWageList;
    private Map<String,CompanyEmpWage> companyEmpWageMap;

    public EmpWageBuilder() {
        companyEmpWageList = new LinkedList<>();
        companyEmpWageMap = new HashMap<>();
    }

    public void addCompanyEmpWage(String company, int empRatePerHr,
                                  int numOfWorkingDays, int maxHrsPerMonth) {
        CompanyEmpWage companyEmpWage = new CompanyEmpWage(company, empRatePerHr, numOfWorkingDays,
                maxHrsPerMonth);
        companyEmpWageList.add(companyEmpWage);
        companyEmpWageMap.put(company, companyEmpWage);
    }

    public void computeEmpWage() {
        for (int i = 0; i < companyEmpWageList.size(); i++) {
            CompanyEmpWage companyEmpWage = companyEmpWageList.get(i);
            companyEmpWage.setTotalEmpWage(this.calEmpWageForCompany(companyEmpWage));
            System.out.println(companyEmpWage);
        }
    }

    public int getTotalWage(String company) {
        return companyEmpWageMap.get(company).totalEmpWage;
    }

    public int calEmpWageForCompany(CompanyEmpWage companyEmpWage) {

        int empHrs, totalEmpHrs = 0, totalWorkingDays = 0;
        while (totalEmpHrs <= companyEmpWage.maxHrsPerMonth &&
                totalWorkingDays < companyEmpWage.numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            int empWage = empHrs * companyEmpWage.empRatePerHr;
            System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " + empHrs);
            System.out.println("Emp Wage = " + empWage);
            System.out.println();
        }
        System.out.println("totalEmpHrs = " + totalEmpHrs);
        return totalEmpHrs * companyEmpWage.empRatePerHr;
    }

    public static void main(String[] args) {
        IComputeEmpWage empWageBuilder = new EmpWageBuilder();
        empWageBuilder.addCompanyEmpWage("DMart", 20, 4,
                10);
        empWageBuilder.addCompanyEmpWage("Reliance", 15, 3,
                10);
        empWageBuilder.computeEmpWage();
        System.out.println("Total Wage for DMart company: " + empWageBuilder.getTotalWage("DMart"));
        System.out.println("Total Wage for Reliance company: " + empWageBuilder.getTotalWage("Reliance"));
    }
}