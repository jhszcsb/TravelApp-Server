CREATE TABLE `friendship_data` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=3;

CREATE TABLE `gallery` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2;

CREATE TABLE `personal_data` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2;

CREATE TABLE `places` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2;

CREATE TABLE `social_data` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2;

CREATE TABLE `timeline` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2;

CREATE TABLE `traveler` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`personaldata_id` INT(10) NULL DEFAULT NULL,
	`socialdata_id` INT(10) NULL DEFAULT NULL,
	`friendshipdata_id` INT(10) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `traveler_friendship_data` (`friendshipdata_id`),
	INDEX `traveler_personal_data` (`personaldata_id`),
	INDEX `traveler_social_data` (`socialdata_id`),
	CONSTRAINT `traveler_friendship_data` FOREIGN KEY (`friendshipdata_id`) REFERENCES `friendship_data` (`id`),
	CONSTRAINT `traveler_personal_data` FOREIGN KEY (`personaldata_id`) REFERENCES `personal_data` (`id`),
	CONSTRAINT `traveler_social_data` FOREIGN KEY (`socialdata_id`) REFERENCES `social_data` (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=4;

CREATE TABLE `trip` (
	`id` INT(10) NOT NULL AUTO_INCREMENT,
	`traveler_id` INT(10) NULL DEFAULT NULL,
	`timeline_id` INT(10) NULL DEFAULT NULL,
	`gallery_id` INT(10) NULL DEFAULT NULL,
	`places_id` INT(10) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `trip_timeline` (`timeline_id`),
	INDEX `trip_gallery` (`gallery_id`),
	INDEX `trip_places` (`places_id`),
	INDEX `trip_traveler` (`traveler_id`),
	CONSTRAINT `trip_traveler` FOREIGN KEY (`traveler_id`) REFERENCES `traveler` (`id`),
	CONSTRAINT `trip_gallery` FOREIGN KEY (`gallery_id`) REFERENCES `gallery` (`id`),
	CONSTRAINT `trip_places` FOREIGN KEY (`places_id`) REFERENCES `places` (`id`),
	CONSTRAINT `trip_timeline` FOREIGN KEY (`timeline_id`) REFERENCES `timeline` (`id`)
)
COLLATE='latin2_hungarian_ci'
ENGINE=InnoDB
AUTO_INCREMENT=5;
