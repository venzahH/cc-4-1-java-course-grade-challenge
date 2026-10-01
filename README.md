[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/sgf7HsHH)
# CC3.2---Java-OOP2-Challenge
Intro to Superior Java Week 2 Challenge

Follow the instruction from Canvas [CC 3.2 - Java OOP2 Challenge ](https://awstechu.instructure.com/courses/778/modules/items/142643)

# Summary
This program will read files containing student exam data by prompting for a file name, create a file caller report.txt, and write the following results:
1. The students last name, first name, midterm 1 score, midterm 2 score, final exam score, and letter grade for the class
2. The classroom's average for midterm 1, midterm 2, and final exam

For testing, three files have been provided
1. StudentInfo.tsv - A tsv file containing a generic data set with no errors
2. Error.tsv - A tsv file containing erroneous data which should be caught by the program and as a result, the student with the incorrect data will not included in report.txt
3. StudentInfo.txt - An exact copy of StudentInfo.tsv except formatted as a text file. As a result, the program should detect that it's not a tsv file and not read it or write to report.txt

# Instructions to Run File
## Terminal
1. Download
2. Navigate to the folder containing the (for example: cd ~/Downloads/cc-4-1-java-course-grade-challenge-venzah-git-main/src)
3. Run: javac Result.java
4. Run: java Result

## IntelliJ
1. Download
2. Open IntelliJ
3. Select File > Open... > the newly downloaded folder
4. In the lefthand navigation panel, expand the src folder to reveal the Java files
5. Select the file labeled Result
6. Select Run > Run... > Result file

Important note: If running with InelliJ you will need to add the src folder when entering the file name (ie. use "src/StudentInfo.tsv")
