CREATE TABLE tliste (
    timelistenr int primary key,
    status text check (status = 'aktiv' or status = 'levert' or status = 'utbetalt'),
    beskrivelse text
);

CREATE TABLE tlistelinje (
    timelistenr int references tliste(timelistenr),
    linjenr int,
    timeantall int not null,
    beskrivelse text,
    kumulativt_timeantall int,
    primary key(timelistenr, linjenr)
);

insert into tliste(timelistenr, status, beskrivelse) values
    (1, 'utbetalt', 'HMS-kurs'),
    (2, 'aktiv', 'Test av database'),
    (3, 'levert', 'Innlegging av virksomhetsdokumenter');

insert into tlistelinje(timelistenr, linjenr, timeantall, beskrivelse) values
    (1, 1, 3, 'HMS del 1'),
    (1, 2, 3, 'HMS del 2'),
    (2, 1, 1, 'Test 1'),
    (2, 2, 4, 'Test 2'),
    (2, 3, 3, 'Test 3'),
    (2, 4, 5, 'Test 4'),
    (3, 1, 1, 'Innlegging'),
    (3, 2, 1, 'Innlegging'),
    (3, 3, 2, 'Innlegging'),
    (3, 4, 2, 'Innlegging');
