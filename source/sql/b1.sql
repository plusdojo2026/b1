CREATE DATABASE b1;
USE b1;
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
INSERT INTO users 
(phone, pw, name, rank_id, icon, vote, levelup_menu, created_at, updated_at)
VALUES
('09012345678', 'pass1234', 'ミスターバーガー', 1, 'icons/user1.png', 5, 101, current_timestamp, current_timestamp),
('08023456789', 'burger99', 'バーガーマスター', 2, 'icons/user2.png', 12, 102, current_timestamp, current_timestamp),
('07034567890', 'cheese77', 'キングバーガー', 1, 'icons/user3.png', 8, 103, current_timestamp, current_timestamp),
('09045678901', 'meat555', 'バーガー太郎', 3, 'icons/user4.png', 20, 104, current_timestamp, current_timestamp),
('08056789012', 'bbq0000', 'チーズ花子', 2, 'icons/user5.png', 15, 105, now(), now());

CREATE TABLE ranks (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO ranks (name)
VALUES
('Bronze'),
('Silver'),
('Bronze'),
('Silver'),
('Gold');

CREATE TABLE materials (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    class INT,
    price INT,
    image VARCHAR(100),
    protein INT,
    df INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO materials
(name, class, price, image, protein, df)
VALUES
('ビーフパティ', 1, 300, 'images/beef.png', 22, 0),
('バンズ', 1, 120, 'images/buns.png', 6, 1),
('チェダーチーズ', 2, 150, 'images/cheddar.png', 8, 0),
('レタス', 3, 80, 'images/lettuce.png', 2, 3),
('ベーコン', 2, 180, 'images/bacon.png', 10, 0);

CREATE TABLE classes (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO classes (name)
VALUES
('バンズ'),
('パティ'),
('トッピング'),
('野菜'),
('ソース');

CREATE TABLE menus (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    image VARCHAR(100),
    buns INT,
    patty1 INT,
    patty2 INT,
    patty3 INT,
    vege1 INT,
    vege2 INT,
    vege3 INT,
    topping1 INT,
    topping2 INT,
    topping3 INT,
    sauce INT,
    price INT,
    judge tinyint(1),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO menus 
(name, image, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price, judge)
VALUES
('トリプルチーズボム', 'images/menu6.png', 2, 1, 1, 1, 4, NULL, NULL, 3, 3, 3, 1, 950, 1),
('アボカドベーコン', 'images/menu7.png', 2, 1, NULL, NULL, 4, 7, NULL, 5, NULL, NULL, 2, 750, 1),
('スパイシーチキンサンド', 'images/menu8.png', 2, 6, NULL, NULL, 4, NULL, NULL, 3, NULL, NULL, 3, 680, 1),
('ベジバーガー', 'images/menu4.png', 2, NULL, NULL, NULL, 4, 5, 4, NULL, NULL, NULL, 3, 450, 0),
('トリプルミート', 'images/menu5.png', 2, 1, 1, 1, 4, NULL, NULL, 5, 3, NULL, 2, 900, 1);

CREATE TABLE mymenus (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    image VARCHAR(100),
    user_id INT,
    buns INT,
    patty1 INT,
    patty2 INT,
    patty3 INT,
    vege1 INT,
    vege2 INT,
    vege3 INT,
    topping1 INT,
    topping2 INT,
    topping3 INT,
    sauce INT,
    price INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO mymenus
(name, image, user_id, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price)
VALUES
('マイダブルチーズ', 'images/mymenu1.png', 1, 2, 1, 1, NULL, 4, NULL, NULL, 3, 3, NULL, 1, 800),
('ヘルシーミックス', 'images/mymenu2.png', 2, 2, NULL, NULL, NULL, 4, 5, 4, NULL, NULL, NULL, 3, 500),
('ベーコンマシマシ', 'images/mymenu3.png', 3, 2, 1, NULL, NULL, 4, NULL, NULL, 5, 5, 5, 2, 900),
('チキンスパイシー', 'images/mymenu4.png', 4, 2, 6, NULL, NULL, 4, NULL, NULL, 3, NULL, NULL, 3, 720),
('よくばりトリプル', 'images/mymenu5.png', 5, 2, 1, 1, 1, 4, 5, NULL, 3, 5, NULL, 2, 1100);

CREATE TABLE contestmenus (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    image VARCHAR(100),
    user_id INT,
    buns INT,
    patty1 INT,
    patty2 INT,
    patty3 INT,
    vege1 INT,
    vege2 INT,
    vege3 INT,
    topping1 INT,
    topping2 INT,
    topping3 INT,
    sauce INT,
    price INT,
    contest_id INT,
    vote INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO contestmenus
(name, image, user_id, buns, patty1, patty2, patty3, vege1, vege2, vege3, topping1, topping2, topping3, sauce, price, contest_id, vote)
VALUES
('チーズ爆増バーガー', 'images/contest1.png', 1, 2, 1, 1, NULL, 4, NULL, NULL, 3, 3, 3, 1, 920, 1, 15),
('アボカドヘルシー', 'images/contest2.png', 2, 2, NULL, NULL, NULL, 4, 7, 5, NULL, NULL, NULL, 3, 600, 1, 22),
('ベーコンモンスター', 'images/contest3.png', 3, 2, 1, 1, NULL, 4, NULL, NULL, 5, 5, 5, 2, 980, 1, 30),
('スパイシーチキン極', 'images/contest4.png', 4, 2, 6, NULL, NULL, 4, NULL, NULL, 3, NULL, NULL, 3, 750, 2, 18),
('トリプルミートキング', 'images/contest5.png', 5, 2, 1, 1, 1, 4, 5, NULL, 3, 5, NULL, 2, 1200, 2, 40);

CREATE TABLE contests (
    id int AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    start_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    end_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO contests
(name, start_at, end_at)
VALUES
('第1回バーガー選手権', '2026-06-01 00:00:00', '2026-06-10 23:59:59'),
('夏のスパイシーフェス', '2026-07-01 00:00:00', '2026-07-15 23:59:59'),
('チーズラバー大会', '2026-08-01 00:00:00', '2026-08-20 23:59:59'),
('ヘルシーバーガー杯', '2026-09-01 00:00:00', '2026-09-10 23:59:59'),
('年末メガバーガー祭', '2026-12-01 00:00:00', '2026-12-31 23:59:59');

CREATE TABLE votes (
    id int AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    contest_id INT,
    contestmenu_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO votes
(user_id, contest_id, contestmenu_id)
VALUES
(1, 1, 1),
(2, 1, 3),
(3, 1, 2),
(4, 2, 5),
(5, 2, 4);

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
INSERT INTO orders
(user_id, menu_id, menu_count, mymenu_id, mymenu_count)
VALUES
(1, 1, 2, NULL, NULL),
(2, 2, 1, 1, 1),
(3, 3, 3, NULL, NULL),
(4, NULL, NULL, 2, 2),
(5, 4, 1, 3, 1);

CREATE TABLE levelup (
    id int AUTO_INCREMENT PRIMARY KEY,
    image VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
INSERT INTO levelup
(image)
VALUES
('images/levelup1.png'),
('images/levelup2.png'),
('images/levelup3.png'),
('images/levelup4.png'),
('images/levelup5.png');
