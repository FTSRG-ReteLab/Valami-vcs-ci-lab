package hu.bme.mit.train.system;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;

import java.util.List;

public class Tachograph {

    // creating a table
    Table<String, String, Integer>  tachoTable;

    public Tachograph()
    {

        List<String> dataRowTable
                = Lists.newArrayList("Data");
        List<String> elementColumnTables
                = Lists.newArrayList("Time", "Position", "Speed");
        tachoTable
                = ArrayTable.create(dataRowTable, elementColumnTables);

    }

    public void put(int a, int b, int c)
    {
        tachoTable.put("Data", "Time", a);
        tachoTable.put("Data", "Position", b);
        tachoTable.put("Data", "Speed", c);

    }

    public boolean isEmpty()
    {
        return tachoTable.isEmpty();
    }


}
