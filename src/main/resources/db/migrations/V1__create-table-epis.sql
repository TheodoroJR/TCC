create table epis(

    codigoEpi bigint not null auto_increment,
    nomeEpi varchar(50) not null,
    descricaoEpi varchar(100) not null,
    numeroCa integer not null,
    validadeCa varchar(10) not null,
    fabricanteEpi varchar(50) not null,

    primary key (codigoEpi)
);