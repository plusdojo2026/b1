SET SESSION sql_mode = CONCAT(@@sql_mode, ',NO_AUTO_VALUE_ON_ZERO');

/* テーブル作成 */
/* usersテーブル */
CREATE TABLE users  (
    id INT AUTO_INCREMENT PRIMARY KEY,
    phone VARCHAR(20) UNIQUE,
    pw VARCHAR(20),
    name VARCHAR(10),
    rank_id INT DEFAULT 0,
    icon VARCHAR(100),
    vote INT DEFAULT 0,
    levelup_menu INT DEFAULT 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* usersダミーデータ */
INSERT INTO users 
    (id,phone, pw, name, rank_id, icon, vote, levelup_menu)
VALUES
    (0,'','','', 0,'',0,0);

INSERT INTO users 
    (phone, pw, name, rank_id, icon, vote, levelup_menu)
VALUES
	('admin', 'pass1111','管理者',3,'',20,5),
    ('09012345678', 'pass1234', 'ミスターバーガー', 1, 'icons/user1.png', 5, 1),
    ('08023456789', 'burger99', 'バーガーマスター', 2, 'icons/user2.png', 12, 2),
    ('07034567890', 'cheese77', 'キングバーガー', 1, 'icons/user3.png', 8, 3),
    ('09045678901', 'meat555', 'バーガー太郎', 3, 'icons/user4.png', 20, 4),
    ('08056789012', 'bbq0000', 'チーズ花子', 2, 'icons/user5.png', 15, 5);


/* ranksテーブル */
CREATE TABLE ranks (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* ranksダミーデータ */
INSERT INTO ranks (id,name)
VALUES
    (0,'');
INSERT INTO ranks (name)
VALUES
    ('Bronze'),
    ('Silver'),
    ('Gold');


/* materialsテーブル */
CREATE TABLE materials (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    category INT DEFAULT 0,
    price INT DEFAULT 0,
    image VARCHAR(100),
    protein INT DEFAULT 0,
    df INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* materialsダミーデータ */
INSERT INTO materials
    (id,name, category, price, image, protein, df)
VALUES
    (0,'',0,0,'',0,0);
INSERT INTO materials
    (name, category, price, image, protein, df)
VALUES
	('バンズ上', 1, 60, '/b1/images/hamburger/buns_top.png', 3, 1),
	('バンズ下', 1, 60, '/b1/images/hamburger/buns_bottom.png', 3, 1),
    ('ビーフ', 2, 300, '/b1/images/hamburger/beef.png', 22, 0),
    ('チキン', 2, 300, '/b1/images/hamburger/chicken.png', 22, 0),
    ('チーズ', 3, 150, '/b1/images/hamburger/cheese.png', 8, 0),
    ('ベーコン', 3, 180, '/b1/images/hamburger/bacon.png', 10, 0),
    ('エッグ', 3, 100, '/b1/images/hamburger/egg.png', 10, 0),
    ('レタス', 4, 80, '/b1/images/hamburger/lettuce.png', 2, 3),
    ('トマト', 4, 80, '/b1/images/hamburger/tomato.png', 2, 3),
    ('タマネギ', 4, 80, '/b1/images/hamburger/onion.png', 2, 3),
    ('BBQ', 5, 20, '', 10, 0),
    ('サルサ', 5, 30, '', 15, 0),
    ('マスタード', 5, 20, '', 5, 0);

/* categoriesテーブル */
CREATE TABLE categories(
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* categoriesダミーデータ */
INSERT INTO categories (id,name)
VALUES
    (0,'');
INSERT INTO categories (name)
VALUES
    ('バンズ'),
    ('パティ'),
    ('トッピング'),
    ('野菜'),
    ('ソース');


/* menusテーブル */
CREATE TABLE menus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20),
    image VARCHAR(100),
    buns1 INT DEFAULT 0,
    buns2 INT DEFAULT 0,
    patty1 INT DEFAULT 0,
    patty2 INT DEFAULT 0,
    patty3 INT DEFAULT 0,
    vege1 INT DEFAULT 0,
    vege2 INT DEFAULT 0,
    vege3 INT DEFAULT 0,
    topping1 INT DEFAULT 0,
    topping2 INT DEFAULT 0,
    topping3 INT DEFAULT 0,
    sauce INT DEFAULT 0,
    price INT DEFAULT 0,
    judge INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* menusダミーデータ */
INSERT INTO menus 
    (id,name, image, buns1, buns2, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price, judge)
VALUES
    (0,'', '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO menus 
    (name, image, buns1, buns2, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price, judge)
VALUES
    ('トリプルチーズボム', 'images/menu6.png', 1, 2, 3, 4, 3, 8, 9, 0, 5, 5, 5, 12, 1050, 1),
    ('アボカドベーコン', 'images/menu7.png', 1, 2, 3, 0, 0, 9, 8, 0, 6, 7, 6, 11, 850, 1),
    ('スパイシーチキンサンド', 'images/menu8.png', 1, 2, 4, 0, 0, 10, 0, 0, 8, 0, 0, 13, 780, 1),
    ('ベジバーガー', 'images/menu4.png', 1, 2, 3, 0, 0, 8, 5, 9, 0, 10, 0, 11, 650, 0),
    ('トリプルミート', 'images/menu5.png', 1, 2, 3, 3, 3, 5, 6, 5, 8, 10, 9, 12, 1500, 1),
    ('ヘルシーベジタブル', '', 1, 2, 0, 0, 0, 5, 6, 7, 0, 10, 0, 11, 520, 0),
    ('ダブルチキン', '', 1, 2, 4, 4, 0, 7, 0, 0, 9, 0, 8, 12, 980, 1),
    ('ダブルビーフ', '', 1, 2, 3, 3, 0, 5, 7, 0, 8, 9, 0, 12, 820, 1),
    ('スパイシーダブルビーフ', '', 1, 2, 3, 3, 0, 7, 6, 0, 9, 10, 0, 13, 980, 1),
    ('てりやきチキン', '', 1, 2, 4, 0, 0, 7, 5, 0, 9, 0, 0, 13, 700, 1),
    ('エッグチーズバーガー', '', 1, 2, 3, 0, 0, 5, 7, 0, 8, 9, 0, 12, 650, 1),
    ('エッグベジサンド', '', 1, 2, 0, 0, 0, 5, 6, 7, 0, 10, 0, 11, 580, 0),
    ('アボカドチキンエッグ', '', 1, 2, 4, 0, 0, 9, 7, 0, 8, 6, 10, 11, 880, 1),
    ('オールスター全部のせ', '', 1, 2, 3, 4, 0, 8, 9, 10, 5, 6, 7, 11, 1400, 1),
    ('ノーバンズプロテインバーガー', '', 0, 0, 3, 4, 3, 8, 9, 0, 7, 0, 0, 12, 950, 1)

    ;


/* mymenusテーブル */
CREATE TABLE mymenus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    user_id INT DEFAULT 0,
    
    buns1 INT DEFAULT 0,
    buns2 INT DEFAULT 0,
    
    patty1 INT DEFAULT 0,
    patty2 INT DEFAULT 0,
    patty3 INT DEFAULT 0,
    
    vege1 INT DEFAULT 0,
    vege2 INT DEFAULT 0,
    vege3 INT DEFAULT 0,
    
    topping1 INT DEFAULT 0,
    topping2 INT DEFAULT 0,
    topping3 INT DEFAULT 0,
    
    sauce INT DEFAULT 0,
    price INT DEFAULT 0,
    
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* mymenusダミーデータ（修正版） */
INSERT INTO mymenus
    (id, name, user_id, buns1, buns2, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price)
VALUES
    (0, '', 0, 1, 2, 3, 3, 3, 8, 8, 8, 5, 5, 5, 0, 0);

INSERT INTO mymenus
    (name, user_id, buns1, buns2, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price)
VALUES
    ('マイダブルチーズ', 1,
        1, 2,      -- buns
        3, 0, 4,   -- patty1=3, patty2=0, patty3=4
        8, 0, 0,   -- vege1=8
        5, 0, 7,   -- topping1=5, topping3=7
        12, 800),

    ('ヘルシーミックス', 2,
        1, 2,
        4, 3, 0,   -- patty
        9, 8, 9,   -- vege
        0, 0, 0,   -- topping
        13, 500),

    ('ベーコンマシマシ', 3,
        1, 2,
        3, 0, 0,   -- patty
        8, 0, 0,   -- vege
        6, 6, 6,   -- topping
        0, 900),

    ('チキンスパイシー', 4,
        1, 2,
        3, 4, 0,   -- patty
        0, 0, 0,   -- vege
        7, 0, 6,   -- topping
        11, 720),

    ('よくばりトリプル', 5,
        1, 2,
        3, 0, 4,   -- patty
        9, 0, 10,  -- vege
        7, 0, 5,   -- topping
        12, 1100);

/* contestmenusテーブル */
CREATE TABLE contestmenus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    user_id INT DEFAULT 0,
    buns1 INT DEFAULT 0,
    buns2 INT DEFAULT 0,
    patty1 INT DEFAULT 0,
    patty2 INT DEFAULT 0,
    patty3 INT DEFAULT 0,
    vege1 INT DEFAULT 0,
    vege2 INT DEFAULT 0,
    vege3 INT DEFAULT 0,
    topping1 INT DEFAULT 0,
    topping2 INT DEFAULT 0,
    topping3 INT DEFAULT 0,
    sauce INT DEFAULT 0,
    price INT DEFAULT 0,
    contest_id INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* contestmenusダミーデータ */
INSERT INTO contestmenus
    (id,name, user_id, buns1, buns2, patty1, patty2, patty3,
     vege1, vege2, vege3, topping1, topping2, topping3,
     sauce, price, contest_id)
VALUES
    (0,'', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

INSERT INTO contestmenus
    (name, user_id, buns1, buns2, patty1, patty2, patty3,
     vege1, vege2, vege3, topping1, topping2, topping3,
     sauce, price, contest_id)
VALUES
    ('欲張りバーガー', 1,
        1, 2,
        3, 4, 0,
        8, 0, 9,
        5, 5, 5,
        11, 920, 1),

    ('ベジベジヘルシー', 2,
        1, 2,
        3, 4, 0,
        8, 9, 10,
        5, 0, 7,
        13, 600, 1),

    ('ベーコンモンスター', 3,
        1, 2,
        4, 3, 0,
        8, 0, 9,
        6, 6, 6,
        12, 980, 1),

    ('チキン極', 4,
        1, 2,
        4, 0, 0,
        8, 9, 0,
        7, 6, 5,
        13, 750, 1),

    ('トリプルミートキング', 5,
        1, 2,
        3, 3, 3,
        8, 9, 10,
        7, 6, 5,
        12, 1200, 1);

/* contestsテーブル */
CREATE TABLE contests (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    start_at TIMESTAMP NULL DEFAULT NULL,
	end_at TIMESTAMP NULL DEFAULT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* contestsダミーデータ */
INSERT INTO contests
    (id,name, start_at, end_at)
VALUES
    (0,'',NULL,NULL);
INSERT INTO contests
    (name, start_at, end_at)
VALUES
    ('第1回バーガー選手権', '2026-06-01 00:00:00', '2037-12-31 23:59:59'),
    ('夏のスパイシーフェス', '2026-07-01 00:00:00', '2026-07-15 23:59:59'),
    ('チーズラバー大会', '2026-08-01 00:00:00', '2026-08-20 23:59:59'),
    ('ヘルシーバーガー杯', '2026-09-01 00:00:00', '2026-09-10 23:59:59'),
    ('年末メガバーガー祭', '2026-12-01 00:00:00', '2026-12-31 23:59:59');


/* votesテーブル */
CREATE TABLE votes (
    id int AUTO_INCREMENT PRIMARY KEY,
    user_id INT DEFAULT 0,
    contest_id INT DEFAULT 0,
    contestmenu_id INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* votesダミーデータ */
INSERT INTO votes
    (id,user_id, contest_id, contestmenu_id)
VALUES
    (0,0,0,0);
INSERT INTO votes
    (user_id, contest_id, contestmenu_id)
VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 1, 3),
    (4, 2, 1),
    (5, 2, 1),
    (6, 1, 1),
    (7, 1, 1),
    (8, 1, 2),
    (9, 2, 3),
    (10, 2, 3);


/* ordersテーブル */
CREATE TABLE orders (
    id int AUTO_INCREMENT PRIMARY KEY,
    user_id INT DEFAULT 0,
    menu_id INT DEFAULT 0,
    menu_count INT DEFAULT 0,
    mymenu_id INT DEFAULT 0,
    mymenu_count INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

/* ordersダミーデータ */
INSERT INTO orders
    (id,user_id, menu_id, menu_count, mymenu_id, mymenu_count)
VALUES
    (0,0,0,0,0,0);
INSERT INTO orders
    (user_id, menu_id, menu_count, mymenu_id, mymenu_count)
VALUES
    (1, 1, 2, 0, 0),
    (2, 2, 1, 2, 1),
    (3, 3, 3, 0, 0),
    (4, 0, 0, 4, 2),
    (5, 4, 1, 5, 1);

