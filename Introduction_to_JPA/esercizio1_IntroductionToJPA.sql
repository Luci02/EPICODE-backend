/*
create table Clienti (
	NumeroCliente SERIAL PRIMARY KEY,
	Nome VARCHAR NOT NULL,
	Cognome VARCHAR NOT NULL,
	DataNascita DATE NOT NULL,
	RegioneResidenza VARCHAR NOT NULL
);

INSERT INTO Clienti (Nome, Cognome, DataNascita, RegioneResidenza)
VALUES
('Mario', 'Rossi', '1985-06-15', 'Lombardia'),
('Laura', 'Bianchi', '1990-02-28', 'Lazio'),
('Giovanni', 'Verdi', '1982-11-10', 'Toscana'),
('Maria', 'Russo', '1995-09-20', 'Campania'),
('Francesco', 'Ricci', '1992-04-12', 'Lombardia'),
('Chiara', 'Ferrari', '1996-10-18', 'Emilia-Romagna'),
('Alessandro', 'Conti', '1988-07-03', 'Toscana'),
('Valentina', 'Moretti', '1991-12-28', 'Veneto'),
('Marco', 'Gallo', '1995-03-08', 'Piemonte'),
('Luca', 'Esposito', '1998-03-12', 'Veneto');

CREATE TABLE Fornitori (
	NumeroFornitore SERIAL PRIMARY KEY,
	Denominazione VARCHAR,
	RegioneResidenza VARCHAR NOT NULL
);

INSERT INTO Fornitori (Denominazione, RegioneResidenza)
VALUES
('Fornitore A', 'Lombardia'),
('Fornitore B', 'Lazio'),
('Fornitore C', 'Toscana'),
('Fornitore D', 'Campania'),
('Fornitore E', 'Veneto');

create table Fatture (
	NumeroFattura SERIAL PRIMARY KEY,
	Tipologia VARCHAR NOT NULL,
	Importo NUMERIC NOT NULL,
	Iva INTEGER NOT NULL,
	IdCliente INTEGER NOT NULL REFERENCES Clienti (NumeroCliente),
	DataFattura DATE NOT NULL,
	NumeroFornitore INTEGER NOT NULL REFERENCES Fornitori (NumeroFornitore)
);

INSERT INTO Fatture (Tipologia, Importo, Iva, IdCliente, DataFattura, NumeroFornitore)
VALUES
('A', 150.50, 22, 1, '2023-06-10', 1),
('B', 500.00, 10, 2, '2023-06-15', 2),
('C', 250.75, 22, 3, '2023-06-20', 1),
('A', 800.00, 10, 4, '2023-06-25', 3),
('B', 350.25, 22, 5, '2023-06-30', 2),
('A', 150.50, 22, 1, '2018-06-10', 1),
('B', 500.00, 10, 2, '2022-06-15', 2),
('C', 447.98, 22, 10, '2021-11-30', 4);

 CREATE TABLE Prodotti (
 	IdProdotto SERIAL PRIMARY KEY,
 	Descrizione VARCHAR,
 	InProduzione BOOLEAN NOT NULL,
 	InCommercio BOOLEAN NOT NULL,
 	DataAttivazione DATE NOT NULL,
 	DataDisattivazione DATE NOT NULL
 );
 
INSERT INTO Prodotti (Descrizione, InProduzione, InCommercio, DataAttivazione, DataDisattivazione)
VALUES
('Prodotto A', true, true, '2023-01-01', '2023-12-31'),
('Prodotto B', true, true, '2023-02-15', '2024-06-30'),
('Prodotto C', false, true, '2022-11-01', '2023-03-31'),
('Prodotto D', true, false, '2022-09-01', '2023-08-31'),
('Prodotto E', true, true, '2023-03-10', '2023-09-30'),
('Prodotto F', false, true, '2017-01-08', '2023-12-31');
*/

-- Estrarre il nome e il cognome dei clienti nati nel 1982
select nome, cognome, * from clienti where EXTRACT(YEAR FROM DataNascita) = 1982;

-- Estrarre il numero delle fatture con iva al 20%
select * from fatture where iva = 20

-- Riportare il numero di fatture e la somma dei relativi importi divisi per anno di fatturazione
SELECT 
	COUNT(*) AS Numero_Fatture, 
	SUM(importo) as Somma_importi, 
	EXTRACT(YEAR FROM datafattura) AS anno 
FROM fatture GROUP BY anno

-- Estrarre i prodotti attivati nel 2017 e che sono in produzione oppure in commercio
SELECT * from prodotti where extract(YEAR FROM dataAttivazione) = 2017 AND ( inproduzione = true OR incommercio = true )

-- Considerando soltanto le fatture con iva al 20 per cento, estrarre il numero di fatture per ogni anno
SELECT 
	extract(year from datafattura) as anno,
	count(*) AS Numero_fatture_per_anno
FROM Fatture where Iva = 20 group by anno

-- Estrarre gli anni in cui sono state registrate più di 2 fatture con tipologia 'A'
SELECT EXTRACT(YEAR FROM dataFattura) AS anno, COUNT(*) AS numero_fatture FROM Fatture 
WHERE tipologia = 'A'
GROUP BY anno
HAVING COUNT(*) > 1

-- Riportare l'elenco delle fatture (numero, importo, iva e data) con in aggiunta il nome del fornitore
SELECT 
	numeroFattura AS numero,
	importo,
	iva,
	dataFattura AS data,
	Denominazione AS nome_fornitore
FROM FATTURE
INNER JOIN Fornitori ON Fatture.numeroFornitore = Fornitori.numeroFornitore

-- Estrarre il totale degli importi delle fatture divisi per residenza dei clienti
SELECT
	SUM(importo) as totale_importi,
	RegioneResidenza as regione_residenza
FROM Fatture
INNER JOIN Clienti ON Fatture.idCliente = Clienti.numeroCliente
GROUP BY RegioneResidenza

-- Estrarre il numero dei clienti nati nel 1980 che hanno almeno una fattura superiore a 50 euro
SELECT * 
FROM Clienti
INNER JOIN Fatture ON Fatture.idCliente = Clienti.numeroCliente
WHERE EXTRACT(YEAR FROM dataNascita) = 1980 AND importo > 50
ORDER BY NumeroCliente ASC

-- Estrarre una colonna di nome "Denominazione" contenente il nome, seguito da un carattere "-", seguito dal cognome, per i soli clienti residenti nella regione Lombardia
SELECT CONCAT(nome, '-', cognome) AS Denominazione FROM CLIENTI
WHERE RegioneResidenza = 'Lombardia';