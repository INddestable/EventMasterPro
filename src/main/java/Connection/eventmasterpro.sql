/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  kevin
 * Created: 19/05/2025
 */
-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS EventMasterPro;
USE EventMasterPro;

-- Tabla: Location
CREATE TABLE Location (
    idlocation INT AUTO_INCREMENT PRIMARY KEY,
    namelocation VARCHAR(100) NOT NULL,
    capacity INT NOT NULL
);

-- Tabla: Artist
CREATE TABLE Artist (
    idartist INT AUTO_INCREMENT PRIMARY KEY,
    nameartist VARCHAR(100) NOT NULL
);

-- Tabla: Record
CREATE TABLE Record (
    idrecord INT AUTO_INCREMENT PRIMARY KEY,
    namerecord VARCHAR(100) NOT NULL
);

-- Tabla intermedia: ArtistRecord (muchos a muchos)
CREATE TABLE ArtistRecord (
    idartist INT,
    idrecord INT,
    PRIMARY KEY (idartist, idrecord),
    FOREIGN KEY (idartist) REFERENCES Artist(idartist),
    FOREIGN KEY (idrecord) REFERENCES Record(idrecord)
);

-- Tabla: Event
CREATE TABLE Event (
    idevent INT AUTO_INCREMENT PRIMARY KEY,
    nameevent VARCHAR(100) NOT NULL,
    idlocation INT,
    date DATE NOT NULL,
    FOREIGN KEY (idlocation) REFERENCES Location(idlocation)
);

-- Tabla intermedia: EventArtist (por si un evento tiene varios artistas)
CREATE TABLE EventArtist (
    idevent INT,
    idartist INT,
    PRIMARY KEY (idevent, idartist),
    FOREIGN KEY (idevent) REFERENCES Event(idevent),
    FOREIGN KEY (idartist) REFERENCES Artist(idartist)
);

-- Tabla: Assistant
CREATE TABLE Assistant (
    idassistant INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- Tabla: Ticket
CREATE TABLE Ticket (
    idticket INT AUTO_INCREMENT PRIMARY KEY,
    idevent INT,
    ticket_type VARCHAR(50),
    price DECIMAL(10,2),
    selled BOOLEAN,
    idassistant INT,
    FOREIGN KEY (idevent) REFERENCES Event(idevent),
    FOREIGN KEY (idassistant) REFERENCES Assistant(idassistant)
);

-- Tabla: History
CREATE TABLE History (
    idhistory INT AUTO_INCREMENT PRIMARY KEY,
    idassistant INT,
    idevent INT,
    FOREIGN KEY (idassistant) REFERENCES Assistant(idassistant),
    FOREIGN KEY (idevent) REFERENCES Event(idevent)
);
