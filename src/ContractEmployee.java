public class ContractEmployee extends Employee{
    private double wagePerHour;
    
    public ContractEmployee(String employeeName, double wagePerHour){
        super(employeeName);
        super.setEmployeeId("C");
        this.wagePerHour = wagePerHour;
    }

    @Override
    public void calculateSalary(float hoursWorked){
        if(hoursWorked < 190){
            super.setSalary(Math.floor((wagePerHour/2)*(190-hoursWorked)));
        }
        super.setSalary(Math.floor(wagePerHour * hoursWorked));
    }

    public double getWagePerHour() {
        return wagePerHour;
    }

    public void setWagePerHour(double wagePerHour) {
        this.wagePerHour = wagePerHour;
    }

    @Override
    public String toString() {
        return "ContractEmployee [wagePerHour=" + wagePerHour + "]";
    }
}
