/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.css.dao;

import com.css.bll.Feedback;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class FeedbackDaoImpl implements FeedbackDao {

    @Override
    public void SubmitFeedback(Feedback f) throws IOException {
         FileWriter fw=new FileWriter("Feedback.txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(f.getParcelNo()+","+f.getAddress()+","+f.getContact()+","+f.getProducts()+"," +f.getDate()+","+f.getCustomerName()+","+f.getMessage());
        bw.flush();
        bw.newLine();
        bw.close();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getAllFeedback() throws IOException {
        
         ArrayList<String> fileData=new ArrayList<>();
      FileReader fr=new FileReader("Feedback.txt");
      BufferedReader br=new BufferedReader(fr);
      String line;
      while((line=br.readLine())!=null){
          fileData.add(line);
          return fileData;
      }
      
     
      throw new UnsupportedOperationException("Not supported yet.");
      
//To change body of generated methods, choose Tools | Templates.
    }
    
}
