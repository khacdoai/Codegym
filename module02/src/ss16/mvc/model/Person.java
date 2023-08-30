package ss16.mvc.model;

public  abstract class Person {
    private int code;
    private String name;
    private String dateOfBirth;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {
    }

    public Person(int code, String name, String dateOfBirth) {
        this.code = code;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }


}
