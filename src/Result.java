import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Result class that is the source file for this Java program. It will prompt the user for a file name and if it exists,
 * it will read the student data and caluculate their individual grades as well as the class average for each exam.
 * The program will create a file called report.txt and record the results there.
 *
 * Please note: Everytime the program is run, any information in report.txt will be overwritten.
 *
 * @author Venzah Hamilton
 * @version 1.1
 */

public class Result {

    private static final int MAXIMUM_GRADE = 100;
    private static final int MINIMUM_GRADE = 0;
    private static final String OUTPUT_FILE = "report.txt";

    /**
     * Reads through the file line-by-line and creates new Student objects using the provided information. These
     * Student objects are stored in an array list and returned
     *
     * @param scanner A scanner object that will be reading through the file
     * @return ArrayList<Student> An array list of Student objects
     */
    public static ArrayList<Student> loadStudents(Scanner scanner){
        ArrayList<Student> studentList = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String[] studentInfo = scanner.nextLine().split("\\s+");
            try{
                validateStudent(studentInfo); // A new student is only created if it passes validation
                Student student = new Student(studentInfo[0], studentInfo[1], studentInfo[2], studentInfo[3], studentInfo[4]);
                studentList.add(student);

            } catch(NumberFormatException errorMessage){
                System.out.println(errorMessage.getMessage());
            }
            catch(IllegalArgumentException errorMessage){
                System.out.println(errorMessage.getMessage());
            }
        }
        return studentList;
    }

    /**
     * Ensures the data provided is valid by checking that:
     * 1. There are 5 items in the list (last name, first name, midterm 1 grade, midterm 2 grade, and final exam grade)
     * 2. All three grades are between 0 and 100 (inclusive)
     * 3. All three grades are numbers
     *
     * If it fails any of these checks, an exception is thrown
     *
     * @param student A string list containing the student's information
     * @throws IllegalArgumentException thrown if any of the grades is less than 0 or greater than 100
     * @throws NumberFormatException thrown if there is a non-number in any of the section where there should be grades
     */
    public static void validateStudent (String[] student) throws IllegalArgumentException, NumberFormatException{
        if(student.length != 5){
            throw new IllegalArgumentException("The student must have a first and last name, 2 midterm scores, and a final score (5 elements)");
        }
        try{
            if(Double.parseDouble(student[2]) < MINIMUM_GRADE || Double.parseDouble(student[3]) < MINIMUM_GRADE || Double.parseDouble(student[4]) < MINIMUM_GRADE){
                throw new IllegalArgumentException("Grades can only be 0 or greater");
            }
            if(Double.parseDouble(student[2]) > MAXIMUM_GRADE || Double.parseDouble(student[3]) > MAXIMUM_GRADE || Double.parseDouble(student[4]) > MAXIMUM_GRADE){
                throw new IllegalArgumentException("Grades cannot exceed 100");
            }
        } catch(NumberFormatException errorMessage){
            throw new NumberFormatException("One of the grades is not a number");
        }
    }

    /**
     * Will write the following results to report.txt:
     * Last name   First name   Midterm 1 grade   Midterm 2 grade   Final Exam grade   Letter grade
     *
     * Averages: Midterm1: Midterm 1 class average, Midterm2: Midterm 2 class average, Final: Final exam class average
     *
     * @param printWriter A PrintWriter object that will be used to write to report.txt
     * @param classroom A Classroom object which contains a list of Student objects of all the students in the file
     */
    public static void writeResults(PrintWriter printWriter, Classroom classroom){
        for(Student student : classroom.getStudents()){
            printWriter.printf("%s\t%s\t%s\t%s\t%s\t%s\n", student.getLastName(), student.getFirstName(), student.getMidterm1Grade(), student.getMidterm2Grade(), student.getFinalGrade(), student.calculateGrade());
        }
        printWriter.printf("\nAverages: Midterm1: %.2f, Midterm2: %.2f, Final: %.2f", classroom.calculateMidterm1Average(), classroom.calculateMidterm2Average(), classroom.calculateFinalAverage());
    }

    /**
     * Checks to ensure that the file the user wants the program to read is a tsv file
     *
     * @param fileName String representation of the file to be read
     * @throws IllegalArgumentException This exception is thrown if the file is not a tsv (ends with .tsv)
     */
    public static void validateTsvFile(String fileName) throws IllegalArgumentException{
        if(!fileName.substring(fileName.length() - 4).equals(".tsv")){
            throw new IllegalArgumentException("The file must be a tsv file");
        }
    }

    /**
     * Prompts the user for a file name and if it exists, it reads the data, caluclates the grade and class avaerages,
     * and writes the results in a file called report.txt.
     *
     * Note: Should consider throwing if tsv file is not specified
     *
     * @param args String list of arguments (for this program, no arguments are needed)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("What file would you like to open: ");
        String fileName = scanner.nextLine();

        File file = null;
        Classroom classroom = null;

        try{
            validateTsvFile(fileName);
            file = new File(fileName);
        } catch(IllegalArgumentException errorMessage){
            System.out.println(errorMessage.getMessage());
        }

        if(file != null){ // Program will not read file (or write to report.txt) if file is incorrectly formatted
            try {
                FileInputStream fileStream = new FileInputStream(file);
                Scanner fileScanner = new Scanner(fileStream);

                classroom = new Classroom(loadStudents(fileScanner));

                fileStream.close();
                fileScanner.close();

            } catch(FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch(IOException e) {
                System.out.println(e.getMessage());
            }
        } else{
            System.out.println("Error with reading file");
        }

        if(classroom != null){ // Program will not write to report.txt if file is not found
            try{
                FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
                PrintWriter printWriter = new PrintWriter(fileWriter);

                writeResults(printWriter, classroom);

                printWriter.close();
                fileWriter.close();
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
        } else{
            System.out.println("Error with writing file");
        }
    }
}
