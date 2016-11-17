import java.util.Scanner;

public class CourseCalculator {
	public static void main(String[] args) {
		final double assignmentPercentage = 0.30;
		final double quizPercentage = 0.20;
		final double examPercentage = 0.15;
		final double finalExamPercentage = 0.20;

		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to the course calculator!");

		System.out.println("For attendance, how frequently did you attend Mr. Henry's class?");
		System.out.print("Enter 0 to 15: ");
		int totalAttendancePoints = sc.nextInt();

		System.out.println("How many exams do you have in this course?");
		int amountOfExams = sc.nextInt();
		int[] examGrades = new int[amountOfExams];
		enterGrades(examGrades);
		int totalExamPoints = sumUpGrades(examGrades);
		displayGrade(examGrades);

		/*
		 * System.out.println("Do you want to replace your lowest grade? (Y/N)"
		 * ); String response = sc.nextLine(); if
		 * (response.equalsIgnoreCase("Y")) {
		 * replaceLowestGradeWith100(examGrades); }
		 */
		displayGrade(examGrades);

		System.out.println("How many quizzes do you have in this course?");
		int amountOfQuizzes = sc.nextInt();
		int[] quizGrades = new int[amountOfQuizzes];
		enterGrades(quizGrades);
		int totalQuizPoints = sumUpGrades(quizGrades);
		displayGrade(quizGrades);

		System.out.println("How many assignments do you have in this course?");
		int amountOfAssignments = sc.nextInt();
		int[] assignmentGrades = new int[amountOfAssignments];
		enterGrades(assignmentGrades);
		int totalAssignmentPoints = sumUpGrades(assignmentGrades);
		displayGrade(assignmentGrades);

		System.out.println("For final exam...");
		int[] finalExamGrade = new int[1];
		enterGrades(finalExamGrade);
		int totalFinalExamPoints = sumUpGrades(finalExamGrade);
		sc.close();
		double finalCoursePercentage = calculateAllGrades(totalAttendancePoints, totalExamPoints, examPercentage,
				totalQuizPoints, quizPercentage, totalAssignmentPoints, assignmentPercentage, totalFinalExamPoints,
				finalExamPercentage);
		System.out.println("You finished Louis Henry's CSC 1301 course with " + finalCoursePercentage + "%!");
	}

	public static void enterGrades(int[] theGrades) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter grades for");
		for (int i = 0; i < theGrades.length; i++) {
			System.out.print("#" + (i + 1) + ": ");
			theGrades[i] = sc.nextInt();
		}
	}

	public static int sumUpGrades(int[] theGrades) {
		int summedUp = 0;
		int count = 0;
		for (int i = 0; i < theGrades.length; i++) {
			summedUp += theGrades[i];
			count++;
		}
		if (theGrades.length != 0) {
			summedUp /= count;
		}
		return summedUp;
	}

	public static void replaceLowestGradeWith100(int[] theGrades) {
		int lowestGrade = theGrades[0];
		int lowestGradeIndex = 0;
		for (int i = 1; i < theGrades.length; i++) {
			if (lowestGrade >= theGrades[i]) {
				lowestGrade = theGrades[i];
				lowestGradeIndex = i;
			}
		}
		theGrades[lowestGradeIndex] = 100;
	}

	public static void displayGrade(int[] theGrades) {
		for (int i = 0; i < theGrades.length; i++) {
			if (i != theGrades.length - 1) {
				System.out.print(theGrades[i] + " ");
			} else {
				System.out.print(theGrades[i]);
			}
		}
		System.out.println();
		System.out.println();
	}

	public static double calculateAllGrades(int attendancePoints, int examGradePoints, double examPercentage,
			int quizGradePoints, double quizPercentage, int assignmentGradePoints, double assignmentPercentage,
			int finalExamPoints, double finalExamPercentage) {
		double examGrade = examGradePoints * examPercentage;
		double quizGrade = quizGradePoints * quizPercentage;
		double assignmentGrade = assignmentGradePoints * assignmentPercentage;
		double finalExamGrade = finalExamPoints * finalExamPercentage;
		return attendancePoints + examGrade + quizGrade + assignmentGrade + finalExamGrade;
	}
}