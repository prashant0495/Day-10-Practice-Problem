package day10;

public class EmpWageBuilderUC1 {
    public static void main(String[] args) {
    //CONSTANTTS
    int IS_FULL_TIME=1;
    // COMPUTATION
    double empCheck = Math.floor(Math.random()*10)%2;
    if(empCheck == IS_FULL_TIME)
        System.out.println("Employee is Present");
    else
        System.out.println("Employee is Absent");
    }
}
