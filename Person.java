public class Person {
    private String IDNum;
    private String firstName;
    private String lastName;
    private int YOB;
    private String Title;
    static private int IDSeed = 1;

    public  void setIDSeed(int IDSeed) { this.IDSeed = IDSeed; }
    public  int getIDSeed() { return IDSeed; }

    public Person(String IDNum, String firstName, String lastName, int YOB, String Title) {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.YOB = YOB;
        this.Title = Title;
    }
    public String toCSVString() {
        return firstName + "," + lastName + "," + IDNum + "," + Title + "," + YOB;
    }
    public String getIDNum() {
        return IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFullName() {
        return firstName + " " + lastName;


    }

    public String getFormalName() {
        return Title + "" + getFullName();
    }

    public int calculateAge() {
        int currentYear = 2023;
        return currentYear - YOB;
    }





    @Override
    public String toString() {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", YOB=" + YOB +
                ", Title='" + Title + '\'' +
                '}';
    }
}