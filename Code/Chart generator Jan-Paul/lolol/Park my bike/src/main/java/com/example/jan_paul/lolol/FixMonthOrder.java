package com.example.jan_paul.lolol;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.List;

import Design_Patterns.Adapted_List;
import Design_Patterns.IOptionVisitor;
import Design_Patterns.Option;
import Design_Patterns.OptionVisitor;

/**
 * Created by jan-paul on 6-7-2016.
 */
public class FixMonthOrder {
    public IOptionVisitor<Data, Data> the_visitor = new OptionVisitor<Data>();

    public FixMonthOrder(){
    }

    List<Data> FixMonth(List<Data> col){
        Adapted_List<Data> adaptedlist = new Adapted_List(col);
        Option<Data> thenewsome  = adaptedlist.GetNext();
        List<Data> copy = new ArrayList<>(col);
        while (thenewsome.IsSome()) {
            try {
                Data d = thenewsome.Visit(the_visitor);
                if (d.naam.equals("Januari")){
                    copy.set(0, d);
                }
                else if (d.naam.equals("Februari")){
                    copy.set(1, d);
                }
                else if (d.naam.equals("Maart")){
                    copy.set(2, d);
                }
                else if (d.naam.equals("April")){
                    copy.set(3, d);
                }
                else if (d.naam.equals("Mei")){
                    copy.set(4, d);
                }
                else if (d.naam.equals("Juni")){
                    copy.set(5, d);
                }
                else if (d.naam.equals("Juli")){
                    copy.set(6, d);
                }
                else if (d.naam.equals("Augustus")){
                    copy.set(7, d);
                }
                else if (d.naam.equals("September")){
                    copy.set(8, d);
                }
                else if (d.naam.equals("Oktober")){
                    copy.set(9, d);
                }
                else if (d.naam.equals("November")){
                    copy.set(10, d);
                }
                else if (d.naam.equals("December")){
                    copy.set(11, d);
                }
                thenewsome = adaptedlist.GetNext();
            }
            catch (Exception e){}
        }
        return copy;
    }

}
