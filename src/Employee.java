public class Employee{
    private String employeeId;
    private String employeeName;
    private double salary;
    private static int contractIdCounter;
    private static int permanentIdCounter;

    static{
        contractIdCounter = 10000;
        permanentIdCounter = 10000;
    }

    public Employee(String employeeName){
        if(employeeName.matches("([A-Z]{1}[A-Z|a-z]{1,}|[A-Z]{1}[a-z]{1,}\s[|A-Z]{1}[a-z]{1,})"))
         this.employeeName = employeeName;
    }


    public void calculateSalary(float salaryFactor){}

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        if(employeeId.equals("C")){
            contractIdCounter++;
            this.employeeId = employeeId+contractIdCounter;
        }

        if(employeeId.equals("E")){
            permanentIdCounter++;
            this.employeeId = employeeId+permanentIdCounter;
        }
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        if(employeeName.matches("([A-Z]{1}[A-Z|a-z]{1,}|[A-Z]{1}[a-z]{1,}\s[|A-Z]{1}[a-z]{1,})"))
         this.employeeName = employeeName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary > 0)
         this.salary = salary;
        else
         this.salary = 0;
    }

    public static int getContractIdCounter() {
        return contractIdCounter;
    }

    public static void setContractIdCounter(int contractIdCounter) {
        Employee.contractIdCounter = contractIdCounter;
    }

    public static int getPermanentIdCounter() {
        return permanentIdCounter;
    }

    public static void setPermanentIdCounter(int permanentIdCounter) {
        Employee.permanentIdCounter = permanentIdCounter;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", salary=" + salary + "]";
    }
    
}