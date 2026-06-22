package test;

import java.util.List;

import dao.MenusDAO;
import dto.Menu;

public class MenusDAOTest {

    // 一覧表示
    public static void showAllData(List<Menu> list) {
        if (list == null) {
            System.out.println("データなし（null）");
            return;
        }

        for (Menu m : list) {
            System.out.println("ID：" + m.getId());
            System.out.println("名前：" + m.getName());
            System.out.println("画像：" + m.getImage());
            System.out.println("バンズ1：" + m.getBuns1());
            System.out.println("バンズ2：" + m.getBuns2());
            System.out.println("パティ1：" + m.getPatty1());
            System.out.println("パティ2：" + m.getPatty2());
            System.out.println("パティ3：" + m.getPatty3());
            System.out.println("野菜1：" + m.getVege1());
            System.out.println("野菜2：" + m.getVege2());
            System.out.println("野菜3：" + m.getVege3());
            System.out.println("トッピング1：" + m.getTopping1());
            System.out.println("トッピング2：" + m.getTopping2());
            System.out.println("トッピング3：" + m.getTopping3());
            System.out.println("ソース：" + m.getSauce());
            System.out.println("価格：" + m.getPrice());
            System.out.println("判定：" + m.getJudge());
            System.out.println();
        }
    }

    public static void main(String[] args) {

        MenusDAO dao = new MenusDAO();

        // -------------------------
        // selectById
        // -------------------------
        System.out.println("---------- selectById()のテスト ----------");
        Menu m1 = dao.selectById(1); // ←存在するIDに変更
        if (m1 != null) {
            System.out.println(m1.getName());
        } else {
            System.out.println("データなし");
        }

        // -------------------------
        // selectByName
        // -------------------------
        System.out.println("---------- selectByName()のテスト ----------");
        Menu m2 = dao.selectByName("アボカドベーコン");
        if (m2 != null) {
            System.out.println(m2.getName());
        } else {
            System.out.println("データなし");
        }

        // -------------------------
        // selectByBuns
        // -------------------------
        System.out.println("---------- selectByBuns()のテスト ----------");
        showAllData(dao.selectByBuns(1));

        // -------------------------
        // selectByPatty
        // -------------------------
        System.out.println("---------- selectByPatty()のテスト ----------");
        showAllData(dao.selectByPatty(1));

        // -------------------------
        // selectByVege
        // -------------------------
        System.out.println("---------- selectByVege()のテスト ----------");
        showAllData(dao.selectByVege(1));

        // -------------------------
        // selectByTopping
        // -------------------------
        System.out.println("---------- selectByTopping()のテスト ----------");
        showAllData(dao.selectByTopping(1));

        // -------------------------
        // selectBySauce
        // -------------------------
        System.out.println("---------- selectBySauce()のテスト ----------");
        showAllData(dao.selectBySauce(1));

        // -------------------------
        // insert
        // -------------------------
        System.out.println("---------- insert()のテスト ----------");

        Menu ins = new Menu(
                0,
                "テストメニュー",
                "test.png",
                1,
                0,
                1,
                0,
                0,
                1,
                0,
                0,
                1,
                0,
                0,
                1,
                500,
                1,
                null,
                null
        );

        if (dao.insert(ins)) {
            System.out.println("登録成功！");
            showAllData(List.of(dao.selectByName("テストメニュー")));
        } else {
            System.out.println("登録失敗！");
        }

        // -------------------------
        // update
        // -------------------------
        System.out.println("---------- update()のテスト ----------");

        Menu up = dao.selectByName("テストメニュー");

        if (up != null) {
            up = new Menu(
                    up.getId(),
                    "更新メニュー",
                    "update.png",
                    up.getBuns1(),
                    up.getBuns2(),
                    up.getPatty1(),
                    up.getPatty2(),
                    up.getPatty3(),
                    up.getVege1(),
                    up.getVege2(),
                    up.getVege3(),
                    up.getTopping1(),
                    up.getTopping2(),
                    up.getTopping3(),
                    up.getSauce(),
                    600,
                    up.getJudge(),
                    up.getCreated_at(),
                    up.getUpdated_at()
            );

            if (dao.update(up)) {
                System.out.println("更新成功！");
                showAllData(List.of(dao.selectByName("更新メニュー")));
            } else {
                System.out.println("更新失敗！");
            }
        } else {
            System.out.println("更新対象なし");
        }

        // -------------------------
        // delete
        // -------------------------
        System.out.println("---------- delete()のテスト ----------");

        Menu del = dao.selectByName("更新メニュー");

        if (del != null) {
            if (dao.delete(del.getId())) {
                System.out.println("削除成功！");
                Menu deleted = dao.selectByName("更新メニュー");

                if (deleted == null) {
                    System.out.println("削除後データなし（正常）");
                } else {
                    showAllData(List.of(deleted));
                }
            } else {
                System.out.println("削除失敗！");
            }
        } else {
            System.out.println("削除対象なし");
        }
    }
}