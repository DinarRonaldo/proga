package proga.classwork3_1;

public class Student {
    private int id;
    private String name;
    private int age;
    private String group;

    public Student(int id, String name, int age, String group) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return id + "/" + name + "/" + age + "/" + group;
    }
}