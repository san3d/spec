--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.2

-- Started on 2016-05-31 00:14:41

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2252 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_with_oids = false;

--
-- TOC entry 186 (class 1259 OID 19300)
-- Name: department; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE department (
    id integer NOT NULL,
    name character varying NOT NULL
);


--
-- TOC entry 185 (class 1259 OID 19298)
-- Name: department_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE department_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2253 (class 0 OID 0)
-- Dependencies: 185
-- Name: department_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE department_id_seq OWNED BY department.id;


--
-- TOC entry 193 (class 1259 OID 19343)
-- Name: department_part; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE department_part (
    part_fk integer NOT NULL,
    department_fk integer NOT NULL,
    quantity numeric NOT NULL,
    date_change date NOT NULL
);


--
-- TOC entry 182 (class 1259 OID 19265)
-- Name: part; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE part (
    id integer NOT NULL,
    specification character varying(400) NOT NULL,
    unit_fk integer NOT NULL,
    tag integer,
    note character varying(200)
);


--
-- TOC entry 181 (class 1259 OID 19263)
-- Name: part_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE part_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2254 (class 0 OID 0)
-- Dependencies: 181
-- Name: part_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE part_id_seq OWNED BY part.id;


--
-- TOC entry 194 (class 1259 OID 19351)
-- Name: part_tag; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE part_tag (
    part_fk integer NOT NULL,
    tag_fk integer NOT NULL
);


--
-- TOC entry 192 (class 1259 OID 19334)
-- Name: reserve; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reserve (
    id integer NOT NULL,
    part_fk integer NOT NULL,
    department_fk integer NOT NULL,
    amount numeric NOT NULL,
    date date NOT NULL,
    note character varying(200),
    status character varying(10) NOT NULL
);


--
-- TOC entry 191 (class 1259 OID 19332)
-- Name: reserve_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE reserve_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2255 (class 0 OID 0)
-- Dependencies: 191
-- Name: reserve_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE reserve_id_seq OWNED BY reserve.id;


--
-- TOC entry 200 (class 1259 OID 19449)
-- Name: reserve_order; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reserve_order (
    id integer NOT NULL,
    stock_department_fk integer NOT NULL,
    date date NOT NULL,
    author integer NOT NULL,
    comment character varying(300) NOT NULL,
    status integer NOT NULL
);


--
-- TOC entry 199 (class 1259 OID 19447)
-- Name: reserve_order_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE reserve_order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2256 (class 0 OID 0)
-- Dependencies: 199
-- Name: reserve_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE reserve_order_id_seq OWNED BY reserve_order.id;


--
-- TOC entry 202 (class 1259 OID 19458)
-- Name: reserve_part; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE reserve_part (
    reserve_fk integer NOT NULL,
    part_fk integer NOT NULL,
    quantity bigint NOT NULL
);


--
-- TOC entry 188 (class 1259 OID 19313)
-- Name: tag; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE tag (
    id integer NOT NULL,
    tag_name character varying(20) NOT NULL
);


--
-- TOC entry 187 (class 1259 OID 19311)
-- Name: tag_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE tag_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2257 (class 0 OID 0)
-- Dependencies: 187
-- Name: tag_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE tag_id_seq OWNED BY tag.id;


--
-- TOC entry 190 (class 1259 OID 19323)
-- Name: transfer; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE transfer (
    id integer NOT NULL,
    part_fk integer NOT NULL,
    new_department_fk integer NOT NULL,
    prev_department_fk integer NOT NULL,
    amount numeric NOT NULL,
    date date NOT NULL,
    note character varying(200),
    status character varying(10) NOT NULL
);


--
-- TOC entry 189 (class 1259 OID 19321)
-- Name: transfer_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE transfer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2258 (class 0 OID 0)
-- Dependencies: 189
-- Name: transfer_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE transfer_id_seq OWNED BY transfer.id;


--
-- TOC entry 198 (class 1259 OID 19441)
-- Name: transfer_order; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE transfer_order (
    id integer NOT NULL,
    target_department_fk integer NOT NULL,
    stock_department_fk integer NOT NULL,
    date date NOT NULL,
    author integer NOT NULL,
    approver integer NOT NULL,
    approve_date date NOT NULL,
    complete_date date NOT NULL,
    comment character varying(300),
    status integer NOT NULL
);


--
-- TOC entry 197 (class 1259 OID 19439)
-- Name: transfer_order_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE transfer_order_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2259 (class 0 OID 0)
-- Dependencies: 197
-- Name: transfer_order_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE transfer_order_id_seq OWNED BY transfer_order.id;


--
-- TOC entry 201 (class 1259 OID 19455)
-- Name: transfer_part; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE transfer_part (
    transfer_fk integer NOT NULL,
    part_fk integer NOT NULL,
    quantity bigint NOT NULL
);


--
-- TOC entry 184 (class 1259 OID 19276)
-- Name: unit; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE unit (
    id integer NOT NULL,
    name character varying(4) NOT NULL
);


--
-- TOC entry 183 (class 1259 OID 19274)
-- Name: unit_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE unit_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2260 (class 0 OID 0)
-- Dependencies: 183
-- Name: unit_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE unit_id_seq OWNED BY unit.id;


--
-- TOC entry 196 (class 1259 OID 19414)
-- Name: user_profile; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE user_profile (
    id integer NOT NULL,
    email character varying(80) NOT NULL,
    password character varying(80) NOT NULL,
    department_fk integer NOT NULL,
    first_name character varying(20) NOT NULL,
    last_name character varying(20) NOT NULL,
    role integer NOT NULL,
    log_in date NOT NULL
);


--
-- TOC entry 195 (class 1259 OID 19412)
-- Name: user_profile_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE user_profile_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2261 (class 0 OID 0)
-- Dependencies: 195
-- Name: user_profile_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE user_profile_id_seq OWNED BY user_profile.id;


--
-- TOC entry 2052 (class 2604 OID 19303)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY department ALTER COLUMN id SET DEFAULT nextval('department_id_seq'::regclass);


--
-- TOC entry 2050 (class 2604 OID 19268)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY part ALTER COLUMN id SET DEFAULT nextval('part_id_seq'::regclass);


--
-- TOC entry 2055 (class 2604 OID 19337)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY reserve ALTER COLUMN id SET DEFAULT nextval('reserve_id_seq'::regclass);


--
-- TOC entry 2058 (class 2604 OID 19452)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY reserve_order ALTER COLUMN id SET DEFAULT nextval('reserve_order_id_seq'::regclass);


--
-- TOC entry 2053 (class 2604 OID 19316)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY tag ALTER COLUMN id SET DEFAULT nextval('tag_id_seq'::regclass);


--
-- TOC entry 2054 (class 2604 OID 19326)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer ALTER COLUMN id SET DEFAULT nextval('transfer_id_seq'::regclass);


--
-- TOC entry 2057 (class 2604 OID 19444)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer_order ALTER COLUMN id SET DEFAULT nextval('transfer_order_id_seq'::regclass);


--
-- TOC entry 2051 (class 2604 OID 19279)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY unit ALTER COLUMN id SET DEFAULT nextval('unit_id_seq'::regclass);


--
-- TOC entry 2056 (class 2604 OID 19417)
-- Name: id; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY user_profile ALTER COLUMN id SET DEFAULT nextval('user_profile_id_seq'::regclass);


--
-- TOC entry 2229 (class 0 OID 19300)
-- Dependencies: 186
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO department (id, name) VALUES (3, 'Concrete Manufacturing');
INSERT INTO department (id, name) VALUES (1, 'Metal Manufacturing');
INSERT INTO department (id, name) VALUES (2, 'Plastics Manufacturing');
INSERT INTO department (id, name) VALUES (4, 'Service Department');
INSERT INTO department (id, name) VALUES (5, 'Assembly Shop');


--
-- TOC entry 2262 (class 0 OID 0)
-- Dependencies: 185
-- Name: department_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('department_id_seq', 1, false);


--
-- TOC entry 2236 (class 0 OID 19343)
-- Dependencies: 193
-- Data for Name: department_part; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO department_part (part_fk, department_fk, quantity, date_change) VALUES (1, 1, 100, '2003-03-03');
INSERT INTO department_part (part_fk, department_fk, quantity, date_change) VALUES (2, 1, 110, '2003-04-05');
INSERT INTO department_part (part_fk, department_fk, quantity, date_change) VALUES (3, 2, 120, '2005-05-05');
INSERT INTO department_part (part_fk, department_fk, quantity, date_change) VALUES (4, 2, 130, '2003-03-03');
INSERT INTO department_part (part_fk, department_fk, quantity, date_change) VALUES (5, 3, 140, '2002-03-06');
INSERT INTO department_part (part_fk, department_fk, quantity, date_change) VALUES (6, 3, 150, '2009-09-09');
INSERT INTO department_part (part_fk, department_fk, quantity, date_change) VALUES (7, 4, 160, '2009-09-09');
INSERT INTO department_part (part_fk, department_fk, quantity, date_change) VALUES (8, 4, 170, '2005-09-10');
INSERT INTO department_part (part_fk, department_fk, quantity, date_change) VALUES (9, 5, 180, '2020-02-10');


--
-- TOC entry 2225 (class 0 OID 19265)
-- Dependencies: 182
-- Data for Name: part; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO part (id, specification, unit_fk, tag, note) VALUES (1, 'Лист Ст3, р-р 1200х6000 мм', 2, 1, NULL);
INSERT INTO part (id, specification, unit_fk, tag, note) VALUES (7, 'Труба нерж.', 7, NULL, NULL);
INSERT INTO part (id, specification, unit_fk, tag, note) VALUES (6, 'Шебень мелкой фракции', 3, NULL, NULL);
INSERT INTO part (id, specification, unit_fk, tag, note) VALUES (5, 'Арматура 8, L=9 м', 3, NULL, NULL);
INSERT INTO part (id, specification, unit_fk, tag, note) VALUES (4, 'Картон упаковочный', 6, NULL, NULL);
INSERT INTO part (id, specification, unit_fk, tag, note) VALUES (3, 'Полиэтилен, гранулят', 3, NULL, NULL);
INSERT INTO part (id, specification, unit_fk, tag, note) VALUES (2, 'Гайка М12 по DIN985', 4, NULL, NULL);
INSERT INTO part (id, specification, unit_fk, tag, note) VALUES (8, 'Датчики', 4, NULL, NULL);
INSERT INTO part (id, specification, unit_fk, tag, note) VALUES (9, 'Набор инструментов', 4, NULL, NULL);


--
-- TOC entry 2263 (class 0 OID 0)
-- Dependencies: 181
-- Name: part_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('part_id_seq', 2, true);


--
-- TOC entry 2237 (class 0 OID 19351)
-- Dependencies: 194
-- Data for Name: part_tag; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO part_tag (part_fk, tag_fk) VALUES (1, 1);
INSERT INTO part_tag (part_fk, tag_fk) VALUES (1, 2);


--
-- TOC entry 2235 (class 0 OID 19334)
-- Dependencies: 192
-- Data for Name: reserve; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 2264 (class 0 OID 0)
-- Dependencies: 191
-- Name: reserve_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('reserve_id_seq', 1, false);


--
-- TOC entry 2243 (class 0 OID 19449)
-- Dependencies: 200
-- Data for Name: reserve_order; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 2265 (class 0 OID 0)
-- Dependencies: 199
-- Name: reserve_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('reserve_order_id_seq', 1, false);


--
-- TOC entry 2245 (class 0 OID 19458)
-- Dependencies: 202
-- Data for Name: reserve_part; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 2231 (class 0 OID 19313)
-- Dependencies: 188
-- Data for Name: tag; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO tag (id, tag_name) VALUES (1, 'Лист');
INSERT INTO tag (id, tag_name) VALUES (2, 'Сталь');


--
-- TOC entry 2266 (class 0 OID 0)
-- Dependencies: 187
-- Name: tag_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('tag_id_seq', 1, false);


--
-- TOC entry 2233 (class 0 OID 19323)
-- Dependencies: 190
-- Data for Name: transfer; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 2267 (class 0 OID 0)
-- Dependencies: 189
-- Name: transfer_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('transfer_id_seq', 1, false);


--
-- TOC entry 2241 (class 0 OID 19441)
-- Dependencies: 198
-- Data for Name: transfer_order; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 2268 (class 0 OID 0)
-- Dependencies: 197
-- Name: transfer_order_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('transfer_order_id_seq', 1, false);


--
-- TOC entry 2244 (class 0 OID 19455)
-- Dependencies: 201
-- Data for Name: transfer_part; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 2227 (class 0 OID 19276)
-- Dependencies: 184
-- Data for Name: unit; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO unit (id, name) VALUES (1, 'г');
INSERT INTO unit (id, name) VALUES (2, 'кг');
INSERT INTO unit (id, name) VALUES (3, 'т');
INSERT INTO unit (id, name) VALUES (4, 'шт');
INSERT INTO unit (id, name) VALUES (5, 'л');
INSERT INTO unit (id, name) VALUES (6, 'уп');
INSERT INTO unit (id, name) VALUES (7, 'м');
INSERT INTO unit (id, name) VALUES (8, 'км');


--
-- TOC entry 2269 (class 0 OID 0)
-- Dependencies: 183
-- Name: unit_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('unit_id_seq', 1, false);


--
-- TOC entry 2239 (class 0 OID 19414)
-- Dependencies: 196
-- Data for Name: user_profile; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO user_profile (id, email, password, department_fk, first_name, last_name, role, log_in) VALUES (3, 'test3@gmail.com', 'test', 1, 'First3', 'Last3', 1, '2001-01-01');
INSERT INTO user_profile (id, email, password, department_fk, first_name, last_name, role, log_in) VALUES (2, 'test2@gmail.com', 'test', 1, 'First2', 'Last2', 1, '2001-01-01');
INSERT INTO user_profile (id, email, password, department_fk, first_name, last_name, role, log_in) VALUES (4, 'test4@gmail.com', 'test', 1, 'First4', 'Last4', 1, '2001-01-01');
INSERT INTO user_profile (id, email, password, department_fk, first_name, last_name, role, log_in) VALUES (5, 'test5@gmail.com', 'test', 1, 'First5', 'Last5', 1, '2001-01-01');
INSERT INTO user_profile (id, email, password, department_fk, first_name, last_name, role, log_in) VALUES (1, 'test1@gmail.com', 'test', 1, 'First1', 'Last1', 0, '2001-01-01');


--
-- TOC entry 2270 (class 0 OID 0)
-- Dependencies: 195
-- Name: user_profile_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('user_profile_id_seq', 1, false);


--
-- TOC entry 2066 (class 2606 OID 19310)
-- Name: department_name_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_name_key UNIQUE (name);


--
-- TOC entry 2078 (class 2606 OID 19350)
-- Name: department_part_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY department_part
    ADD CONSTRAINT department_part_pk PRIMARY KEY (part_fk, department_fk);


--
-- TOC entry 2068 (class 2606 OID 19308)
-- Name: department_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY department
    ADD CONSTRAINT department_pk PRIMARY KEY (id);


--
-- TOC entry 2060 (class 2606 OID 19273)
-- Name: part_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY part
    ADD CONSTRAINT part_pk PRIMARY KEY (id);


--
-- TOC entry 2080 (class 2606 OID 19355)
-- Name: part_tag_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY part_tag
    ADD CONSTRAINT part_tag_pk PRIMARY KEY (part_fk, tag_fk);


--
-- TOC entry 2088 (class 2606 OID 19454)
-- Name: reserve_order_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reserve_order
    ADD CONSTRAINT reserve_order_pk PRIMARY KEY (id);


--
-- TOC entry 2076 (class 2606 OID 19342)
-- Name: reserve_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reserve
    ADD CONSTRAINT reserve_pk PRIMARY KEY (id);


--
-- TOC entry 2070 (class 2606 OID 19318)
-- Name: tag_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tag
    ADD CONSTRAINT tag_pk PRIMARY KEY (id);


--
-- TOC entry 2072 (class 2606 OID 19320)
-- Name: tag_tag_name_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY tag
    ADD CONSTRAINT tag_tag_name_key UNIQUE (tag_name);


--
-- TOC entry 2086 (class 2606 OID 19446)
-- Name: transfer_order_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer_order
    ADD CONSTRAINT transfer_order_pk PRIMARY KEY (id);


--
-- TOC entry 2074 (class 2606 OID 19331)
-- Name: transfer_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer
    ADD CONSTRAINT transfer_pk PRIMARY KEY (id);


--
-- TOC entry 2062 (class 2606 OID 19283)
-- Name: unit_name_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY unit
    ADD CONSTRAINT unit_name_key UNIQUE (name);


--
-- TOC entry 2064 (class 2606 OID 19281)
-- Name: unit_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY unit
    ADD CONSTRAINT unit_pk PRIMARY KEY (id);


--
-- TOC entry 2082 (class 2606 OID 19421)
-- Name: user_profile_email_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY user_profile
    ADD CONSTRAINT user_profile_email_key UNIQUE (email);


--
-- TOC entry 2084 (class 2606 OID 19419)
-- Name: user_profile_pk; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY user_profile
    ADD CONSTRAINT user_profile_pk PRIMARY KEY (id);


--
-- TOC entry 2095 (class 2606 OID 19391)
-- Name: department_part_fk0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY department_part
    ADD CONSTRAINT department_part_fk0 FOREIGN KEY (part_fk) REFERENCES part(id);


--
-- TOC entry 2096 (class 2606 OID 19396)
-- Name: department_part_fk1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY department_part
    ADD CONSTRAINT department_part_fk1 FOREIGN KEY (department_fk) REFERENCES department(id);


--
-- TOC entry 2089 (class 2606 OID 19356)
-- Name: part_fk0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY part
    ADD CONSTRAINT part_fk0 FOREIGN KEY (unit_fk) REFERENCES unit(id);


--
-- TOC entry 2097 (class 2606 OID 19401)
-- Name: part_tag_fk0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY part_tag
    ADD CONSTRAINT part_tag_fk0 FOREIGN KEY (part_fk) REFERENCES part(id);


--
-- TOC entry 2098 (class 2606 OID 19406)
-- Name: part_tag_fk1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY part_tag
    ADD CONSTRAINT part_tag_fk1 FOREIGN KEY (tag_fk) REFERENCES tag(id);


--
-- TOC entry 2093 (class 2606 OID 19381)
-- Name: reserve_fk0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reserve
    ADD CONSTRAINT reserve_fk0 FOREIGN KEY (part_fk) REFERENCES part(id);


--
-- TOC entry 2094 (class 2606 OID 19386)
-- Name: reserve_fk1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reserve
    ADD CONSTRAINT reserve_fk1 FOREIGN KEY (department_fk) REFERENCES department(id);


--
-- TOC entry 2104 (class 2606 OID 19481)
-- Name: reserve_order_fk0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reserve_order
    ADD CONSTRAINT reserve_order_fk0 FOREIGN KEY (stock_department_fk) REFERENCES department(id);


--
-- TOC entry 2105 (class 2606 OID 19486)
-- Name: reserve_order_fk1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reserve_order
    ADD CONSTRAINT reserve_order_fk1 FOREIGN KEY (author) REFERENCES user_profile(id);


--
-- TOC entry 2108 (class 2606 OID 19501)
-- Name: reserve_part_fk0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reserve_part
    ADD CONSTRAINT reserve_part_fk0 FOREIGN KEY (reserve_fk) REFERENCES reserve_order(id);


--
-- TOC entry 2109 (class 2606 OID 19506)
-- Name: reserve_part_fk1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY reserve_part
    ADD CONSTRAINT reserve_part_fk1 FOREIGN KEY (part_fk) REFERENCES part(id);


--
-- TOC entry 2090 (class 2606 OID 19366)
-- Name: transfer_fk0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer
    ADD CONSTRAINT transfer_fk0 FOREIGN KEY (part_fk) REFERENCES part(id);


--
-- TOC entry 2091 (class 2606 OID 19371)
-- Name: transfer_fk1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer
    ADD CONSTRAINT transfer_fk1 FOREIGN KEY (new_department_fk) REFERENCES department(id);


--
-- TOC entry 2092 (class 2606 OID 19376)
-- Name: transfer_fk2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer
    ADD CONSTRAINT transfer_fk2 FOREIGN KEY (prev_department_fk) REFERENCES department(id);


--
-- TOC entry 2100 (class 2606 OID 19461)
-- Name: transfer_order_fk0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer_order
    ADD CONSTRAINT transfer_order_fk0 FOREIGN KEY (target_department_fk) REFERENCES department(id);


--
-- TOC entry 2101 (class 2606 OID 19466)
-- Name: transfer_order_fk1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer_order
    ADD CONSTRAINT transfer_order_fk1 FOREIGN KEY (stock_department_fk) REFERENCES department(id);


--
-- TOC entry 2102 (class 2606 OID 19471)
-- Name: transfer_order_fk2; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer_order
    ADD CONSTRAINT transfer_order_fk2 FOREIGN KEY (author) REFERENCES user_profile(id);


--
-- TOC entry 2103 (class 2606 OID 19476)
-- Name: transfer_order_fk3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer_order
    ADD CONSTRAINT transfer_order_fk3 FOREIGN KEY (approver) REFERENCES user_profile(id);


--
-- TOC entry 2106 (class 2606 OID 19491)
-- Name: transfer_part_fk0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer_part
    ADD CONSTRAINT transfer_part_fk0 FOREIGN KEY (transfer_fk) REFERENCES transfer_order(id);


--
-- TOC entry 2107 (class 2606 OID 19496)
-- Name: transfer_part_fk1; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY transfer_part
    ADD CONSTRAINT transfer_part_fk1 FOREIGN KEY (part_fk) REFERENCES part(id);


--
-- TOC entry 2099 (class 2606 OID 19422)
-- Name: user_profile_fk0; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY user_profile
    ADD CONSTRAINT user_profile_fk0 FOREIGN KEY (department_fk) REFERENCES department(id);


-- Completed on 2016-05-31 00:14:42

--
-- PostgreSQL database dump complete
--

