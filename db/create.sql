CREATE TABLE `follower_data` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`follower_id` INT(10) NULL DEFAULT NULL,
	`followed_id` INT(10) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `follow_follower-traveler` (`follower_id`),
	INDEX `follow_followed-traveler` (`followed_id`),
	CONSTRAINT `follow_follower-traveler` FOREIGN KEY (`follower_id`) REFERENCES `traveler` (`id`),
	CONSTRAINT `follow_followed-traveler` FOREIGN KEY (`followed_id`) REFERENCES `traveler` (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;

CREATE TABLE `gallery` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`url` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin2_hungarian_ci',
	PRIMARY KEY (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;

CREATE TABLE `personal_data` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(50) NOT NULL COLLATE 'latin2_hungarian_ci',
	`profilepic` LONGBLOB NULL,
	`firstname` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin2_hungarian_ci',
	`lastname` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin2_hungarian_ci',
	`password` VARCHAR(200) NULL DEFAULT NULL COLLATE 'latin2_hungarian_ci',
	`email` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin2_hungarian_ci',
	`hometown` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin2_hungarian_ci',
	`membersince` DATETIME NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `username` (`username`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;

CREATE TABLE `place` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`description` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin2_hungarian_ci',
	`name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'latin2_hungarian_ci',
	PRIMARY KEY (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;

CREATE TABLE `social_data` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;

CREATE TABLE `timeline` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;

CREATE TABLE `traveler` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`personaldata_id` INT(10) NULL DEFAULT NULL,
	`socialdata_id` INT(10) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `traveler_personal_data` (`personaldata_id`),
	INDEX `traveler_social_data` (`socialdata_id`),
	CONSTRAINT `traveler_personal_data` FOREIGN KEY (`personaldata_id`) REFERENCES `personal_data` (`id`),
	CONSTRAINT `traveler_social_data` FOREIGN KEY (`socialdata_id`) REFERENCES `social_data` (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;

CREATE TABLE `trip` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`traveler_id` INT(10) NULL DEFAULT NULL,
	`timeline_id` INT(10) NULL DEFAULT NULL,
	`gallery_id` INT(10) NULL DEFAULT NULL,
	`place_id` INT(10) NULL DEFAULT NULL,
	`name` VARCHAR(50) NOT NULL COLLATE 'latin2_hungarian_ci',
	PRIMARY KEY (`id`),
	INDEX `trip_timeline` (`timeline_id`),
	INDEX `trip_gallery` (`gallery_id`),
	INDEX `trip_place` (`place_id`),
	INDEX `trip_traveler` (`traveler_id`),
	CONSTRAINT `trip_gallery` FOREIGN KEY (`gallery_id`) REFERENCES `gallery` (`id`),
	CONSTRAINT `trip_place` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`),
	CONSTRAINT `trip_timeline` FOREIGN KEY (`timeline_id`) REFERENCES `timeline` (`id`),
	CONSTRAINT `trip_traveler` FOREIGN KEY (`traveler_id`) REFERENCES `traveler` (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1;

CREATE TABLE `picture` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`data` LONGBLOB NULL,
	`gallery_id` INT(11) NULL DEFAULT NULL,
	`place_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `picture_gallery` FOREIGN KEY (`gallery_id`) REFERENCES `gallery` (`id`),
	CONSTRAINT `picture_place` FOREIGN KEY (`place_id`) REFERENCES `place` (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB;