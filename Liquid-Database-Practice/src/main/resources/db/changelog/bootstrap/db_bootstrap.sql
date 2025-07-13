drop table if EXISTS `articles`;
create table articles (
    id serial primary key,
    title varchar(512),
    authored date,
    published date
);

drop table if EXISTS `comments`;
create table comments (
    id serial primary key,
    comment varchar(1024) not null,
    article_id bigint unsigned,
    constraint article_fk foreign key (article_id) references articles(id)
);


insert into articles ( `title`, `authored`, `published`) values
	('Waiter! There is a bus...g in my JSoup!', now(), null),
	('Understanding JPA', now(), null),
	('Working with liqui-base', now(), null);


insert into comments (comment, article_id) VALUES
    ('first!', (select max(id) from articles)),
    ('first!', (select min(id) from articles)),
    ('I came here to say that!', (select min(id) from articles));