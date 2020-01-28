package basic.generic;

public class Sample {
    public static void main(String[] args) {
        Person person = new Student();
        person.setName("장윤진");

        Student student = (Student) person;
        student.setStudentId("1234");

        System.out.println(student);
    }
}
