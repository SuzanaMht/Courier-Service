/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.css.dao;

import com.css.bll.PendingCourier;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public interface PendingCourierDao {
    
     void SaveCourier(PendingCourier pc) throws IOException;
     void deleteCourier(String Parcelno) throws IOException;
    ArrayList<String> getAllCourier() throws IOException;
}
