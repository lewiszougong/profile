DROP TABLE IF EXISTS user_profile;
CREATE TABLE user_profile (
	user_ref_id VARCHAR(255) NOT NULL,
	name VARCHAR(100) NOT NULL,
	age INTEGER NOT NULL,
	status VARCHAR(10) NOT NULL,
	created_date datetime NOT NULL,
	PRIMARY KEY(user_ref_id)
);

DROP TABLE IF EXISTS user_preference;
CREATE TABLE user_preference (
	user_ref_id VARCHAR(255) NOT NULL,
	balance_shown BIT NOT NULL,
	marketing_consent BIT NOT NULL,
	security BIT NOT NULL,
	location BIT NOT NULL,
	PRIMARY KEY(user_ref_id)
);