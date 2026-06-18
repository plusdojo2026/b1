package test;

import dao.ContestsDAO;
import dto.Contest;

public class ContestsDAOTest {

    public static void main(String[] args) {

        ContestsDAO dao = new ContestsDAO();

        // -----------------------------
        // selectById テスト
        // -----------------------------
        System.out.println("---------- selectById()のテスト ----------");

        Contest c1 = dao.selectById(1);

        if (c1 != null) {
            System.out.println("ID：" + c1.getId());
            System.out.println("名前：" + c1.getName());
            System.out.println("開始日：" + c1.getStart_at());
            System.out.println("終了日：" + c1.getEnd_at());
            System.out.println();
        } else {
            System.out.println("データなし");
        }

        // -----------------------------
        // selectByName テスト
        // -----------------------------
        System.out.println("---------- selectByName()のテスト ----------");

        Contest c2 = dao.selectByName("第1回バーガー選手権");

        if (c2 != null) {
            System.out.println("ID：" + c2.getId());
            System.out.println("名前：" + c2.getName());
            System.out.println("開始日：" + c2.getStart_at());
            System.out.println("終了日：" + c2.getEnd_at());
            System.out.println();
        } else {
            System.out.println("データなし");
        }

        // -----------------------------
        // insert テスト
        // -----------------------------
        System.out.println("---------- insert()のテスト ----------");

        Contest ins = new Contest(
                0,
                "テストコンテスト",
                java.time.LocalDateTime.of(2026, 6, 1, 0, 0),
                java.time.LocalDateTime.of(2026, 6, 10, 23, 59),
                null,
                null
        );

        if (dao.insert(ins)) {
            System.out.println("登録成功！");

            Contest checkIns = dao.selectByName("テストコンテスト");
            if (checkIns != null) {
                System.out.println("ID：" + checkIns.getId());
                System.out.println("名前：" + checkIns.getName());
            }
        } else {
            System.out.println("登録失敗！");
        }

        // -----------------------------
        // update テスト
        // -----------------------------
        System.out.println("---------- update()のテスト ----------");

        Contest upRec = dao.selectByName("テストコンテスト");

        if (upRec != null) {
            upRec.setName("更新コンテスト");

            if (dao.update(upRec)) {
                System.out.println("更新成功！");

                Contest checkUp = dao.selectByName("更新コンテスト");
                if (checkUp != null) {
                    System.out.println("ID：" + checkUp.getId());
                    System.out.println("名前：" + checkUp.getName());
                }
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

        Contest delRec = dao.selectByName("更新コンテスト");

        if (delRec != null) {

            if (dao.delete(delRec.getId())) {
                System.out.println("削除成功！");

                Contest checkDel = dao.selectByName("更新コンテスト");
                System.out.println("削除後：" + checkDel);
            } else {
                System.out.println("削除失敗！");
            }

        } else {
            System.out.println("対象データなし");
        }
    }
}