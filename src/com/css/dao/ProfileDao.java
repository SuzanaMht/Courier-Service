/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.css.dao;

import java.io.IOException;
import java.util.ArrayList;
import com.css.bll.Profile;

/**
 *
 * @author Raju
 */
public interface ProfileDao {
    void submitProfile(Profile ab) throws IOException;
    void deleteProfile(String Id) throws IOException;
    void listProfile(int Id);
    ArrayList<String> getAllProfiles() throws IOException;
    
}
