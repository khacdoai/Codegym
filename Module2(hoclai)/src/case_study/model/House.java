package case_study.model;

public class House extends Facility{
    private String roomStandards;
    private int numberFloors;

    public House() {
    }

    public House(String roomStandards, int numberFloors) {
        this.roomStandards = roomStandards;
        this.numberFloors = numberFloors;
    }

    public House(int serviceCode, String serviveName, int usableArea, String expense, int numberTenants, String rentalType, String roomStandards, int numberFloors) {
        super(serviceCode, serviveName, usableArea, expense, numberTenants, rentalType);
        this.roomStandards = roomStandards;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "serviceCode=" + serviceCode +
                ", serviveName='" + serviveName + '\'' +
                ", usableArea=" + usableArea +
                ", expense='" + expense + '\'' +
                ", numberTenants=" + numberTenants +
                ", rentalType='" + rentalType + '\'' +
                ", roomStandards='" + roomStandards + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
