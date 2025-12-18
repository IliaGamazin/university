## How to Run

```bash
docker compose -up -d
```

<strong>Note that for input parameters, consisting of more than one word (e.g. Applied Mathematics) Your input should be enclosed in double quotes.</strong>

✅ Show "department name" statistics 
<br>
❌ Show department name statistics

## How to use

1. User Input: Who is head of department {department_name}<br>
   Answer: Head of {department_name} department is {head_of_department_name}<br>

2. User Input: Show {department_name} statistics.<br>
   Answer: assistans - {assistams_count}.<br>
   associate professors - {associate_professors_count}<br>
   professors -{professors_count}<br>

3. User Input: Show the average salary for the department {department_name}.<br>
   Answer: The average salary of {department_name} is {average_salary}<br>

4. User Input: Show count of employee for {department_name}.<br>
   Answer: {employee_count}<br>

5. User Input: Global search by {template}.<br>
   Example: Global search by van<br>
   Answer: Ivan Petrenko, Petro Ivanov<br>
