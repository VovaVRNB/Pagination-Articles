Detailed Build

Stack:
- Java 11
- Angular 12
- MySQL server 8.0.28

1. DB setting.

This application use MySQL database. Before starting you need to create db, tables and fill some data for the app. You can find the script below:

CREATE DATABASE ART;

USE ART;

create table roles(
	id int NOT NULL AUTO_INCREMENT,
	name VARCHAR(20) NOT NULL,
	PRIMARY KEY (id)
);

create table users(
	id int NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	password VARCHAR(100) NOT NULL,
	role_id int NOT NULL,
	PRIMARY KEY (id), 
	FOREIGN KEY (role_id) REFERENCES roles(id),
	UNIQUE(name)
);

create table articles(
	id int NOT NULL AUTO_INCREMENT,
	title VARCHAR(100) NOT NULL,
	content TEXT NOT NULL,
	date VARCHAR(50) NOT NULL,
	user_id int NOT NULL,
	PRIMARY KEY (id), 
	FOREIGN KEY (user_id) REFERENCES users(id)
);

insert into roles(name) value("ROLE_ADMIN"), ("ROLE_USER");

insert into users (name, password, role_id) values 
("admin", "$2a$10$Il7twPvztg1rns8oQqa1E.V7xKohWXaiXTjJ06Ubalm//nZsGm6aq", 1), 
("user", "$2a$10$Il7twPvztg1rns8oQqa1E.V7xKohWXaiXTjJ06Ubalm//nZsGm6aq", 2);

insert into articles(title, content, date, user_id) values("title1", "content1", "2022-06-27T14:00:00.000000Z", 2), ("title2", "content2", "2022-06-28T14:00:00.000000Z", 2), ("title3", "content3", "2022-06-29T14:00:00.000000Z", 2), ("title4", "content4", "2022-06-30T14:00:00.000000Z", 2), ("title5", "content5", "2022-07-01T14:00:00.000000Z", 2), ("title6", "content6", "2022-07-02T14:00:00.000000Z", 2), ("title7", "content7", "2022-07-03T14:00:00.000000Z", 2), ("title8", "content8", "2022-07-04T14:00:00.000000Z", 2), ("title9", "content9", "2022-07-04T15:00:00.000000Z", 1), ("title10", "content10", "2022-07-04T16:00:00.000000Z", 1), ("title11", "content11", "2022-07-04T17:00:00.000000Z", 1);

2. Application setting.   
 
Now, when db is created, you need to go to application code and find «application.properties» file where you need to set username and password for your database. Next you can start the application.

3. UI setting.

UI uses Angular. Some steps to start our UI:
- Download Node.Js from https://nodejs.org/en/download/
- Check your version by command “node -v”
- Install Angular CLI by command “npm install -g @angular/cli”
- Check your Angular version by command “ng -v”

After Angular installation open your terminal, go to the «articlesUI» directory and write «ng serve» command to start. Now you can go to the «localhost:4200/login».

In «login» page you can log in by two ways: as admin or as user. Difference between this two roles is that admin has permission to statistic. However user can just search, watch and create.

Credentials:

- For ADMIN:
	Login - admin
	Password - password
- For USER:
	Login - user
	Password - password


Thats all what you need to do to start application.


