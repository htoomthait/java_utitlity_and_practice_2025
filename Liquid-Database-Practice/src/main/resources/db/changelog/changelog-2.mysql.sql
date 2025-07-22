-- liquibase formatted sql

-- changeset htoomaungthait:1753203511035-1
CREATE TABLE articles (id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL, title VARCHAR(512) NULL, authored date DEFAULT NULL NULL, published date DEFAULT NULL NULL, CONSTRAINT PK_ARTICLES PRIMARY KEY (id));

-- changeset htoomaungthait:1753203511035-2
CREATE TABLE comments (id BIGINT UNSIGNED AUTO_INCREMENT NOT NULL, comment VARCHAR(1024) NOT NULL, article_id BIGINT UNSIGNED DEFAULT NULL NULL, CONSTRAINT PK_COMMENTS PRIMARY KEY (id));

-- changeset htoomaungthait:1753203511035-3
CREATE INDEX article_fk_idx ON comments(article_id);

-- changeset htoomaungthait:1753203511035-4
ALTER TABLE comments ADD CONSTRAINT article_fk FOREIGN KEY (article_id) REFERENCES articles (id) ON UPDATE RESTRICT ON DELETE RESTRICT;

