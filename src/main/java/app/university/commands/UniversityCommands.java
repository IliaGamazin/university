package app.university.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UniversityCommands {
    @ShellMethod(
        key = "Who is head of department",
        value = "Display the department's head name"
    )
    public String findDepartmentHead(@ShellOption String arg) {
        return "Finding head of" + arg;
    }

    @ShellMethod(
        key = "Show count of employee for",
        value = "Display the department's employee count"
    )
    public String showEmployeeCount(String arg) {
        return "Showing employee count of " + arg;
    }

    @ShellMethod(
        key = "Show the average salary for the department",
        value = "Display the department's average salary"
    )
    public String showAverageSalary(String arg) {
        return "Showing average salary of " + arg;
    }

    @ShellMethod(key = "Show", value = "Display the department's statistics")
    public String showDepartmentStatistics(String arg, String suffix) {
        if (suffix == null || !suffix.equals("statistics")) {
            System.err.println("Invalid command format. Did you mean 'show {department_name} statistics'?");
        }
        return "Showing statistics of " + arg + suffix;
    }

    @ShellMethod(key = "Global search by", value = "Display department/lector names by template")
    public String showGlobalSearchResults(String arg) {
        return "Showing global search results by" + arg;
    }
}
