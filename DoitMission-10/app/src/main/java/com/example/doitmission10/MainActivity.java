package com.example.doitmission10;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.doitmission10.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentMenu1 fragment1;
    FragmentMenu2 fragment2;
    FragmentMenu3 fragment3;

    ViewPager pager;

    DrawerLayout drawer;
    Toolbar toolbar;

    BottomNavigationView bottomNavigation;
    private MenuItem prevBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(3);

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragment1 = new FragmentMenu1(); adapter.addItem(fragment1);
        fragment2 = new FragmentMenu2(); adapter.addItem(fragment2);
        fragment3 = new FragmentMenu3(); adapter.addItem(fragment3);

        pager.setAdapter(adapter);
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevBottomNavigation != null) {
                    prevBottomNavigation.setChecked(false);
                }
                prevBottomNavigation = bottomNavigation.getMenu().getItem(position);
                prevBottomNavigation.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(), "첫 번째 탭 선택됨", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(0);
                        return true;
                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(), "두 번째 탭 선택됨", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(1);
                        return true;
                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "세 번째 탭 선택됨", Toast.LENGTH_LONG).show();
                        pager.setCurrentItem(3);
                        return true;
                }

                return false;
            }
        });


    }

    @Override
    //시스템 [BACK] 키를 눌렀을 때
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            //바로가기 메뉴가 열려있을 경유
            drawer.closeDrawer(GravityCompat.START); //바로가기 메뉴 닫기
        } else {
            super.onBackPressed();
        }
    }

    @Override
    //바로가기 메뉴의 아이템이 눌렸을 때
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_menu1) {
            Toast.makeText(this, "첫번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            pager.setCurrentItem(0);

        } else if (id == R.id.nav_menu2) {
            Toast.makeText(this, "두번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            pager.setCurrentItem(1);
        } else if (id == R.id.nav_menu3) {
            Toast.makeText(this, "세번째 메뉴 선택됨.", Toast.LENGTH_LONG).show();
            pager.setCurrentItem(2);
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {
        ArrayList<Fragment> items = new ArrayList<Fragment>(); //프래그먼트를 담아둘 객체

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addItem(Fragment item) {
            //프래그먼트 추가하기
            items.add(item);
        }

        @Override
        public Fragment getItem(int position) {
            //프래그먼트 가져가기
            return items.get(position);
        }

        @Override
        public int getCount() {
            //프래그먼트 갯수 확인
            return items.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //타이틀스크립 설정
            return "페이지 " + position;
        }
    }



}