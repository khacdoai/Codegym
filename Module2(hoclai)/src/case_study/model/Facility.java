package case_study.model;

public  abstract class Facility {
    public int  serviceCode;
    public String serviveName;
    public int usableArea;
    public String expense;
    public int numberTenants;
    public String rentalType;

    public Facility() {
    }

    public Facility(int serviceCode, String serviveName, int usableArea, String expense, int numberTenants, String rentalType) {
        this.serviceCode = serviceCode;
        this.serviveName = serviveName;
        this.usableArea = usableArea;
        this.expense = expense;
        this.numberTenants = numberTenants;
        this.rentalType = rentalType;
    }

    public int getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(int serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiveName() {
        return serviveName;
    }

    public void setServiveName(String serviveName) {
        this.serviveName = serviveName;
    }

    public int getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(int usableArea) {
        this.usableArea = usableArea;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public int getNumberTenants() {
        return numberTenants;
    }

    public void setNumberTenants(int numberTenants) {
        this.numberTenants = numberTenants;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "serviceCode=" + serviceCode +
                ", serviveName='" + serviveName + '\'' +
                ", usableArea=" + usableArea +
                ", expense='" + expense + '\'' +
                ", numberTenants=" + numberTenants +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
