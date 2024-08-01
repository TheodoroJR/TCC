create table cargos(

    codigoCargo bigint not null auto_increment,
    nomeCargo varchar(50) not null,
    riscosCargo bigint not null references riscos (codigoRisco),
    ativo tinyint default 1,

    primary key (codigoCargo)
);
