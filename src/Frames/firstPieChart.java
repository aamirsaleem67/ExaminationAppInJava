/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frames;

import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author ubit
 */
public class firstPieChart {

    firstPieChart() {
        String[] country={"Pakistan","UAE","London","SriLanka"};
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Pakistan", new Integer(25));
        dataset.setValue("UAE", new Integer(50));
        dataset.setValue("London", new Integer(75));
        dataset.setValue("SriLanka", new Integer(15));
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset);
        PiePlot p = (PiePlot) chart.getPlot();
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} {1}");
        
        
        p.setLabelGenerator(labelGenerator);
        p.setSimpleLabels(true);
        ChartFrame frame = new ChartFrame("Pie Chart", chart);
        frame.setVisible(true);
        frame.setSize(450, 550);
    }
}
