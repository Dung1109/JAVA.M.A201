package fa.training.main;

import fa.training.entities.Course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/**
 * A class to manage courses.
 *
 * @author AnhNN66
 * @version 1.0
 * @since 2023-02-15
 */
public class CourseManagement {
    private static final List<Course> courses = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) {
        CourseManagement courseManagement = new CourseManagement();
        Scanner scanner = new Scanner(System.in);
        boolean isContinue = false;
        do {
            courseManagement.display();
            String choice = scanner.next();
            // check choice is from 0 to 5
            try {
                if (Integer.parseInt(choice) < 0 || Integer.parseInt(choice) > 9) {
                    throw new Exception("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Invalid choice!");
                continue;
            }
            switch (choice) {
                case "0" -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                case "1" -> {
                    courseManagement.addCourse(new Course());
                    courses.get(count - 1).updateCourse(Arrays.stream(courses.toArray()).map(course -> ((Course) course).getId()).toArray(String[]::new));

                }
                case "2" -> {
                    System.out.println("Please input the type of search (id, name, duration, status, flag): ");
                    scanner.nextLine();
                    String type = scanner.nextLine();
                    courseManagement.find(type, courses);
                }
                case "3" -> courseManagement.displayCourseByFlag();
                case "4" -> {
                    System.out.println("Display all courses:");
                    if (courses.isEmpty()) {
                        System.out.println("No course to display!");
                        break;
                    }
                    System.out.printf("%10s || %20s || %10s || %12s || %12s%n", "ID", "Name", "Duration", "Status", "Flag");
                    System.out.println("-".repeat(86));
                    for (Course course : courses) {
                        System.out.println(course);
                    }
                }
                case "5" -> {
                    System.out.println("Delete all the course!!! ");
                    courseManagement.delete();
                }
                case "6" -> {
                    System.out.println("Save course list to file 'input.txt'");
                    // save courses to txt file
                    try (BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt"))) {
                        for (Course course : courses) {
                            bw.write(course.toString());
                            bw.newLine();
                        }
                        System.out.println("Successfully saved!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "7" -> {
                    System.out.println("Load course list from file 'input.txt'");
                    courseManagement.delete();
                    // load courses from txt file
                    try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] arr = line.split("\\|\\|");
                            Course course = new Course(arr[0].trim(), arr[1].trim(), Double.parseDouble(arr[2].trim()), arr[3].trim(), arr[4].trim());
                            courseManagement.addCourse(course);
                        }
                        System.out.println("Successfully loaded!");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                case "8" -> {
                    courses.sort(Comparator.comparing(Course::getId));
                    System.out.println("Sort by id successfully!");
                }
                case "9" -> {
                    System.out.print("Input the ID of the course to update: ");
                    String id = scanner.next();
                    for (Course course : courses) {
                        if (course.getId().equalsIgnoreCase(id)) {
                            course.updateCourse();
                            System.out.println("Update successfully!");
                            break;
                        }
                    }
                }
                default -> System.out.println("Invalid choice!");
            }
            System.out.print("Do you want to continue? (Y/N): ");
            isContinue = !scanner.next().equalsIgnoreCase("n");
        } while (isContinue);
    }

    /**
     * Clear the course list.
     */
    private void delete() {
        courses.clear();
        count = 0;
    }

    /**
     * Display the course with "mandatory" flag.
     */
    private void displayCourseByFlag() {
        System.out.printf("%10s || %20s || %10s || %12s || %12s%n", "ID", "Name", "Duration", "Status", "Flag");
        System.out.println("-".repeat(86));
        for (Course course : courses) {
            if (course.getFlag().equalsIgnoreCase("mandatory")) {
                System.out.println(course);
            }
        }
    }

    /**
     * Find and display the course with specific info.
     */
    private void find(String type, List<Course> courses) {
        switch (type) {
            case "id" -> {
                System.out.println("Please input the id: ");
                String id = new Scanner(System.in).nextLine();
                for (Course course : courses) {
                    if (course.getId().contains(id)) {
                        System.out.println("course = " + course);
                    }
                }
            }
            case "name" -> {
                System.out.println("Please input the name: ");
                String name = new Scanner(System.in).nextLine();
                for (Course course : courses) {
                    if (course.getName().contains(name)) {
                        System.out.println("course = " + course);
                    }
                }
            }
            case "duration" -> {
                System.out.println("Please input the duration: ");
                double duration = new Scanner(System.in).nextDouble();
                for (Course course : courses) {
                    if (course.getDuration() == duration) {
                        System.out.println("course = " + course);
                    }
                }
            }
            case "status" -> {
                System.out.println("Please input the status: ");
                String status = new Scanner(System.in).nextLine();
                for (Course course : courses) {
                    if (course.getStatus().contains(status)) {
                        System.out.println("course = " + course);
                    }
                }
            }
            case "flag" -> {
                System.out.println("Please input the flag: ");
                String flag = new Scanner(System.in).nextLine();
                for (Course course : courses) {
                    if (course.getFlag().contains(flag)) {
                        System.out.println("course = " + course);
                    }
                }
            }
            default -> System.out.println("Invalid type search!");
        }
    }

    /**
     * Add a new course to the course list.
     */
    private void addCourse(Course course) {
        courses.add(count++, course);
    }

    /**
     * Display the menu.
     */
    private void display() {
        System.out.println("==========================================================");
        System.out.println("Welcome to Course Management System");
        System.out.println("Please choose an option:");
        System.out.println("0. Exit");
        System.out.println("1. Add new course");
        System.out.println("2. Search course by name");
        System.out.println("3. Display mandatory courses");
        System.out.println("4. Display all courses");
        System.out.println("5. Delete all courses");
        System.out.println("6. Save all courses to file");
        System.out.println("7. Read all courses from file");
        System.out.println("8. Sort the course list by ID in ascending order.");
        System.out.println("9. Update course by ID");
        System.out.println("--------------");
        System.out.print("Your choice: ");
    }
}


