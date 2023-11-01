CREATE DATABASE pro_viagens;

USE pro_viagens;

CREATE TABLE Clientes (
Cod_Cliente INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(30) NOT NULL,
CPF VARCHAR(20) UNIQUE NOT NULL,
RG VARCHAR(25) UNIQUE NOT NULL,
Telefone VARCHAR(20) NOT NULL,
Email VARCHAR(25) UNIQUE NOT NULL,
Senha VARCHAR(30) UNIQUE NOT NULL
);

CREATE TABLE Destinos (
Cod_Destino INT AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(20) NOT NULL,
Pais VARCHAR(20) NOT NULL,
Valor DECIMAL(7) NOT NULL
);

INSERT INTO Destinos (Nome, Pais, Valor) VALUES 
("Rio de Janeiro", "Brasil", 1300),
("Orlando", "Estados Unidos", 4500),
("Curitiba", "Brasil", 580),
("Lisboa", "Portugal", 2200),
("Tóquio", "Japão", 5110),
("Cairo", "Egito", 6500);

CREATE TABLE Reservas (
Cod_Reserva INT AUTO_INCREMENT PRIMARY KEY,
Data_reserva DATE NOT NULL,
Data_viagem DATE NOT NULL,
Cod_Cliente INT NOT NULL,
Cod_Destino INT NOT NULL,
FOREIGN KEY(Cod_Cliente) REFERENCES Clientes (Cod_Cliente),
FOREIGN KEY(Cod_Destino) REFERENCES Destinos (Cod_Destino)
);