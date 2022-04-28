package edu.school21.repositories;

import edu.school21.models.Product;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Isolated;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@Isolated
public class ProductsRepositoryJdbcImplTest {

    ProductsRepository prRep;
    EmbeddedDatabase dataSource;

    final List<Product> EXPECTED_FIND_ALL_PRODUCTS = Arrays.asList(
            new Product("milkshake", 210),
            new Product("cake pops", 37),
            new Product("marshmallow", 120),
            new Product("popcorn", 350),
            new Product("chupa-chups", 40)
    );
    final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(1L, "milkshake", 210);
    final Product EXPECTED_UPDATE_PRODUCT = new Product(2L, "kitkat", 70);
    final Product EXPECTED_SAVED_PRODUCT = new Product(6L, "twix", 75);

    @BeforeEach
            void init() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL)
                .addScript("schema.sql")
                .addScript("data.sql")
                .build();
        prRep = new ProductsRepositoryJdbcImpl(dataSource);
    }

    @Test
    void testFindAll() throws SQLException {
        Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, prRep.findAll());
    }

    @Test
    void testFindById() throws SQLException {
        Assertions.assertEquals(prRep.findById(1L).get(), EXPECTED_FIND_BY_ID_PRODUCT);
    }

    @Test
    void testUpdate() throws SQLException {
        prRep.update(EXPECTED_UPDATE_PRODUCT);
        Assertions.assertEquals(prRep.findById(2L).get(), EXPECTED_UPDATE_PRODUCT);
    }

    @Test
    void testSave() throws SQLException {
        prRep.save(EXPECTED_SAVED_PRODUCT);
        Assertions.assertEquals(prRep.findById(6L).get(), EXPECTED_SAVED_PRODUCT);
    }

    @Test
    void testDelete() throws SQLException {
        prRep.delete(1L);
        Assertions.assertThrows(RuntimeException.class, () -> prRep.findById(1L));
    }

    @AfterEach
    void close() {
        dataSource.shutdown();
    }
}
