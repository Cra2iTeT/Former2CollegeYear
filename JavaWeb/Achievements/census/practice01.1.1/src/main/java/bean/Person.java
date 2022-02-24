package bean;

public class Person {
    private String name;
    private String houseType;
    private String homeType;
    private String area;
    private String roomNum;
    private String id;
    private String gender;
    private String nation;
    private String edu;

    public Person() {
    }

    public Person(String name, String houseType, String homeType, String area, String roomNum, String id, String gender, String nation, String edu) {
        this.name = name;
        this.houseType = houseType;
        this.homeType = homeType;
        this.area = area;
        this.roomNum = roomNum;
        this.id = id;
        this.gender = gender;
        this.nation = nation;
        this.edu = edu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getHomeType() {
        return homeType;
    }

    public void setHomeType(String homeType) {
        this.homeType = homeType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }
}
