package test;

import dao.CategoriesDAO;
import dto.Category;

public class CategoriesDAOTest {

	public static void main(String[] args) {
		CategoriesDAO dao = new CategoriesDAO();

		// selectById()のテスト
		System.out.println("---------- selectById()のテスト----------");
		Category categorySelectId=dao.selectById(3);
		System.out.println(categorySelectId.getName());
		
		// selectByName()のテスト
		System.out.println("---------- selectByName()のテスト ----------");
		Category categorySelectName=dao.selectByName("パティ");
		System.out.println(categorySelectName.getId());
		System.out.println(categorySelectName.getName());

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		if (dao.insert("肉")) {
			System.out.println("登録成功！");
			Category categoryInsert=dao.selectByName("肉");
			System.out.println(categoryInsert.getId());
			System.out.println(categoryInsert.getName());
		} else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Category categoryup = dao.selectByName("肉");
		categoryup.setName("牛肉");
		if (dao.update(categoryup)) {
			System.out.println("更新成功！");
			categoryup = dao.selectByName("牛肉");
			System.out.println(categoryup.getId());
			System.out.println(categoryup.getName());
		} else {
			System.out.println("更新失敗！");
		}

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		Category categorydel = dao.selectByName("牛肉");
		int delRec2=categorydel.getId();
		if (dao.delete(delRec2)) {
			System.out.println("削除成功！");
			categorydel = dao.selectByName("牛肉");
			System.out.println(categorydel.getId());
			System.out.println(categorydel.getName());
		} else {
			System.out.println("削除失敗！");
		}
	}
}