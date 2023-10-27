package case_study.model;

public class Room extends Facility{
    private String freeService;

    public Room() {
    }

    public Room(String freeService) {
        this.freeService = freeService;
    }

    public Room(int serviceCode, String serviveName, int usableArea, String expense, int numberTenants, String rentalType, String freeService) {
        super(serviceCode, serviveName, usableArea, expense, numberTenants, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "serviceCode=" + serviceCode +
                ", serviveName='" + serviveName + '\'' +
                ", usableArea=" + usableArea +
                ", expense='" + expense + '\'' +
                ", numberTenants=" + numberTenants +
                ", rentalType='" + rentalType + '\'' +
                ", freeService='" + freeService + '\'' +
                '}';
    }
}
