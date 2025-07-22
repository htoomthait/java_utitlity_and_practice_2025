-- liquibase formatted sql

-- changeset htoomaungthait:1752594487744-1
--preconditions onFail:MARK_RAN onError:MARK_RAN
--precondition-sql-check  expectedResult:0 select count(*) from information_schema.tables where table_name = 'articles';
CREATE TABLE articles (id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL, title VARCHAR(512) NULL, authored date DEFAULT NULL NULL, published date DEFAULT NULL NULL, CONSTRAINT PK_ARTICLES PRIMARY KEY (id));
-- rollback drop table articles cascade;

-- changeset htoomaungthait:1752594487744-2
--preconditions onFail:MARK_RAN onError:MARK_RAN
--precondition-sql-check  expectedResult:0 select count(*) from information_schema.tables where table_name = 'comments';
CREATE TABLE comments (id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL, comment VARCHAR(1024) NOT NULL, article_id BIGINT UNSIGNED DEFAULT NULL NULL, CONSTRAINT PK_COMMENTS PRIMARY KEY (id));
-- rollback drop table comments;

-- changeset htoomaungthait:1752594487744-3
--preconditions onFail:MARK_RAN onError:MARK_RAN
CREATE INDEX article_fk_idx ON comments(article_id);

-- changeset htoomaungthait:1752594487744-4
--preconditions onFail:MARK_RAN onError:MARK_RAN
ALTER TABLE comments ADD CONSTRAINT article_fk FOREIGN KEY (article_id) REFERENCES articles (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

-- changeset htoomaungthait:1752594487744-5-simple-data
--preconditions onFail:MARK_RAN onError:MARK_RAN
--precondition-sql-check  expectedResult:0 select count(*) from articles;
insert into articles ( `title`, `authored`, `published`) values
	('Waiter! There is a bus...g in my JSoup!', now(), null),
	('Understanding JPA', now(), null),
	('Working with liqui-base', now(), null);
insert into comments (comment, article_id) VALUES
    ('first!', (select max(id) from articles)),
    ('first!', (select min(id) from articles)),
    ('I came here to say that!', (select min(id) from articles));
-- rollback SET FOREIGN_KEY_CHECKS=0;
-- rollback truncate table comments;
-- rollback truncate table articles;
-- rollback SET FOREIGN_KEY_CHECKS=1;


