package org.example.chapter10.practice01;

// Manageable + able 할수있는

import java.util.List;

public interface Manageable {
    void add(Item item);
    void listAll();
    void remove(String id);
    void updateStock(String Id, int quantity);

    List<Item> search(String keyword);

}
