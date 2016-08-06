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
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

import com.hfad.idealtrade.R;
import com.hfad.idealtrade.fragments.CommentsFragment;
import com.hfad.idealtrade.fragments.ComplaintsFragment;
import com.hfad.idealtrade.fragments.ContactsFragment;
import com.hfad.idealtrade.fragments.DonationsFragment;
import com.hfad.idealtrade.fragments.FavouritesFragment;
import com.hfad.idealtrade.fragments.FeedbackFragment;
import com.hfad.idealtrade.fragments.FileSharingFragment;
import com.hfad.idealtrade.fragments.InboxFragment;
import com.hfad.idealtrade.fragments.InviteFragment;
import com.hfad.idealtrade.fragments.LandingFragment;
import com.hfad.idealtrade.fragments.MyListingsFragment;
import com.hfad.idealtrade.fragments.PostItemFragment;
import com.hfad.idealtrade.fragments.PostSkillFragment;
import com.hfad.idealtrade.fragments.PrivacyFragment;
import com.hfad.idealtrade.fragments.QueriesFragment;
import com.hfad.idealtrade.fragments.SimpleRequestFragment;
import com.hfad.idealtrade.fragments.SuggestionsFragment;
import com.hfad.idealtrade.fragments.TradesFragment;
import com.hfad.idealtrade.fragments.VerifyFragment;
import com.hfad.idealtrade.fragments.VideoSharingFragment;

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
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set up navigation listeners
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

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
                setMainFragment(new PostSkillFragment());
                setTitle("Post a Skill");
                break;
            case R.id.post_item:
                setMainFragment(new PostItemFragment());
                setTitle("Post an Item");
                break;
            case R.id.simple_request:
                setMainFragment(new SimpleRequestFragment());
                setTitle("Make a Simple Request");
                break;
            case R.id.account_management:
                // TODO implement expanding menu section
                Intent accManageIntent = new Intent(this, MainActivity.class);
                startActivity(accManageIntent);
                break;
            case R.id.inbox:
                setMainFragment(new InboxFragment());
                setTitle("Inbox");
                break;
            case R.id.contacts:
                setMainFragment(new ContactsFragment());
                setTitle("Contacts");
                break;
            case R.id.privacy_settings:
                setMainFragment(new PrivacyFragment());
                setTitle("Privacy Settings");
                break;
            case R.id.video_sharing:
                setMainFragment(new VideoSharingFragment());
                setTitle("Video Sharing");
                break;
            case R.id.file_sharing:
                setMainFragment(new FileSharingFragment());
                setTitle("File Sharing");
                break;
            case R.id.trading_overview:
                // TODO implement expanding menu section
                Intent tradingIntent = new Intent(this, MainActivity.class);
                startActivity(tradingIntent);
                break;
            case R.id.trades:
                setMainFragment(new TradesFragment());
                setTitle("trades");
                break;
            case R.id.favourite_listings:
                setMainFragment(new FavouritesFragment());
                setTitle("Favourite Listings");
                break;
            case R.id.my_listings:
                setMainFragment(new MyListingsFragment());
                setTitle("My Listings");
                break;
            case R.id.notifications:
                // TODO implement expanding menu section
                Intent notificationsIntent = new Intent(this, MainActivity.class);
                startActivity(notificationsIntent);
                break;
            case R.id.feedback:
                setMainFragment(new FeedbackFragment());
                setTitle("Feedback");
                break;
            case R.id.verify_account:
                setMainFragment(new VerifyFragment());
                setTitle("Verify Account");
                break;
            case R.id.comments:
                setMainFragment(new CommentsFragment());
                setTitle("Comments");
                break;
            case R.id.take_action:
                // TODO implement expanding menu section
                Intent actionIntent = new Intent(this, MainActivity.class);
                startActivity(actionIntent);
                break;
            case R.id.invite_friends:
                setMainFragment(new InviteFragment());
                setTitle("Invite Friends");
                break;
            case R.id.suggestion_box:
                setMainFragment(new SuggestionsFragment());
                setTitle("Suggestion Box");
                break;
            case R.id.complaints:
                setMainFragment(new ComplaintsFragment());
                setTitle("Complaints");
                break;
            case R.id.donations:
                setMainFragment(new DonationsFragment());
                setTitle("Donations");
                break;
            case R.id.queries:
                setMainFragment(new QueriesFragment());
                setTitle("Queries");
                break;
            case R.id.settings:
                // TODO implement settings
                Intent settingsIntent = new Intent(this, MainActivity.class);
                startActivity(settingsIntent);
                break;
            case R.id.log_out:
                // TODO implement proper log off function
                Intent logOffIntent = new Intent(this, MainActivity.class);
                startActivity(logOffIntent);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.END);
        return true;
    }

    @Override
    public void onBackPressed() {

        // If back is pressed when the drawer is open, close it.
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }
}
