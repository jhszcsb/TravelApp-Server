--todo: add valid sequence of create codes to be able to reinitialize db
--todo: add test data to db from sql file

CREATE TABLE `friendship_data` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`traveler1_id` INT(10) NULL DEFAULT NULL,
	`traveler2_id` INT(10) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `friendship_traveler1-traveler` (`traveler1_id`),
	INDEX `friendship_traveler2-traveler` (`traveler2_id`),
	CONSTRAINT `friendship_traveler1-traveler` FOREIGN KEY (`traveler1_id`) REFERENCES `traveler` (`id`),
	CONSTRAINT `friendship_traveler2-traveler` FOREIGN KEY (`traveler2_id`) REFERENCES `traveler` (`id`)
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

CREATE TABLE `places` (
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
	`places_id` INT(10) NULL DEFAULT NULL,
	`name` VARCHAR(50) NOT NULL COLLATE 'latin2_hungarian_ci',
	PRIMARY KEY (`id`),
	INDEX `trip_timeline` (`timeline_id`),
	INDEX `trip_gallery` (`gallery_id`),
	INDEX `trip_places` (`places_id`),
	INDEX `trip_traveler` (`traveler_id`),
	CONSTRAINT `trip_gallery` FOREIGN KEY (`gallery_id`) REFERENCES `gallery` (`id`),
	CONSTRAINT `trip_places` FOREIGN KEY (`places_id`) REFERENCES `places` (`id`),
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
	`places_id` INT(11) NOT NULL,
	PRIMARY KEY (`id`),
	CONSTRAINT `picture_gallery` FOREIGN KEY (`gallery_id`) REFERENCES `gallery` (`id`),
	CONSTRAINT `picture_places` FOREIGN KEY (`places_id`) REFERENCES `places` (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB;