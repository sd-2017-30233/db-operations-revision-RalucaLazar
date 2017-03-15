/**
 * Created by Raluca on 11.03.2017.
 */
public class Course {
    private int id;
    private String name;
    private String teacher;
    private int year;

    public int getId() {
        return id;
    }
    public void setId(int id) { this.id = id;}


    public String getName() {
        return name;
    }
    public void setName(String nume) {
        this.name = nume;
    }

    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", teacher=" + teacher
                + ", year=" + year + "]";
    }
}
