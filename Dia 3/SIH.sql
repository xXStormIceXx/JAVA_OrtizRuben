use brfbqpw5se20g0tvfxtw;

CREATE TABLE persona (
    id_persona INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL
);

CREATE TABLE hospitales (
    id_hospital INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL
);

CREATE TABLE persona_hospital (
    id_hospital INT,
    id_persona INT,
    PRIMARY KEY (id_hospital, id_persona),
    FOREIGN KEY (id_hospital) REFERENCES hospitales(id_hospital),
    FOREIGN KEY (id_persona) REFERENCES Persona(id_persona)
);

CREATE TABLE pabellon (
    id_hospital INT,
    id_pabellon INT AUTO_INCREMENT PRIMARY KEY,
    capacidad INT NOT NULL,
    FOREIGN KEY (id_hospital) REFERENCES hospitales(id_hospital)
);

CREATE TABLE paciente (
    id_persona INT,
    id_pabellon INT,
    edad INT NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    fecha_ingreso DATE NOT NULL,
    PRIMARY KEY (id_persona, id_pabellon),
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona),
    FOREIGN KEY (id_pabellon) REFERENCES pabellon(id_pabellon)
);

CREATE TABLE departamentos (
    id_departamento INT AUTO_INCREMENT PRIMARY KEY,
    id_hospital INT,
    tipo_departamento VARCHAR(100) NOT NULL,
    FOREIGN KEY (id_hospital) REFERENCES hospitales(id_hospital)
);

CREATE TABLE personal_tecnico (
    id_personal INT AUTO_INCREMENT PRIMARY KEY,
    id_departamento_tecnico INT,
    tipo VARCHAR(100) NOT NULL,
	FOREIGN KEY (id_personal) REFERENCES persona(id_persona),
    FOREIGN KEY (id_departamento_tecnico) REFERENCES departamentos(id_departamento)
);

CREATE TABLE personal_administrativo (
    id_personal INT,
    id_departamento_tecnico INT,
    PRIMARY KEY (id_personal, id_departamento_tecnico),
    FOREIGN KEY (id_personal) REFERENCES persona(id_persona),
    FOREIGN KEY (id_departamento_tecnico) REFERENCES departamentos(id_departamento)
);

CREATE TABLE personal_operaciones (
    id_personal INT,
    id_departamento_tecnico INT,
    tipo VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_personal, id_departamento_tecnico),
    FOREIGN KEY (id_personal) REFERENCES personal_tecnico(id_personal),
    FOREIGN KEY (id_departamento_tecnico) REFERENCES departamentos(id_departamento)
);

CREATE TABLE doctores_asociados (
    id_persona INT PRIMARY KEY,
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
);

CREATE TABLE doctores_junior (
    id_persona INT PRIMARY KEY,
    diagnosticos TEXT NOT NULL,
    FOREIGN KEY (id_persona) REFERENCES persona(id_persona)
);

CREATE TABLE equipo_medico (
    id_doctores_asociados INT,
    id_doctores_junior INT,
    PRIMARY KEY (id_doctores_asociados, id_doctores_junior),
    FOREIGN KEY (id_doctores_asociados) REFERENCES doctores_asociados(id_persona),
    FOREIGN KEY (id_doctores_junior) REFERENCES doctores_junior(id_persona)
);