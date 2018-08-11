package com.example.annis.apps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.annis.apps.modal.AdapterSungai;

import java.util.ArrayList;
import java.util.List;

public class Home extends Fragment {
//    private ViewPager viewPager;
//    private TabLayout tabLayout;
//    private Toolbar toolbar;
//    private ActionBar actionBar;
//    ImageView foto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setTitle("Halaman Utama");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_home, container, false);
        return rootView;
    }

    // SETUP VIEW PAGER
//    private void setupViewPager(ViewPager viewPager) {
//    viewPagerAdapter adapter = new viewPagerAdapter(getActivity().getSupportFragmentManager());
//        adapter.addFragment(new Sungai(), "Sungai");
//        adapter.addFragment(new Monitoring(), "Monitoring");
//        viewPager.setAdapter(adapter);
//    }
//
////    Buat Kelas
//    class viewPagerAdapter extends FragmentPagerAdapter {
//        private final List<Fragment> mFragmenlist = new ArrayList<>();
//        private final List<String> mFragmenstring = new ArrayList<>();
//
//        public viewPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return mFragmenlist.get(position);
//        }
//
//        public void addFragment(Fragment fragment, String judul) {
//            mFragmenlist.add(fragment);
//            mFragmenstring.add(judul);
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mFragmenstring.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragmenlist.size();
//        }
//    }

}
