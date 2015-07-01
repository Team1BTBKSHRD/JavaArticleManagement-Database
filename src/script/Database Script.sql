/*
Navicat PGSQL Data Transfer

Source Server         : PostgresSQL
Source Server Version : 90303
Source Host           : localhost:5432
Source Database       : DbArticle
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90303
File Encoding         : 65001

Date: 2015-07-01 16:59:57
*/


-- ----------------------------
-- Sequence structure for art_id_seq
-- ----------------------------
DROP SEQUENCE "art_id_seq";
CREATE SEQUENCE "art_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 8
 CACHE 1;
SELECT setval('"public"."art_id_seq"', 8, true);

-- ----------------------------
-- Table structure for tbarticle
-- ----------------------------
DROP TABLE IF EXISTS "tbarticle";
CREATE TABLE "tbarticle" (
"id" int4 DEFAULT nextval('art_id_seq'::regclass) NOT NULL,
"author" text COLLATE "default" NOT NULL,
"title" text COLLATE "default" NOT NULL,
"content" text COLLATE "default",
"published_date" text COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbarticle
-- ----------------------------
BEGIN;
INSERT INTO "tbarticle" VALUES ('1', 'cadf', 'asdf', 'asdf', '2015-07-01 12:11:01');
INSERT INTO "tbarticle" VALUES ('2', 'adsf', 'asdf', 'asdfasdf', '2015-07-01 13:32:57');
INSERT INTO "tbarticle" VALUES ('3', 'sok', 'sok', 'sok', '2015-07-01 13:48:15');
INSERT INTO "tbarticle" VALUES ('5', 'sok', 'sok', 'sok', '2015-07-01 14:08:15.638+07');
INSERT INTO "tbarticle" VALUES ('6', 'sf', 'sok', 'sokdfadf', '2015-07-01 14:11:03.1+07');
INSERT INTO "tbarticle" VALUES ('7', 'sf', 'sok', '', '2015-07-01 14:13:07.393+07');
INSERT INTO "tbarticle" VALUES ('8', '', 'sok', '', '2015-07-01 14:13:17.646+07');
COMMIT;

-- ----------------------------
-- Table structure for tbl_student
-- ----------------------------
DROP TABLE IF EXISTS "tbl_student";
CREATE TABLE "tbl_student" (
"id" int4 NOT NULL,
"st_name" text COLLATE "default",
"gender" char(1) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbl_student
-- ----------------------------
BEGIN;
INSERT INTO "tbl_student" VALUES ('2', 'pov', 'f');
INSERT INTO "tbl_student" VALUES ('5', 'fdg', 'm');
COMMIT;

-- ----------------------------
-- Table structure for tbstudent
-- ----------------------------
DROP TABLE IF EXISTS "tbstudent";
CREATE TABLE "tbstudent" (
"id" int4,
"name" text COLLATE "default",
"gender" char(1) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbstudent
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- View structure for vw_search_by_id
-- ----------------------------
CREATE OR REPLACE VIEW "vw_search_by_id" AS 
 SELECT tbarticle.id,
    tbarticle.author,
    tbarticle.title,
    tbarticle.content,
    tbarticle.published_date
   FROM tbarticle
  WHERE (tbarticle.id = set_id(3));

-- ----------------------------
-- View structure for vw_short_by_author_asc
-- ----------------------------
CREATE OR REPLACE VIEW "vw_short_by_author_asc" AS 
 SELECT tbarticle.id,
    tbarticle.author,
    tbarticle.title,
    tbarticle.content,
    tbarticle.published_date
   FROM tbarticle
  ORDER BY tbarticle.author;

-- ----------------------------
-- View structure for vw_short_by_author_desc
-- ----------------------------
CREATE OR REPLACE VIEW "vw_short_by_author_desc" AS 
 SELECT tbarticle.id,
    tbarticle.author,
    tbarticle.title,
    tbarticle.content,
    tbarticle.published_date
   FROM tbarticle
  ORDER BY tbarticle.author DESC;

-- ----------------------------
-- View structure for vw_short_by_content_asc
-- ----------------------------
CREATE OR REPLACE VIEW "vw_short_by_content_asc" AS 
 SELECT tbarticle.id,
    tbarticle.author,
    tbarticle.title,
    tbarticle.content,
    tbarticle.published_date
   FROM tbarticle
  ORDER BY tbarticle.content;

-- ----------------------------
-- View structure for vw_short_by_content_desc
-- ----------------------------
CREATE OR REPLACE VIEW "vw_short_by_content_desc" AS 
 SELECT tbarticle.id,
    tbarticle.author,
    tbarticle.title,
    tbarticle.content,
    tbarticle.published_date
   FROM tbarticle
  ORDER BY tbarticle.content DESC;

-- ----------------------------
-- View structure for vw_short_by_title_asc
-- ----------------------------
CREATE OR REPLACE VIEW "vw_short_by_title_asc" AS 
 SELECT tbarticle.id,
    tbarticle.author,
    tbarticle.title,
    tbarticle.content,
    tbarticle.published_date
   FROM tbarticle
  ORDER BY tbarticle.title;

-- ----------------------------
-- View structure for vw_short_by_title_desc
-- ----------------------------
CREATE OR REPLACE VIEW "vw_short_by_title_desc" AS 
 SELECT tbarticle.id,
    tbarticle.author,
    tbarticle.title,
    tbarticle.content,
    tbarticle.published_date
   FROM tbarticle
  ORDER BY tbarticle.title DESC;

-- ----------------------------
-- View structure for vw_show
-- ----------------------------
CREATE OR REPLACE VIEW "vw_show" AS 
 SELECT tbarticle.id,
    tbarticle.author,
    tbarticle.title,
    tbarticle.content,
    tbarticle.published_date
   FROM tbarticle;

-- ----------------------------
-- View structure for vw_show_by_id
-- ----------------------------
CREATE OR REPLACE VIEW "vw_show_by_id" AS 
 SELECT tbarticle.id,
    tbarticle.author,
    tbarticle.title,
    tbarticle.content,
    tbarticle.published_date
   FROM tbarticle
  ORDER BY tbarticle.id;

-- ----------------------------
-- View structure for vw_show_by_id_dsc
-- ----------------------------
CREATE OR REPLACE VIEW "vw_show_by_id_dsc" AS 
 SELECT tbarticle.id,
    tbarticle.author,
    tbarticle.title,
    tbarticle.content,
    tbarticle.published_date
   FROM tbarticle
  ORDER BY tbarticle.id DESC;

-- ----------------------------
-- Function structure for add_article
-- ----------------------------
CREATE OR REPLACE FUNCTION "add_article"(author text, title text, content text)
  RETURNS "pg_catalog"."void" AS $BODY$
BEGIN
INSERT into tbarticle(author, title,content, published_date) VALUES(author, title,content, now());

-- RETURN $add;
END
$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for delete_article
-- ----------------------------
CREATE OR REPLACE FUNCTION "delete_article"(i int4)
  RETURNS "pg_catalog"."void" AS $BODY$
BEGIN
DELETE FROM tbarticle WHERE "id"=i;
END

$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for search_by_author
-- ----------------------------
CREATE OR REPLACE FUNCTION "search_by_author"(au text)
  RETURNS SETOF "public"."tbarticle" AS $BODY$ SELECT
	*
FROM
	tbarticle
WHERE
	author = au ; -- RETURN $add;
	$BODY$
  LANGUAGE 'sql' VOLATILE COST 100
 ROWS 1000
;

-- ----------------------------
-- Function structure for search_by_content
-- ----------------------------
CREATE OR REPLACE FUNCTION "search_by_content"(con varchar)
  RETURNS SETOF "public"."tbarticle" AS $BODY$

SELECT * FROM tbarticle WHERE "content"=con;
-- RETURN $add;

$BODY$
  LANGUAGE 'sql' VOLATILE COST 100
 ROWS 1000
;

-- ----------------------------
-- Function structure for search_by_title
-- ----------------------------
CREATE OR REPLACE FUNCTION "search_by_title"(ti varchar)
  RETURNS SETOF "public"."tbarticle" AS $BODY$

SELECT * FROM tbarticle WHERE title=ti;
-- RETURN $add;

$BODY$
  LANGUAGE 'sql' VOLATILE COST 100
 ROWS 1000
;

-- ----------------------------
-- Function structure for search_id
-- ----------------------------
CREATE OR REPLACE FUNCTION "search_id"(i int4)
  RETURNS SETOF "public"."tbarticle" AS $BODY$

SELECT * FROM tbarticle WHERE ID=i;
-- RETURN $add;

$BODY$
  LANGUAGE 'sql' VOLATILE COST 100
 ROWS 1000
;

-- ----------------------------
-- Function structure for set_id
-- ----------------------------
CREATE OR REPLACE FUNCTION "set_id"(i int4)
  RETURNS "pg_catalog"."int4" AS $BODY$
BEGIN
	RETURN i ;
END ; $BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for set_row
-- ----------------------------
CREATE OR REPLACE FUNCTION "set_row"(r int4)
  RETURNS SETOF "public"."tbarticle" AS $BODY$

SELECT * FROM tbarticle LIMIT r;
-- RETURN $add;

$BODY$
  LANGUAGE 'sql' VOLATILE COST 100
 ROWS 1000
;

-- ----------------------------
-- Function structure for total_record()
-- ----------------------------
CREATE OR REPLACE FUNCTION "total_record()"()
  RETURNS "pg_catalog"."int4" AS $BODY$
DECLARE total INTEGER;
BEGIN
	SELECT count(*) INTO total FROM tbarticle;
	RETURN total;
END;
$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for update_article
-- ----------------------------
CREATE OR REPLACE FUNCTION "update_article"(i int4, au text, ti text, con text)
  RETURNS "pg_catalog"."void" AS $BODY$
BEGIN
UPDATE tbarticle SET author=au,title=ti,content=con, published_date=to_char(now() ,'YYYY-MM-DD HH24:MI:SS') WHERE "id"=i;
END

$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for update_article_author
-- ----------------------------
CREATE OR REPLACE FUNCTION "update_article_author"(i int4, au text)
  RETURNS "pg_catalog"."void" AS $BODY$
BEGIN
UPDATE tbarticle SET author=au, published_date=to_char(now() ,'YYYY-MM-DD HH24:MI:SS') WHERE "id"=i;
END

$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for update_article_content
-- ----------------------------
CREATE OR REPLACE FUNCTION "update_article_content"(i int4, con text)
  RETURNS "pg_catalog"."void" AS $BODY$
BEGIN
UPDATE tbarticle SET content=con, published_date=to_char(now() ,'YYYY-MM-DD HH24:MI:SS') WHERE "id"=i;
END

$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for update_article_title
-- ----------------------------
CREATE OR REPLACE FUNCTION "update_article_title"(i int4, ti text)
  RETURNS "pg_catalog"."void" AS $BODY$
BEGIN
UPDATE tbarticle SET title=ti, published_date=to_char(now() ,'YYYY-MM-DD HH24:MI:SS') WHERE "id"=i;
END

$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table tbarticle
-- ----------------------------
ALTER TABLE "tbarticle" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table tbl_student
-- ----------------------------
ALTER TABLE "tbl_student" ADD PRIMARY KEY ("id");
