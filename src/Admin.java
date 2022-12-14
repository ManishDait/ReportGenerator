public class Admin {
    public void generateSalarySlip(Employee[] employees, float[] salaryFactor){
        for(int i=0; i<employees.length; i++){
            employees[i].calculateSalary(salaryFactor[i]);
        }
    }
    public int generateAssetsReport(Employee[] employess, String lastDate){
        for(int i=0; i<employess.length; i++){
            if(employess[i].getEmployeeId().substring(0,1).equals("E")){
                PermanentEmployee permanentEmployee = (PermanentEmployee) employess[i];
                try {
                    Asset[] assets = permanentEmployee.getAssetsByDate(lastDate);
                    return assets.length;
                } catch (InvalidAssetsException e) {
                    return -1;
                }
            }
        }

        return -1;
    }
    public String[] generateAssetsReport(Employee[] employees, char assetCategory){
        String[] array = new String[employees.length*3];
        int k = 0;
        for(int i=0; i<employees.length; i++){
            if(employees[i].getEmployeeId().substring(0,1).equals("E")){
                PermanentEmployee permanentEmployee = (PermanentEmployee) employees[i];
                Asset[] newAssets = permanentEmployee.getAssets();
                for(int j=0; j<newAssets.length; j++){
                    
                    if(newAssets[j].getAssetId().charAt(0) == assetCategory){
                        array[k] = newAssets[j].getAssetId();
                        k++;
                    }
                }
            }
        }
        return array;
    }
}
