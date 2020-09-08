package com.launchcenter.ui.activities.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.launchcenter.R;
import com.launchcenter.ui.activities.login.LoginActivity;
import com.launchcenter.ui.fragments.chatHistory.ChatHistoryAdapter;
import com.launchcenter.ui.fragments.chatHistory.ChatHistoryFragment;
import com.launchcenter.ui.fragments.explore.ExploreFragment;
import com.launchcenter.ui.fragments.help.HelpFragment;
import com.launchcenter.ui.fragments.home.HomeFragment;
import com.launchcenter.ui.fragments.launchPremium.LaunchPremiumFragment;
import com.launchcenter.ui.fragments.myBooking.MyBookingsFragment;
import com.launchcenter.ui.fragments.newsfeed.NewsFeedFragment;
import com.launchcenter.ui.fragments.payments.PaymentsFragment;
import com.launchcenter.ui.fragments.premiumPosts.PremiumPostsFragment;
import com.launchcenter.ui.fragments.profile.ProfileFragment;
import com.launchcenter.ui.fragments.report.ReportFragment;
import com.launchcenter.ui.fragments.settings.SettingsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {

    DrawerLayout drawer1 ;
    BottomNavigationView  bottomNavigationView;

    TextView navHelp, navLaunchPremium,navPremiumPosts,navPayment, navReport,navSignOut;
    ImageView newsFeedBtn;

   RelativeLayout frameBack;
   FrameLayout navigation_bottom_frame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        frameBack=findViewById(R.id.frameBack);

        bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setItemIconTintList(null);

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



      toggle.setDrawerIndicatorEnabled(false);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_side_menu, getTheme());
        toggle.setHomeAsUpIndicator(drawable);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerVisible(GravityCompat.START)) {
                    drawer.closeDrawer((GravityCompat.START));
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }

            }
        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //navigationView.getBackground().setColorFilter(0x80000000, PorterDuff.Mode.MULTIPLY);
        navigationView.setNavigationItemSelectedListener(this);

        drawer1 = (DrawerLayout) findViewById(R.id.drawer_layout);


        newsFeedBtn=(ImageView)findViewById(R.id.newsFeedBtn);

        navHelp=(TextView)findViewById(R.id.navHelp);
        navLaunchPremium=(TextView)findViewById(R.id.navLaunchPremium);
        navPremiumPosts=(TextView)findViewById(R.id.navPremiumPosts);
        navPayment=(TextView)findViewById(R.id.navPayment);
        navReport=(TextView)findViewById(R.id.navReport);
        navSignOut=(TextView)findViewById(R.id.navSignOut);


        navHelp.setOnClickListener(this);
        navPremiumPosts.setOnClickListener(this);
        navLaunchPremium.setOnClickListener(this);
        navPayment.setOnClickListener(this);
        navReport.setOnClickListener(this);
        navSignOut.setOnClickListener(this);
        newsFeedBtn.setOnClickListener(this);

    }



    private void initViews()
    {
        navigation_bottom_frame=findViewById(R.id.navigation_bottom_frame);
        navigation_bottom_frame.setVisibility(View.VISIBLE);

        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
        BottomNavigationView navigation = findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, new HomeFragment(), null).commit();

    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    newsFeedBtn.setVisibility(View.VISIBLE);
                    navigation_bottom_frame.setVisibility(View.VISIBLE);

                    FragmentManager fm = MainActivity.this.getSupportFragmentManager();
                    for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
                        fm.popBackStack();
                    }
                    fragment = new HomeFragment();
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
                    return true;
                case R.id.navigation_explore:
                    newsFeedBtn.setVisibility(View.GONE);
                    navigation_bottom_frame.setVisibility(View.VISIBLE);

                    fragment = new ExploreFragment();
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment, null).commit();
                    return true;
                case R.id.navigation_my_booking:
                    newsFeedBtn.setVisibility(View.GONE);
                    navigation_bottom_frame.setVisibility(View.VISIBLE);

                    fragment = new MyBookingsFragment();
                      getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment, null).commit();
                    return true;

                case R.id.navigation_settings:
                    newsFeedBtn.setVisibility(View.GONE);
                    navigation_bottom_frame.setVisibility(View.VISIBLE);

                    fragment = new SettingsFragment();
                   MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment, null).commit();
                    return true;

                case R.id.navigation_profile:
                    newsFeedBtn.setVisibility(View.GONE);
                    navigation_bottom_frame.setVisibility(View.VISIBLE);

                    fragment = new ProfileFragment();
                    MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment, null).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_chat) {
            newsFeedBtn.setVisibility(View.GONE);
            navigation_bottom_frame.setVisibility(View.VISIBLE);
            ChatHistoryFragment chatHistoryFragment = new ChatHistoryFragment();
            MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, chatHistoryFragment, null).commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        Fragment fragment;

        switch (v.getId()) {
            case R.id.navHelp:
                newsFeedBtn.setVisibility(View.GONE);
                navigation_bottom_frame.setVisibility(View.VISIBLE);

                fragment = new HelpFragment();
                MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
                break;
            case R.id.navReport:
                newsFeedBtn.setVisibility(View.GONE);
                navigation_bottom_frame.setVisibility(View.VISIBLE);

                fragment = new ReportFragment();
                MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
                break;
            case R.id.navPayment:
                newsFeedBtn.setVisibility(View.GONE);
                navigation_bottom_frame.setVisibility(View.VISIBLE);

                fragment = new PaymentsFragment();
                MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
                break;
            case R.id.navPremiumPosts:
                newsFeedBtn.setVisibility(View.GONE);
                navigation_bottom_frame.setVisibility(View.VISIBLE);

                fragment = new PremiumPostsFragment();
                MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
                break;
            case R.id.navLaunchPremium:
              /*  newsFeedBtn.setVisibility(View.GONE);
                navigation_bottom_frame.setVisibility(View.VISIBLE);

                fragment = new LaunchPremiumFragment();
                MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
                */
                break;

            case R.id.newsFeedBtn:
                newsFeedBtn.setVisibility(View.GONE);
                navigation_bottom_frame.setVisibility(View.VISIBLE);

                fragment = new NewsFeedFragment();
                MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
                break;

            default:
                break;
        }



        if (drawer1.isDrawerVisible(GravityCompat.START)) {
            drawer1.closeDrawer((GravityCompat.START));
        }
    }



    @Override
    public void onBackPressed() {
        int stackCount = getSupportFragmentManager().getBackStackEntryCount();
        if (stackCount == 0) {
            Fragment f = getSupportFragmentManager().findFragmentById(R.id.frame_container);
            if (f instanceof HomeFragment) {
                super.onBackPressed();

            }else{
                newsFeedBtn.setVisibility(View.VISIBLE);
                navigation_bottom_frame.setVisibility(View.VISIBLE);

                HomeFragment fragment = new HomeFragment();
                MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, fragment).commit();
            }

        } else {

            super.onBackPressed();
        }
    }



}