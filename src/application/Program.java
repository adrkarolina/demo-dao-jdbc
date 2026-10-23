package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("\n============== Test 1: Seller findById ==============");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n============== Test 2: Seller findByDepartment ==============");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n============== Test 3: Seller findAll ==============");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("\n============== Test 4: Seller insert ==============");
        Seller newSeller = new Seller(null, "Teste", "teste@teste.com", new Date(), 4500.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted seller with id: " + newSeller.getId());


        System.out.println("\n============== Test 5: Seller update ==============");
        seller = sellerDao.findById(2);
        seller.setName("Marta Teste");
        sellerDao.update(seller);
        System.out.println("Updated complete");


        System.out.println("\n============== Test 6: Seller delete ==============");
        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Deleted seller with id: " + id);

        sc.close();
    }


}
