package org.eugens21.user_interface.object;

import java.util.List;

public interface Menu<T> {

    List<T> getItems();

    T getItem(String name);

}
