## How to Run

```bash
docker compose -up -d
```

<strong>Note that for input parameters, consisting of more than one word (e.g. Applied Mathematics) Your input should be enclosed in double quotes.</strong>

✅ Show "department name" statistics 
<br>
❌ Show department name statistics

## How to use

1. User Input: Who is head of department {department_name}
   Answer: Head of {department_name} department is {head_of_department_name}

2. User Input: Show {department_name} statistics.
   Answer: assistans - {assistams_count}.
   associate professors - {associate_professors_count}
   professors -{professors_count}

3. User Input: Show the average salary for the department {department_name}.
   Answer: The average salary of {department_name} is {average_salary}

4. User Input: Show count of employee for {department_name}.
   Answer: {employee_count}

5. User Input: Global search by {template}.
   Example: Global search by van
   Answer: Ivan Petrenko, Petro Ivanov
