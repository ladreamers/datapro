package com.fork.cash.services.xxservice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListRecur {

    public static void main (String args[]) {

        Projection p1 = new Projection();
        p1.setClassification("CAT1");
        p1.setAmount(23);
        p1.setProjection_dt("1/30/2019");

        Projection p2 = new Projection();
        p2.setClassification("CAT2");
        p2.setAmount(323);
        p2.setProjection_dt("2/2/2019");

        Projection p3 = new Projection();
        p3.setClassification("CAT2");
        p3.setAmount(41);
        p3.setProjection_dt("1/31/2019");

        Projection p4 = new Projection();
        p4.setClassification("CAT2");
        p4.setAmount(1);
        p4.setProjection_dt("2/1/2019");

        Projection p5 = new Projection();
        p5.setClassification("CAT1");
        p5.setAmount(19);
        p5.setProjection_dt("2/1/2019");

        List<Projection> projection = new ArrayList<>();
        projection.add(p1);
        projection.add(p2);
        projection.add(p3);
        projection.add(p4);
        projection.add(p5);

        projection.sort(Comparator.comparing(Projection::getClassification));


        for (Projection p : projection){
            System.out.println(p.getClassification() + " -- " + p.getProjection_dt());
        }

    }




}

class Projection{
    private String classification;
    private String projection_dt;
    private Integer amount;


    public String getClassification() { return classification;     }
    public void setClassification(String classification) {  this.classification = classification;     }

    public String getProjection_dt() {
        return projection_dt;
    }

    public void setProjection_dt(String projection_dt) {
        this.projection_dt = projection_dt;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}

