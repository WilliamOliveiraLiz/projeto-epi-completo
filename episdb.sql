CREATE DATABASE controle_epis; 
 
USE controle_epis; 
 
CREATE TABLE usuario ( 
    id_usuario INT(11) PRIMARY KEY AUTO_INCREMENT, 
    nome VARCHAR(100), 
    email VARCHAR(100), 
    senha VARCHAR(25), 
    perfil ENUM('administrador', 'colaborador') 
); 
 
CREATE TABLE epi ( 
    id_epi INT(11) PRIMARY KEY AUTO_INCREMENT, 
    nome VARCHAR(100), 
    quantidade INT(11), 
    validade DATE 
); 
 
CREATE TABLE emprestimo ( 
    id_emprestimo INT(11) PRIMARY KEY AUTO_INCREMENT, 
    id_usuario INT(11), 
    id_epi INT(11), 
    data_retirada DATETIME, 
    data_prevista_devolucao DATETIME, 
    confirmacao_retirada TINYINT(1), 
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario), 
    FOREIGN KEY (id_epi) REFERENCES epi(id_epi) 
); 
 
CREATE TABLE devolucao ( 
id_devolucao INT(11) PRIMARY KEY AUTO_INCREMENT, 
id_emprestimo INT(11), 
data_devolucao DATETIME, 
FOREIGN KEY (id_emprestimo) REFERENCES emprestimo(id_emprestimo) 
);
controle_epis