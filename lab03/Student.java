public class Student {
    private String name;
    private int marks;

    public Student(String name, int marks) {
        setName(name);
        setMarks(marks);          // validate in the constructor too
    }

    public String getName() { return name; }
    public int getMarks()   { return marks; }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name required");
        this.name = name.trim();
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100)
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        this.marks = marks;
    }

    // Computed, not stored. Thresholds are examples; use your instructor's values.
    public String getGrade() {
        if (marks >= 75) return "A";
        if (marks >= 60) return "B";
        if (marks >= 50) return "C";
        return "F";
    }

    public static void main(String[] args) {
        Student s = new Student("Tariro", 78);
        System.out.println(s.getName() + ": " + s.getMarks() + " grade " + s.getGrade());
        try {
            s.setMarks(150);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
