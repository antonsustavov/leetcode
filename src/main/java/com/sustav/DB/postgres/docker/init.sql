#TABLE url_table
create table url_table
(
    id     serial not null primary key,
    url    text,
    url_id character(5)
);

#TABLE temp
create table temp
(
    t int
);
insert into temp (t)
select random() * 100
from generate_series(0, 100000);

#TABLE login
create table login
(
    username int,
    password text,
    salary   int
);

#TABLE grades
create table grades
(
    id   serial primary key,
    g    int,
    name text
);
insert into grades (g, name)
select random() * 100, substring(md5(random()::text), 0, floor(random() * 31)::int)
from generate_series(0, 500);
vacuum
(analyze, verbose, full);
explain
analyze
select id, g
from grades
where g > 80
  and g < 95
order by g;

#TABLE employees
create table employees
(
    id   serial primary key,
    name text
);

create
or replace function random_string(length integer) returns text as
$$
declare
chars text[] := '{0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z}';
  result
text := '';
  i
integer := 0;
  length2
integer := (select trunc(random() * length + 1));
begin
  if
length2 < 0 then
    raise exception 'Given length cannot be less than 0';
end if;
for i in 1..length2 loop
    result := result || chars[1+random()*(array_length(chars, 1)-1)];
end loop;
return result;
end;
$$
language plpgsql;

insert into employees(name)(select random_string(10) from generate_series(0, 1000000));
