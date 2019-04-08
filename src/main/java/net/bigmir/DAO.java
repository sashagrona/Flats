package net.bigmir;

import java.util.List;

public interface DAO{
    void init();
    void addFlat(Flat flat);
    void removeFlat(int id);
    List<Flat> getFlats();
}
