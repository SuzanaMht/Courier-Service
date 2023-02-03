/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.css.dao;

import com.css.bll.Feedback;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public interface FeedbackDao {
    void SubmitFeedback(Feedback f) throws IOException;
    ArrayList<String> getAllFeedback() throws IOException;
    
}