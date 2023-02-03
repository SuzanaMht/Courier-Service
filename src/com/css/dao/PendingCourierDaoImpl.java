/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.css.dao;

import com.css.bll.PendingCourier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class PendingCourierDaoImpl implements PendingCourierDao {

    @Override
    public void SaveCourier(PendingCourier pc) throws IOException {
        try{
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("PendingCourier.txt", true))) {
            bw.write(pc.getParcelNo() + "," + pc.getCustomerName() + "," + pc.getCustomerPhone() + "," 
                    + pc.getDeliveryDate() + "," +pc.getProduct()+","+pc.getDestination()+","+pc.getStatus());
            bw.flush();
            bw.newLine();
            bw.close();
        }
    }
        catch (IOException ex){
            System.out.println(ex);
    }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    @Override
    public void deleteCourier(String Parcelno) throws IOException {
        String search;
        File oldfile = new File("PendingCourierTmp.txt");
        File newfile = new File("PendingCourier.txt");
        
        BufferedWriter bw;
        try (BufferedReader br = new BufferedReader(new FileReader(newfile))){
            bw = new BufferedWriter(new FileWriter(oldfile));
            while ((search = br.readLine()) != null) {
            String split[] = search.split (",");
            if (split[0].contains(Parcelno)) {
            continue;
            }
            bw.write(Parcelno);
            bw.flush();
            bw.newLine();
            }
    }
        bw.close();
        
        if (newfile.delete()) {
        oldfile.renameTo(newfile);
        }
        else{
        JOptionPane.showMessageDialog(null,"Delete Courier Successful");
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllCourier() throws IOException {
         ArrayList<String> fileData = new ArrayList<>();
        FileReader fr = new FileReader("PendingCourier.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            fileData.add(line);
        }
        return fileData;
    

       
    }
}
