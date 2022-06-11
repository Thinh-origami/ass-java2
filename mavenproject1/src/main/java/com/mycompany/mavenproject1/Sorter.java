/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author nguth
 */
public class Sorter {
    private QLNV<NhanVien> _qlnv;
    private HashMap<String, Comparator<NhanVien>> _sorter;
    public Sorter(QLNV ql) {
        _qlnv = new QLNV<>();
        _sorter = new HashMap<String, Comparator<NhanVien>>()
        {{
            put("id",
                (NhanVien o1, NhanVien o2) -> o1
                        .getId()
                        .compareTo(o2
                                .getId()));
            put("name",
                (NhanVien o1, NhanVien o2) -> o1
                        .getName()
                        .compareTo(o2
                                .getName()));
            put("date",
                (NhanVien o1, NhanVien o2) -> o1
                        .getDate()
                        .compareTo(o2
                                .getDate()));
            put("salary",
                (NhanVien o1, NhanVien o2) -> o1
                        .getSalary()
                        .compareTo(o2
                                .getSalary()));
            put("sex",
                (NhanVien o1, NhanVien o2) -> o1
                        .isSex()
                        .compareTo(o2
                                .isSex()));
            put("position",
                (NhanVien o1, NhanVien o2) -> o1
                        .getPosition()
                        .compareTo(o2
                                .getPosition()));
        }};
    }

    public HashMap<String, Comparator<NhanVien>> getSorter() {
        return _sorter;
    }
}
