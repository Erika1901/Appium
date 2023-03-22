/**
 * @author Rajat Verma
 * https://www.linkedin.com/in/rajat-v-3b0685128/
 * https://github.com/rajatt95
 * https://rajatt95.github.io/
 *
 * Course: Appium Mobile Automation - Android & iOS + Frameworks + CICD (https://www.udemy.com/course/the-complete-appium-course-for-ios-and-android/)
 * Tutor: Omprakash Chavan (https://www.udemy.com/user/omprakash-chavan/)
 */

/***************************************************/

package com.appium.java_Mail_API;

import static com.appium.constants.FrameworkConstants.Project_Name;

/**
 * Data for Sending EMail after execution
 */
public class EmailConfig {

	public static final String SERVER = "smtp.gmail.com";
	public static final String PORT = "587";

	public static final String FROM = "ngaedzoa98@gmail.com";
	public static final String PASSWORD = "Malika2016+";

	/* "**********@gmail.com", */
	public static final String[] TO = { "ngaedzoa98@gmail.com" };
	public static final String SUBJECT = Project_Name;
}
