package fa.training.entities;

import fa.training.utils.Validator;

import java.util.Scanner;

/**
 * A class represents a course.
 *
 * @author AnhNN66
 * @version 1.0
 * @since 2023-02-15
 */
public class Course {
    private String id;
    private String name;
    private double duration;
    private String status;
    private String flag;

    public Course(String id, String name, double duration, String status, String flag) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.status = status;
        this.flag = flag;
    }

    public Course() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return String.format("%10s || %20s || %10f || %12s || %12s", id, name, duration, status, flag);
    }

    /**
     * This method is used to add new course
     * @param courseIDList list of course id
     */
    public void updateCourse(String[] courseIDList) {
        Scanner scanner = new Scanner(System.in);

        // enter course id
        while (true) {
            System.out.println("Enter course id (started by “FW” and followed by 3 digits): ");
            String id = scanner.nextLine();
            if (Validator.isCourseId(id) && Validator.isUniqueCourseId(id, courseIDList)) {
                setId(id);
                break;
            } else {
                System.out.println("Course ID has been existed. Please enter another ID.");
            }
        }

        // enter course name
        System.out.println("Enter course name");
        setName(scanner.nextLine());

        // enter course duration
        while (true) {
            System.out.println("Enter course duration");
            try {
                double duration = Double.parseDouble(scanner.nextLine());
                setDuration(duration);
                break;
            } catch (Exception e) {
                System.out.println("Invalid course duration");
            }
        }

        // enter course status
        while (true) {
            System.out.println("Enter course status (only accept ‘active’ or ‘in-active’)");
            String status = scanner.nextLine();
            if (Validator.isStatus(status)) {
                setStatus(status);
                break;
            } else {
                System.out.println("Invalid course status");
            }
        }

        // enter course flag
        while (true) {
            System.out.println("Enter course flag (only accept ‘optional’, ‘mandatory’, ‘N/A’)");
            String flag = scanner.nextLine();
            if (Validator.isFlag(flag)) {
                setFlag(flag);
                break;
            } else {
                System.out.println("Invalid course flag");
            }
        }
    }

    /**
     * This method is used to update course information
     */
    public void updateCourse() {
        Scanner scanner = new Scanner(System.in);

        // enter course name
        System.out.println("Enter course name");
        setName(scanner.nextLine());

        // enter course duration
        while (true) {
            System.out.println("Enter course duration");
            try {
                double duration = Double.parseDouble(scanner.nextLine());
                setDuration(duration);
                break;
            } catch (Exception e) {
                System.out.println("Invalid course duration");
            }
        }

        // enter course status
        while (true) {
            System.out.println("Enter course status (only accept ‘active’ or ‘in-active’)");
            String status = scanner.nextLine();
            if (Validator.isStatus(status)) {
                setStatus(status);
                break;
            } else {
                System.out.println("Invalid course status");
            }
        }

        // enter course flag
        while (true) {
            System.out.println("Enter course flag (only accept ‘optional’, ‘mandatory’, ‘N/A’)");
            String flag = scanner.nextLine();
            if (Validator.isFlag(flag)) {
                setFlag(flag);
                break;
            } else {
                System.out.println("Invalid course flag");
            }
        }
    }
}
