create table ExemploNotNull(
	id int not null,
	descricao VARCHAR(10) not null,
	idade int
);


insert into exemplonotnull (id,descricao,idade) values(1,'',20);


create table exemploUnique(
	id int not null unique,
	descricao varchar(10) not null,
	idade int
)

create table exemploDefault(
	id int not null unique,
	descricao varchar(10) not null,
	idade int not null default 0
)


create table exemplopk(
	id SERIAL not null,
	nome varchar(10) not null,
	funcionario boolean not null default false,
	constraint pk_id_exemplopk primary key(id)
)

create table exemplofk(
	id SERIAL not null,
	nome varchar(10) not null,
	funcionario boolean not null default false,
	id_exemplopk int not null,
	constraint pk_id_exemplofk primary key(id),
	constraint fk_id_exemplopk foreign key (id_exemplopk) references exemplopk(id)
)


insert into exemplopk (nome) values('LUCAS'),('VITOR'),('CLEITON'),('JULIO'),('ESTRNOGS')

insert into exemplopk (nome) values ('TEO')

insert into exemplofk (nome, id_exemplopk) values ('TEO',6)


drop table produto

create table produto(
	id serial not null,
	descricao varchar(50) not null,
	preco numeric(12,2) not null,
	constraint pk_id_produto primary key (id)
)

drop table cliente

create table cliente(
	id serial not null,
	nome varchar(50) not null,
	endereco varchar(50) not null,
	constraint pk_id_cliente primary key (id)
)

drop table pedido

create table pedido (
id SERIAL not null,
numeropedido bigint not null,
id_cliente int not null,
data date not null,
entregue boolean not null,
constraint pk_id_pedido primary key (id),
constraint fk_id_cliente foreign key (id_cliente)
references cliente (id)
);

drop table pedidoitem

create table pedidoitem(
	id serial not null,
	id_pedido int not null,
	id_produto int not null,
	quantidade numeric(12,2) not null,
	desconto numeric(12,2) not null,
	subtotal numeric(12,2) not null,
	constraint pk_id_pedidoitem primary key(id),
	constraint pk_id_pedido foreign key(id_pedido) references pedido(id),
	constraint fk_id_produto foreign key(id_produto) references produto(id)
)
/*
Atividade:
	CRIAR AS INSTRUÇÕES SQL PARA QUE
	A TABELA PEDIDO CONTENHA
	5 PEDIDOS PARA 5 CLIENTES DISTINTOS
	E A TABELA PEDIDOITEM CONTENHA
	5 PRODUTOS PARA CADA PEDIDO COM CODIGOS DE PRODUTOS DIFERENTES
	5 CLIENTES
	5 PEDIDOS
	25 PRODUTOS
	25 PEDIDOITEM
	ENTREGAR NO CLASSROOM ATIVADE CHAMADA SQL PEDIDO.
*/
INSERT INTO public.cliente (nome, endereco) values
('Cliente 1', 'Endereco 1'),
('Cliente 2', 'Endereco 2'),
('Cliente 3', 'Endereco 3'),
('Cliente 4', 'Endereco 4'),
('Cliente 5', 'Endereco 5');


INSERT INTO public.produto (descricao, preco) values
('Produto 1', 10.00),
('Produto 2', 20.50),
('Produto 3', 30.25),
('Produto 4', 40.75),
('Produto 5', 50.90),
('Produto 6', 18.75),
('Produto 7', 14.50),
('Produto 8', 9.99),
('Produto 9', 22.00),
('Produto 10', 11.25),
('Produto 11', 16.50),
('Produto 12', 13.75),
('Produto 13', 19.99),
('Produto 14', 8.50),
('Produto 15', 24.50),
('Produto 16', 10.99),
('Produto 17', 15.75),
('Produto 18', 12.25),
('Produto 19', 21.50),
('Produto 20', 9.25),
('Produto 21', 17.99),
('Produto 22', 14.25),
('Produto 23', 11.50),
('Produto 24', 20.00),
('Produto 25', 7.75);

INSERT INTO public.pedido (numeropedido, id_cliente, "data", entregue) values
(1, 1, '2023-11-20', true),
(2, 2, '2023-11-21', false),
(3, 3, '2023-11-22', true),
(4, 4, '2023-11-23', false),
(5, 5, '2023-11-24', true);


INSERT INTO public.pedidoitem (id_pedido, id_produto, quantidade, desconto, subtotal) values
-- Pedido 1
(1, 6, 2, 0.50, 37.50),
(1, 7, 1, 0.25, 14.50),
(1, 8, 3, 1.00, 29.97),
(1, 9, 1, 0.20, 17.60),
(1, 10, 2, 0.75, 25.50),

-- Pedido 2
(2, 11, 1, 0.00, 16.50),
(2, 12, 2, 0.75, 26.75),
(2, 13, 1, 0.20, 15.80),
(2, 14, 3, 1.50, 38.25),
(2, 15, 1, 0.10, 22.05),

-- Pedido 3
(3, 16, 2, 0.75, 33.00),
(3, 17, 1, 0.00, 15.75),
(3, 18, 1, 0.15, 10.41),
(3, 19, 3, 1.25, 37.25),
(3, 20, 2, 0.50, 18.50),

-- Pedido 4
(4, 21, 3, 1.25, 41.25),
(4, 22, 1, 0.10, 12.75),
(4, 23, 2, 0.50, 23.00),
(4, 24, 1, 0.25, 19.75),
(4, 25, 1, 0.20, 15.40),

-- Pedido 5
(5, 1, 2, 0.50, 19.50),
(5, 2, 1, 0.25, 7.75),
(5, 3, 3, 1.00, 60.75),
(5, 4, 1, 0.20, 7.00),
(5, 5, 2, 0.75, 25.98);