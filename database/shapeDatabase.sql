create table shapes
(
    object   int auto_increment
        primary key,
    location varchar(255) null,
    shape    varchar(255) null,
    param1   varchar(255) null,
    param2   varchar(255) null,
    param3   varchar(255) null,
    color    varchar(255) default 'WHITE' null
);

insert into shapes (object, location, shape, param1, param2, param3, color)
values (1, '50,20', 'square', '100', null, null, 'red'),
       (2, '500,100', 'circle', '100', null, null, 'green'),
       (3, '250,350', 'rectangle', '200', '250', null, 'blue'),
       (4, '150,150', 'triangle', '(150,150)', '(200,70)', '(50,0)', 'pink'),
       (5, '350,200', 'rectangle', '200', '250', null, 'firebrick'),
       (6, '750,250', 'triangle', '(175,450)', '(200,60)', '(20,20)', '0x40A8CC'),
       (7, '600,400', 'circle', '155.12', null, null, '#26619C');
