package test;

import java.util.List;

import dao.ContestmenusDAO;
import dto.Contestmenu;

public class ContestmenusDAOTest {

    // リスト表示用メソッド
    public static void showAllData(List<Contestmenu> list) {
        for (Contestmenu cm : list) {
            System.out.println("ID：" + cm.getId());
            System.out.println("名前：" + cm.getName());
            System.out.println("ユーザーID：" + cm.getUser_id());
            System.out.println("バンズ上：" + cm.getBuns1());
            System.out.println("バンズ下：" + cm.getBuns2());
            System.out.println("パティ1：" + cm.getPatty1());
            System.out.println("パティ2：" + cm.getPatty2());
            System.out.println("パティ3：" + cm.getPatty3());
            System.out.println("野菜1：" + cm.getVege1());
            System.out.println("野菜2：" + cm.getVege2());
            System.out.println("野菜3：" + cm.getVege3());
            System.out.println("トッピング1：" + cm.getTopping1());
            System.out.println("トッピング2：" + cm.getTopping2());
            System.out.println("トッピング3：" + cm.getTopping3());
            System.out.println("ソース：" + cm.getSauce());
            System.out.println("価格：" + cm.getPrice());
            System.out.println("コンテストID：" + cm.getContest_id());
            System.out.println();
        }
    }

    public static void main(String[] args) {

        ContestmenusDAO dao = new ContestmenusDAO();

        // -----------------------------
        // selectById テスト
        // -----------------------------
        System.out.println("---------- selectById()のテスト ----------");
        Contestmenu cm1 = dao.selectById(1);
        if (cm1 != null) {
            System.out.println(cm1.getName());
        } else {
            System.out.println("データなし");
        }

        // -----------------------------
        // selectByName テスト
        // -----------------------------
        System.out.println("---------- selectByName()のテスト ----------");
        Contestmenu cm2 = dao.selectByName("チーズ爆増バーガー");
        if (cm2 != null) {
            System.out.println(cm2.getName());
        } else {
            System.out.println("データなし");
        }

        // -----------------------------
        // selectByUserId テスト
        // -----------------------------
        System.out.println("---------- selectByUserId()のテスト ----------");
        List<Contestmenu> list1 = dao.selectByUserId(1);
        showAllData(list1);

        // -----------------------------
        // selectByContestId テスト
        // -----------------------------
        System.out.println("---------- selectByContestId()のテスト ----------");
        List<Contestmenu> list2 = dao.selectByContestId(1);
        showAllData(list2);

        // -----------------------------
        // insert テスト
        // -----------------------------
        System.out.println("---------- insert()のテスト ----------");

        Contestmenu ins = new Contestmenu(
                0,
                "テストバーガー",
                1,
                2,
                0,
                1,
                0,
                0,
                4,
                0,
                0,
                3,
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
            showAllData(dao.selectByUserId(1));
        } else {
            System.out.println("登録失敗！");
        }

        // -----------------------------
        // update テスト
        // -----------------------------
        System.out.println("---------- update()のテスト ----------");

        Contestmenu upRec = dao.selectByName("テストバーガー");

        if (upRec != null) {
            upRec.setName("更新バーガー");

            if (dao.update(upRec)) {
                System.out.println("更新成功！");
                Contestmenu contestup = dao.selectByName("更新バーガー");
                System.out.println(contestup.getName());
            } else {
                System.out.println("更新失敗！");
            }
        } else {
            System.out.println("対象データなし");
        }

        // -----------------------------
        // delete テスト
        // -----------------------------
        System.out.println("---------- delete()のテスト ----------");

        Contestmenu delRec = dao.selectByName("更新バーガー");

        if (delRec != null) {

            if (dao.delete(delRec.getId())) {
                System.out.println("削除成功！");
                System.out.println(dao.selectByName("更新バーガー"));
            } else {
                System.out.println("削除失敗！");
            }

        } else {
            System.out.println("対象データなし");
        }
    }
}