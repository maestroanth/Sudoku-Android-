package org.example.sudoku;
/*
 * use bluestacks emulator. android apps use .apk extension, so open bluestacks search 
 * for .apk extension to debug on bluestacks.
 */
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

public class MainActivity extends Activity implements OnClickListener {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Set up click listeners for all the buttons
		View continueButton = findViewById(R.id.continue_button);
		View newButton = findViewById(R.id.new_button);
		View aboutButton = findViewById(R.id.about_button);
		View exitButton = findViewById(R.id.exit_button);
		aboutButton.setOnClickListener(this);
		newButton.setOnClickListener(this);
		exitButton.setOnClickListener(this);
		continueButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()){
		case R.id.settings:
			startActivity(new Intent(this, Prefs.class));
			return true;
		}
		return false;
	}
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.about_button:
			Intent i = new Intent(this, About.class);
			startActivity(i);
			break;
		case R.id.continue_button:
			i = new Intent(this, About.class);
			startActivity(i);
			break;
		case R.id.new_button:
			openNewGameDialog();
			break;
		case R.id.exit_button:
			finish();
			break;
			
		}
	}


private static final String TAG = "Sudoku";
private void openNewGameDialog() {
	new AlertDialog.Builder(this)
		.setTitle(R.string.new_game_title)
		.setItems(R.array.difficulty,
		new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialoginterface,
					int i) {
				startGame(i);
			}
		})
		.show();
}
//Start game here.......
private void startGame(int i) {
	Log.d(TAG, "clicked on " + i);
	Intent intent = new Intent(this, Game.class);
	intent.putExtra(Game.KEY_DIFFICULTY, i);
	startActivity(intent);
}
}