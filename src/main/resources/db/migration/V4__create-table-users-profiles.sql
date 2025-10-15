

CREATE TABLE users_profiles(
    user_id BIGINT NOT NULL,
    profile_id BIGINT NOT NULL,

    PRIMARY KEY(user_id, profile_id),
    CONSTRAINT USERS_PROFILES_FK_USER FOREIGN KEY(user_id) REFERENCES users(id),
    CONSTRAINT USERS_PROFILES_FK_PROFILE FOREIGN KEY(profile_id) REFERENCES profiles(id)

);

INSERT INTO profiles(name) VALUES('TENANT');
INSERT INTO profiles(name) VALUES('OWNER');
INSERT INTO profiles(name) VALUES('ADMIN');
