PGDMP         5                  z            quan_ly_nhan_khau    14.1    14.1 s    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    16394    quan_ly_nhan_khau    DATABASE     u   CREATE DATABASE quan_ly_nhan_khau WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
 !   DROP DATABASE quan_ly_nhan_khau;
                postgres    false            ?            1259    16395    chung_minh_thu    TABLE     ?   CREATE TABLE public.chung_minh_thu (
    id integer NOT NULL,
    idnhankhau integer,
    socmt character varying(12) NOT NULL,
    ngaycap date,
    noicap character varying(100)
);
 "   DROP TABLE public.chung_minh_thu;
       public         heap    postgres    false            ?            1259    16674    deleteditem    TABLE     ?   CREATE TABLE public.deleteditem (
    delete_id integer NOT NULL,
    item_id integer NOT NULL,
    date integer NOT NULL,
    reason character varying(255) NOT NULL,
    item_number integer NOT NULL
);
    DROP TABLE public.deleteditem;
       public         heap    postgres    false            ?            1259    16673    deleteditem_date_delete_seq    SEQUENCE     ?   CREATE SEQUENCE public.deleteditem_date_delete_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.deleteditem_date_delete_seq;
       public          postgres    false    229            ?           0    0    deleteditem_date_delete_seq    SEQUENCE OWNED BY     T   ALTER SEQUENCE public.deleteditem_date_delete_seq OWNED BY public.deleteditem.date;
          public          postgres    false    228            ?            1259    16671    deleteditem_delete_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.deleteditem_delete_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.deleteditem_delete_id_seq;
       public          postgres    false    229            ?           0    0    deleteditem_delete_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.deleteditem_delete_id_seq OWNED BY public.deleteditem.delete_id;
          public          postgres    false    226            ?            1259    16672    deleteditem_item_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.deleteditem_item_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.deleteditem_item_id_seq;
       public          postgres    false    229            ?           0    0    deleteditem_item_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.deleteditem_item_id_seq OWNED BY public.deleteditem.item_id;
          public          postgres    false    227            ?            1259    16398 
   dinh_chinh    TABLE     ?   CREATE TABLE public.dinh_chinh (
    id integer NOT NULL,
    idhokhau integer,
    thongtinthaydoi character varying(100),
    thaydoitu character varying(100),
    thaydoithanh character varying(100),
    ngaythaydoi date,
    nguoithaydoi integer
);
    DROP TABLE public.dinh_chinh;
       public         heap    postgres    false            ?            1259    16401    gia_dinh    TABLE     *  CREATE TABLE public.gia_dinh (
    id integer NOT NULL,
    idnhankhau integer,
    hoten character varying(100),
    namsinh date,
    gioitinh character varying(100),
    quanhevoinhankhau character varying(100),
    nghenghiep character varying(100),
    diachihientai character varying(100)
);
    DROP TABLE public.gia_dinh;
       public         heap    postgres    false            ?            1259    16406    ho_khau    TABLE       CREATE TABLE public.ho_khau (
    id integer NOT NULL,
    mahokhau character varying(100),
    idchuho integer,
    makhuvuc character varying(100),
    diachi character varying(100),
    ngaylap date,
    ngaychuyendi date,
    lydochuyen text,
    nguoithuchien integer
);
    DROP TABLE public.ho_khau;
       public         heap    postgres    false            ?            1259    16666    infraregistered    TABLE     ?   CREATE TABLE public.infraregistered (
    infra_id integer NOT NULL,
    user_id integer NOT NULL,
    event_no integer NOT NULL
);
 #   DROP TABLE public.infraregistered;
       public         heap    postgres    false            ?            1259    16659    infrastructure    TABLE     ?   CREATE TABLE public.infrastructure (
    infra_id integer NOT NULL,
    infra_name character varying(255) NOT NULL,
    reason character varying(255)
);
 "   DROP TABLE public.infrastructure;
       public         heap    postgres    false            ?            1259    16757    infrastructure_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.infrastructure_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.infrastructure_id_seq;
       public          postgres    false    224            ?           0    0    infrastructure_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.infrastructure_id_seq OWNED BY public.infrastructure.infra_id;
          public          postgres    false    232            ?            1259    16640    item    TABLE     ?   CREATE TABLE public.item (
    item_id integer NOT NULL,
    item_name character varying(255) NOT NULL,
    item_quantity integer NOT NULL
);
    DROP TABLE public.item;
       public         heap    postgres    false            ?            1259    16759    item_id_seq    SEQUENCE     t   CREATE SEQUENCE public.item_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.item_id_seq;
       public          postgres    false    221            ?           0    0    item_id_seq    SEQUENCE OWNED BY     @   ALTER SEQUENCE public.item_id_seq OWNED BY public.item.item_id;
          public          postgres    false    233            ?            1259    16647    itemregistered    TABLE     ?   CREATE TABLE public.itemregistered (
    item_id integer NOT NULL,
    user_id integer NOT NULL,
    event_no integer NOT NULL,
    item_number integer NOT NULL
);
 "   DROP TABLE public.itemregistered;
       public         heap    postgres    false            ?            1259    16411    khai_tu    TABLE     ?   CREATE TABLE public.khai_tu (
    id integer NOT NULL,
    sogiaykhaitu character varying(100),
    idnguoikhai integer,
    idnguoichet integer,
    ngaykhai date,
    ngaychet date,
    lydochet character varying(100)
);
    DROP TABLE public.khai_tu;
       public         heap    postgres    false            ?            1259    16683    money    TABLE     ?   CREATE TABLE public.money (
    money_id integer NOT NULL,
    item_id integer NOT NULL,
    item_number integer NOT NULL,
    date date NOT NULL,
    reason character varying(255)
);
    DROP TABLE public.money;
       public         heap    postgres    false            ?            1259    16682    money_money_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.money_money_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.money_money_id_seq;
       public          postgres    false    231            ?           0    0    money_money_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.money_money_id_seq OWNED BY public.money.money_id;
          public          postgres    false    230            ?            1259    16414 	   nhan_khau    TABLE     s  CREATE TABLE public.nhan_khau (
    id integer NOT NULL,
    manhankhau character varying(100),
    hoten character varying(100),
    bietdanh character varying(100),
    namsinh date,
    gioitinh character varying(100),
    noisinh character varying(100),
    nguyenquan character varying(100),
    dantoc character varying(100),
    tongiao character varying(100),
    quoctich character varying(100),
    sohochieu character varying(100),
    noithuongtru character varying(100),
    diachihiennay character varying(100),
    trinhdohocvan character varying(100),
    trinhdochuyenmon character varying(100),
    biettiengdantoc character varying(100),
    trinhdongoaingu character varying(100),
    nghenghiep character varying(100),
    noilamviec character varying(100),
    tienan character varying(100),
    ngaychuyenden date,
    lydochuyenden character varying(100),
    ngaychuyendi date,
    lydochuyendi character varying(100),
    diachimoi character varying(100),
    ngaytao date,
    idnguoitao integer,
    ngayxoa date,
    idnguoixoa integer,
    lydoxoa character varying(100),
    ghichu character varying(100)
);
    DROP TABLE public.nhan_khau;
       public         heap    postgres    false            ?            1259    16652 	   registers    TABLE       CREATE TABLE public.registers (
    user_id integer NOT NULL,
    user_name character varying(255) NOT NULL,
    user_address character varying(255) NOT NULL,
    user_phone character varying(255) NOT NULL,
    fee_register integer NOT NULL,
    cccd character varying(255) NOT NULL
);
    DROP TABLE public.registers;
       public         heap    postgres    false            ?            1259    16762    registers_id_seq    SEQUENCE     y   CREATE SEQUENCE public.registers_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.registers_id_seq;
       public          postgres    false    223            ?           0    0    registers_id_seq    SEQUENCE OWNED BY     J   ALTER SEQUENCE public.registers_id_seq OWNED BY public.registers.user_id;
          public          postgres    false    234            ?            1259    16635    schedule    TABLE     ?   CREATE TABLE public.schedule (
    event_no integer NOT NULL,
    time_start timestamp with time zone NOT NULL,
    time_end timestamp with time zone NOT NULL,
    real_time_end timestamp with time zone
);
    DROP TABLE public.schedule;
       public         heap    postgres    false            ?            1259    16764    schedule_id_seq    SEQUENCE     x   CREATE SEQUENCE public.schedule_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.schedule_id_seq;
       public          postgres    false    220            ?           0    0    schedule_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.schedule_id_seq OWNED BY public.schedule.event_no;
          public          postgres    false    235            ?            1259    16419    tam_tru    TABLE     ?   CREATE TABLE public.tam_tru (
    id integer NOT NULL,
    idnhankhau integer,
    magiaytamtru character varying(100),
    sodienthoainguoidangky character varying(100),
    tungay date NOT NULL,
    denngay date NOT NULL,
    lydo text NOT NULL
);
    DROP TABLE public.tam_tru;
       public         heap    postgres    false            ?            1259    16424    tam_vang    TABLE     ?   CREATE TABLE public.tam_vang (
    id integer NOT NULL,
    idnhankhau integer,
    magiaytamvang character varying(100),
    noitamtru character varying(100),
    tungay date,
    denngay date,
    lydo character varying(100)
);
    DROP TABLE public.tam_vang;
       public         heap    postgres    false            ?            1259    16427    thanh_vien_cua_ho    TABLE     ?   CREATE TABLE public.thanh_vien_cua_ho (
    idnhankhau integer NOT NULL,
    idhokhau integer NOT NULL,
    quanhevoichuho character varying(100)
);
 %   DROP TABLE public.thanh_vien_cua_ho;
       public         heap    postgres    false            ?            1259    16430    tieu_su    TABLE     ?   CREATE TABLE public.tieu_su (
    id integer NOT NULL,
    idnhankhau integer,
    tungay date,
    denngay date,
    diachi character varying(100),
    nghenghiep character varying(100),
    noilamviec character varying(100)
);
    DROP TABLE public.tieu_su;
       public         heap    postgres    false            ?            1259    16433    users    TABLE        CREATE TABLE public.users (
    id integer NOT NULL,
    username character varying(100),
    passwd character varying(100)
);
    DROP TABLE public.users;
       public         heap    postgres    false            ?           2604    16677    deleteditem delete_id    DEFAULT     ~   ALTER TABLE ONLY public.deleteditem ALTER COLUMN delete_id SET DEFAULT nextval('public.deleteditem_delete_id_seq'::regclass);
 D   ALTER TABLE public.deleteditem ALTER COLUMN delete_id DROP DEFAULT;
       public          postgres    false    226    229    229            ?           2604    16678    deleteditem item_id    DEFAULT     z   ALTER TABLE ONLY public.deleteditem ALTER COLUMN item_id SET DEFAULT nextval('public.deleteditem_item_id_seq'::regclass);
 B   ALTER TABLE public.deleteditem ALTER COLUMN item_id DROP DEFAULT;
       public          postgres    false    227    229    229            ?           2604    16679    deleteditem date    DEFAULT     {   ALTER TABLE ONLY public.deleteditem ALTER COLUMN date SET DEFAULT nextval('public.deleteditem_date_delete_seq'::regclass);
 ?   ALTER TABLE public.deleteditem ALTER COLUMN date DROP DEFAULT;
       public          postgres    false    229    228    229            ?           2604    16758    infrastructure infra_id    DEFAULT     |   ALTER TABLE ONLY public.infrastructure ALTER COLUMN infra_id SET DEFAULT nextval('public.infrastructure_id_seq'::regclass);
 F   ALTER TABLE public.infrastructure ALTER COLUMN infra_id DROP DEFAULT;
       public          postgres    false    232    224            ?           2604    16760    item item_id    DEFAULT     g   ALTER TABLE ONLY public.item ALTER COLUMN item_id SET DEFAULT nextval('public.item_id_seq'::regclass);
 ;   ALTER TABLE public.item ALTER COLUMN item_id DROP DEFAULT;
       public          postgres    false    233    221            ?           2604    16686    money money_id    DEFAULT     p   ALTER TABLE ONLY public.money ALTER COLUMN money_id SET DEFAULT nextval('public.money_money_id_seq'::regclass);
 =   ALTER TABLE public.money ALTER COLUMN money_id DROP DEFAULT;
       public          postgres    false    231    230    231            ?           2604    16763    registers user_id    DEFAULT     q   ALTER TABLE ONLY public.registers ALTER COLUMN user_id SET DEFAULT nextval('public.registers_id_seq'::regclass);
 @   ALTER TABLE public.registers ALTER COLUMN user_id DROP DEFAULT;
       public          postgres    false    234    223            ?           2604    16765    schedule event_no    DEFAULT     p   ALTER TABLE ONLY public.schedule ALTER COLUMN event_no SET DEFAULT nextval('public.schedule_id_seq'::regclass);
 @   ALTER TABLE public.schedule ALTER COLUMN event_no DROP DEFAULT;
       public          postgres    false    235    220            z          0    16395    chung_minh_thu 
   TABLE DATA           P   COPY public.chung_minh_thu (id, idnhankhau, socmt, ngaycap, noicap) FROM stdin;
    public          postgres    false    209   r?       ?          0    16674    deleteditem 
   TABLE DATA           T   COPY public.deleteditem (delete_id, item_id, date, reason, item_number) FROM stdin;
    public          postgres    false    229   ??       {          0    16398 
   dinh_chinh 
   TABLE DATA           w   COPY public.dinh_chinh (id, idhokhau, thongtinthaydoi, thaydoitu, thaydoithanh, ngaythaydoi, nguoithaydoi) FROM stdin;
    public          postgres    false    210   	?       |          0    16401    gia_dinh 
   TABLE DATA           z   COPY public.gia_dinh (id, idnhankhau, hoten, namsinh, gioitinh, quanhevoinhankhau, nghenghiep, diachihientai) FROM stdin;
    public          postgres    false    211   &?       }          0    16406    ho_khau 
   TABLE DATA           |   COPY public.ho_khau (id, mahokhau, idchuho, makhuvuc, diachi, ngaylap, ngaychuyendi, lydochuyen, nguoithuchien) FROM stdin;
    public          postgres    false    212   @?       ?          0    16666    infraregistered 
   TABLE DATA           F   COPY public.infraregistered (infra_id, user_id, event_no) FROM stdin;
    public          postgres    false    225   ??       ?          0    16659    infrastructure 
   TABLE DATA           F   COPY public.infrastructure (infra_id, infra_name, reason) FROM stdin;
    public          postgres    false    224   ?       ?          0    16640    item 
   TABLE DATA           A   COPY public.item (item_id, item_name, item_quantity) FROM stdin;
    public          postgres    false    221   Е       ?          0    16647    itemregistered 
   TABLE DATA           Q   COPY public.itemregistered (item_id, user_id, event_no, item_number) FROM stdin;
    public          postgres    false    222   {?       ~          0    16411    khai_tu 
   TABLE DATA           k   COPY public.khai_tu (id, sogiaykhaitu, idnguoikhai, idnguoichet, ngaykhai, ngaychet, lydochet) FROM stdin;
    public          postgres    false    213   ??       ?          0    16683    money 
   TABLE DATA           M   COPY public.money (money_id, item_id, item_number, date, reason) FROM stdin;
    public          postgres    false    231   ̖                 0    16414 	   nhan_khau 
   TABLE DATA           ?  COPY public.nhan_khau (id, manhankhau, hoten, bietdanh, namsinh, gioitinh, noisinh, nguyenquan, dantoc, tongiao, quoctich, sohochieu, noithuongtru, diachihiennay, trinhdohocvan, trinhdochuyenmon, biettiengdantoc, trinhdongoaingu, nghenghiep, noilamviec, tienan, ngaychuyenden, lydochuyenden, ngaychuyendi, lydochuyendi, diachimoi, ngaytao, idnguoitao, ngayxoa, idnguoixoa, lydoxoa, ghichu) FROM stdin;
    public          postgres    false    214   b?       ?          0    16652 	   registers 
   TABLE DATA           e   COPY public.registers (user_id, user_name, user_address, user_phone, fee_register, cccd) FROM stdin;
    public          postgres    false    223   ߚ       ?          0    16635    schedule 
   TABLE DATA           Q   COPY public.schedule (event_no, time_start, time_end, real_time_end) FROM stdin;
    public          postgres    false    220   ??       ?          0    16419    tam_tru 
   TABLE DATA           n   COPY public.tam_tru (id, idnhankhau, magiaytamtru, sodienthoainguoidangky, tungay, denngay, lydo) FROM stdin;
    public          postgres    false    215   ?       ?          0    16424    tam_vang 
   TABLE DATA           c   COPY public.tam_vang (id, idnhankhau, magiaytamvang, noitamtru, tungay, denngay, lydo) FROM stdin;
    public          postgres    false    216   $?       ?          0    16427    thanh_vien_cua_ho 
   TABLE DATA           Q   COPY public.thanh_vien_cua_ho (idnhankhau, idhokhau, quanhevoichuho) FROM stdin;
    public          postgres    false    217   A?       ?          0    16430    tieu_su 
   TABLE DATA           b   COPY public.tieu_su (id, idnhankhau, tungay, denngay, diachi, nghenghiep, noilamviec) FROM stdin;
    public          postgres    false    218   ??       ?          0    16433    users 
   TABLE DATA           5   COPY public.users (id, username, passwd) FROM stdin;
    public          postgres    false    219   ??       ?           0    0    deleteditem_date_delete_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.deleteditem_date_delete_seq', 1, false);
          public          postgres    false    228            ?           0    0    deleteditem_delete_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.deleteditem_delete_id_seq', 1, false);
          public          postgres    false    226            ?           0    0    deleteditem_item_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.deleteditem_item_id_seq', 1, false);
          public          postgres    false    227            ?           0    0    infrastructure_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.infrastructure_id_seq', 10, true);
          public          postgres    false    232            ?           0    0    item_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.item_id_seq', 9, true);
          public          postgres    false    233            ?           0    0    money_money_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.money_money_id_seq', 9, true);
          public          postgres    false    230            ?           0    0    registers_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.registers_id_seq', 4, true);
          public          postgres    false    234            ?           0    0    schedule_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.schedule_id_seq', 5, true);
          public          postgres    false    235            ?           2606    16437 "   chung_minh_thu chung_minh_thu_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY public.chung_minh_thu
    ADD CONSTRAINT chung_minh_thu_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.chung_minh_thu DROP CONSTRAINT chung_minh_thu_pkey;
       public            postgres    false    209            ?           2606    16681    deleteditem deleteditem_pk 
   CONSTRAINT     _   ALTER TABLE ONLY public.deleteditem
    ADD CONSTRAINT deleteditem_pk PRIMARY KEY (delete_id);
 D   ALTER TABLE ONLY public.deleteditem DROP CONSTRAINT deleteditem_pk;
       public            postgres    false    229            ?           2606    16439    dinh_chinh dinh_chinh_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.dinh_chinh
    ADD CONSTRAINT dinh_chinh_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.dinh_chinh DROP CONSTRAINT dinh_chinh_pkey;
       public            postgres    false    210            ?           2606    16441    gia_dinh gia_dinh_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.gia_dinh
    ADD CONSTRAINT gia_dinh_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.gia_dinh DROP CONSTRAINT gia_dinh_pkey;
       public            postgres    false    211            ?           2606    16443    ho_khau ho_khau_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.ho_khau
    ADD CONSTRAINT ho_khau_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.ho_khau DROP CONSTRAINT ho_khau_pkey;
       public            postgres    false    212            ?           2606    16670 "   infraregistered infraregistered_pk 
   CONSTRAINT     y   ALTER TABLE ONLY public.infraregistered
    ADD CONSTRAINT infraregistered_pk PRIMARY KEY (infra_id, user_id, event_no);
 L   ALTER TABLE ONLY public.infraregistered DROP CONSTRAINT infraregistered_pk;
       public            postgres    false    225    225    225            ?           2606    16665     infrastructure infrastructure_pk 
   CONSTRAINT     d   ALTER TABLE ONLY public.infrastructure
    ADD CONSTRAINT infrastructure_pk PRIMARY KEY (infra_id);
 J   ALTER TABLE ONLY public.infrastructure DROP CONSTRAINT infrastructure_pk;
       public            postgres    false    224            ?           2606    16646    item item_pk 
   CONSTRAINT     O   ALTER TABLE ONLY public.item
    ADD CONSTRAINT item_pk PRIMARY KEY (item_id);
 6   ALTER TABLE ONLY public.item DROP CONSTRAINT item_pk;
       public            postgres    false    221            ?           2606    16651     itemregistered itemregistered_pk 
   CONSTRAINT     v   ALTER TABLE ONLY public.itemregistered
    ADD CONSTRAINT itemregistered_pk PRIMARY KEY (item_id, user_id, event_no);
 J   ALTER TABLE ONLY public.itemregistered DROP CONSTRAINT itemregistered_pk;
       public            postgres    false    222    222    222            ?           2606    16445    khai_tu khai_tu_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.khai_tu
    ADD CONSTRAINT khai_tu_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.khai_tu DROP CONSTRAINT khai_tu_pkey;
       public            postgres    false    213            ?           2606    16688    money money_pk 
   CONSTRAINT     R   ALTER TABLE ONLY public.money
    ADD CONSTRAINT money_pk PRIMARY KEY (money_id);
 8   ALTER TABLE ONLY public.money DROP CONSTRAINT money_pk;
       public            postgres    false    231            ?           2606    16447    nhan_khau nhan_khau_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.nhan_khau
    ADD CONSTRAINT nhan_khau_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.nhan_khau DROP CONSTRAINT nhan_khau_pkey;
       public            postgres    false    214            ?           2606    16658    registers registers_pk 
   CONSTRAINT     Y   ALTER TABLE ONLY public.registers
    ADD CONSTRAINT registers_pk PRIMARY KEY (user_id);
 @   ALTER TABLE ONLY public.registers DROP CONSTRAINT registers_pk;
       public            postgres    false    223            ?           2606    16639    schedule schedule_pk 
   CONSTRAINT     X   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pk PRIMARY KEY (event_no);
 >   ALTER TABLE ONLY public.schedule DROP CONSTRAINT schedule_pk;
       public            postgres    false    220            ?           2606    16449    tam_tru tam_tru_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.tam_tru
    ADD CONSTRAINT tam_tru_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.tam_tru DROP CONSTRAINT tam_tru_pkey;
       public            postgres    false    215            ?           2606    16451    tam_vang tam_vang_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.tam_vang
    ADD CONSTRAINT tam_vang_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.tam_vang DROP CONSTRAINT tam_vang_pkey;
       public            postgres    false    216            ?           2606    16453 (   thanh_vien_cua_ho thanh_vien_cua_ho_pkey 
   CONSTRAINT     x   ALTER TABLE ONLY public.thanh_vien_cua_ho
    ADD CONSTRAINT thanh_vien_cua_ho_pkey PRIMARY KEY (idnhankhau, idhokhau);
 R   ALTER TABLE ONLY public.thanh_vien_cua_ho DROP CONSTRAINT thanh_vien_cua_ho_pkey;
       public            postgres    false    217    217            ?           2606    16455    tieu_su tieu_su_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.tieu_su
    ADD CONSTRAINT tieu_su_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.tieu_su DROP CONSTRAINT tieu_su_pkey;
       public            postgres    false    218            ?           2606    16457    users users_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    219            ?           2606    16458 $   chung_minh_thu chung_minh_thu_ibfk_1    FK CONSTRAINT     ?   ALTER TABLE ONLY public.chung_minh_thu
    ADD CONSTRAINT chung_minh_thu_ibfk_1 FOREIGN KEY (idnhankhau) REFERENCES public.nhan_khau(id);
 N   ALTER TABLE ONLY public.chung_minh_thu DROP CONSTRAINT chung_minh_thu_ibfk_1;
       public          postgres    false    3262    209    214            ?           2606    16719    deleteditem deleteditem_fk0    FK CONSTRAINT     ~   ALTER TABLE ONLY public.deleteditem
    ADD CONSTRAINT deleteditem_fk0 FOREIGN KEY (item_id) REFERENCES public.item(item_id);
 E   ALTER TABLE ONLY public.deleteditem DROP CONSTRAINT deleteditem_fk0;
       public          postgres    false    3276    221    229            ?           2606    16463    dinh_chinh dinh_chinh_ibfk_1    FK CONSTRAINT     ~   ALTER TABLE ONLY public.dinh_chinh
    ADD CONSTRAINT dinh_chinh_ibfk_1 FOREIGN KEY (idhokhau) REFERENCES public.ho_khau(id);
 F   ALTER TABLE ONLY public.dinh_chinh DROP CONSTRAINT dinh_chinh_ibfk_1;
       public          postgres    false    210    212    3258            ?           2606    16468    dinh_chinh dinh_chinh_ibfk_2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.dinh_chinh
    ADD CONSTRAINT dinh_chinh_ibfk_2 FOREIGN KEY (nguoithaydoi) REFERENCES public.users(id);
 F   ALTER TABLE ONLY public.dinh_chinh DROP CONSTRAINT dinh_chinh_ibfk_2;
       public          postgres    false    210    219    3272            ?           2606    16473    gia_dinh gia_dinh_ibfk_1    FK CONSTRAINT     ~   ALTER TABLE ONLY public.gia_dinh
    ADD CONSTRAINT gia_dinh_ibfk_1 FOREIGN KEY (idnhankhau) REFERENCES public.nhan_khau(id);
 B   ALTER TABLE ONLY public.gia_dinh DROP CONSTRAINT gia_dinh_ibfk_1;
       public          postgres    false    3262    211    214            ?           2606    16478    ho_khau ho_khau_ibfk_1    FK CONSTRAINT     y   ALTER TABLE ONLY public.ho_khau
    ADD CONSTRAINT ho_khau_ibfk_1 FOREIGN KEY (idchuho) REFERENCES public.nhan_khau(id);
 @   ALTER TABLE ONLY public.ho_khau DROP CONSTRAINT ho_khau_ibfk_1;
       public          postgres    false    3262    214    212            ?           2606    16704 #   infraregistered infraregistered_fk0    FK CONSTRAINT     ?   ALTER TABLE ONLY public.infraregistered
    ADD CONSTRAINT infraregistered_fk0 FOREIGN KEY (infra_id) REFERENCES public.infrastructure(infra_id);
 M   ALTER TABLE ONLY public.infraregistered DROP CONSTRAINT infraregistered_fk0;
       public          postgres    false    225    224    3282            ?           2606    16709 #   infraregistered infraregistered_fk1    FK CONSTRAINT     ?   ALTER TABLE ONLY public.infraregistered
    ADD CONSTRAINT infraregistered_fk1 FOREIGN KEY (user_id) REFERENCES public.registers(user_id);
 M   ALTER TABLE ONLY public.infraregistered DROP CONSTRAINT infraregistered_fk1;
       public          postgres    false    223    225    3280            ?           2606    16714 #   infraregistered infraregistered_fk2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.infraregistered
    ADD CONSTRAINT infraregistered_fk2 FOREIGN KEY (event_no) REFERENCES public.schedule(event_no);
 M   ALTER TABLE ONLY public.infraregistered DROP CONSTRAINT infraregistered_fk2;
       public          postgres    false    225    3274    220            ?           2606    16689 !   itemregistered itemregistered_fk0    FK CONSTRAINT     ?   ALTER TABLE ONLY public.itemregistered
    ADD CONSTRAINT itemregistered_fk0 FOREIGN KEY (item_id) REFERENCES public.item(item_id);
 K   ALTER TABLE ONLY public.itemregistered DROP CONSTRAINT itemregistered_fk0;
       public          postgres    false    222    3276    221            ?           2606    16694 !   itemregistered itemregistered_fk1    FK CONSTRAINT     ?   ALTER TABLE ONLY public.itemregistered
    ADD CONSTRAINT itemregistered_fk1 FOREIGN KEY (user_id) REFERENCES public.registers(user_id);
 K   ALTER TABLE ONLY public.itemregistered DROP CONSTRAINT itemregistered_fk1;
       public          postgres    false    222    3280    223            ?           2606    16699 !   itemregistered itemregistered_fk2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.itemregistered
    ADD CONSTRAINT itemregistered_fk2 FOREIGN KEY (event_no) REFERENCES public.schedule(event_no);
 K   ALTER TABLE ONLY public.itemregistered DROP CONSTRAINT itemregistered_fk2;
       public          postgres    false    3274    220    222            ?           2606    16483    khai_tu khai_tu_ibfk_1    FK CONSTRAINT     }   ALTER TABLE ONLY public.khai_tu
    ADD CONSTRAINT khai_tu_ibfk_1 FOREIGN KEY (idnguoikhai) REFERENCES public.nhan_khau(id);
 @   ALTER TABLE ONLY public.khai_tu DROP CONSTRAINT khai_tu_ibfk_1;
       public          postgres    false    3262    214    213            ?           2606    16488    khai_tu khai_tu_ibfk_2    FK CONSTRAINT     }   ALTER TABLE ONLY public.khai_tu
    ADD CONSTRAINT khai_tu_ibfk_2 FOREIGN KEY (idnguoichet) REFERENCES public.nhan_khau(id);
 @   ALTER TABLE ONLY public.khai_tu DROP CONSTRAINT khai_tu_ibfk_2;
       public          postgres    false    213    214    3262            ?           2606    16729    money money_fk1    FK CONSTRAINT     r   ALTER TABLE ONLY public.money
    ADD CONSTRAINT money_fk1 FOREIGN KEY (item_id) REFERENCES public.item(item_id);
 9   ALTER TABLE ONLY public.money DROP CONSTRAINT money_fk1;
       public          postgres    false    221    3276    231            ?           2606    16493    nhan_khau nhan_khau_ibfk_1    FK CONSTRAINT     |   ALTER TABLE ONLY public.nhan_khau
    ADD CONSTRAINT nhan_khau_ibfk_1 FOREIGN KEY (idnguoitao) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.nhan_khau DROP CONSTRAINT nhan_khau_ibfk_1;
       public          postgres    false    219    3272    214            ?           2606    16498    nhan_khau nhan_khau_ibfk_2    FK CONSTRAINT     |   ALTER TABLE ONLY public.nhan_khau
    ADD CONSTRAINT nhan_khau_ibfk_2 FOREIGN KEY (idnguoixoa) REFERENCES public.users(id);
 D   ALTER TABLE ONLY public.nhan_khau DROP CONSTRAINT nhan_khau_ibfk_2;
       public          postgres    false    3272    219    214            ?           2606    16503    tam_tru tam_tru_ibfk_1    FK CONSTRAINT     |   ALTER TABLE ONLY public.tam_tru
    ADD CONSTRAINT tam_tru_ibfk_1 FOREIGN KEY (idnhankhau) REFERENCES public.nhan_khau(id);
 @   ALTER TABLE ONLY public.tam_tru DROP CONSTRAINT tam_tru_ibfk_1;
       public          postgres    false    3262    214    215            ?           2606    16508    tam_vang tam_vang_ibfk_1    FK CONSTRAINT     ~   ALTER TABLE ONLY public.tam_vang
    ADD CONSTRAINT tam_vang_ibfk_1 FOREIGN KEY (idnhankhau) REFERENCES public.nhan_khau(id);
 B   ALTER TABLE ONLY public.tam_vang DROP CONSTRAINT tam_vang_ibfk_1;
       public          postgres    false    214    3262    216            ?           2606    16513 *   thanh_vien_cua_ho thanh_vien_cua_ho_ibfk_1    FK CONSTRAINT     ?   ALTER TABLE ONLY public.thanh_vien_cua_ho
    ADD CONSTRAINT thanh_vien_cua_ho_ibfk_1 FOREIGN KEY (idnhankhau) REFERENCES public.nhan_khau(id);
 T   ALTER TABLE ONLY public.thanh_vien_cua_ho DROP CONSTRAINT thanh_vien_cua_ho_ibfk_1;
       public          postgres    false    3262    214    217            ?           2606    16518 *   thanh_vien_cua_ho thanh_vien_cua_ho_ibfk_2    FK CONSTRAINT     ?   ALTER TABLE ONLY public.thanh_vien_cua_ho
    ADD CONSTRAINT thanh_vien_cua_ho_ibfk_2 FOREIGN KEY (idhokhau) REFERENCES public.ho_khau(id);
 T   ALTER TABLE ONLY public.thanh_vien_cua_ho DROP CONSTRAINT thanh_vien_cua_ho_ibfk_2;
       public          postgres    false    217    212    3258            ?           2606    16523    tieu_su tieu_su_ibfk_1    FK CONSTRAINT     |   ALTER TABLE ONLY public.tieu_su
    ADD CONSTRAINT tieu_su_ibfk_1 FOREIGN KEY (idnhankhau) REFERENCES public.nhan_khau(id);
 @   ALTER TABLE ONLY public.tieu_su DROP CONSTRAINT tieu_su_ibfk_1;
       public          postgres    false    214    218    3262            z   j   x?e??	ACѳ:?%?6I8???????u{ ?%p???p???j?;??	?x%Æz?4??႘???)?
	???D?R?Jp ????????j?=?w<)      ?      x?????? ? ?      {      x?????? ? ?      |   
  x?ŗ=O?@??˧??+ߝ_?H$Q?ZL]"??6?H???PU*??P??????2`?bp?{?7??\B?SpQ?)?#??w????r?p??ä??w??b?gI?U???aچ`???&+??>ːl????\???*ۣ?*??e??&Kt?????ݫ3?xn?l?n?=tUz$iu ?????r?.??F6UvH?,???0???J?*ʿ?
??NTz*+??>ټ<?-??@vl$?N???i??Ϛ&f??H?8?*??t?	&??`?0}???})׉'???^???r?S?w?E??q???^$?? &M??w??31]"̿$?^î???l??t??F???`$wk?w}q??e|??kS?7?I0??c?f?V?CvuT?Tz^ST?%?w??d??c???쵐?8{?ۤ??!??!BLՓ ????l???\??????xĴfb?ȼ?+?>???A?iz?????_W?G??V?A???(O???Āe?0?{Qα?p!?XW??"uqj9+p7?@mp?? ??l>.&kp?a?Q? ??b?UαHX??V???????/?t?!??U?\???i??????<?????4??j???"?'???!w?????We?h?<?+?ݭ?=?G^3???? ??6????b??? ???aj?????KT??/?{zn?}?+xP?]?7?D?:¾?e?.2S?W??B????A??&6???}??????ꅣ??n(?Rn??u7v?????Β9,?*?fW[ڛ?Rq??4??????Ok?B      }   ?   x?34?	t200?4????30?~?{???B??]K????^[??PX?p??<??L??B??m?K?Q? ???id`h?kh?k`??A\?&?9?̐?7?a?Z??7??o?id?d?1??7??o?il?d?	?̏???? ???      ?      x?3?4?4?2?Ɯ&?&\&`2F??? 53      ?   ?   x?3??8?)/]?83/C!#?ᮅ%
??y震? ????T?K??7Y!???<???????2/P(;Ҝ?sx!?̘??????????ш$????$i4?i4"ѩ???9???4?Zr?$?o?#????F?Ա??$ch 1'?????
9????0b???? ؍{      ?   ?   x?%?+?@@??)???-?MҠp+?5K???Z?$iA4?+?p??	?`_^?S?N??j?:>`?B?4f??x????N?ck??plxx?B?\o_?u??X{r߾????-Ǘ?j?K?R?@??:??^?W ?'?Sodx? ???;?      ?   $   x?3?4A#c.#0??Ȑ˘??L?t? n?!      ~      x?????? ? ?      ?   ?   x?3?4?442?4202?50?54?<<%/]????L????{?B/?S(y?k;P</????#?y
??rqq??ݘh3??M8M??l?iJ?f3N3N??l?i?	?B?nN`|??ے?h?i????? ??[         m  x?՗?N?@?ϛ??????|I???????D?-`?`#?X????9r?D?CEUԨ傭??C??o?ى??nT??x??3???3?j?m??Ѱ?	??	?eΘ??ʒ?Jr???{bB???r??Y??3Y???x?U???h???6?
?ۆ?????w?%(V-ȡ???wy?G+E?P?׊
5ӿ?h?&3L4??Q?b?2>????Z??rl????P??5??2??Mț????-??TY??S&$?? Z?~?`?UtVp?b}?.-lT?a???]?v,xk??0?G?iK?0????-N??%80xp??%?rݿB???{ϑ٤OZ[?x???t??Ϡ?ʦ??ñ ǂ?? ??0 ?	˹|$???\/??ú?ꆃ>?.ɺ?)??S?,?5????mo?F????fX?{áp{??[*)?)I?F?H0?~????0?b?n?"?f(66??B0???
?7??G,[???VޭD????O??օ?5F??ivj????.>?X?ċ?q6PR??D?Pt??abu???G£?RY???>"g??l2??m??v???h
???Xq? ?T?q}?:?????7???t????N???\[X?Ĳ??
?{	쎆A?^??6ѼiI"?d3????V?K?X?l?%0̹?;?*NꠗAS?Q??&??j??5?A???	;?~u?e?????????AF?r0V.b???$ ?h???kA???DH??a)@?M)O}r??p?J??E9CM?e?5u??Nu??R$?Q?Z?]KM??}??d????$Y?=j?~j?&gc?'N??q	?g??30?n&R8???1Quzlv?,yx<,????@>t(?????pN|2X?hc????f?????֫D"???g?      ?   ?   x?3?)z?ky???ݛ?????pw{g????Lx?ka????ݓ?@2%:
??w??S?H?Tp:? ??؆?t ?????F?&?f???@'??e??sx?B`)??d?6?챴0735162?a8?˘????L?t???B/ʃ?cD?=0?i?	gs?p? S?x?{})P皼
C?!f"a?+F??? ?ŧ-      ?   >   x?3?4202?50?54P02?20 "ms????X]? Y?ˈ:?S??cJcb???? ?;@?      ?      x?????? ? ?      ?      x?????? ? ?      ?   ^   x?32?44?t?x?{????ed?ih??p?b.#KNCSd9c? X??,???PR???el??^?s???4	@t????:?`\??=... y?/L      ?   ?  x????k?@?ϓ????Lf6???????x	E2A??fa???$?co??B????0?????^6?(bA??0?>???7???	?O<t呭?`??3sA??8+??z?a_?:sad?O??m?q?Y??V?9;ʵ????????-?9([?;???^m?:??ӑL?-;jd?p???ҪO??Y+x?^??bg?D??$???????cO4悮#??e?????|?ly?af??ld???|	???	?䄈!$?????CH?`?pX``0??e?«?.?????
&???ق??|а ??ؼ?p??7????O_Ϝ?I?,?m|?{twB??.z?1)????up@?z?d?w?????????E??	uPc}?+?~L?????????t??????u????????t?c#~7?&??ڝ?????.??1??/?Am6?Š a???>a>5%?HNk2?1??2~?"L0?ن???????Najnh?9l???m?O?9???O?
      ?      x?3?LL????4?????? K0     