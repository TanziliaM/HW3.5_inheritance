package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class ProductManagerTest {
        private ProductRepository repository = new ProductRepository();
        private ProductManager manager = new ProductManager(repository);

        Product product1 = new Book(1, "One", 100, "Author1");
        Product product2 = new Book(2, "Second", 200, "Author2");
        Product product3 = new Book(3, "Third", 300, "Author3");
        Product product4 = new Book(4, "Fourth", 400, "Author4");
        Product product5 = new Book(5, "Fifth", 500, "Author5");
        Product product6 = new Smartphone(6, "Sixth", 600, "Maker6");
        Product product7 = new Smartphone(7, "Seventh", 700, "Maker7");
        Product product8 = new Smartphone(8, "Eighth", 800, "Maker8");
        Product product9 = new Smartphone(9, "Ninth", 900, "Maker9");
        Product product10 = new Smartphone(10, "Tenth", 1000, "Maker10");

        @BeforeEach
        void setUp() {
            manager.addProduct(product1);
            manager.addProduct(product2);
            manager.addProduct(product3);
            manager.addProduct(product4);
            manager.addProduct(product5);
            manager.addProduct(product6);
            manager.addProduct(product7);
            manager.addProduct(product8);
            manager.addProduct(product9);
            manager.addProduct(product10);
        }
    @Test
    void searchByMakerBook() {
        Product[] actual = manager.searchBy("Author1");
        Product[] expected = {new Book(1, "One", 100, "Author1")};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByMakerSmartphone() {
        Product[] actual = manager.searchBy("Maker6");
        Product[] expected = {new Smartphone(6, "Sixth", 600, "Maker6")};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneName() {
        Product[] actual = manager.searchBy("Sixth");
        Product[] expected = {new Smartphone(6, "Sixth", 600, "Maker6")};
        assertArrayEquals(expected, actual);

    }

    @Test
    void searchByBookName() {
        Product[] actual = manager.searchBy("Second");
        Product[] expected = {new Book(2, "Second", 200, "Author2")};
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldRemoveById() {
        repository.removeById(7);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{product1, product2, product3, product4, product5, product6, product8, product9, product10};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByInvalidMaker() {
        Product[] actual = manager.searchBy("Maker11");
        Product[] expected = {};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByInvalidAuthor() {
        Product[] actual = manager.searchBy("Author6");
        Product[] expected = {};
        assertArrayEquals(expected, actual);

    }

}
