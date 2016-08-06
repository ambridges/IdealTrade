package com.hfad.idealtrade.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.hfad.idealtrade.fragments.LandingFragment;
import com.hfad.idealtrade.R;
import com.hfad.idealtrade.fragments.PlaceholderFragment;

/**
 *
 * Created by Alex on 04/08/2016.
 */
public class AppActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Toolbar toolbar;

    private FragmentManager fragmentManager;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Associate a layout file
        setContentView(R.layout.activity_app);

        // Initialise fields
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fragmentManager = getSupportFragmentManager();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);

        // Set up toolbar
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // Configure & display hamburger icon
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        // Set landing fragment to main content area
        if (savedInstanceState == null) {
            setMainFragment(new LandingFragment());
        }
    }

    /**
     * Change the main display area to a given page (fragment)
     *
     * @param fragment desired fragment to load
     */
    private void setMainFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.landingFragmentContainer, fragment)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();

        // Define navigation item behaviour
        switch (id) {
            case R.id.edit_profile:
                // TODO implement proper profile & associated settings
                Intent editIntent = new Intent(this, MainActivity.class);
                startActivity(editIntent);
                break;
            case R.id.post_skill:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.post_item:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.simple_request:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.account_management:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.inbox:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.contacts:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.privacy_settings:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.video_sharing:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.file_sharing:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.trading_overview:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.trades:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.favourite_listings:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.my_listings:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.notifications:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.feedback:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.verify_account:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.comments:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.take_action:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.invite_friends:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.suggestion_box:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.complaints:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.donations:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.queries:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.settings:
                setMainFragment(new PlaceholderFragment());
                setTitle("Placeholder" + id);
                break;
            case R.id.log_out:
                // TODO implement proper log off function
                Intent logOffIntent = new Intent(this, MainActivity.class);
                startActivity(logOffIntent);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {

        // If back is pressed when the drawer is open, close it.
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
