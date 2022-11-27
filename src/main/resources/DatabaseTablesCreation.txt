-- Table: public.cars

-- DROP TABLE IF EXISTS public.cars;

CREATE TABLE IF NOT EXISTS public.cars
(
    year integer,
    model text COLLATE pg_catalog."default" NOT NULL,
    horse_power integer,
    electric boolean,
    used boolean,
    number_of_seats integer,
    id bigint NOT NULL DEFAULT nextval('cars_id_seq'::regclass),
    CONSTRAINT cars_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.cars
    OWNER to postgres;

-- Table: public.carshop

-- DROP TABLE IF EXISTS public.carshop;

CREATE TABLE IF NOT EXISTS public.carshop
(
    location text COLLATE pg_catalog."default",
    inventory integer,
    currently_open boolean,
    number_of_employees integer,
    open_since time with time zone,
    id bigint NOT NULL DEFAULT nextval('carshop_id_seq'::regclass),
    CONSTRAINT carshop_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.carshop
    OWNER to postgres;
