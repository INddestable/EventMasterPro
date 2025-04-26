/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package utils;
import java.util.List;
import model.event.Event;
import model.ticket.Sale;
/**
 *
 * @author kevin
 */
public interface StadisticsGenerator {
    void generateAttendanceReport(List<Event> events);
    void generateSalesReport(List<Sale> sales);
    double getTotalRevenue(List<Event> events);
    String getEventStatistics(Event event);
}
