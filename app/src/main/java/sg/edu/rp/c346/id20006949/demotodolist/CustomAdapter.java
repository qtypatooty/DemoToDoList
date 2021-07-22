package sg.edu.rp.c346.id20006949.demotodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<ToDoItem> alToDoList;
    public CustomAdapter(Context context, int resource, ArrayList<ToDoItem> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        alToDoList = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvToDo = rowView.findViewById(R.id.tvToDo);
        TextView tvDate = rowView.findViewById(R.id.tvDate);

        // Obtain the Android Version information based on the position
        ToDoItem todo = alToDoList.get(position);

        // Set values to the TextView to display the corresponding information

        tvToDo.setText(todo.getTitle());
        String str = todo.getDate().get(Calendar.DAY_OF_MONTH)+"/"+todo.getDate().get(Calendar.MONTH)
                +"/"+todo.getDate().get(Calendar.YEAR) + " (" + getDay(todo.getDate().get(Calendar.DAY_OF_WEEK)) + ")";

        tvDate.setText(str);

        return rowView;
    }
    private String getDay(int day) {
        switch (day) {
            case 1: return "Monday";

            case 2: return "Tuesday";

            case 3: return "Wednesday";

            case 4: return "Thursday";

            case 5: return "Friday";

            case 6: return "Saturday";

            case 7: return "Sunday";

            default: return "";
        }
    }
}
