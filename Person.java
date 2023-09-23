package homeworks.personDatabaseConsoleApplication1;


import java.io.Serializable;


/**
 * The type Person.
 */
public class Person implements Serializable {
    private static  int ID = 0;

    private String name;
    private String surName;
    private int age;
    private String dateOfBirth;
    private int id;

    /**
     * Instantiates a new Person.
     *
     * @param name        the name
     * @param surName     the sur name
     * @param age         the age
     * @param dateOfBirth the date of birth
     */
    public Person(String name, String surName, int age, String dateOfBirth) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.id = ++ID;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets sur name.
     *
     * @return the sur name
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public static int getID() {
        return ID;
    }

    /**
     * Gets date of birth.
     *
     * @return the date of birth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }


    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age + ", ID= " + id + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}

