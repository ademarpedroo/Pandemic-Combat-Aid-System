CREATE TABLE hosp_rec (
                id_hosp_rec INT AUTO_INCREMENT NOT NULL,
                fk_hospital INT NOT NULL,
                fk_recurso INT NOT NULL,
                quantidade INT NOT NULL,
                PRIMARY KEY (id_hosp_rec)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE hosp_rec ADD CONSTRAINT recursos_hosp_rec_fk
FOREIGN KEY (fk_recurso)
REFERENCES recurso (id_recurso)
ON DELETE NO ACTION
ON UPDATE NO ACTION;

ALTER TABLE hosp_rec ADD CONSTRAINT hospital_hosp_rec_fk
FOREIGN KEY (fk_hospital)
REFERENCES hospital (id_hospital)
ON DELETE NO ACTION
ON UPDATE NO ACTION;