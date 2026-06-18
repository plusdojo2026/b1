package test;

import java.util.List;

import dao.MaterialsDAO;
import dto.Material;

public class MaterialsDAOTest {

    // 一覧表示
    public static void showAllData(List<Material> list) {
        for (Material m : list) {
            System.out.println("ID：" + m.getId());
            System.out.println("名前：" + m.getName());
            System.out.println("カテゴリ：" + m.getCategory());
            System.out.println("価格：" + m.getPrice());
            System.out.println("画像：" + m.getImage());
            System.out.println("タンパク質：" + m.getProtein());
            System.out.println("食物繊維：" + m.getDf());
            System.out.println();
        }
    }

    public static void main(String[] args) {

        MaterialsDAO dao = new MaterialsDAO();

        // -------------------------
        // selectById
        // -------------------------
        System.out.println("---------- selectById()のテスト ----------");
        Material m1 = dao.selectById(1);
        if (m1 != null) {
            System.out.println(m1.getName());
        } else {
            System.out.println("データなし");
        }

        // -------------------------
        // selectByName
        // -------------------------
        System.out.println("---------- selectByName()のテスト ----------");
        List<Material> list1 = dao.selectByName("バンズ");
        showAllData(list1);

        // -------------------------
        // selectByCategory
        // -------------------------
        System.out.println("---------- selectByCategory()のテスト ----------");
        List<Material> list2 = dao.selectByCategory(1);
        showAllData(list2);

        // -------------------------
        // insert
        // -------------------------
        System.out.println("---------- insert()のテスト ----------");

        Material ins = new Material(
                0,
                "テスト食材",
                1,
                999,
                "images/test.png",
                10,
                5,
                null,
                null
        );

        if (dao.insert(ins)) {
            System.out.println("登録成功！");
            showAllData(dao.selectByName("テスト食材"));
        } else {
            System.out.println("登録失敗！");
        }

        // -------------------------
        // update
        // -------------------------
        System.out.println("---------- update()のテスト ----------");

        List<Material> upList = dao.selectByName("テスト食材");

        if (upList != null && !upList.isEmpty()) {
            Material up = upList.get(0);
            up.setName("更新食材");

            if (dao.update(up)) {
                System.out.println("更新成功！");
                showAllData(dao.selectByName("更新食材"));
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

        List<Material> delList = dao.selectByName("更新食材");

        if (delList != null && !delList.isEmpty()) {
            int id = delList.get(0).getId();

            if (dao.delete(id)) {
                System.out.println("削除成功！");
                showAllData(dao.selectByName("更新食材"));
            } else {
                System.out.println("削除失敗！");
            }
        } else {
            System.out.println("削除対象なし");
        }
    }
}