#use citron_kids_manager;

#drop database citron_kids_manager;

#show tables;

CREATE DATABASE IF NOT EXISTS citron_kids_manager;

USE citron_kids_manager;

CREATE TABLE IF NOT EXISTS citron_users(
    username VARCHAR(50) NOT NULL PRIMARY KEY DEFAULT 'root',
    password VARCHAR(64) NOT NULL DEFAULT '$2a$10$2iFgtsjtTbAdOq/j1q1vDOm4LqtWo4RbjiPmbNNZhnOsiZr/FUSaG',
    permission ENUM('ADMIN', 'TEACHER', 'PARENT', 'STUDENT'),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP
);

INSERT INTO citron_users (username, password) VALUES (
                                                         'root',
                                                         '$2a$10$2iFgtsjtTbAdOq/j1q1vDOm4LqtWo4RbjiPmbNNZhnOsiZr/FUSaG'
                                                     );

CREATE TABLE IF NOT EXISTS citron_classes(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    class_id VARCHAR(36) NOT NULL,
    class_time DATETIME NOT NULL,
    subject ENUM('MINECRAFT', 'SWIFT', 'INDIVIDUAL_LEARNING') NOT NULL,
    name VARCHAR(50) NOT NULL,
    is_change ENUM('CHANGED', 'UNCHANGED') NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS citron_todo_lists(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    todo_thing VARCHAR(128) NOT NULL,
    term DATETIME,
    priority ENUM('EMERGENCY', 'HIGH', 'NORMAL', 'LOW'),
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS citron_class_changes(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    class_id VARCHAR(36) NOT NULL,
    term_of_change DATE NOT NULL,
    is_change ENUM('CHANGED', 'UNCHANGED') NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS citron_students(
    student_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    last_name VARCHAR(50) NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    last_name_kana VARCHAR(50) NOT NULL,
    first_name_kana VARCHAR(50) NOT NULL,
    emergency_call_number VARCHAR(12) NOT NULL,
    emergency_relationship VARCHAR(20) NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS citron_students_details(
    student_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    parent_last_name VARCHAR(50),
    parent_first_name VARCHAR(50),
    parent_last_name_kana VARCHAR(50),
    parent_first_name_kana VARCHAR(50),
    tel_number VARCHAR(10),
    phone_number VARCHAR(12),
    email_address VARCHAR(254),
    birthday VARCHAR(8),
    family_relationship VARCHAR(20),
    enrollment_date DATE NOT NULL,
    enrollment_status ENUM('TAKING', 'WAITING', 'ABSENCE', 'WITHDRAWAL') NOT NULL,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES citron_students(student_id)
    );

CREATE TABLE IF NOT EXISTS citron_students_address(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    student_id INT NOT NULL,
    zip_code VARCHAR(7),
    prefecture VARCHAR(10),
    city VARCHAR(30),
    street VARCHAR(128),
    apartment_number VARCHAR(128),
    detail TEXT,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES citron_students(student_id)
);

CREATE TABLE IF NOT EXISTS citron_student_classes(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    student_id INT NOT NULL,
    classroom ENUM('KURANAMI', 'YOKOTA'),
    subject ENUM('MINECRAFT', 'SWIFT', 'INDIVIDUAL_LEARNING') NOT NULL,
    course_count INT NOT NULL,
    course_week ENUM('EVEN_WEEK', 'ODD_WEEK') NOT NULL,
    course_day_of_week ENUM('SUNDAY', 'MONDAY', 'TUESDAY', 'WEDNESDAY', 'THURSDAY', 'FRIDAY', 'SATURDAY') NOT NULL,
    course_time TIME,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP,
    FOREIGN KEY (student_id) REFERENCES citron_students(student_id)
);

CREATE TABLE IF NOT EXISTS citron_monthly_fee(
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    student_id INT NOT NULL,
    payment_term DATE NOT NULL,
    is_receipted ENUM('DONE', 'NOT_YET') NOT NULL DEFAULT 'NOT_YET',
    initiation_fee INT NOT NULL DEFAULT 0,
    minecraft_programming_fee INT NOT NULL DEFAULT 0,
    swift_programming_fee INT NOT NULL DEFAULT 0,
    individual_learning_fee INT NOT NULL DEFAULT 0,
    account_management_fee INT NOT NULL DEFAULT 0,
    maintenance_cost INT NOT NULL DEFAULT 0,
    FOREIGN KEY (student_id) REFERENCES citron_students(student_id)
);

INSERT
    INTO citron_students (last_name, first_name, last_name_kana, first_name_kana, emergency_call_number, emergency_relationship, create_date, update_date)
    VALUES ();