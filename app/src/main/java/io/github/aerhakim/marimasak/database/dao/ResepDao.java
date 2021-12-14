package io.github.aerhakim.marimasak.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;

import java.util.List;

import io.github.aerhakim.marimasak.database.Resep;

@Dao
public interface ResepDao {
    @Query("SELECT * FROM resep")
    List<Resep> getAll();

    @Query("INSERT INTO Resep (title,thumb, times, portion, kunci, dificulty) VALUES(:title, :thumb, :times, :portion, :kunci, :dificulty)")
    void insertAll(String title, String thumb, String times, String portion,  String kunci, String dificulty);

    @Delete
    void delete(Resep resep);
}