--IN2090: Obligatorisk oppgave 5

--sarime

--Oppgave 1
SELECT filmcharacter as rollefigurnavn, 
count(filmcharacter) as antallgangerforekommer FROM filmcharacter
group by filmcharacter
having count(filmcharacter) >2000
order by antallgangerforekommer desc;

--Oppgave 2
--a
select film.title, film.prodyear from film 
inner join
(filmparticipation inner join person on person.personid = filmparticipation.personid) as x on film.filmid=x.filmid
where x.firstname = 'Stanley' and x.lastname = 'Kubrick' and x.parttype = 'director';
--jeg slaar sammen foerst filmparticipation og person som heter x 

--b
select film.title, film.prodyear from film 
natural join
(filmparticipation natural join person) as x
where x.firstname = 'Stanley' and x.lastname = 'Kubrick' and x.parttype = 'director';

--c
select film.title, film.prodyear from film, person, filmparticipation 
where person.firstname = 'Stanley' and person.lastname = 'Kubrick' and filmparticipation.parttype = 'director'
and film.filmid = filmparticipation.filmid and filmparticipation.personid = person.personid;

--Oppgave 3
select person.personid, concat(person.firstname,' ', person.lastname) as full_name , film.title, filmcountry.country 
from film 
natural join filmparticipation natural join person natural join filmcountry natural join filmcharacter
where person.firstname = 'Ingrid' and filmcharacter.filmcharacter ='Ingrid';

--Oppgave 4
select count(filmgenre.genre), film.filmid, film.title from film left join filmgenre on
film.filmid = filmgenre.filmid where film.title like '%Antoine %'
group by film.filmid,film.title; 

--Oppgave 5
select film.title, filmparticipation.parttype, count(filmparticipation.parttype) as antall 
from filmitem natural join filmparticipation natural join film
where film.title like '%Lord of the Rings%' and filmitem.filmtype = 'C'
group by filmparticipation.parttype,film.title;

--Oppgave 6
select title, prodyear from film
where prodyear in(select min(prodyear) from film);

--Oppgave 7
select film.title, film.prodyear from film natural join filmgenre
where filmgenre.genre = 'Film-Noir' and film.filmid in (select film.filmid 
from film natural join filmgenre
where filmgenre.genre ='Comedy');

--Oppgave 8
select title, prodyear from film
where prodyear in(select min(prodyear) from film)
union
select film.title, film.prodyear from film natural join filmgenre
where filmgenre.genre = 'Film-Noir' and film.filmid in (select film.filmid 
from film natural join filmgenre
where filmgenre.genre ='Comedy');

--Oppgave 9
select film.title, film.prodyear from film 
natural join
(filmparticipation natural join person) as x
where x.firstname = 'Stanley' and x.lastname = 'Kubrick' and x.parttype = 'director' 
and film.filmid in (select film.filmid from film 
natural join
(filmparticipation natural join person) as x
where x.firstname = 'Stanley' and x.lastname = 'Kubrick' and x.parttype = 'cast');

--Oppgave 10
 
select series.maintitle, filmrating.rank from series, filmrating 
where series.seriesid=filmrating.filmid and filmrating.votes>1000
and filmrating.rank in 
(select max(filmrating.rank) from filmrating 
where filmrating.filmid in 
(select series.seriesid from series, filmrating 
where series.seriesid = filmrating.filmid and filmrating.votes>1000));
/*First we found the rank of filmseries that have more than 1000 votes than 
we filtered the table for series that have this rank and has more than 1000 votes.*/

--Oppgave 11
select country from filmcountry
group by country
having count(country) = 1;

--Oppgave 12
select concat(person.firstname, ' ', person.lastname) as name , count(filmparticipation.filmid) 
from filmcharacter natural join filmparticipation natural join person where filmcharacter.filmcharacter in
(select filmcharacter from filmcharacter group by filmcharacter having count(filmcharacter) = 1)
group by name 
having count(filmparticipation.filmid)>199;

--Oppgave 13
select person.firstname, person.lastname , filmparticipation.parttype 
from person natural join filmparticipation  natural join filmrating
where filmrating.votes > 60000 
and filmrating.rank >= 8 and filmparticipation.personid 
not in (select distinct filmparticipation.personid 
from filmrating natural join filmparticipation 
where filmrating.votes <= 60000 
or filmrating.rank <8);
--Jeg kan ikke loese denne oppgaven jeg faar feil svaret.

--Oppgave 13 Løsningsforslaget
SELECT DISTINCT firstname, lastname
FROM filmrating natural join filmparticipation natural join person
where parttype = 'director' AND votes > 60000
AND personid NOT IN (
SELECT personid FROM filmparticipation natural join filmrating
WHERE parttype = 'director' AND rank < 8 AND votes > 60000
);


