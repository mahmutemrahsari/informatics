--Oblig 3 Fixed 1.1
--sarime

--Oppgave 2
--a)
select * from timelistelinje
where timelistenr=3;

--b)
select count(timelistenr) from timeliste; -- Teller timelistenr som er primaar noekkel paa timeliste 

--c)
select count(timelistenr) from timeliste
where timeliste.status = 'utbetalt';


--d)
select timeliste.status, count(*) as antall --Teller alt i timeliste
from timeliste
group by timeliste.status; --grupper av status

--e) 
select count(timelistenr) as antall, count(pause) as antallMedPause from timelistelinje;


--f)
select * from timelistelinje
where pause is  null;

--Oppgave 3
--a)
select sum(varighet.varighet)/60 as antalltime from  varighet, timeliste 
where timeliste.timelistenr=varighet.timelistenr  
and timeliste.status <> 'utbetalt';

--b)
select timelistenr, beskrivelse from timeliste
where beskrivelse like '%test%' or beskrivelse like '%Test%';

--c)
select timelistelinje.timelistenr, timelistelinje.linjenr, 
varighet.varighet, timelistelinje.beskrivelse 
from timelistelinje, varighet
where timelistelinje.timelistenr = varighet.timelistenr 
and timelistelinje.linjenr = varighet.linjenr
order by varighet.varighet desc
limit 5; --Tar bare foerste 5 linjene


--d)
select timeliste.timelistenr, count(timelistelinje.timelistenr) as  antall
from timeliste left join timelistelinje 
on timeliste.timelistenr = timelistelinje.timelistenr
group by timeliste.timelistenr
order by timeliste.timelistenr asc;

--e)
select sum(varighet.varighet)/60*200 as utbetaltPenger from  varighet, timeliste 
where timeliste.timelistenr=varighet.timelistenr  
and timeliste.status = 'utbetalt';

--f)
select timelistelinje.timelistenr, count(timelistelinje.timelistenr) as antall 
from timelistelinje 
where pause is null
group by timelistelinje.timelistenr
having count(timelistelinje.timelistenr) >=4
order by antall;


