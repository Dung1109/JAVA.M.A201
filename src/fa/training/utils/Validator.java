package fa.training.utils;

import java.util.Arrays;

/**
 * A utility class provides the functions to check input data.
 *
 * @author AnhNN66
 * @version 1.0
 * @since 2023-02-15
 */
public class Validator {
    //course code: is a string of 5 characters, started by “FW” and followed by 3 digits.
    private static final String VALID_COURSE_ID_REGEX = "^FW\\d{3}$";

    /**
     * Check course id is valid.
     *
     * @param courseId course id
     * @return true, if valid, otherwise return false.
     */
    public static boolean isCourseId(String courseId) {
        return courseId.matches(VALID_COURSE_ID_REGEX);
    }

    private static final String VALID_STATUS_REGEX = "^(active|in-active)$";

    /**
     * Check course status is valid.
     *
     * @param status course status
     * @return true, if valid, otherwise return false.
     */
    public static boolean isStatus(String status) {
        return status.matches(VALID_STATUS_REGEX);
    }

    //flag: only accept ‘optional’, ‘mandatory’, ‘N/A’.
    private static final String VALID_FLAG_REGEX = "^(optional|mandatory|N/A)$";

    /**
     * Check course flag is valid.
     *
     * @param flag  course flag
     * @return true, if valid, otherwise return false.
     */
    public static boolean isFlag(String flag) {
        return flag.matches(VALID_FLAG_REGEX);
    }

    /**
     * Check course id is unique.
     *
     * @param id course id
     * @param courseIDList list of course id
     * @return true, if valid, otherwise return false.
     */
    public static boolean isUniqueCourseId(String id, String[] courseIDList) {
        return courseIDList == null || !Arrays.asList(courseIDList).contains(id);
    }
}
