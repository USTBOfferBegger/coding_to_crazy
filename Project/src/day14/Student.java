package day14;

public class Student extends Person implements Move, Study{

    public Student(){
        System.out.println("Student()");
    }
    public Student(String school){
        this.school = school;
        System.out.println("Student(String school)");
    }
    private Student(String name, int age){
        System.out.println("Student(String name, int age)");
        this.name = name;
        this.age = age;
    }

    public String school;
    private String style;

    public void showInfo(){
        System.out.println("学校：" + school);
    }

    @Override
    public void moveType() {
        System.out.println("骑自行车");
    }

    @Override
    public void studyInfo() {
        System.out.println("学校的知识");
    }

    private void test(String name){
        System.out.println("私有方法");
    }

    public String getSchool(){
        return this.school;
    }

    public void setSchool(String name, String school){
        this.name = name;
        this.school = school;
        System.out.println("这是setInfo方法");
    }
    public void setSchool(String name){
        this.name = name;
        System.out.println("这是setInfo重载方法");
    }
}
