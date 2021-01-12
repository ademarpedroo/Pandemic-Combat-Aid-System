CREATE TABLE historico (
                id_hist INT AUTO_INCREMENT NOT NULL,
                data_status DATE NOT NULL,
                fk_hospital INT NOT NULL,
                fk_recurso INT NOT NULL,
                PRIMARY KEY (id_hist)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE historico ADD CONSTRAINT recurso_historico_fk
FOREIGN KEY (fk_recurso)
REFERENCES recurso (id_recurso)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE historico ADD CONSTRAINT hospital_historico_fk
FOREIGN KEY (fk_hospital)
REFERENCES hospital (id_hospital)
ON DELETE NO ACTION
ON UPDATE NO ACTION;