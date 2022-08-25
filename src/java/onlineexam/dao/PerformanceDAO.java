/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package onlineexam.dao;

import java.util.List;
import onlineexam.entity.Performance;

/**
 *
 * @author SHUBHAM MANMOHAN
 */
public interface PerformanceDAO {
    public boolean addPerformance(Performance pr);
    public List<Performance> getPerformance(String userId);
    public List<Performance> getAllPerformance();
}
