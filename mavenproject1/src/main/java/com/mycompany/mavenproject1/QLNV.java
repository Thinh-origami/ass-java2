/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.Serializable;
import java.util.ArrayList;


interface NhanVienDAO<T> {
    public boolean then(int index, T bj);
    public boolean sua(int index, T obj);
    public boolean xoa(int index);
}

/**
 *
 * @author nguth
 */
public class QLNV<T> extends ArrayList<T> implements NhanVienDAO<T>, Serializable {

    @Override
    public boolean then(int index, T obj) {
        this.add(index, obj);
        return true;
    }

    @Override
    public boolean sua(int index, T obj) {
        this.set(index, obj);
        return true;
    }

    @Override
    public boolean xoa(int index) {
        this.remove(index);
        return true;
    }
    
}
