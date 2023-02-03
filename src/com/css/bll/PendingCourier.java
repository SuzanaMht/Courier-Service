/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.css.bll;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class PendingCourier {
  private String Parcelno;
  private String CustomerName;
  private String CustomerPhone;
  private String DeliveryDate;
  private String Product;
  private String Destination;
  private String Status;

  
    public String getParcelNo(){
        return Parcelno;
    }

    public void setParcelno(String Parcelno) {
        this.Parcelno = Parcelno;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getCustomerPhone() {
        return CustomerPhone;
    }

    public void setCustomerPhone(String CustomerPhone) {
        this.CustomerPhone = CustomerPhone;
    }

    public String getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(String DeliveryDate) {
        this.DeliveryDate = DeliveryDate;
    }

    public String getProduct() {
        return Product;
    }

    public void setProduct(String Product) {
        this.Product = Product;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String Destination) {
        this.Destination = Destination;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

 public void Update(String Parcelno, String CustomerName, String CustomerPhone,
            String DeliveryDate, String Product,String Destination, String Status)
        { 
          BufferedReader br = null;
            try {
            File newfile = new File("PendingCourier.txt");
            File oldfile = new File("pendingCourierTmp.txt");
            br = new BufferedReader(new FileReader(newfile));
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(oldfile))) {
                String search;
                while ((search = br.readLine()) != null) {
                    String split[] = search.split("  ");
                    if (split[0].contains(Parcelno)) {

                        bw.write(Parcelno+ "  " + CustomerName + "  " + CustomerPhone
                                + "  " + DeliveryDate +" " + Product +" "+Destination+" "+Status+" ");
                    
                    } else {
                        bw.write(search);
                    }

                    bw.flush();
                    bw.newLine();

                }

                br.close();
            }

            if (newfile.delete()) {
                JOptionPane.showMessageDialog(null, "Courier Updated succesfully");
                oldfile.renameTo(newfile);
            }
            else{
            JOptionPane.showMessageDialog(null,"Error");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(Profile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }   

    public void Update(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
