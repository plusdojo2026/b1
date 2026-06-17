CREATE DATABASE b1;
USE b1;

/* テーブル作成 */
/* usersテーブル */
CREATE TABLE users  (
    id INT AUTO_INCREMENT PRIMARY KEY,
    phone VARCHAR(20) NOT NULL,
    pw VARCHAR(10) NOT NULL,
    name VARCHAR(10) NOT NULL,
    rank_id INT,
    icon VARCHAR(100),
    vote INT,
    levelup_menu INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* usersダミーデータ */
INSERT INTO users 
    (phone, pw, name, rank_id, icon, vote, levelup_menu)
VALUES
    ('09012345678', 'pass1234', 'ミスターバーガー', 1, 'icons/user1.png', 5, 101),
    ('08023456789', 'burger99', 'バーガーマスター', 2, 'icons/user2.png', 12, 102),
    ('07034567890', 'cheese77', 'キングバーガー', 1, 'icons/user3.png', 8, 103),
    ('09045678901', 'meat555', 'バーガー太郎', 3, 'icons/user4.png', 20, 104),
    ('08056789012', 'bbq0000', 'チーズ花子', 2, 'icons/user5.png', 15, 105);


/* ranksテーブル */
CREATE TABLE ranks (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* ranksダミーデータ */
INSERT INTO ranks (name)
VALUES
    ('Bronze'),
    ('Silver'),
    ('Bronze'),
    ('Silver'),
    ('Gold');


/* materialsテーブル */
CREATE TABLE materials (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    category INT,
    price INT,
    image VARCHAR(100),
    protein INT,
    df INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* materialsダミーデータ */
INSERT INTO materials
    (name, category, price, image, protein, df)
VALUES
    ('ビーフパティ', 1, 300, 'images/beef.png', 22, 0),
    ('バンズ', 1, 120, 'images/buns.png', 6, 1),
    ('チェダーチーズ', 2, 150, 'images/cheddar.png', 8, 0),
    ('レタス', 3, 80, 'images/lettuce.png', 2, 3),
    ('ベーコン', 2, 180, 'images/bacon.png', 10, 0);


/* categoriesテーブル */
CREATE TABLE categories(
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* categoriesダミーデータ */
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
    name VARCHAR(20) NOT NULL,
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
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* menusダミーデータ */
INSERT INTO menus 
    (name, image, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price, judge)
VALUES
    ('トリプルチーズボム', 'images/menu6.png', 2, 1, 1, 1, 4, NULL, NULL, 3, 3, 3, 1, 950, 1),
    ('アボカドベーコン', 'images/menu7.png', 2, 1, NULL, NULL, 4, 7, NULL, 5, NULL, NULL, 2, 750, 1),
    ('スパイシーチキンサンド', 'images/menu8.png', 2, 6, NULL, NULL, 4, NULL, NULL, 3, NULL, NULL, 3, 680, 1),
    ('ベジバーガー', 'images/menu4.png', 2, NULL, NULL, NULL, 4, 5, 4, NULL, NULL, NULL, 3, 450, 0),
    ('トリプルミート', 'images/menu5.png', 2, 1, 1, 1, 4, NULL, NULL, 5, 3, NULL, 2, 900, 1);


/* mymenusテーブル */
CREATE TABLE mymenus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    user_id INT,
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
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* mymenusダミーデータ */
INSERT INTO mymenus
    (name, user_id, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price)
VALUES
    ('マイダブルチーズ', 1, 2, 1, 1, NULL, 4, NULL, NULL, 3, 3, NULL, 1, 800),
    ('ヘルシーミックス', 2, 2, NULL, NULL, NULL, 4, 5, 4, NULL, NULL, NULL, 3, 500),
    ('ベーコンマシマシ', 3, 2, 1, NULL, NULL, 4, NULL, NULL, 5, 5, 5, 2, 900),
    ('チキンスパイシー', 4, 2, 6, NULL, NULL, 4, NULL, NULL, 3, NULL, NULL, 3, 720),
    ('よくばりトリプル', 5, 2, 1, 1, 1, 4, 5, NULL, 3, 5, NULL, 2, 1100);


/* contestmenusテーブル */
CREATE TABLE contestmenus (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    user_id INT,
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
    contest_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* contestmenusダミーデータ */
INSERT INTO contestmenus
    (name, user_id, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price, contest_id)
VALUES
    ('チーズ爆増バーガー', 1, 2, 1, 1, NULL, 4, NULL, NULL, 3, 3, 3, 1, 920, 1),
    ('アボカドヘルシー', 2, 2, NULL, NULL, NULL, 4, 7, 5, NULL, NULL, NULL, 3, 600, 1),
    ('ベーコンモンスター', 3, 2, 1, 1, NULL, 4, NULL, NULL, 5, 5, 5, 2, 980, 1),
    ('スパイシーチキン極', 4, 2, 6, NULL, NULL, 4, NULL, NULL, 3, NULL, NULL, 3, 750, 2),
    ('トリプルミートキング', 5, 2, 1, 1, 1, 4, 5, NULL, 3, 5, NULL, 2, 1200, 2);


/* contestsテーブル */
CREATE TABLE contests (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    start_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    end_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* contestsダミーデータ */
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
    user_id INT,
    contest_id INT,
    contestmenu_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* votesダミーデータ */
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
    user_id INT,
    menu_id INT,
    menu_count INT,
    mymenu_id INT,
    mymenu_count INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* ordersダミーデータ */
INSERT INTO orders
    (user_id, menu_id, menu_count, mymenu_id, mymenu_count)
VALUES
    (1, 1, 2, NULL, NULL),
    (2, 2, 1, 1, 1),
    (3, 3, 3, NULL, NULL),
    (4, NULL, NULL, 2, 2),
    (5, 4, 1, 3, 1);


/* levelupテーブル */
CREATE TABLE levelup (
    id int AUTO_INCREMENT PRIMARY KEY,
    image VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

/* levelupダミーデータ */
INSERT INTO levelup (image)
VALUES
    ('images/levelup1.png'),
    ('images/levelup2.png'),
    ('images/levelup3.png'),
    ('images/levelup4.png'),
    ('images/levelup5.png');