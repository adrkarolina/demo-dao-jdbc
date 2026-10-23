package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("============== Test 1: Seller findById ==============");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("============== Test 2: Seller findByDepartment ==============");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("============== Test 3: Seller findAll ==============");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }

        System.out.println("============== Test 4: Seller insert ==============");
        Seller newSeller = new Seller(null, "Teste", "teste@teste.com", new Date(), 4500.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted seller with id: " + newSeller.getId());
    }
}
