package com.example.beroepsproduct4.schermen.wooncentrum;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.beroepsproduct4.R;
import com.example.beroepsproduct4.database.DataDBHelper;
import com.example.beroepsproduct4.model.Zorgcentrum;
import com.example.beroepsproduct4.util.ZorcentrumArrayAdapter;

import java.util.ArrayList;


public class WooncentrumListFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_wooncentrum_list, container, false);
        ListView lvBsn = v.findViewById(R.id.lvZorgcentrum);
        DataDBHelper dbHelper = new DataDBHelper(v.getContext());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select afdeling,zorgcentrum from zorgcentrums";
        Cursor cur_beheerder = db.rawQuery(sql, null);
        ArrayList<Zorgcentrum> alZorgcentrums = new ArrayList<>();
        if (cur_beheerder.moveToFirst()) {
            do {
                Zorgcentrum zorgcentrum = new Zorgcentrum();
                zorgcentrum.setAfdeling(cur_beheerder.getString(0));
                zorgcentrum.setZorgcentrum(cur_beheerder.getString(1));
                alZorgcentrums.add(zorgcentrum);
            } while (cur_beheerder.moveToNext());
            db.close();
        }
        ArrayAdapter<Zorgcentrum> zorgcentrumArrayAdapter = new ZorcentrumArrayAdapter(v.getContext(), R.layout.zorgcentrum_list_adapter, alZorgcentrums);
        lvBsn.setAdapter(zorgcentrumArrayAdapter);
//        lvBsn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
//                Beheerder f = (Beheerder) parent.getItemAtPosition(i);
//                FragmentManager fragmentManager = getParentFragmentManager();
//                Fragment fragment = fragmentManager.findFragmentById(R.id.InsertBeperking);
//                ((InsertBeperkingFragment)fragment).fillInfo(f);
//            }
//        });
        return v;





    }
}