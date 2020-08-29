package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PurchaseItem;
import ru.netology.manager.CartManager;

import static org.junit.jupiter.api.Assertions.*;

public class CartManagerTest {
    private CartManager manager = new CartManager();
    private PurchaseItem first = new PurchaseItem(1, 1, "first", 1, 1);
    private PurchaseItem second = new PurchaseItem(2, 2, "second", 2, 2);
    private PurchaseItem third = new PurchaseItem(3, 3, "third", 3, 3);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }


    @Test
    void shouldAdd() {
        PurchaseItem item = new PurchaseItem();
        manager.add(item);

        PurchaseItem[] expected = new PurchaseItem[]{item};
        assertArrayEquals(expected, manager.getItems());
    }

    @Test
    void shouldRemoveIfExist() {
        int idToRemove = 1;
        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveIfNotExist() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        PurchaseItem[] actual = manager.getAll();
        PurchaseItem[] expected = new PurchaseItem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }


}