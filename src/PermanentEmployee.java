import java.util.Arrays;

public class PermanentEmployee extends Employee{

    private double basicPay;
    private String[] salaryComponents;
    private float experience;
    private Asset[] assets;

    public PermanentEmployee(String employeeName, double basicPay, String[] salaryComponents, Asset[] assets){
        super(employeeName);
        super.setEmployeeId("E");
        this.basicPay = basicPay;
        this.salaryComponents = salaryComponents;
        this.assets = assets;
    }

    public double calculateBonus(float experience) throws InvalidExperienceException{
            
        if(experience >= 2.5 && experience < 4){
            return 2550;
        }
        if(experience >= 4 && experience < 8){
            return 5000;
        }
        if(experience >= 8 && experience < 12){
            return 8750;
        }
        if(experience >= 12){
            return 13000;
        }

        throw new InvalidExperienceException("A minimum of 2.5 years is required for bonus!");

    }

    @Override
    public void calculateSalary(float experience){
        setExperience(experience);
      
            try {
                super.setSalary(Math.floor(basicPay+Double.parseDouble(salaryComponents[0].substring(3))+Double.parseDouble(salaryComponents[1].substring(4))+calculateBonus(experience)));
            }
            catch (InvalidExperienceException e) {
                super.setSalary(Math.floor(basicPay+Double.parseDouble(salaryComponents[0].substring(3))+Double.parseDouble(salaryComponents[1].substring(4))+0));
            }
       
        
    }

    public Asset[] getAssetsByDate(String lastDate) throws InvalidAssetsException{
        Asset[] expire = new Asset[assets.length];
        int month = Resources.getMonth(lastDate.substring(5,8));
        lastDate = lastDate.substring(0,4)+month+lastDate.substring(9, 11);

        int date = Integer.parseInt(lastDate);
        int j = 0;
        for(int i=0; i<assets.length ;i++){
            String currenrExp = assets[i].getAssetExpiry();
            int currentMonth = Resources.getMonth(currenrExp.substring(5,8));
            currenrExp = currenrExp.substring(0,4)+currentMonth+currenrExp.substring(9,11);

            int currentDate = Integer.parseInt(currenrExp);

            if(currentDate<=date){
                expire[j] = assets[i];
                j++;
            }
        }
        if(expire[0]==null){
            throw new InvalidAssetsException("No assets found for the given criteria!");
        }
        return expire;
    }

    public double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(double basicPay) {
        this.basicPay = basicPay;
    }

    public String[] getSalaryComponents() {
        return salaryComponents;
    }

    public void setSalaryComponents(String[] salaryComponents) {
        this.salaryComponents = salaryComponents;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public Asset[] getAssets() {
        return assets;
    }

    public void setAssets(Asset[] assets) {
        this.assets = assets;
    }

    @Override
    public String toString() {
        return "PermanentEmployee [basicPay=" + basicPay + ", salaryComponents=" + Arrays.toString(salaryComponents)
                + ", experience=" + experience + ", assets=" + Arrays.toString(assets) + "]";
    }

    

}
