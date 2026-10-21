public class Student {
    // Encapsulated Private Attributes
    private int id;
    private String name;
    private String course;
    private double gpa;

    // Default Constructor
    public Student() {
        this.id = 0;
        this.name = "Unknown";
        this.course = "General";
        this.gpa = 0.0;
    }

    // Parameterized Constructor (Constructor Overloading)
    public Student(int id, String name, String course, double gpa) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
    }

    // Getters and Setters (Encapsulation)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    public double getGpa() { return gpa; }
    public void setGpa(double gpa) { this.gpa = gpa; }

    // Method to display student information
    public void displayStudentInfo() {
        System.out.println("------------------------------------");
        System.out.println("Student ID   : " + id);
        System.out.println("Name         : " + name);
        System.out.println("Course       : " + course);
        System.out.println("GPA          : " + gpa);
        System.out.println("------------------------------------");
    }

    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("    STUDENT CLASS IMPLEMENTATION    ");
        System.out.println("====================================");

        // Instantiating objects
        Student s1 = new Student(); // Uses Default Constructor
        Student s2 = new Student(101, "Mahima Chaudhari", "Master of Computer Applications", 3.85); // Uses Parameterized Constructor

        System.out.println("\nDefault Student Record:");
        s1.displayStudentInfo();

        System.out.println("\nParameterized Student Record:");
        s2.displayStudentInfo();
    }
}