CREATE TABLE recurso (
                id_recurso INT AUTO_INCREMENT NOT NULL,
                nome VARCHAR(20) NOT NULL,
                ponto DECIMAL(4,2) NOT NULL,
                PRIMARY KEY (id_recurso)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO recurso (id_recurso,nome,ponto) VALUES ('1','Médico','3');
INSERT INTO recurso (id_recurso,nome,ponto) VALUES ('2','Enfermeiro','3');
INSERT INTO recurso (id_recurso,nome,ponto) VALUES ('3','Respirador','5');
INSERT INTO recurso (id_recurso,nome,ponto) VALUES ('4','Tomógrafo','12');
INSERT INTO recurso (id_recurso,nome,ponto) VALUES ('5','Ambulância','10');