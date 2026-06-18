DROP DATABASE b1;
SET SESSION sql_mode = CONCAT(@@sql_mode, ',NO_AUTO_VALUE_ON_ZERO');
CREATE DATABASE b1;
USE b1;


/* テーブル作成 */
/* usersテーブル */
CREATE TABLE users  (
    id INT AUTO_INCREMENT PRIMARY KEY,
    phone VARCHAR(20),
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
	('バンズ上', 1, 60, '/b1/images/buns_top.png', 3, 1),
	('バンズ下', 1, 60, '/b1/images/buns_bottom.png', 3, 1),
    ('ビーフ', 2, 300, '/b1/images/beef.png', 22, 0),
    ('チキン', 2, 300, '/b1/images/beef.png', 22, 0),
    ('チーズ', 3, 150, '/b1/images/cheese.png', 8, 0),
    ('ベーコン', 3, 180, '/b1/images/bacon.png', 10, 0),
    ('エッグ', 3, 100, '/b1/images/egg.png', 10, 0),
    ('レタス', 4, 80, '/b1/images/lettuce.png', 2, 3),
    ('トマト', 4, 80, '/b1/images/tomato.png', 2, 3),
    ('タマネギ', 4, 80, '/b1/images/onion.png', 2, 3),
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
    buns INT DEFAULT 0,
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
    (id,name, image, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price, judge)
VALUES
    (0,'', '', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO menus 
    (name, image, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price, judge)
VALUES
    ('トリプルチーズボム', 'images/menu6.png', 2, 1, 1, 1, 4, 0, 0, 3, 3, 3, 1, 950, 1),
    ('アボカドベーコン', 'images/menu7.png', 2, 1, 0, 0, 4, 7, 0, 5, 0, 0, 2, 750, 1),
    ('スパイシーチキンサンド', 'images/menu8.png', 2, 6, 0, 0, 4, 0, 0, 3, 0, 0, 3, 680, 1),
    ('ベジバーガー', 'images/menu4.png', 2, 0, 0, 0, 4, 5, 4, 0, 0, 0, 3, 450, 0),
    ('トリプルミート', 'images/menu5.png', 2, 1, 1, 1, 4, 0, 0, 5, 3, 0, 2, 900, 1);


/* mymenusテーブル */
CREATE TABLE mymenus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    user_id INT DEFAULT 0,
    buns INT DEFAULT 0,
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

/* mymenusダミーデータ */
INSERT INTO mymenus
    (id,name, user_id, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price)
VALUES
    (0,'', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO mymenus
    (name, user_id, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price)
VALUES
    ('マイダブルチーズ', 1, 2, 1, 1, 0, 4, 0, 0, 3, 3, 0, 1, 800),
    ('ヘルシーミックス', 2, 2, 0, 0, 0, 4, 5, 4, 0, 0, 0, 3, 500),
    ('ベーコンマシマシ', 3, 2, 1, 0, 0, 4, 0, 0, 5, 5, 5, 2, 900),
    ('チキンスパイシー', 4, 2, 6, 0, 0, 4, 0, 0, 3, 0, 0, 3, 720),
    ('よくばりトリプル', 5, 2, 1, 1, 1, 4, 5, 0, 3, 5, 0, 2, 1100);


/* contestmenusテーブル */
CREATE TABLE contestmenus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    user_id INT DEFAULT 0,
    buns INT DEFAULT 0,
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
    (id,name, user_id, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price, contest_id)
VALUES
    (0,'', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO contestmenus
    (name, user_id, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price, contest_id)
VALUES
    ('チーズ爆増バーガー', 1, 2, 1, 1, 0, 4, 0, 0, 3, 3, 3, 1, 920, 1),
    ('アボカドヘルシー', 2, 2, 0, 0, 0, 4, 7, 5, 0, 0, 0, 3, 600, 1),
    ('ベーコンモンスター', 3, 2, 1, 1, 0, 4, 0, 0, 5, 5, 5, 2, 980, 1),
    ('スパイシーチキン極', 4, 2, 6, 0, 0, 4, 0, 0, 3, 0, 0, 3, 750, 2),
    ('トリプルミートキング', 5, 2, 1, 1, 1, 4, 5, 0, 3, 5, 0, 2, 1200, 2);


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
    ('第1回バーガー選手権', '2026-06-01 00:00:00', '2026-06-10 23:59:59'),
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
    (2, 1, 3),
    (3, 1, 2),
    (4, 2, 5),
    (5, 2, 4);


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
    (2, 2, 1, 1, 1),
    (3, 3, 3, 0, 0),
    (4, 0, 0, 2, 2),
    (5, 4, 1, 3, 1);

