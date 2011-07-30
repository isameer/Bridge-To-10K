package fitness.bridgeto10k;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListWorkouts extends ListActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTitle("This is my home screen");
        //setContentView(R.layout.main);
        
        //String[] workouts = {"Run" , "Run longer" , "Run harder" , "Run harder and longer"};
        ArrayList<Workout> workouts = DataService.getAllWorkouts();
        
        System.out.println("Created workouts struct");
        //ListAdapter adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , workouts);
        //ListAdapter adapter = new ArrayAdapter<String>(this , R.layout.list_item , workouts);
        ListAdapter adapter = new WorkoutArrayAdapter(this , R.layout.list_item , workouts);
        System.out.println("Created adapter object");
        setListAdapter(adapter);
        System.out.println("Set custom adapter");
        
        //getListView().setTextFilterEnabled(true);
    }
    
    @Override
    protected void onListItemClick (ListView l, View v, int position, long id)
    {
    	super.onListItemClick(l, v, position, id);
    	System.out.println("List item at position " + id + " was clicked");
    	Intent i = new Intent(this , DoWorkout.class);
    	i.putExtra("id", id);
    	i.putExtra("title" , "Title " + id);
    	startActivity(i);
    }
}

class Workout
{
	String m_title;
	String m_description;
	
	public String getM_description() {
		return m_description;
	}

	public void setM_description(String m_description) {
		this.m_description = m_description;
	}

	public String getM_title() {
		return m_title;
	}

	public void setM_title(String m_title) {
		this.m_title = m_title;
	}
}

class WorkoutArrayAdapter extends ArrayAdapter<Workout>
{
	
	private LayoutInflater m_Inflater;
	int m_rowView;
	ArrayList<Workout> m_workouts;
	
	public WorkoutArrayAdapter(Context context , int textViewResourceId , ArrayList<Workout> objects)
	{
		super(context , textViewResourceId , objects);
		System.out.println("constructor of workoutarrayadapter");
		m_Inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		m_workouts = objects;
	}
	
	@Override
	public View getView (int position, View convertView, ViewGroup parent)
	{
		System.out.println("Obtaining view");
		View v = m_Inflater.inflate(R.layout.list_item , parent , false);
			
		System.out.println("Obtained and inflated view " + v.toString());
		TextView titleView = (TextView) v.findViewById(R.id.title);
		System.out.println("Found textview title field in row " + titleView.toString());
		Workout w = DataService.getNthWorkout(position);
		System.out.println("Got workout at position " + position);
		
		titleView.setText(w.getM_title());
		//titleView.setText("Title " + position);
		System.out.println("Set title of row");
		
		return v;
	}
}


/*
class WorkoutArrayAdapter extends BaseAdapter
{
	private ArrayList<Workout> m_workouts;
	private LayoutInflater m_Inflater;
	int m_rowView;
	
	public long getItemId(int position)
	{
		return (long) position;
	}
	
	public int getCount()
	{
		return DataService.getNumberofworkouts();
	}
	
	public Workout getItem(int position)
	{
		Workout w = DataService.getNthWorkout(position);
		return w;
	}
	
	
	@Override
	public View getView (int position, View convertView, ViewGroup parent)
	{
		View v = m_Inflater.inflate(R.layout.list_item , parent , false);
		System.out.println("Obtained and inflated view " + v.toString());
		TextView titleView = (TextView) v.findViewById(R.id.title);
		System.out.println("Found textview title field in row " + titleView.toString());
		Workout w = m_workouts.get(position);
		System.out.println("Got workout at position " + position);
		
		titleView.setText(w.getM_title());
		System.out.println("Set title of row");
		
		return v;
	}
}
*/