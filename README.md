# TASK MANAGEMENT APPLICATION

### Overview:

Background:
<br>Individuals require an effective solution
to efficiently organize their personal tasks spanning various related and/or unrelated responsibilities,
aiming to boost productivity.

### Target Users:
Individuals seeking personal task organization.

### User Story:
As a user, I want to be able to sign up for an account, So that I can access the application and manage my tasks.
* Acceptance Criteria: 
 <br>As a new user, I can sign up for a new account.
 <br>On the sign-up form, I can provide my first name, last name, email, password, confirm password, phone number.
 <br>Upon successful sign-up, I should receive a confirmation email with a token to validate my account after which I can login using my email and password.
 <br>As a registered user, I can log in to my account.
 <br>On log-in, I will use my email and password.
 <br>Upon successful login I should be able to do the following;

i. Create tasks with specific details such as title, description, deadline, priority level (HIGH, MEDIUM, LOW, NONE) etc.

ii. View details of a specific task by its title or ID.

iii. View all tasks associated with a specific user

iv. Edit a task successfully.

v. Delete a task successfully

vi. Filter a task by their status e.g. (PENDING, IN_PROGRESS, COMPLETED).

vii. View a list of completed tasks separately

viii. I can log out of my account.

### Technologies to use:

1. Spring Boot

2. Spring security / JWT

3. Postman

4. MySQL / PostgreSQL

5. GIT


# Project Setup

## Ticket: Project Setup

 * Description: Set up the initial project structure for the Spring Boot application.

 * Tasks:

    i. Initialize a new Spring Boot project using Spring Initializr.

    ii. Set up the project in a version control system (Git) and create a repository.

    iii. Configure the project to use MySQL/PostgreSQL.

 * Acceptance Criteria:

    i. The project structure is created.

    ii. The project is successfully pushed to the Git repository.

    iii. Database connection is configured and tested.


### User Registration 
###### @RequestMapping("/api/auth")
###### @PostMapping("/register")


 * Ticket: User Registration Endpoint

 * Description: Implement the user registration functionality.

 * Tasks:

   i. Create a REST endpoint for user registration.

   ii. Define a User entity with fields: first name, last name, email, password, confirm password, and phone number.

   iii. Implement validation for the input fields.

   iv. Send a confirmation email with a token for account validation.

 * Acceptance Criteria:

   i. Users can register by providing the necessary information.

   ii. Validation errors are returned for incorrect inputs.

   iii. A confirmation email is sent upon successful registration.


### Email Confirmation

###### @RequestMapping("/api/auth")
###### @GetMapping("/confirm")

 * Ticket: Email Confirmation Endpoint

 * Description: Implement email confirmation functionality.

 * Tasks:

   i. Create a REST endpoint to handle email confirmation.

   ii. Validate the token and activate the user account.

 * Acceptance Criteria:

   i. Users can confirm their email using the token sent.

   ii. Upon confirmation, users can log in to their accounts.

### User Login

###### @RequestMapping("/api/auth") 
###### @PostMapping("/login")

 * Ticket: User Login Endpoint

 * Description: Implement the user login functionality.

 * Tasks:

   i. Create a REST endpoint for user login.

   ii. Implement authentication using Spring Security and JWT.

   iii. Return a JWT token upon successful authentication.

 * Acceptance Criteria:

   i. Users can log in using their email and password.

   ii. A JWT token is returned for authenticated users.

### Task Creation

###### @RequestMapping("/api/tasks") 
###### @PostMapping("/create")

 * Ticket: Task Creation Endpoint

 * Description: Implement functionality to create tasks.

 * Tasks:

   i. Create a REST endpoint for creating tasks.

   ii. Define a Task entity with fields: title, description, deadline, priority level.

   iii. Associate tasks with users.

 * Acceptance Criteria:

   i. Users can create tasks with the specified details.

   ii. Tasks are stored in the database and associated with the correct user.

### View Task Details

###### @RequestMapping("/api/tasks")
###### @GetMapping("/{id}")

 * Ticket: View Task Details Endpoint

 * Description: Implement functionality to view details of a specific task.

 * Tasks:

   i. Create a REST endpoint to retrieve task details by task ID.

   ii. Ensure only the task owner can view the task details.

 * Acceptance Criteria:

   i. Users can retrieve task details by providing the task ID.

   ii. Task details are correctly returned.


### View All Tasks 

###### @RequestMapping("/api/tasks") 
###### @GetMapping

 * Ticket: View All Tasks Endpoint

 * Description: Implement functionality to view all tasks for a specific user.

 * Tasks:

   i. Create a REST endpoint to retrieve all tasks associated with a user.

   ii. Ensure only the task owner can view the tasks.

 * Acceptance Criteria:

   i. Users can view all their tasks.

   ii. All tasks associated with the user are returned.

### Edit Task

###### @RequestMapping("/api/tasks")
###### @PutMapping("/{id}")

 * Ticket: Edit Task Endpoint

 * Description: Implement functionality to edit a task.

 * Tasks:

   i. Create a REST endpoint to edit task details.

   ii. Ensure only the task owner can edit the task.

 * Acceptance Criteria:

   i. Users can edit their tasks.

   ii. Updated task details are saved in the database.

### Delete Task

###### @RequestMapping("/api/tasks")
###### @DeleteMapping("/{id}")

 * Ticket: Delete Task Endpoint

 * Description: Implement functionality to delete a task.

 * Tasks:

   i. Create a REST endpoint to delete a task.

   ii. Ensure only the task owner can delete the task.

 * Acceptance Criteria:

   i. Users can delete their tasks.

   ii. The task is removed from the database.

### Filter Tasks by Status

###### @RequestMapping("/api/tasks")
###### @GetMapping("/status/{status}")

 * Ticket: Filter Tasks by Status Endpoint

 * Description: Implement functionality to filter tasks by their status.

 * Tasks:

   i. Create a REST endpoint to filter tasks based on status (PENDING, IN_PROGRESS, COMPLETED).

 * Acceptance Criteria:

   i. Users can filter tasks by status.

   ii. Filtered tasks are correctly returned.

### View Completed Tasks

###### @RequestMapping("/api/tasks") 
###### @GetMapping("/completed")

 * Ticket: View Completed Tasks Endpoint

 * Description: Implement functionality to view a list of completed tasks separately.

 * Tasks:

   i. Create a REST endpoint to retrieve completed tasks for a user.

   ii. Acceptance Criteria:

   iii. Users can view a list of their completed tasks.

   iv. Only completed tasks are returned.

### User Logout

 * Ticket: User Logout

 * Description: Implement user logout functionality.

 * Tasks:

   i. Invalidate the JWT token upon logout.

 * Acceptance Criteria:

   i. Users can log out of their accounts.

   ii. The JWT token is invalidated.


### API Documentation

 * Ticket: API Documentation

 * Description: Document all REST APIs using Swagger or a similar tool.

 * Tasks:

   i. Integrate Swagger into the project.

   ii. Document all endpoints with appropriate details.

 * Acceptance Criteria:

   i. All APIs are documented.

   ii. The documentation is accessible via a web browser.

### Testing

 * Ticket: Unit and Integration Testing

 * Description: Write unit and integration tests for the application.

 * Tasks:

   i. Write unit tests for all service methods.

   ii. Write integration tests for all endpoints.

 * Acceptance Criteria:

   i. Tests cover all functionalities.

   ii. Tests pass successfully.

### Deployment

 * Ticket: Application Deployment

 * Description: Deploy the application to a cloud platform.

 * Tasks:

   i. Set up a cloud environment (e.g., AWS, Heroku).

   ii. Deploy the application.

 * Acceptance Criteria:

   i. The application is deployed and accessible online.

   ii. All functionalities are working in the deployed environment. 

### FrontEnd view

Consider working on the front-end as well
