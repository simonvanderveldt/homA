package st.alr.homer;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class RoomListActivity extends ListActivity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.room_list_container);
	    setListAdapter(((App)getApplicationContext()).getRoomsAdapter());
	}

	
	@Override
	public void onListItemClick(ListView listView, View view, int position, long id) {
		super.onListItemClick(listView, view, position, id);

		
		Intent detailIntent = new Intent(this, RoomDetailActivity.class);
		detailIntent.putExtra("id", ((Room)getListAdapter().getItem(position)).getId());
		startActivity(detailIntent);

	    
	}



	public void setActivateOnItemClick(boolean activateOnItemClick) {
		// When setting CHOICE_MODE_SINGLE, ListView will automatically
		// give items the 'activated' state when touched.
		getListView().setChoiceMode(
				activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
						: ListView.CHOICE_MODE_NONE);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
    
	 // Handle click events
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {		
	    case R.id.menu_settings:
	    	Intent intent = new Intent(RoomListActivity.this, SettingsActivity.class);
	        startActivity(intent);
	       return true;	
	    default:
	       return super.onOptionsItemSelected(item);
	    }
	 } 

}
