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
import android.view.MenuItem;

import com.hfad.idealtrade.R;
import com.hfad.idealtrade.fragments.ComplaintsFragment;
import com.hfad.idealtrade.fragments.DonationsFragment;
import com.hfad.idealtrade.fragments.InviteFragment;
import com.hfad.idealtrade.fragments.LandingFragment;
import com.hfad.idealtrade.fragments.QueriesFragment;
import com.hfad.idealtrade.fragments.SuggestionsFragment;
import com.hfad.idealtrade.utilities.Globals;

/**
 *
 * Created by Alex on 28/07/2016.
 */
public class SettingsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public Toolbar toolbar;

    private FragmentManager fragmentManager;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    private Boolean activeActivity;

    private Globals globals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Initialise fields
        globals = Globals.getInstance();
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
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set up navigation listeners
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

    }

    /**
     * Change the main display area to a given page (fragment)
     *
     * @param fragment desired fragment to load
     */
    private void setMainFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace(R.id.tradingFragmentContainer, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();
        Intent appIntent = new Intent(this, AppActivity.class);
        Intent accManageIntent = new Intent(this, AccountActivity.class);
        Intent tradingIntent = new Intent(this, TradingActivity.class);
        Intent notificationsIntent = new Intent(this, NotificationActivity.class);
        Intent actionIntent = new Intent(this, ActionActivity.class);


        // Define navigation item behaviour
        switch (id) {
            case R.id.home:
                setMainFragment(new LandingFragment());
                setTitle("Ideal Trade");
                break;
            case R.id.edit_profile:
                // TODO implement proper profile & associated settings
                Intent editIntent = new Intent(this, AccountActivity.class);
                startActivity(editIntent);
                break;
            case R.id.post_skill:
                appIntent.putExtra("fragment", Globals.SKILL);
                startActivity(appIntent);
                break;
            case R.id.post_item:
                appIntent.putExtra("fragment", Globals.ITEM);
                startActivity(appIntent);
                break;
            case R.id.simple_request:
                appIntent.putExtra("fragment", Globals.REQUEST);
                startActivity(appIntent);
                break;
            case R.id.account_management:
                // TODO implement expanding menu section
                accManageIntent.putExtra("fragment", Globals.PROFILE);
                startActivity(accManageIntent);
                break;
            case R.id.inbox:
                accManageIntent.putExtra("fragment", Globals.INBOX);
                startActivity(accManageIntent);
                break;
            case R.id.contacts:
                accManageIntent.putExtra("fragment", Globals.CONTACTS);
                startActivity(accManageIntent);
                break;
            case R.id.privacy_settings:
                accManageIntent.putExtra("fragment", Globals.PRIVACYSETTINGS);
                startActivity(accManageIntent);
                break;
            case R.id.video_sharing:
                accManageIntent.putExtra("fragment", Globals.VIDEOSHARING);
                startActivity(accManageIntent);
                break;
            case R.id.file_sharing:
                accManageIntent.putExtra("fragment", Globals.FILESHARING);
                startActivity(accManageIntent);
                break;
            case R.id.trading_overview:
                // TODO implement expanding menu section
                tradingIntent.putExtra("fragment", Globals.TRADES);
                startActivity(tradingIntent);
                break;
            case R.id.trades:
                tradingIntent.putExtra("fragment", Globals.TRADES);
                startActivity(tradingIntent);
                break;
            case R.id.favourite_listings:
                tradingIntent.putExtra("fragment", Globals.FAVOURITELISTINGS);
                startActivity(tradingIntent);
                break;
            case R.id.my_listings:
                tradingIntent.putExtra("fragment", Globals.MYLISTINGS);
                startActivity(tradingIntent);
                break;
            case R.id.notifications:
                // TODO implement expanding menu section
                notificationsIntent.putExtra("fragment", Globals.FEEDBACK);
                startActivity(notificationsIntent);
                break;
            case R.id.feedback:
                notificationsIntent.putExtra("fragment", Globals.FEEDBACK);
                startActivity(notificationsIntent);
                break;
            case R.id.verify_account:
                notificationsIntent.putExtra("fragment", Globals.VERIFYACCOUNT);
                startActivity(notificationsIntent);
                break;
            case R.id.comments:
                notificationsIntent.putExtra("fragment", Globals.COMMENTS);
                startActivity(notificationsIntent);
                break;
            case R.id.take_action:
                // TODO implement expanding menu section
                actionIntent.putExtra("fragment", Globals.INVITEFRIENDS);
                startActivity(actionIntent);
                break;
            case R.id.invite_friends:
                actionIntent.putExtra("fragment", Globals.INVITEFRIENDS);
                startActivity(actionIntent);
                break;
            case R.id.suggestion_box:
                actionIntent.putExtra("fragment", Globals.SUGGESTIONBOX);
                startActivity(actionIntent);
                break;
            case R.id.complaints:
                actionIntent.putExtra("fragment", Globals.COMPLAINTS);
                startActivity(actionIntent);
                break;
            case R.id.donations:
                actionIntent.putExtra("fragment", Globals.DONATIONS);
                startActivity(actionIntent);
                break;
            case R.id.queries:
                actionIntent.putExtra("fragment", Globals.QUERIES);
                startActivity(actionIntent);
                break;
            case R.id.settings:
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

    @Override
    protected void onResume() {
        super.onResume();
        activityResumed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityPaused();
    }

    private void activityResumed(){
        this.activeActivity = true;
    }

    private void activityPaused(){
        this.activeActivity = false;
    }

    public boolean getActive(){
        return activeActivity;
    }

}
