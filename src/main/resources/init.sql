CREATE DATABASE Kanban;
Use Kanban;
CREATE TABLE Applicant (
    Contact VARCHAR(20) NOT NULL,
    FirstName VARCHAR(255) NOT NULL,
    LastName VARCHAR(255) NOT NULL,
    Education VARCHAR(255) NOT NULL,
    Status VARCHAR(255) NOT NULL,
    Resume BLOB,
    Rate Double,
    RateCount int Default 0,
    Primary key(Contact)
);

CREATE TABLE Comment (
	CommentID Int Primary key auto_increment,
    Contact varchar(20),
    Comment varchar(255),
    author  varchar(255)
);
CREATE TABLE hruser (
	email VARCHAR(255) NOT NULL Primary key,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    password VARCHAR(255)
);