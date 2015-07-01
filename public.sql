/*
Navicat PGSQL Data Transfer

Source Server         : zz
Source Server Version : 90303
Source Host           : localhost:5432
Source Database       : dbarticle
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90303
File Encoding         : 65001

Date: 2015-07-01 15:55:45
*/


-- ----------------------------
-- Sequence structure for art_id_seq
-- ----------------------------
CREATE SEQUENCE  "art_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 2
 CACHE 1;
SELECT setval(' "art_id_seq"', 2, true);

-- ----------------------------
-- Table structure for tbarticle
-- ----------------------------
CREATE TABLE  "tbarticle" (
"id" int4 DEFAULT nextval('art_id_seq'::regclass) NOT NULL,
"author" text COLLATE "default" NOT NULL,
"title" text COLLATE "default" NOT NULL,
"content" text COLLATE "default",
"published_date" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbarticle
-- ----------------------------
INSERT INTO  "tbarticle" VALUES ('1', 'sambo', 'java', 'kfjalj', '2015-07-01 10:35:40');
INSERT INTO  "tbarticle" VALUES ('2', 'ellit', 'web', 'kdfjd', '2015-07-01 10:35:55');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
