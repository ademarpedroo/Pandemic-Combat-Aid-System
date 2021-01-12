CREATE TABLE hospital (
                id_hospital INT AUTO_INCREMENT NOT NULL,
                nome VARCHAR(50) NOT NULL,
                cnpj CHAR(14) NOT NULL,
                endereco VARCHAR(40) NOT NULL,
                latitude DECIMAL(4,2) NOT NULL,
                longitude DECIMAL(4,2) NOT NULL,
                capacidade INT NOT NULL,
                PRIMARY KEY (id_hospital)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO hospital (id_hospital,nome,cnpj,endereco,latitude,longitude,capacidade) VALUES ('1','Hospital Campina Grande','01234567891234','Rua marechal segundo,2','43.2515','-25.22','100');
INSERT INTO hospital (id_hospital,nome,cnpj,endereco,latitude,longitude,capacidade) VALUES ('2','Hospital Brasilia','12345678901234','Rua alberto maia,600','33.222','55.632','1000');
INSERT INTO hospital (id_hospital,nome,cnpj,endereco,latitude,longitude,capacidade) VALUES ('3','Hospital JP','12356678901234','Rua julio maia,600','55.959','10.11','200');