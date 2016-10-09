/*
Navicat PGSQL Data Transfer

Source Server         : postgresql
Source Server Version : 90503
Source Host           : 192.168.100.120:5432
Source Database       : postgres
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90503
File Encoding         : 65001

Date: 2016-10-09 20:31:34
*/


-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS "public"."admin";
CREATE TABLE "public"."admin" (
"id" varchar(60) COLLATE "default" NOT NULL,
"email" varchar(40) COLLATE "default" NOT NULL,
"username" varchar(40) COLLATE "default" NOT NULL,
"pwd" varchar(20) COLLATE "default" NOT NULL,
"state" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO "public"."admin" VALUES ('e3e00f67-8aac-446a-a4c7-e88df9eef09c', '13101900@qq.com', 'jpzhu', '560128', 'f');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
