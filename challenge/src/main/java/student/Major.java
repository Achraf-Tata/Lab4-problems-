package student;

public class Major {
    private static int nextId = 1;
    private int id;
    private String code;
    private String name;
    private Student[] students;
    private int studentCount;
    private static final int MAX_STUDENTS = 50;

    private static Major defaultMajor;

    public static Major getDefaultMajor() {
        if (defaultMajor == null) {
            defaultMajor = new Major("23", "computer science");
        }
        return defaultMajor;
    }

    public Major() {
        this.id = nextId++;
        this.code = "";
        this.name = "";
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;
    }

    public Major(String code, String name) {
        this.id = nextId++;
        this.code = code;
        this.name = name;
        this.students = new Student[MAX_STUDENTS];
        this.studentCount = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void addStudent(Student s) {
        if (s == null) {
            return;
        }
        for (int i = 0; i < studentCount; i++) {
            if (students[i] == s) {
                return;
            }
        }
        students[studentCount++] = s;
        if (s.getMajor() != this) {
            s.setMajor(this);
        }
    }

    public Student findStudentByCNE(String cne) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null && cne.equalsIgnoreCase(students[i].getCne())) {
                return students[i];
            }
        }
        return null;
    }

    public boolean removeStudent(String cne) {
        Student target = findStudentByCNE(cne);
        if (target == null) {
            return false;
        }
        for (int i = 0; i < studentCount; i++) {
            if (students[i] == target) {
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null;
                studentCount--;
                if (target.getMajor() == this) {
                    target.setMajor(null);
                }
                return true;
            }
        }
        return false;
    }

    public double getOccupancyRate() {
        double rate = ((double) studentCount / MAX_STUDENTS) * 100.0;
        System.out.println(name + "capacity : " + MAX_STUDENTS + " students");
        System.out.println("Current enrollment : " + studentCount + " students");
        System.out.println("Occupancy rate = " + rate + "%");
        return rate;
    }

    public String getStudentListAsString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < studentCount; i++) {
            sb.append(i + 1).append(". ")
              .append(students[i].getCne()).append(" ")
              .append(students[i].getLastName() != null ? students[i].getLastName().toUpperCase() : "").append(" ")
              .append(students[i].getFirstName() != null ? students[i].getFirstName() : "");
            if (i < studentCount - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public void displayStudents() {
        System.out.println("The students that are in the " + name.toLowerCase() + " major are :");
        String list = getStudentListAsString();
        System.out.println(list);
    }

    @Override
    public String toString() {
        return "Major{id : " + id + ", code : " + code + ", name : " + name + ", studentCount :" + studentCount + "}";
    }
}
