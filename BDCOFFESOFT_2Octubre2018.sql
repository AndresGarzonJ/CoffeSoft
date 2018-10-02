alter table EVENTO
   drop constraint FK_EVENTO_HACE_EMPLEADO;

alter table EVENTO
   drop constraint FK_EVENTO_TIENE_LOTE;

alter table MATERIALES
   drop constraint FK_MATERIAL_UTILIZA_EVENTO;

drop table EMPLEADO cascade constraints;

drop index TIENE_FK;

drop index HACE_FK;

drop table EVENTO cascade constraints;

drop table LOTE cascade constraints;

drop index UTILIZA_FK;

drop table MATERIALES cascade constraints;

drop table ADMINISTRADOR;

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table ADMINISTRADOR 
(
   ADMUSUARIO          VARCHAR2(20)         not null,
   ADMCLAVE            VARCHAR2(20)         not null   
);

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO 
(
   EMPCEDULA            INTEGER              not null,
   EMPNOMBRE            VARCHAR2(20)         not null,
   EMPAPELLIDOS         VARCHAR2(20)         not null,
   EMPEDAD              INTEGER,
   EMPTELEFONO          INTEGER,
   constraint PK_EMPLEADO primary key (EMPCEDULA)
);

/*==============================================================*/
/* Table: EVENTO                                                */
/*==============================================================*/
create table EVENTO 
(
   EVECODIGO            INTEGER              not null,
   EMPCEDULA            INTEGER,
   LOTCODIGO            INTEGER,
   EVEFECHA             DATE                 not null,
   EVENOMBRE            VARCHAR2(20)         not null,
   EVEDESCRIPCION       VARCHAR2(20),
   EVECOSTO             INTEGER              not null,
   EVECANTIDAD          INTEGER,
   constraint PK_EVENTO primary key (EVECODIGO)
);

/*==============================================================*/
/* Index: HACE_FK                                               */
/*==============================================================*/
create index HACE_FK on EVENTO (
   EMPCEDULA ASC
);

/*==============================================================*/
/* Index: TIENE_FK                                              */
/*==============================================================*/
create index TIENE_FK on EVENTO (
   LOTCODIGO ASC
);

/*==============================================================*/
/* Table: LOTE                                                  */
/*==============================================================*/
create table LOTE 
(
   LOTCODIGO            INTEGER              not null,
   LOTNOMBRE            VARCHAR2(20)         not null,
   LOTUBICACION         VARCHAR2(20)         not null,
   LOTNARBOLES          INTEGER              not null,
   LOTFECHASIEMBRA      DATE                 not null,
   LOTNARBOLESSOMBRA    INTEGER              not null,
   constraint PK_LOTE primary key (LOTCODIGO)
);

/*==============================================================*/
/* Table: MATERIALES                                            */
/*==============================================================*/
create table MATERIALES 
(
   MATCODIGO            INTEGER              not null,
   EVECODIGO            INTEGER,
   MATNOMBRE            VARCHAR2(200)        not null,
   MATDESCRIPCION       VARCHAR2(200),
   MATPROVEEDOR         VARCHAR2(200),
   MATFECHA             DATE,
   MATTIPO              VARCHAR2(200),
   MATESTADO            VARCHAR2(200),
   MATMARCA             VARCHAR2(20),
   MATCOSTO             INTEGER              not null,
   MATCANTIDAD          INTEGER              not null,
   constraint PK_MATERIALES primary key (MATCODIGO)
);

/*==============================================================*/
/* Index: UTILIZA_FK                                            */
/*==============================================================*/
create index UTILIZA_FK on MATERIALES (
   EVECODIGO ASC
);

alter table EVENTO
   add constraint FK_EVENTO_HACE_EMPLEADO foreign key (EMPCEDULA)
      references EMPLEADO (EMPCEDULA);

alter table EVENTO
   add constraint FK_EVENTO_TIENE_LOTE foreign key (LOTCODIGO)
      references LOTE (LOTCODIGO);

alter table MATERIALES
   add constraint FK_MATERIAL_UTILIZA_EVENTO foreign key (EVECODIGO)
      references EVENTO (EVECODIGO);
