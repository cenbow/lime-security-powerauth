--
--  Drop all tables and sequence.
--
DROP TABLE "PA_ACTIVATION" CASCADE CONSTRAINTS;
DROP TABLE "PA_APPLICATION" CASCADE CONSTRAINTS;
DROP TABLE "PA_APPLICATION_VERSION" CASCADE CONSTRAINTS;
DROP TABLE "PA_MASTER_KEYPAIR" CASCADE CONSTRAINTS;
DROP TABLE "PA_SIGNATURE_AUDIT" CASCADE CONSTRAINTS;
DROP TABLE "PA_INTEGRATION" CASCADE CONSTRAINTS;
DROP TABLE "PA_APPLICATION_CALLBACK" CASCADE CONSTRAINTS;
DROP SEQUENCE "HIBERNATE_SEQUENCE";
