create table lojas(

    codigoLoja bigint not null auto_increment,
    nomeLoja varchar(50) not null,
    tipoLoja varchar(50) not null,
    rua varchar(100) not null,
    bairro varchar(50) not null,
    cep varchar(9) not null,
    cidade varchar(50) not null,
    uf varchar(50) not null,
    complemento varchar(50),
    numero varchar(20),
    ativo tinyint default 1,

    primary key (codigoLoja)
);
