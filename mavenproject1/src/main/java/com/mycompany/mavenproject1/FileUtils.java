/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.*;
/**
 *
 * @author nguth
 */
class FileUtils {
    
    public final static byte __IN__ = 1;
    public final static byte __OUT__ = 0;
    public final static byte __IN_OUT__ = 2;
    
    private ObjectOutputStream _os;
    private ObjectInputStream _is;
    byte _mode;
    public FileUtils() {

    }

    public FileUtils(String fo, String fi) throws IOException {
        _os = new ObjectOutputStream(
                new FileOutputStream(
                        new File(fo)));
        
        _is = new ObjectInputStream(
                new FileInputStream(
                        new File(fo)));
    }

    public FileUtils open(String file_name, byte mode) throws FileNotFoundException, IOException {
        _mode = mode;
        switch (_mode) {
            case __IN__:
                this._is = new ObjectInputStream(
                                new FileInputStream(
                                    new File(file_name)));
                break;
            case __OUT__:
                this._os = new ObjectOutputStream(
                                new FileOutputStream(
                                    new File(file_name)));
                break;
            case __IN_OUT__:
//                this(file_name, file_name);
                break;
        }
        return this;
    }

    public FileUtils write(QLNV<NhanVien> obj) {
        try {
            _os.writeObject(obj);
        } catch(Exception e) {
            System.out.print(e.getMessage());
            return this;
        }
        return this;
    }

    public QLNV<NhanVien> read() {
        try {
            return (QLNV<NhanVien>)_is.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new QLNV<NhanVien>();
        }
        // for (NhanVien i: obj) {
        //     System.out.println(i.toString());
        // }
    }

    public FileUtils close() throws IOException {

       switch (_mode) {
           case __IN__:
               _is.close();
               break;
           case __OUT__:
               _os.close();
               break;
       }
        return this;
    }
}