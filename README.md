# SchoolHub

for part one in the word document:
Part 1- Extract the requirements in simple sentences(use the word).
•	Create two views one for grades and one to fill the students
•	Validate all fields to be filled 
•	Validate that the text filed for number of students takes only numbers
•	Ensure that when we go to view 2 it will dynamically generate text fields based on the number of students 

other parts in the code
## Overview

The Grade and Student Information System is a web-based application that allows users to manage grade information and student data for various cities and schools. This system consists of two main views: 


1. **Create Grade View**: This view enables users to create new grades, including details such as city name, school name, grade name, and the number of students. The system also provides the functionality to check for existing cities and schools in the database.

2. **Student Information View**: In this view, users can select a city, school, and grade to view or enter student information. The system dynamically generates text fields based on the number of students for the selected grade. Users can view and edit existing student names or add new students.

## Getting Started

To use the Grade and Student Information System, follow these steps:

1. Clone the repository to your local machine:
git clone [https://github.com/your-username/grade-student-system.git](https://github.com/ThaerHussein/SchoolHub.git)

2. To run the application you should go to VS code and right click on the file and click on run on the live server and you should run the spring boot project first
   
3. Access the system through your web browser at `http://localhost:5500/index.html`. and `http://127.0.0.1:5500/form2.html`
## Create Grade View

### Accessing the Create Grade View

- Open the application.
- Navigate to the "Create Grade" view.

### Entering Grade Information

- In the "Create Grade" view, you will find text fields for:
- City Name
- School Name
- Grade Name
- Number of Students

- By default, all fields will be disabled.

### Enabling the Text Fields

- To start entering new grade information, click the "New" button.
- All text fields will become enabled, allowing you to input data.

### Filling Out the Form

- Enter the required information in each text field:
- City Name
- School Name
- Grade Name
- Number of Students

- You can also click the "New" button to clear all fields and start over.

### Saving the Grade

- Once you have filled out all the fields, the "Save" button will become enabled.
- Click the "Save" button to save the grade information.
- If the city or school already exists in the database, you will receive an alert with the relevant message.

## Student Information View

### Accessing the Student Information View

- Open the application.
- Navigate to the "Student Information" view.

### Selecting City, School, and Grade

- In the "Student Information" view, you will find three dropdown lists:
- City: Choose a city from the dropdown.
- School: The dropdown will be populated with schools belonging to the selected city.
- Grade: The dropdown will be populated with grades belonging to the selected school.

- Select a city, school, and grade to view or enter student information.

### Viewing Existing Students

- If there are existing students for the selected city, school, and grade, text fields will be generated for each student's name.
- You can view and edit existing student names in these fields.

### Entering New Student Information

- If there are no existing students for the selected grade, text fields will be generated based on the number of students you specified in the grade creation.
- Enter the names of new students in these text fields.

### Saving Student Information

- After entering or editing student information, click the "Save" button to save the data.
- If the data is saved successfully, you will receive a success message.
- If there is an error, an alert message will provide details about the issue.

## Conclusion

With these instructions, you should be able to effectively use the Grade and Student Information System to manage grade creation and student data for different cities and schools.

