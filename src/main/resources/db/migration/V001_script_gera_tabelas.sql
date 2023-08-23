 create table tbl_atribuicao (
       id_atribuicao integer not null,
        nome_atribuicao varchar(50) not null,
        situacao bit not null,
        primary key (id_atribuicao)
    );
    
    create table tbl_cartorio (
       id_cartorio integer not null,
        nome_cartorio varchar(150) not null,
        observacao varchar(250),
        atribuicoes_cartorio_id_atribuicao integer,
        situacao_cartorio_id_situacao integer,
        primary key (id_cartorio)
    );
    
    create table tbl_situacao (
       id_situacao integer not null,
        nome_situacao varchar(50) not null,
        situacao varchar(255) not null,
        primary key (id_situacao)
    );
    
    alter table tbl_cartorio 
       add constraint FKjfalees8x0py4yiq17486hn4u 
       foreign key (atribuicoes_cartorio_id_atribuicao) 
       references tbl_atribuicao (id_atribuicao);
    
    alter table tbl_cartorio 
       add constraint FKsf8b2pjk8tq8ctqt2457nfn50 
       foreign key (situacao_cartorio_id_situacao) 
       references tbl_situacao (id_situacao);