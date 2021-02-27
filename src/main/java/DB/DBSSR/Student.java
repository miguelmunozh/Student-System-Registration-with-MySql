package DB.DBSSR;

public class Student {
    String firstname;
    String lastname;
    int studentID;
    
    public Student(String firstname, String lastname, int studentID) {
	this.firstname = firstname;
	this.lastname = lastname;
	this.studentID = studentID;
    }
    // getters and setters
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

}
