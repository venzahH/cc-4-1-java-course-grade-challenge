public class Student {
    private static final int NUMBER_OF_EXAMS = 3;
    private static final int A_GRADE = 90;
    private static final int B_GRADE = 80;
    private static final int C_GRADE = 70;
    private static final int D_GRADE = 60;

    private String lastName;
    private String firstName;
    private String midterm1Grade;
    private String midterm2Grade;
    private String finalGrade;

    /**
     * Constructor for Student object
     *
     * @param lastName String representation of the student's last name
     * @param firstName String representation of the student's first name
     * @param midterm1Grade String representation of the student's midterm 1 score
     * @param midterm2Grade String representation of the student's midterm 2 score
     * @param finalGrade String representation of the student's final exam score
     */
    Student(String lastName, String firstName, String midterm1Grade,  String midterm2Grade, String finalGrade) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.midterm1Grade = midterm1Grade;
        this.midterm2Grade = midterm2Grade;
        this.finalGrade = finalGrade;
    }

    /**
     * Returns the student's last name
     *
     * @return String of the student's last name
     */
    public String getLastName() { return lastName; }

    /**
     * Returns the student's first name
     *
     * @return String of the student's first name
     */
    public String getFirstName() { return firstName; }

    /**
     * Returns the student's midterm 1 grade
     *
     * @return String of the student's midterm 1 grade
     */
    public String getMidterm1Grade() { return midterm1Grade; }

    /**
     * Returns the student's midterm 2 grade
     *
     * @return String of the student's midterm 2 grade
     */
    public String getMidterm2Grade() { return midterm2Grade; }

    /**
     * Returns the student's final exam grade
     *
     * @return String of the student's final exam grade
     */
    public String getFinalGrade() { return finalGrade; }

    /**
     * Calculates the students grade by averaging their midterm 1, midterm 2, and final exam grade and assigning it a
     * letter based on the following:
     * A: average >= 90
     * B: 80 <= average < 90
     * C: 70 <= average < 80
     * D: 60 <= average < 70
     * F: average < 60
     *
     * @return A string of the letter representation of the student's average grade in the class
     */
    public String calculateGrade(){
        double average = (Double.parseDouble(midterm1Grade) + Double.parseDouble(midterm2Grade) + Double.parseDouble(finalGrade))/NUMBER_OF_EXAMS;

        if(average >= A_GRADE){
            return "A";
        } else if(average >= B_GRADE){
            return "B";
        } else if(average >= C_GRADE){
            return "C";
        }  else if(average >= D_GRADE){
            return "D";
        } else{
            return "F";
        }
    }
}
