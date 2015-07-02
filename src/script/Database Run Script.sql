/*
Navicat PGSQL Data Transfer

Source Server         : pisalpostgres
Source Server Version : 90303
Source Host           : 192.168.178.155:5432
Source Database       : dbarticle
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90303
File Encoding         : 65001

Date: 2015-07-02 17:14:39
*/


-- ----------------------------
-- Sequence structure for art_id_seq
-- ----------------------------

CREATE SEQUENCE "art_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 230
 CACHE 1;
SELECT setval('"public"."art_id_seq"', 230, true);

-- ----------------------------
-- Table structure for tbarticle
-- ----------------------------
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
INSERT INTO "tbarticle" VALUES ('12', 'HOME', 'HOME', 'This is Home.', '2015-07-02 16:09:32');
INSERT INTO "tbarticle" VALUES ('13', 'DD', 'HODDDDME', 'This is Home.', '2015-07-02 16:37:32');
INSERT INTO "tbarticle" VALUES ('19', 'HOme', 'Home', 'Home', '2015-07-02 16:13:08');
INSERT INTO "tbarticle" VALUES ('20', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 14:44:19.241+07');
INSERT INTO "tbarticle" VALUES ('21', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 14:44:19.358+07');
INSERT INTO "tbarticle" VALUES ('23', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 14:44:19.427+07');
INSERT INTO "tbarticle" VALUES ('24', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 14:44:19.481+07');
INSERT INTO "tbarticle" VALUES ('25', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 14:44:19.487+07');
INSERT INTO "tbarticle" VALUES ('27', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 14:44:20.276+07');
INSERT INTO "tbarticle" VALUES ('28', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 14:44:20.325+07');
INSERT INTO "tbarticle" VALUES ('29', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 14:44:20.42+07');
INSERT INTO "tbarticle" VALUES ('30', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 14:44:20.421+07');
INSERT INTO "tbarticle" VALUES ('31', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.838+07');
INSERT INTO "tbarticle" VALUES ('32', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.852+07');
INSERT INTO "tbarticle" VALUES ('33', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.853+07');
INSERT INTO "tbarticle" VALUES ('34', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.853+07');
INSERT INTO "tbarticle" VALUES ('35', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.863+07');
INSERT INTO "tbarticle" VALUES ('36', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.864+07');
INSERT INTO "tbarticle" VALUES ('37', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.865+07');
INSERT INTO "tbarticle" VALUES ('38', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.865+07');
INSERT INTO "tbarticle" VALUES ('39', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.866+07');
INSERT INTO "tbarticle" VALUES ('40', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.867+07');
INSERT INTO "tbarticle" VALUES ('41', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.867+07');
INSERT INTO "tbarticle" VALUES ('42', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.868+07');
INSERT INTO "tbarticle" VALUES ('43', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.869+07');
INSERT INTO "tbarticle" VALUES ('44', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.869+07');
INSERT INTO "tbarticle" VALUES ('45', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.87+07');
INSERT INTO "tbarticle" VALUES ('46', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.871+07');
INSERT INTO "tbarticle" VALUES ('47', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.871+07');
INSERT INTO "tbarticle" VALUES ('48', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.872+07');
INSERT INTO "tbarticle" VALUES ('49', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.872+07');
INSERT INTO "tbarticle" VALUES ('50', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.873+07');
INSERT INTO "tbarticle" VALUES ('51', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.874+07');
INSERT INTO "tbarticle" VALUES ('52', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.874+07');
INSERT INTO "tbarticle" VALUES ('53', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.875+07');
INSERT INTO "tbarticle" VALUES ('54', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.875+07');
INSERT INTO "tbarticle" VALUES ('55', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.876+07');
INSERT INTO "tbarticle" VALUES ('56', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.877+07');
INSERT INTO "tbarticle" VALUES ('57', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.877+07');
INSERT INTO "tbarticle" VALUES ('58', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.878+07');
INSERT INTO "tbarticle" VALUES ('59', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.878+07');
INSERT INTO "tbarticle" VALUES ('60', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.879+07');
INSERT INTO "tbarticle" VALUES ('61', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.88+07');
INSERT INTO "tbarticle" VALUES ('62', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.88+07');
INSERT INTO "tbarticle" VALUES ('63', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.881+07');
INSERT INTO "tbarticle" VALUES ('64', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.881+07');
INSERT INTO "tbarticle" VALUES ('65', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.882+07');
INSERT INTO "tbarticle" VALUES ('66', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.883+07');
INSERT INTO "tbarticle" VALUES ('67', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.884+07');
INSERT INTO "tbarticle" VALUES ('68', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.884+07');
INSERT INTO "tbarticle" VALUES ('69', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.885+07');
INSERT INTO "tbarticle" VALUES ('70', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.885+07');
INSERT INTO "tbarticle" VALUES ('71', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.886+07');
INSERT INTO "tbarticle" VALUES ('72', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.887+07');
INSERT INTO "tbarticle" VALUES ('73', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.887+07');
INSERT INTO "tbarticle" VALUES ('74', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.888+07');
INSERT INTO "tbarticle" VALUES ('75', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.889+07');
INSERT INTO "tbarticle" VALUES ('76', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.889+07');
INSERT INTO "tbarticle" VALUES ('77', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.89+07');
INSERT INTO "tbarticle" VALUES ('78', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.89+07');
INSERT INTO "tbarticle" VALUES ('79', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.891+07');
INSERT INTO "tbarticle" VALUES ('80', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.891+07');
INSERT INTO "tbarticle" VALUES ('81', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.892+07');
INSERT INTO "tbarticle" VALUES ('82', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.893+07');
INSERT INTO "tbarticle" VALUES ('83', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.893+07');
INSERT INTO "tbarticle" VALUES ('84', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.894+07');
INSERT INTO "tbarticle" VALUES ('85', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.894+07');
INSERT INTO "tbarticle" VALUES ('86', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.895+07');
INSERT INTO "tbarticle" VALUES ('87', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.896+07');
INSERT INTO "tbarticle" VALUES ('88', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.896+07');
INSERT INTO "tbarticle" VALUES ('89', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.897+07');
INSERT INTO "tbarticle" VALUES ('90', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.897+07');
INSERT INTO "tbarticle" VALUES ('91', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.898+07');
INSERT INTO "tbarticle" VALUES ('92', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.899+07');
INSERT INTO "tbarticle" VALUES ('93', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.9+07');
INSERT INTO "tbarticle" VALUES ('94', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.901+07');
INSERT INTO "tbarticle" VALUES ('95', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.901+07');
INSERT INTO "tbarticle" VALUES ('96', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.902+07');
INSERT INTO "tbarticle" VALUES ('97', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.903+07');
INSERT INTO "tbarticle" VALUES ('98', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.904+07');
INSERT INTO "tbarticle" VALUES ('99', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.905+07');
INSERT INTO "tbarticle" VALUES ('100', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.906+07');
INSERT INTO "tbarticle" VALUES ('101', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.906+07');
INSERT INTO "tbarticle" VALUES ('102', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.907+07');
INSERT INTO "tbarticle" VALUES ('103', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.908+07');
INSERT INTO "tbarticle" VALUES ('104', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.908+07');
INSERT INTO "tbarticle" VALUES ('105', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.909+07');
INSERT INTO "tbarticle" VALUES ('106', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.91+07');
INSERT INTO "tbarticle" VALUES ('107', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.91+07');
INSERT INTO "tbarticle" VALUES ('108', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.911+07');
INSERT INTO "tbarticle" VALUES ('109', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.912+07');
INSERT INTO "tbarticle" VALUES ('110', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.912+07');
INSERT INTO "tbarticle" VALUES ('111', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.913+07');
INSERT INTO "tbarticle" VALUES ('112', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.914+07');
INSERT INTO "tbarticle" VALUES ('113', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.914+07');
INSERT INTO "tbarticle" VALUES ('114', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.916+07');
INSERT INTO "tbarticle" VALUES ('115', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.916+07');
INSERT INTO "tbarticle" VALUES ('116', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.917+07');
INSERT INTO "tbarticle" VALUES ('117', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.918+07');
INSERT INTO "tbarticle" VALUES ('118', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.919+07');
INSERT INTO "tbarticle" VALUES ('119', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.919+07');
INSERT INTO "tbarticle" VALUES ('120', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.92+07');
INSERT INTO "tbarticle" VALUES ('121', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.921+07');
INSERT INTO "tbarticle" VALUES ('122', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.921+07');
INSERT INTO "tbarticle" VALUES ('123', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.922+07');
INSERT INTO "tbarticle" VALUES ('124', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.923+07');
INSERT INTO "tbarticle" VALUES ('125', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.923+07');
INSERT INTO "tbarticle" VALUES ('126', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.924+07');
INSERT INTO "tbarticle" VALUES ('127', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.924+07');
INSERT INTO "tbarticle" VALUES ('128', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.925+07');
INSERT INTO "tbarticle" VALUES ('129', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.926+07');
INSERT INTO "tbarticle" VALUES ('130', 'Ke Pisal', 'JAVA', 'This is JAVA', '2015-07-02 15:23:54.927+07');
INSERT INTO "tbarticle" VALUES ('131', 'Ke Pisal0', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.818+07');
INSERT INTO "tbarticle" VALUES ('132', 'Ke Pisal1', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.832+07');
INSERT INTO "tbarticle" VALUES ('133', 'Ke Pisal2', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.833+07');
INSERT INTO "tbarticle" VALUES ('134', 'Ke Pisal3', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.834+07');
INSERT INTO "tbarticle" VALUES ('135', 'Ke Pisal4', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.835+07');
INSERT INTO "tbarticle" VALUES ('136', 'Ke Pisal5', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.835+07');
INSERT INTO "tbarticle" VALUES ('137', 'Ke Pisal6', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.836+07');
INSERT INTO "tbarticle" VALUES ('138', 'Ke Pisal7', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.837+07');
INSERT INTO "tbarticle" VALUES ('139', 'Ke Pisal8', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.837+07');
INSERT INTO "tbarticle" VALUES ('140', 'Ke Pisal9', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.838+07');
INSERT INTO "tbarticle" VALUES ('141', 'Ke Pisal10', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.839+07');
INSERT INTO "tbarticle" VALUES ('142', 'Ke Pisal11', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.839+07');
INSERT INTO "tbarticle" VALUES ('143', 'Ke Pisal12', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.84+07');
INSERT INTO "tbarticle" VALUES ('144', 'Ke Pisal13', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.84+07');
INSERT INTO "tbarticle" VALUES ('145', 'Ke Pisal14', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.841+07');
INSERT INTO "tbarticle" VALUES ('146', 'Ke Pisal15', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.841+07');
INSERT INTO "tbarticle" VALUES ('147', 'Ke Pisal16', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.842+07');
INSERT INTO "tbarticle" VALUES ('148', 'Ke Pisal17', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.842+07');
INSERT INTO "tbarticle" VALUES ('149', 'Ke Pisal18', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.843+07');
INSERT INTO "tbarticle" VALUES ('150', 'Ke Pisal19', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.843+07');
INSERT INTO "tbarticle" VALUES ('151', 'Ke Pisal20', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.844+07');
INSERT INTO "tbarticle" VALUES ('152', 'Ke Pisal21', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.844+07');
INSERT INTO "tbarticle" VALUES ('153', 'Ke Pisal22', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.845+07');
INSERT INTO "tbarticle" VALUES ('154', 'Ke Pisal23', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.846+07');
INSERT INTO "tbarticle" VALUES ('155', 'Ke Pisal24', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.846+07');
INSERT INTO "tbarticle" VALUES ('156', 'Ke Pisal25', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.847+07');
INSERT INTO "tbarticle" VALUES ('157', 'Ke Pisal26', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.848+07');
INSERT INTO "tbarticle" VALUES ('158', 'Ke Pisal27', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.849+07');
INSERT INTO "tbarticle" VALUES ('159', 'Ke Pisal28', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.85+07');
INSERT INTO "tbarticle" VALUES ('160', 'Ke Pisal29', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.851+07');
INSERT INTO "tbarticle" VALUES ('161', 'Ke Pisal30', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.851+07');
INSERT INTO "tbarticle" VALUES ('162', 'Ke Pisal31', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.852+07');
INSERT INTO "tbarticle" VALUES ('163', 'Ke Pisal32', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.852+07');
INSERT INTO "tbarticle" VALUES ('164', 'Ke Pisal33', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.853+07');
INSERT INTO "tbarticle" VALUES ('165', 'Ke Pisal34', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.853+07');
INSERT INTO "tbarticle" VALUES ('166', 'Ke Pisal35', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.854+07');
INSERT INTO "tbarticle" VALUES ('167', 'Ke Pisal36', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.854+07');
INSERT INTO "tbarticle" VALUES ('168', 'Ke Pisal37', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.855+07');
INSERT INTO "tbarticle" VALUES ('169', 'Ke Pisal38', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.855+07');
INSERT INTO "tbarticle" VALUES ('170', 'Ke Pisal39', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.856+07');
INSERT INTO "tbarticle" VALUES ('171', 'Ke Pisal40', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.857+07');
INSERT INTO "tbarticle" VALUES ('172', 'Ke Pisal41', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.858+07');
INSERT INTO "tbarticle" VALUES ('173', 'Ke Pisal42', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.861+07');
INSERT INTO "tbarticle" VALUES ('174', 'Ke Pisal43', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.861+07');
INSERT INTO "tbarticle" VALUES ('175', 'Ke Pisal44', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.862+07');
INSERT INTO "tbarticle" VALUES ('176', 'Ke Pisal45', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.862+07');
INSERT INTO "tbarticle" VALUES ('177', 'Ke Pisal46', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.863+07');
INSERT INTO "tbarticle" VALUES ('178', 'Ke Pisal47', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.863+07');
INSERT INTO "tbarticle" VALUES ('179', 'Ke Pisal48', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.864+07');
INSERT INTO "tbarticle" VALUES ('180', 'Ke Pisal49', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.865+07');
INSERT INTO "tbarticle" VALUES ('181', 'Ke Pisal50', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.866+07');
INSERT INTO "tbarticle" VALUES ('182', 'Ke Pisal51', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.866+07');
INSERT INTO "tbarticle" VALUES ('183', 'Ke Pisal52', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.867+07');
INSERT INTO "tbarticle" VALUES ('184', 'Ke Pisal53', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.867+07');
INSERT INTO "tbarticle" VALUES ('185', 'Ke Pisal54', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.868+07');
INSERT INTO "tbarticle" VALUES ('186', 'Ke Pisal55', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.868+07');
INSERT INTO "tbarticle" VALUES ('187', 'Ke Pisal56', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.869+07');
INSERT INTO "tbarticle" VALUES ('188', 'Ke Pisal57', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.869+07');
INSERT INTO "tbarticle" VALUES ('189', 'Ke Pisal58', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.87+07');
INSERT INTO "tbarticle" VALUES ('190', 'Ke Pisal59', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.871+07');
INSERT INTO "tbarticle" VALUES ('191', 'Ke Pisal60', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.871+07');
INSERT INTO "tbarticle" VALUES ('192', 'Ke Pisal61', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.872+07');
INSERT INTO "tbarticle" VALUES ('193', 'Ke Pisal62', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.872+07');
INSERT INTO "tbarticle" VALUES ('194', 'Ke Pisal63', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.873+07');
INSERT INTO "tbarticle" VALUES ('195', 'Ke Pisal64', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.873+07');
INSERT INTO "tbarticle" VALUES ('196', 'Ke Pisal65', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.874+07');
INSERT INTO "tbarticle" VALUES ('197', 'Ke Pisal66', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.875+07');
INSERT INTO "tbarticle" VALUES ('198', 'Ke Pisal67', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.876+07');
INSERT INTO "tbarticle" VALUES ('199', 'Ke Pisal68', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.876+07');
INSERT INTO "tbarticle" VALUES ('200', 'Ke Pisal69', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.877+07');
INSERT INTO "tbarticle" VALUES ('201', 'Ke Pisal70', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.877+07');
INSERT INTO "tbarticle" VALUES ('202', 'Ke Pisal71', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.878+07');
INSERT INTO "tbarticle" VALUES ('203', 'Ke Pisal72', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.879+07');
INSERT INTO "tbarticle" VALUES ('204', 'Ke Pisal73', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.879+07');
INSERT INTO "tbarticle" VALUES ('205', 'Ke Pisal74', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.88+07');
INSERT INTO "tbarticle" VALUES ('206', 'Ke Pisal75', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.881+07');
INSERT INTO "tbarticle" VALUES ('207', 'Ke Pisal76', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.881+07');
INSERT INTO "tbarticle" VALUES ('208', 'Ke Pisal77', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.882+07');
INSERT INTO "tbarticle" VALUES ('209', 'Ke Pisal78', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.883+07');
INSERT INTO "tbarticle" VALUES ('210', 'Ke Pisal79', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.883+07');
INSERT INTO "tbarticle" VALUES ('211', 'Ke Pisal80', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.884+07');
INSERT INTO "tbarticle" VALUES ('212', 'Ke Pisal81', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.884+07');
INSERT INTO "tbarticle" VALUES ('213', 'Ke Pisal82', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.885+07');
INSERT INTO "tbarticle" VALUES ('214', 'Ke Pisal83', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.885+07');
INSERT INTO "tbarticle" VALUES ('215', 'Ke Pisal84', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.886+07');
INSERT INTO "tbarticle" VALUES ('216', 'Ke Pisal85', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.887+07');
INSERT INTO "tbarticle" VALUES ('217', 'Ke Pisal86', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.888+07');
INSERT INTO "tbarticle" VALUES ('218', 'Ke Pisal87', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.888+07');
INSERT INTO "tbarticle" VALUES ('219', 'Ke Pisal88', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.889+07');
INSERT INTO "tbarticle" VALUES ('220', 'Ke Pisal89', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.889+07');
INSERT INTO "tbarticle" VALUES ('221', 'Ke Pisal90', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.89+07');
INSERT INTO "tbarticle" VALUES ('222', 'Ke Pisal91', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.891+07');
INSERT INTO "tbarticle" VALUES ('223', 'Ke Pisal92', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.891+07');
INSERT INTO "tbarticle" VALUES ('224', 'Ke Pisal93', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.892+07');
INSERT INTO "tbarticle" VALUES ('225', 'Ke Pisal94', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.892+07');
INSERT INTO "tbarticle" VALUES ('226', 'Ke Pisal95', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.893+07');
INSERT INTO "tbarticle" VALUES ('227', 'Ke Pisal96', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.893+07');
INSERT INTO "tbarticle" VALUES ('228', 'Ke Pisal97', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.894+07');
INSERT INTO "tbarticle" VALUES ('229', 'Ke Pisal98', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.895+07');
INSERT INTO "tbarticle" VALUES ('230', 'Ke Pisal99', 'JAVA', 'This is JAVA', '2015-07-02 15:24:41.895+07');
COMMIT;

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
  RETURNS "pg_catalog"."bool" AS $BODY$
BEGIN
   delete from tbarticle where id =i;

   IF FOUND THEN
      RETURN TRUE;
   ELSE
      RETURN FALSE;
   END IF;
END
$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for next_page
-- ----------------------------
CREATE OR REPLACE FUNCTION "next_page"(r int4, o int4)
  RETURNS SETOF "public"."tbarticle" AS $BODY$

SELECT * FROM tbarticle LIMIT r OFFSET o;
-- RETURN $add;

$BODY$
  LANGUAGE 'sql' VOLATILE COST 100
 ROWS 1000
;

-- ----------------------------
-- Function structure for search_by_author
-- ----------------------------
CREATE OR REPLACE FUNCTION "search_by_author"(au varchar)
  RETURNS SETOF "public"."tbarticle" AS $BODY$ SELECT
	*
FROM
	tbarticle
WHERE
	author LIKE UPPER (au) || '%'
OR author LIKE "lower" (au) || '%'
ORDER BY
	ID ASC ; -- RETURN $add;
	$BODY$
  LANGUAGE 'sql' VOLATILE COST 100
 ROWS 1000
;

-- ----------------------------
-- Function structure for search_by_content
-- ----------------------------
CREATE OR REPLACE FUNCTION "search_by_content"(con varchar)
  RETURNS SETOF "public"."tbarticle" AS $BODY$ SELECT
	*
FROM
	tbarticle
WHERE
	CONTENT LIKE '%' || "upper" (con) || '%'
OR CONTENT LIKE '%' || "upper" (con) || '%'
ORDER BY
	ID ASC ; -- RETURN $add;
	$BODY$
  LANGUAGE 'sql' VOLATILE COST 100
 ROWS 1000
;

-- ----------------------------
-- Function structure for search_by_title
-- ----------------------------
CREATE OR REPLACE FUNCTION "search_by_title"(ti varchar)
  RETURNS SETOF "public"."tbarticle" AS $BODY$

SELECT
	*
FROM
	tbarticle
WHERE
	title LIKE "upper" (ti) || '%'
OR title LIKE "lower" (ti) || '%'
ORDER BY
	ID ASC ;
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

SELECT * FROM tbarticle WHERE id=i;
-- RETURN $add;

$BODY$
  LANGUAGE 'sql' VOLATILE COST 100
 ROWS 1000
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
-- Function structure for set_row(ro int4, pa int4)
-- ----------------------------
CREATE OR REPLACE FUNCTION "set_row(ro int4, pa int4)"(ro int4, pa int4)
  RETURNS SETOF "public"."tbarticle" AS $BODY$

SELECT * FROM tbarticle LIMIT ro OFFSET pa;
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
  RETURNS "pg_catalog"."bool" AS $BODY$
BEGIN
	UPDATE tbarticle
SET author = au,
 title = ti,
 CONTENT = con,
 published_date = to_char(
	now(),
	'YYYY-MM-DD HH24:MI:SS'
)
WHERE
	"id" = i ;
IF FOUND THEN
	RETURN TRUE ;
ELSE
	RETURN FALSE ;
END
IF ;
END $BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for update_article_author
-- ----------------------------
CREATE OR REPLACE FUNCTION "update_article_author"(i int4, au text)
  RETURNS "pg_catalog"."bool" AS $BODY$
BEGIN
	UPDATE tbarticle
SET author = au,
 published_date = to_char(
	now(),
	'YYYY-MM-DD HH24:MI:SS'
)
WHERE
	"id" = i ;
IF FOUND THEN
	RETURN TRUE ;
ELSE
	RETURN FALSE ;
END
IF ;
END $BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for update_article_content
-- ----------------------------
CREATE OR REPLACE FUNCTION "update_article_content"(i int4, con text)
  RETURNS "pg_catalog"."bool" AS $BODY$
BEGIN
	UPDATE tbarticle
SET 
 content = con,
 published_date = to_char(
	now(),
	'YYYY-MM-DD HH24:MI:SS'
)
WHERE
	"id" = i ;
IF FOUND THEN
	RETURN TRUE ;
ELSE
	RETURN FALSE ;
END
IF ;
END $BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Function structure for update_article_title
-- ----------------------------
CREATE OR REPLACE FUNCTION "update_article_title"(i int4, ti text)
  RETURNS "pg_catalog"."bool" AS $BODY$
BEGIN
	UPDATE tbarticle
SET 
 title = ti,
 published_date = to_char(
	now(),
	'YYYY-MM-DD HH24:MI:SS'
)
WHERE
	"id" = i;
IF FOUND THEN
	RETURN TRUE ;
ELSE
	RETURN FALSE ;
END
IF ;
END $BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table tbarticle
-- ----------------------------
ALTER TABLE "tbarticle" ADD PRIMARY KEY ("id");
