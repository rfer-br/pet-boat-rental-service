# pet-boat-rental-service
Assignment Title
Pet-Friendly Boat Rental Service API

Objective
Develop a GraphQL API using Spring Boot that interfaces with a PostgreSQL database. This API will manage pet eligibility for a boat rental service based on specific conditions such as weight, breed, vaccination status, and training level.

Overview
Build a GraphQL API using Spring Boot that allows users to check if their pets are eligible for a boat rental.

Requirements
- Database Setup: Use PostgreSQL to create a database for storing pet information (e.g., name, weight, breed, vaccination status, training level).
- Create GraphQL queries and mutations to:
  Add new pet records to the database.
  Retrieve pet data based on different criteria.
  + Under 25 lbs
  + Vaccinated
  + Not a Poodle
  + Training level 3 or above (use a scale of 1-10 for training)
- Check eligibility of a pet for boat rental based on predefined rules as listed above
- Business Logic: Implement business logic to determine pet eligibility (weight limit, breed restrictions, vaccination requirement, training level).
- Implement basic error handling for the API and database interactions.
- Bonus: add pet_owner as an object and require pets to be assigned to a pet_owner.

Coding Standards
- Well-structured, readable, and maintainable code.  Well-written code needs minimal, if any, comments in the code
- Efficient use of Java best practices.

Submission
- Source code of the application, or share a public GitHub repo
- A readme.md file explaining the API endpoints, how to interact with them, the structure of the database, and how to get the project up and running after cloning the repo
- Assignment to be completed and submitted within 24 hours.

General advice for the Candidate when completing the assignment
- Focus on creating a well-structured and efficient API.
- Ensure all requirements are met with clear and concise code.
- Test the API thoroughly to handle different scenarios.

**********

The below requirements weren't completed yet:

-- include unit tests;
-- change some things in database(change some column names) and perform corresponding refactor within the code;
-- change to graphql instead of using rest;
-- change to postgresql instead of H2;
-- include db startup script to insert some essential data to test api's;
-- include swagger to document api's;
-- review annotations;
-- check comments and indentation;