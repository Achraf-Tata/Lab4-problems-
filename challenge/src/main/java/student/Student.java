package student;

public class Student extends Person {
    private String cne;
    private Major major;

    public Student() {
        super();
        this.major = Major.getDefaultMajor();
        if (this.major != null) {
            this.major.addStudent(this);
        }
    }

    public Student(String nom, String prenom, String telephone, String email, String cne, Major major) {
        super(prenom, nom, telephone, email);
        this.cne = cne;
        this.major = major;
        if (this.major != null)this.major.addStudent(this);
    }

    public Student(String nom, String prenom, String telephone, String email, String cne) {
        this(nom, prenom, telephone, email, cne, Major.getDefaultMajor());
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getFullNameFormatted() {
        String last = (lastName != null) ? lastName.toUpperCase() : "";
        String first = (firstName != null) ? firstName : "";
        return String.format("%s, %s", last, first);
    }

    @Override
    public String toString() {
        String last = (lastName != null) ? lastName.toUpperCase() : "";
        String first = (firstName != null) ? firstName : "";
        return cne + " " + last + " " + first;
    }
}
