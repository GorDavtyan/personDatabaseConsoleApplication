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

//    public boolean validDateFormat(String dateOfBirth) {
//        String str = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[5-9][0-9]|20(0[0-9]|1[0-9]|2[0-3]))$";
//        Pattern pattern = Pattern.compile(str);
//        Matcher matcher = pattern.matcher(dateOfBirth);
//        System.out.println(matcher.matches());
//        if (matcher.matches()) {
//            String[] split = dateOfBirth.split("/");
//            System.out.println(Arrays.toString(split));
//            int day = Integer.parseInt(split[0]);
//            int month = Integer.parseInt(split[1]);
//            int year = Integer.parseInt(split[2]);
//
//            if (((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
//                    && (day >= 1 && day <= 31)) || ((month == 4 || month == 6 || month == 9 || month == 11) && day >= 1 && day <= 30)) {
//                return true;
//            } else if ((month == 2 && (year % 4 == 0 && year % 100 != 0) && (day >= 1 && day <= 29))|| (month == 2 && day >= 1 && day <= 28)) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * Valid age.
     */
    public void validAge() {
        if (age <= 0 || age >= 100) {
            System.out.println("invalid statement");
        }
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

