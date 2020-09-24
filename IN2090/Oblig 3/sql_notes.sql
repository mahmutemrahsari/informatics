create table eksamensforsok (
	brukernavn char(8),
	emne char(10),
	semester char(5),
	karakter char(1),
	primary key (brukernavn)
	--Maks én primærnøkkeldeklarasjon pr. relasjon
);


SQL UNIQUE Constraint
The UNIQUE constraint ensures that all values in a column are different.

Both the UNIQUE and PRIMARY KEY constraints provide a guarantee for uniqueness for a column or set of columns.

A PRIMARY KEY constraint automatically has a UNIQUE constraint.

However, you can have many UNIQUE constraints per table, but only one PRIMARY KEY constraint per table.



SQL CHECK Constraint
The CHECK constraint is used to limit the value range that can be placed in a column.

If you define a CHECK constraint on a single column it allows only certain values for this column.

If you define a CHECK constraint on a table it can limit the values in certain columns based on values in other columns in the row.



A FOREIGN KEY is a key used to link two tables together.

A FOREIGN KEY is a field (or collection of fields) in one table that refers to the PRIMARY KEY in another table.

The table containing the foreign key is called the child table, and the table containing the candidate key is called the referenced or parent table.
Notice that the "PersonID" column in the "Orders" table points to the "PersonID" column in the "Persons" table.

The "PersonID" column in the "Persons" table is the PRIMARY KEY in the "Persons" table.

The "PersonID" column in the "Orders" table is a FOREIGN KEY in the "Orders" table.

The FOREIGN KEY constraint is used to prevent actions that would destroy links between tables.

The FOREIGN KEY constraint also prevents invalid data from being inserted into the foreign key column, because it has to be one of the values contained in the table it points to.


Fremmednøkler mot flere tabeller brukes for å implementere et mange-til-mange forhold mellom tabeller:

create table student (
bnavn char(8) primary key, navn varchar(80),
...
);
create table emne (
ekode char(10) primary key, emnenavn varchar(80), emneeier varchar(80),
...
);
create table antalleksamensforsøk (
brukernavn char(8) references student(bnavn), emne char(10) references emne(ekode), antforsøk integer,
primary key (brukernavn, emne)
);



