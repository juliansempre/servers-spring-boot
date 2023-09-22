<pre>
.................................
Criar:
.................................
docker pull mysql

[com porta modificada para não haver conflito]
docker run -d --name meumysql -e MYSQL_ROOT_PASSWORD=toor -p 3307:3306 mysql:latest

.................................
Executar:
.................................
docker start meumysql

docker exec -it meumysql mysql -p

create database bancododocker;

show databases;
=======================
SQL
=======================
create database login;

CREATE TABLE usuarios (
id INT PRIMARY KEY AUTO_INCREMENT,
nome CHAR(255),
senha CHAR(255)
);

INSERT INTO usuarios (nome, senha) VALUES ('João', 'senha123');
INSERT INTO usuarios (nome, senha) VALUES ('Maria', 'segura456');
INSERT INTO usuarios (nome, senha) VALUES ('Carlos', 'minhasenha');
INSERT INTO usuarios (nome, senha) VALUES ('Ana', 'senhasecreta');
INSERT INTO usuarios (nome, senha) VALUES ('Pedro', '1234senha');
INSERT INTO usuarios (nome, senha) VALUES ('Laura', 'laurapass');
INSERT INTO usuarios (nome, senha) VALUES ('Rafael', 'senha12345');
INSERT INTO usuarios (nome, senha) VALUES ('Julia', 'julia123');
INSERT INTO usuarios (nome, senha) VALUES ('Fernanda', 'minhasenha123');
INSERT INTO usuarios (nome, senha) VALUES ('Lucas', 'senha321');

------------------------------------------------
</pre>

