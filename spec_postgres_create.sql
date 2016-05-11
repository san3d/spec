CREATE TABLE "part" (
	"id" serial NOT NULL,
	"specification" character varying(400) NOT NULL,
	"unit_fk" int NOT NULL,
	"tag" int,
	"note" character varying(200),
	CONSTRAINT part_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "unit" (
	"id" serial NOT NULL,
	"name" character varying(5) NOT NULL UNIQUE,
	CONSTRAINT unit_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user_profile" (
	"id" serial NOT NULL,
	"email" character varying(80) NOT NULL UNIQUE,
	"password" character varying(80) NOT NULL UNIQUE,
	"department_fk" int NOT NULL,
	"first_name" character varying(20) NOT NULL,
	"last_name" character varying(20) NOT NULL,
	"role" int NOT NULL UNIQUE,
	"log_in" DATE NOT NULL,
	CONSTRAINT user_profile_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "department" (
	"id" serial NOT NULL,
	"name" character varying NOT NULL UNIQUE,
	CONSTRAINT department_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "tag" (
	"id" serial NOT NULL,
	"tag_name" character varying(20) NOT NULL UNIQUE,
	CONSTRAINT tag_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "transfer_order" (
	"id" serial NOT NULL,
	"target_department_fk" int NOT NULL,
	"stock_department_fk" int NOT NULL,
	"date" DATE NOT NULL,
	"author" int NOT NULL,
	"approver" int NOT NULL,
	"approve_date" DATE NOT NULL,
	"complete_date" DATE NOT NULL,
	"comment" character varying(300),
	"status" int NOT NULL,
	CONSTRAINT transfer_order_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "reserve_order" (
	"id" serial NOT NULL,
	"stock_department_fk" int NOT NULL,
	"date" DATE NOT NULL,
	"author" int NOT NULL,
	"status" int NOT NULL,
	"comment" character varying(300) NOT NULL,
	CONSTRAINT reserve_order_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "department_part" (
	"part_fk" int NOT NULL,
	"department_fk" int NOT NULL,
	"quantity" DECIMAL NOT NULL,
	"date_change" DATE NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "part_tag" (
	"part_fk" int NOT NULL,
	"tag_fk" int NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "transfer_part" (
	"transfer_fk" int NOT NULL,
	"part_fk" int NOT NULL,
	"quantity" bigint NOT NULL
) WITH (
  OIDS=FALSE
);



CREATE TABLE "reserve_part" (
	"reserve_fk" int NOT NULL,
	"part_fk" int NOT NULL,
	"quantity" bigint NOT NULL
) WITH (
  OIDS=FALSE
);



ALTER TABLE "part" ADD CONSTRAINT "part_fk0" FOREIGN KEY ("unit_fk") REFERENCES "unit"("id");


ALTER TABLE "user_profile" ADD CONSTRAINT "user_profile_fk0" FOREIGN KEY ("department_fk") REFERENCES "department"("id");



ALTER TABLE "transfer_order" ADD CONSTRAINT "transfer_order_fk0" FOREIGN KEY ("target_department_fk") REFERENCES "department"("id");
ALTER TABLE "transfer_order" ADD CONSTRAINT "transfer_order_fk1" FOREIGN KEY ("stock_department_fk") REFERENCES "department"("id");
ALTER TABLE "transfer_order" ADD CONSTRAINT "transfer_order_fk2" FOREIGN KEY ("author") REFERENCES "user_profile"("id");
ALTER TABLE "transfer_order" ADD CONSTRAINT "transfer_order_fk3" FOREIGN KEY ("approver") REFERENCES "user_profile"("id");

ALTER TABLE "reserve_order" ADD CONSTRAINT "reserve_order_fk0" FOREIGN KEY ("stock_department_fk") REFERENCES "department"("id");
ALTER TABLE "reserve_order" ADD CONSTRAINT "reserve_order_fk1" FOREIGN KEY ("author") REFERENCES "user_profile"("id");

ALTER TABLE "department_part" ADD CONSTRAINT "department_part_fk0" FOREIGN KEY ("part_fk") REFERENCES "part"("id");
ALTER TABLE "department_part" ADD CONSTRAINT "department_part_fk1" FOREIGN KEY ("department_fk") REFERENCES "department"("id");

ALTER TABLE "part_tag" ADD CONSTRAINT "part_tag_fk0" FOREIGN KEY ("part_fk") REFERENCES "part"("id");
ALTER TABLE "part_tag" ADD CONSTRAINT "part_tag_fk1" FOREIGN KEY ("tag_fk") REFERENCES "tag"("id");

ALTER TABLE "transfer_part" ADD CONSTRAINT "transfer_part_fk0" FOREIGN KEY ("transfer_fk") REFERENCES "transfer_order"("id");
ALTER TABLE "transfer_part" ADD CONSTRAINT "transfer_part_fk1" FOREIGN KEY ("part_fk") REFERENCES "part"("id");

ALTER TABLE "reserve_part" ADD CONSTRAINT "reserve_part_fk0" FOREIGN KEY ("reserve_fk") REFERENCES "reserve_order"("id");
ALTER TABLE "reserve_part" ADD CONSTRAINT "reserve_part_fk1" FOREIGN KEY ("part_fk") REFERENCES "part"("id");

