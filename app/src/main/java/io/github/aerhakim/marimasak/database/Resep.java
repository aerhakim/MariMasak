package io.github.aerhakim.marimasak.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Resep {
    @PrimaryKey
    public int uid;
    @ColumnInfo
    public String title;
    public String thumb;
    public String times;
    public String portion;
    public String dificulty;
    public String kunci;
}
