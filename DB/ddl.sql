/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : food_truck

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 21/12/2023 21:35:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for food_facility_permit
-- ----------------------------
DROP TABLE IF EXISTS `food_facility_permit`;
CREATE TABLE `food_facility_permit` (
  `location_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `applicant` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `facility_type` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `cnn` int(11) DEFAULT NULL,
  `location_description` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `address` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `block_lot` varchar(10) COLLATE utf8mb4_bin DEFAULT NULL,
  `block` varchar(5) COLLATE utf8mb4_bin DEFAULT NULL,
  `lot` varchar(5) COLLATE utf8mb4_bin DEFAULT NULL,
  `permit` varchar(11) COLLATE utf8mb4_bin DEFAULT NULL,
  `status` varchar(9) COLLATE utf8mb4_bin DEFAULT NULL,
  `food_items` varchar(400) COLLATE utf8mb4_bin DEFAULT NULL,
  `x` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `y` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `latitude` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `longitude` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `schedule` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL,
  `days_hours` varchar(50) COLLATE utf8mb4_bin DEFAULT NULL,
  `noi_sent` varchar(20) COLLATE utf8mb4_bin DEFAULT NULL,
  `approved` date DEFAULT NULL,
  `received` varchar(8) COLLATE utf8mb4_bin DEFAULT NULL,
  `prior_permit` bit(1) DEFAULT NULL,
  `expiration_date` date DEFAULT NULL,
  `location` varchar(100) COLLATE utf8mb4_bin DEFAULT NULL,
  `fire_prevention_districts` int(11) DEFAULT NULL,
  `police_districts` int(11) DEFAULT NULL,
  `supervisor_districts` int(11) DEFAULT NULL,
  `zip_codes` int(11) DEFAULT NULL,
  `neighborhoods` int(11) DEFAULT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1747912 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

SET FOREIGN_KEY_CHECKS = 1;
