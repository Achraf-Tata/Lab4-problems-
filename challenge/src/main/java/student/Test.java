package student;

public class Test {
    public static void main(String[] args) {
        Major cs = Major.getDefaultMajor();
        Major math = new Major("12", "Mathematics");

        Student s1 = new Student("SAFI", "Amal", "0612345678", "amal.safi@example.com", "22885676");
        Student s2 = new Student("ALAMI", "Samir", "0687654321", "samir.alami@example.com", "23585976");
        Student s3 = new Student("Test", "Student", "0655443322", "student.test@example.com", "0000000", math);

        cs.displayStudents();

        System.out.println(s1.getFullNameFormatted());
        System.out.println(cs.findStudentByCNE("23585976"));
        System.out.println("Student count: " + cs.getStudentCount());
        cs.getOccupancyRate();
        System.out.println(cs.getStudentListAsString());
        cs.removeStudent("23585976");
    }
}
