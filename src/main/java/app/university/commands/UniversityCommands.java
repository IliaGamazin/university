package app.university.commands;

import app.university.services.UniversityService;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UniversityCommands {
    private final UniversityService service;

    public UniversityCommands(UniversityService service) {
        this.service = service;
    }

    @ShellMethod(
        key = "Who is head of department",
        value = "Display the department's head name"
    )
    public String findDepartmentHead(@ShellOption String arg) {
        String res = service.getDepartmentHeadName(arg);
        return "Head of " + arg + " is " + res;
    }

    @ShellMethod(key = "Show", value = "Display the department's statistics")
    public String showDepartmentStatistics(String arg, String suffix) {
        if (suffix == null || !suffix.equals("statistics")) {
            System.err.println("Invalid command format. Did you mean 'show {department_name} statistics'?");
        }
        return "Showing statistics of " + arg + suffix;
    }

    @ShellMethod(
        key = "Show the average salary for the department",
        value = "Display the department's average salary"
    )
    public String showAverageSalary(String arg) {
        Double res = service.getAverageSalary(arg);
        return "The average salary of " + arg + " is " + res;
    }

    @ShellMethod(
        key = "Show count of employee for",
        value = "Display the department's employee count"
    )
    public String showEmployeeCount(String arg) {
        return service.getEmployeeCount(arg).toString();
    }

    @ShellMethod(key = "Global search by", value = "Display department/lector names by template")
    public String showGlobalSearchResults(String arg) {
        return service.getGlobalSearchResults(arg);
    }
}
