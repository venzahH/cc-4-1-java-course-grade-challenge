import java.util.ArrayList;

/**
 * Classroom class that represents a classroom of student (one file)
 *
 * @author Venzah Hamilton
 * @version 1.0
 */
public class Classroom {
    private ArrayList<Student> students;

    /**
     * Constructor for the Classroom object
     *
     * @param students An array list of Student objects containing their first and last name and their 3 exam scores
     */
    Classroom(ArrayList<Student> students){
        this.students = students;
    }

    /**
     * Returns the array list of Student objects
     *
     * @return ArrayList<Student> An array list of Student objects
     */
    public ArrayList<Student> getStudents(){return students;}

    /**
     * Sums up the midterm 1 scores of every student in the classroom and returns the class average
     *
     * @return A double of the classroom's midterm 1 average score
     */
    public double calculateMidterm1Average(){
        double average = 0;
        for(Student student : students){
           average += Double.parseDouble(student.getMidterm1Grade());
        }
        return average / students.size();
    }

    /**
     * Sums up the midterm 2 scores of every student in the classroom and returns the class average
     *
     * @return A double of the classroom's midterm 2 average score
     */
    public double calculateMidterm2Average(){
        double average = 0;
        for(Student student : students){
            average += Double.parseDouble(student.getMidterm2Grade());
        }
        return average / students.size();
    }

    /**
     * Sums up the final exam scores of every student in the classroom and returns the class average
     *
     * @return A double of the classroom's final exam average score
     */
    public double calculateFinalAverage(){
        double average = 0;
        for(Student student : students){
            average += Double.parseDouble(student.getFinalGrade());
        }
        return average / students.size();
    }
}
