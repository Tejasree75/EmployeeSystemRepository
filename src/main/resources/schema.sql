CREATE TABLE EMPLOYEE (
        id INT AUTO_INCREMENT  PRIMARY KEY,
        employee_name VARCHAR(250) NOT NULL,
        employee_gender VARCHAR(500) NOT NULL,
        employee_age INT NOT NULL,
        employee_designation VARCHAR(500) NOT NULL
      );
      INSERT INTO EMPLOYEE(id, employee_name,employee_gender,employee_age,employee_designation) VALUES ('1', 'Teja', 'female', '22','Developer');
      INSERT INTO EMPLOYEE(id, employee_name,employee_gender,employee_age,employee_designation) VALUES ('2', 'Rama', 'male', '21','IT');
      INSERT INTO EMPLOYEE(id, employee_name,employee_gender,employee_age,employee_designation) VALUES ('3', 'Seetha', 'female', '25','Developer');
      INSERT INTO EMPLOYEE(id, employee_name,employee_gender,employee_age,employee_designation) VALUES ('4', 'Krishna', 'male', '26','Tester');
      INSERT INTO EMPLOYEE(id, employee_name,employee_gender,employee_age,employee_designation) VALUES ('5', 'Bhumi', 'female', '22','IT');
