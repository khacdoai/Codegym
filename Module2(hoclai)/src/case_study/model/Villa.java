package case_study.model;

public class Villa extends Facility {
    private String roomStandards;
    private int acreage;

    public Villa() {
    }

    public Villa(String roomStandards, int acreage) {
        this.roomStandards = roomStandards;
        this.acreage = acreage;
    }

    public Villa(int serviceCode, String serviveName, int usableArea, String expense, int numberTenants, String rentalType, String roomStandards, int acreage) {
        super(serviceCode, serviveName, usableArea, expense, numberTenants, rentalType);
        this.roomStandards = roomStandards;
        this.acreage = acreage;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "serviceCode=" + serviceCode +
                ", serviveName='" + serviveName + '\'' +
                ", usableArea=" + usableArea +
                ", expense='" + expense + '\'' +
                ", numberTenants=" + numberTenants +
                ", rentalType='" + rentalType + '\'' +
                ", roomStandards='" + roomStandards + '\'' +
                ", acreage=" + acreage +
                '}';
    }
}
