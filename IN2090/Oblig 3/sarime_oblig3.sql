--Oblig 3
--sarime

--Oppgave 2
--a)
select * from timelistelinje
where timelistenr=3;

--b)
select count(*) from timelistelinje;

--c)
select count(*) from timelistelinje INNER JOIN timeliste on timeliste.timelistenr = timelistelinje.timelistenr
where timeliste.status = 'utbetalt';
		--her jeg brukte inner join for aa join tabellene

--d)
select timeliste.status, count(*) as counted  
from timelistelinje, timeliste 
where timeliste.timelistenr = timelistelinje.timelistenr 
group by timeliste.status;

--e)
select count(*) as antall, (select count(*) from timelistelinje where pause is not null) as antallmedpause 
from timelistelinje;


--f)
select count(timelistenr) from timelistelinje
where pause is  null;

--Oppgave 3
--a)
select sum(varighet.varighet)/60 as antalltime from  varighet, timeliste 
where timeliste.timelistenr=varighet.timelistenr  
and timeliste.status <> 'utbetalt';

--b)
select timelistenr, beskrivelse from timelistelinje
where beskrivelse like '%test%' or beskrivelse like '%Test%';

--c)
select timelistelinje.timelistenr, timelistelinje.linjenr, varighet.varighet, timelistelinje.beskrivelse 
from timelistelinje, varighet
where timelistelinje.timelistenr = varighet.timelistenr
order by varighet.varighet desc
limit 5 --Tar bare foerste 5 linjene

--d)
select timeliste.timelistenr, count(timelistelinje.timelistenr) as  antall
from timeliste left join timelistelinje on timeliste.timelistenr = timelistelinje.timelistenr
group by timeliste.timelistenr
order by timeliste.timelistenr asc;

--e)
select sum(varighet.varighet)/60*200 as utbetaltpenger from  varighet, timeliste 
where timeliste.timelistenr=varighet.timelistenr  
and timeliste.status <> 'utbetalt';

--f)
select timelistelinje.timelistenr, count(timelistelinje.timelistenr) as antall 
from timelistelinje 
where pause is null
group by timelistelinje.timelistenr
having count(timelistelinje.timelistenr) >=4
order by antall;


