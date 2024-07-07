 CREATE TABLE categoria (
  codigo BIGINT(29) PRIMARY KEY AUTO_INCREMENT,
   nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

  INSERT INTO categoria (nome) values ('tecnologia');
  INSERT INTO categoria (nome) values ('acessorios para veiculos');
  INSERT INTO categoria (nome) values ('esporte e lazer');
  INSERT INTO categoria (nome) values ('casa e eletrodomestico');
  INSERT INTO categoria (nome) values ('joias e relogios');

