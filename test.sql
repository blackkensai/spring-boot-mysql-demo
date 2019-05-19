
CREATE TABLE IF NOT EXISTS T_USER (
    id VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    city VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
)ENGINE=ndbcluster;

insert into T_USER(id, name, city, address) values('4afa6e44-fd4d-41ee-ac20-a21065bf4c06', 'Jon Snow', 'Winterfell', 'Somewhere')

ALTER TABLE T_USER
    PARTITION BY HASH(crc32(city))
    PARTITIONS 8;

