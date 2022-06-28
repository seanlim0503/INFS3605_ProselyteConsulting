package au.edu.unsw.infs3634.cryptobag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import au.edu.unsw.infs3634.cryptobag.API.Coin;
import au.edu.unsw.infs3634.cryptobag.API.CoinLoreResponse;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "MainActivity";
  private RecyclerView mRecyclerView;
  private CoinAdapter mAdapter;
  private RecyclerView.LayoutManager mLayoutManager;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get a handle to the RecyclerView
    mRecyclerView = findViewById(R.id.rvList);
    mRecyclerView.setHasFixedSize(true);

    // Instantiate a LinearLayoutManager
    mLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(mLayoutManager);

    // Implement ClickListener for list items
    CoinAdapter.RecyclerViewListener listener = new CoinAdapter.RecyclerViewListener() {
      @Override
      public void onClick(View view, String coinSymbol) {
        // Launch DetailActivity
        launchDetailActivity(coinSymbol);
      }
    };

    // Implement GSON library to convert JSON string to JAVA object
    Gson gson = new Gson();
    CoinLoreResponse response = gson.fromJson(CoinLoreResponse.jsonData, CoinLoreResponse.class);
    List<Coin> coins = response.getData();

    // Create an adapter instance and supply the coins data to be displayed
    mAdapter = new CoinAdapter((ArrayList<Coin>) coins, listener);
    mAdapter.sort(CoinAdapter.SORT_METHOD_NAME);
    // Connect the adapter with the RecyclerView
    mRecyclerView.setAdapter(mAdapter);

  }

  @Override
  // Instantiate the menu
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);
    SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
      @Override
      public boolean onQueryTextSubmit(String query) {
        mAdapter .getFilter().filter(query);
        return false;
      }

      @Override
      public boolean onQueryTextChange(String newText) {
        mAdapter.getFilter().filter(newText);
        return false;
      }
    });
    return true;
  }

  @Override
  // React to user interaction with the menu
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.sortName:
        mAdapter.sort(CoinAdapter.SORT_METHOD_NAME);
        return true;
      case R.id.sortValue:
        mAdapter.sort(CoinAdapter.SORT_METHOD_VALUE);
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  // Called when user taps on a row on the RecyclerView
  private void launchDetailActivity(String message){
    Intent intent = new Intent(MainActivity.this, DetailActivity.class);
    intent.putExtra(DetailActivity.INTENT_MESSAGE, message);
    startActivity(intent);
  }

}