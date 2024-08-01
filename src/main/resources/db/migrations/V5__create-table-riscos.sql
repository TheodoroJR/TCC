create table riscos(

    codigoRisco bigint not null auto_increment,
    nomeRisco varchar(50) not null,
    descricaoRisco varchar(50) not null,
    ativo tinyint default 1,

    primary key (codigoRisco)
);

