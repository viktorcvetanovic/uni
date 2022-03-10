/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     3/8/2022 11:49:52 AM                         */
/*==============================================================*/


drop table if exists intervju;

drop table if exists kandidat;

drop table if exists kandidat_oglas;

drop table if exists kompanija;

drop table if exists kontakt;

drop table if exists oglas;

drop table if exists osoba;

drop table if exists vlasnik;

/*==============================================================*/
/* Table: intervju                                              */
/*==============================================================*/
create table intervju
(
   intervju_id          int not null,
   profil_oglas_id      int not null,
   mesto                varchar(1024),
   vreme                date,
   primary key (intervju_id)
);

/*==============================================================*/
/* Table: kandidat                                              */
/*==============================================================*/
create table kandidat
(
   profil_id            int not null,
   korisnicko_ime       varchar(1024),
   sifra                varchar(1024),
   primary key (profil_id)
);

/*==============================================================*/
/* Table: kandidat_oglas                                        */
/*==============================================================*/
create table kandidat_oglas
(
   profil_oglas_id      int not null,
   oglas_id             int,
   osoba_id             int,
   profil_id            int,
   datum                date,
   primary key (profil_oglas_id)
);

/*==============================================================*/
/* Table: kompanija                                             */
/*==============================================================*/
create table kompanija
(
   osoba_id             int not null,
   vlasnik_id           int not null,
   kompanija_id         int not null,
   naziv                varchar(1024),
   grad                 varchar(1024),
   primary key (osoba_id, vlasnik_id, kompanija_id)
);

/*==============================================================*/
/* Table: kontakt                                               */
/*==============================================================*/
create table kontakt
(
   kontakt_id           int not null,
   kom_osoba_id         int,
   vlasnik_id           int,
   kompanija_id         int,
   osoba_id             int,
   tip_kontakta         varchar(1024) default 'TELEFON',
   vrednost             varchar(1024),
   primary key (kontakt_id)
);

/*==============================================================*/
/* Table: oglas                                                 */
/*==============================================================*/
create table oglas
(
   oglas_id             int not null,
   osoba_id             int,
   vlasnik_id           int,
   kompanija_id         int,
   naziv_pozicije       varchar(1024),
   tip_posla            char(10),
   plata                float,
   radno_iskustvo       float,
   primary key (oglas_id)
);

/*==============================================================*/
/* Table: osoba                                                 */
/*==============================================================*/
create table osoba
(
   osoba_id             int not null,
   vlasnik_id           int,
   profil_id            int,
   ime                  varchar(1024),
   prezime              varchar(1024),
   pol                  varchar(1024),
   godina_rodjenja      date,
   mesto                varchar(1024),
   primary key (osoba_id)
);

/*==============================================================*/
/* Table: vlasnik                                               */
/*==============================================================*/
create table vlasnik
(
   vlasnik_id           int not null,
   primary key (vlasnik_id)
);

alter table intervju add constraint fk_relationship_11 foreign key (profil_oglas_id)
      references kandidat_oglas (profil_oglas_id) on delete restrict on update restrict;

alter table kandidat_oglas add constraint fk_relationship_5 foreign key (oglas_id)
      references oglas (oglas_id) on delete restrict on update restrict;

alter table kandidat_oglas add constraint fk_relationship_6 foreign key (profil_id)
      references kandidat (profil_id) on delete restrict on update restrict;

alter table kompanija add constraint fk_is foreign key (vlasnik_id)
      references vlasnik (vlasnik_id) on delete restrict on update restrict;

alter table kontakt add constraint fk_contains foreign key (kom_osoba_id, vlasnik_id, kompanija_id)
      references kompanija (osoba_id, vlasnik_id, kompanija_id) on delete restrict on update restrict;

alter table kontakt add constraint fk_relationship_8 foreign key (osoba_id)
      references osoba (osoba_id) on delete restrict on update restrict;

alter table oglas add constraint fk_post foreign key (osoba_id, vlasnik_id, kompanija_id)
      references kompanija (osoba_id, vlasnik_id, kompanija_id) on delete restrict on update restrict;

alter table osoba add constraint fk_relationship_12 foreign key (vlasnik_id)
      references vlasnik (vlasnik_id) on delete restrict on update restrict;

alter table osoba add constraint fk_relationship_13 foreign key (profil_id)
      references kandidat (profil_id) on delete restrict on update restrict;

