CREATE TABLE IF NOT EXISTS invoice (
id INTEGER PRIMARY KEY AUTO_INCREMENT,
invoiceNumber INTEGER,
customerName VARCHAR(255) NOT NULL,
invoiceDate Date NOT NULL,
amount Number(10,2)
);
