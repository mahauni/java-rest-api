ALTER TABLE DATA_TEST DROP COLUMN ACTIVE;
ALTER TABLE data_test ADD active BOOLEAN;
UPDATE data_test SET active = TRUE;