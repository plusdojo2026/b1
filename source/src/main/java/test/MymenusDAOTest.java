package test;

import java.util.List;

import dao.MymenusDAO;
import dto.Mymenu;

public class MymenusDAOTest {

    // 一覧表示
    public static void showAllData(List<Mymenu> list) {

        if (list == null || list.isEmpty()) {
            System.out.println("データなし");
            return;
        }

        for (Mymenu m : list) {
            System.out.println("ID：" + m.getId());
            System.out.println("名前：" + m.getName());
            System.out.println("ユーザーID：" + m.getUser_id());
            System.out.println("バンズ：" + m.getBuns());
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
            System.out.println();
        }
    }

    public static void main(String[] args) {

        MymenusDAO dao = new MymenusDAO();

        // -------------------------
        // select(id)
        // -------------------------
        System.out.println("---------- selectById()のテスト ----------");
        Mymenu m1 = dao.selectById(1);
        if (m1 != null) {
            System.out.println(m1.getName());
        } else {
            System.out.println("データなし");
        }

        // -------------------------
        // select(user_id)
        // -------------------------
        System.out.println("---------- select(user_id)のテスト ----------");
        List<Mymenu> list1 = dao.select(1);
        showAllData(list1);

        // -------------------------
        // insert
        // -------------------------
        System.out.println("---------- insert()のテスト ----------");

        Mymenu ins = new Mymenu(
                0,
                "テストマイメニュー",
                1,      // user_id
                1,
                1, 1, 1,
                1, 1, 1,
                1, 1, 1,
                1,
                999,
                null,
                null
        );

        if (dao.insert(ins)) {
            System.out.println("登録成功！");
            showAllData(dao.select(1));
        } else {
            System.out.println("登録失敗！");
        }

        // -------------------------
        // update
        // -------------------------
        System.out.println("---------- update()のテスト ----------");

        List<Mymenu> upList = dao.select(1);

        if (upList != null && !upList.isEmpty()) {
            Mymenu up = upList.get(0);
            up.setName("更新マイメニュー");

            if (dao.update(up)) {
                System.out.println("更新成功！");
                showAllData(dao.select(1));
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

        List<Mymenu> delList = dao.select(1);

        if (delList != null && !delList.isEmpty()) {
            int id = delList.get(0).getId();

            if (dao.delete(id)) {
                System.out.println("削除成功！");
                showAllData(dao.select(1));
            } else {
                System.out.println("削除失敗！");
            }
        } else {
            System.out.println("削除対象なし");
        }
    }
}