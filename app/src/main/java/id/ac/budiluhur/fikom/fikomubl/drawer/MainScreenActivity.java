package id.ac.budiluhur.fikom.fikomubl.drawer;


import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import id.ac.budiluhur.fikom.fikomubl.R;
import id.ac.budiluhur.fikom.fikomubl.fragments.BrochureFragment;
import id.ac.budiluhur.fikom.fikomubl.fragments.ContactFragment;
import id.ac.budiluhur.fikom.fikomubl.fragments.HomeFragment;
import id.ac.budiluhur.fikom.fikomubl.fragments.LocationFragment;
import id.ac.budiluhur.fikom.fikomubl.fragments.VisiMisiFragment;

public class MainScreenActivity extends AppCompatActivity {
    private Handler mHandler;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    Toolbar toolbar;
    TextView toolbar_title;
    // index current nav menu item
    public static int navItemIndex = 0;

    // tags fragments
    private static final String TAG_HOME = "home";
    private static final String TAG_VM = "fimi";
    private static final String TAG_LOC = "location";
    private static final String TAG_BRO = "brochure";
    private static final String TAG_CON = "contact";
    public static String CURRENT_TAG = TAG_HOME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setTitle(null);
        toolbar_title = (TextView)findViewById(R.id.toolbar_title);
        toolbar_title.setText("HOME");
        //Typeface tf = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/Montserrat-Bold.otf");
        //setSupportActionBar(toolbar);

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    private void loadHomeFragment() {
        selectNavMenu();

        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();
            return;
        }

        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private void setUpNavigationView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.nav_fimi:
                        navItemIndex=1;
                        CURRENT_TAG = TAG_VM;
                        break;
                    case R.id.nav_location:
                        navItemIndex=2;
                        CURRENT_TAG = TAG_LOC;
                        break;
                    case R.id.nav_brochure:
                        navItemIndex=3;
                        CURRENT_TAG = TAG_BRO;
                        break;
                    case R.id.nav_contact:
                        navItemIndex=4;
                        CURRENT_TAG = TAG_CON;
                        break;
                    default:
                        navItemIndex = 0;
                }

                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                item.setChecked(true);

                loadHomeFragment();

                return false;
            }
        });
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex){
            case 0:
                toolbar_title.setText("HOME");
                return new HomeFragment();
            case 1:
                toolbar_title.setText("VISI & MISI");
                return new VisiMisiFragment();
            case 2:
                toolbar_title.setText("LOCATION");
                return new LocationFragment();
            case 3:
                toolbar_title.setText("PROGRAM SELECTION");
                return new BrochureFragment();
            case 4:
                toolbar_title.setText("CONTACT");
                return new ContactFragment();
            default:
                toolbar_title.setText("HOME");
                return new HomeFragment();
        }
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (navItemIndex!=0){
            navItemIndex = 0;
            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainScreenActivity.this);
            builder.setMessage("Apakah anda yakin ingin keluar?");
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            builder.setNegativeButton("Tidak", null);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
}
