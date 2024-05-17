
## Project Requirements

A.   Create a new Java project using Spring Initializr, with each of the following dependencies:

•    Spring Data JPA (spring-boot starter-data-jpa)

•    Rest Repositories (spring-boot-starter-data-rest)

•    MySQL Driver (mysql-connector-java)

•    Lombok

> Initial set up done through intelliJ's Spring Initializr
> application.properties - copied from LabFiles from the lab environment

Note: Since the application properties will be empty, you will need to copy over the supplied application properties.



B.   Create your subgroup and project by logging into GitLab using the web link provided and do the following:

•    connect your new Java project

•    commit with a message and push when you complete each of the tasks listed below (parts B to F, etc.)



Note: Any submissions that do not have a commit after each task will not be evaluated.


Note: You may commit and push whenever you want to back up your changes, even if a task is not complete.


•    Submit a copy of the git repository URL and a copy of the repository branch history retrieved from your repository, which must include the commit messages and dates.


Note: Wait until you have completed all the following prompts before you create your copy of the repository branch history.



C.   Construct four new packages, one for each of the following: controllers, entities, dao, and services. The packages will need to be used for a checkout form and vacations packages list.


Note: The packages should be on the same level of the hierarchy.


Note: Construct a package named config and copy the RestDataConfig.java provided in the laboratory environment to the package. Modify it so that the package and imports have the correct package and import addresses. Copy the application.properties file that is provided in the laboratory environment into your application properties resource file.



D.   Write code for the entities package that includes entity classes and the enum designed to match the UML diagram.


E.   Write code for the dao package that includes repository interfaces for the entities that extend JpaRepository, and add cross-origin support.


F.   Write code for the services package that includes each of the following:

•    a purchase data class with a customer cart and a set of cart items

•    a purchase response data class that contains an order tracking number

•    a checkout service interface

•    a checkout service implementation class



G.   Write code to include validation to enforce the inputs needed by the Angular front-end.


H.   Write code for the controllers package that includes a REST controller checkout controller class with a post mapping to place orders.


Note: You do not need to duplicate REST functionality for each repository by creating methods in Java.


I.   Add five sample customers to the application programmatically.


Note: Make sure the customer information is not overwritten each time you run the application.


J.   Run your integrated application by adding a customer order for a vacation with two excursions using the unmodified Angular front-end. Provide screenshots for the following:

•    that your application does not generate a network error when adding the data

•    your database tables using MySQL Workbench to show the data was successfully added



Note: The screenshot should include the front-end view and the inspection console in the browser.


K.   Demonstrate professional communication in the content and presentation of your submission.

## Database

- The script 'resets' the database state in 3 steps:
    - Drops the database and recreates it.
    - Inserts a demo customer and cart, and all other data.
    - Creates a user `ecommerceapp` and grants permissions as needed.
- **Always run it after testing to ensure a clean slate.**
- **Don't open the file directly.** Instead, follow these steps:
    - Open MySQL Workbench
    - Click on the 'Local instance MySQL80` connection.
    - Go to File > Open SQL Script
    - The script is located at `C:\LabFiles\create_and_populate_db.sql`
    - Click the lightning bolt to execute the script.

## Frontend

- To start the frontend, open PowerShell and run this command in a seperate powershell window, with the backend already running: <br>
  cd 'C:\LabFiles\D288 Front End\'; ng serve

- Leave the powershell window open. You'll know it's running when you see `√ Compiled successfully.` in the output.

- You can also use the debug feature of VS Code by opening the project folder: (C:\LabFiles\D288 Front End) and selecting the ng serve configuration.

- Open [http://localhost:4200/](http://localhost:4200/)

- If you need to stop the frontend, press `CTRL + C` repeatedly in the PowerShell window.

## Application Properties

The application.properties file contains connection strings for your Spring application to connect to the database.
Please add it to your spring project.