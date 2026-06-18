package test;

import java.util.List;

import dao.RanksDAO;
import dto.Rank;

public class RanksDAOTest {

    // 一覧表示
    public static void showAllData(List<Rank> list) {

        if (list == null || list.isEmpty()) {
            System.out.println("データなし");
            return;
        }

        for (Rank r : list) {
            System.out.println("ID：" + r.getId());
            System.out.println("名前：" + r.getName());
            System.out.println();
        }
    }

    public static void main(String[] args) {

        RanksDAO dao = new RanksDAO();

        // -------------------------
        // selectById
        // -------------------------
        System.out.println("---------- selectById()のテスト ----------");

        Rank r1 = dao.selectById(1);

        if (r1 != null) {
            System.out.println("ID：" + r1.getId());
            System.out.println("名前：" + r1.getName());
        } else {
            System.out.println("データなし");
        }

        // -------------------------
        // selectByName
        // -------------------------
        System.out.println("---------- selectByName()のテスト ----------");

        List<Rank> list1 = dao.selectByName("テストランク");
        showAllData(list1);

        // -------------------------
        // insert
        // -------------------------
        System.out.println("---------- insert()のテスト ----------");

        if (dao.insert("テストランク")) {
            System.out.println("登録成功！");
            showAllData(dao.selectByName("テストランク"));
        } else {
            System.out.println("登録失敗！");
        }

        // -------------------------
        // update
        // -------------------------
        System.out.println("---------- update()のテスト ----------");

        List<Rank> upList = dao.selectByName("テストランク");

        if (upList != null && !upList.isEmpty()) {

            Rank up = upList.get(0);
            up.setName("更新ランク");

            if (dao.update(up)) {
                System.out.println("更新成功！");
                showAllData(dao.selectByName("更新ランク"));
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

        List<Rank> delList = dao.selectByName("更新ランク");

        if (delList != null && !delList.isEmpty()) {

            int id = delList.get(0).getId();

            if (dao.delete(id)) {
                System.out.println("削除成功！");
                showAllData(dao.selectByName("更新ランク"));
            } else {
                System.out.println("削除失敗！");
            }

        } else {
            System.out.println("削除対象なし");
        }
    }
}