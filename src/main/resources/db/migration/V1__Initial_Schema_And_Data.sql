CREATE TABLE lector (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    salary INT NOT NULL,
    degree VARCHAR(50)
);

CREATE TABLE department (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    head_id BIGINT,
    CONSTRAINT fk_department_head FOREIGN KEY (head_id) REFERENCES lector(id)
);

CREATE TABLE department_lector (
    department_id BIGINT NOT NULL,
    lector_id BIGINT NOT NULL,
    PRIMARY KEY (department_id, lector_id),
    CONSTRAINT fk_dept_link FOREIGN KEY (department_id) REFERENCES department(id),
    CONSTRAINT fk_lector_link FOREIGN KEY (lector_id) REFERENCES lector(id)
);

INSERT INTO lector (id, name, salary, degree) VALUES
    (1, 'Ivan Ivanov', 1500, 'PROFESSOR'),
    (2, 'Olga Petrenko', 1200, 'ASSOCIATE_PROFESSOR'),
    (3, 'John Smith', 900, 'ASSISTANT'),
    (4, 'Maria Garcia', 1800, 'PROFESSOR'),
    (5, 'Yuki Tanaka', 1100, 'ASSOCIATE_PROFESSOR');

INSERT INTO department (id, name, head_id) VALUES
    (1, 'Computer Science', 1),
    (2, 'Mathematics', 4),
    (3, 'Physics', 1);

INSERT INTO department_lector (department_id, lector_id) VALUES
    (1, 1), (1, 2), (1, 3),
    (2, 4), (2, 5), (2, 2),
    (3, 1), (3, 5), (3, 3);