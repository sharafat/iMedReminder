package com.cryptic.imed.activity.medicine;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.LinearLayout;
import com.cryptic.imed.R;
import com.cryptic.imed.fragment.medicine.MedicineDetailsFragment;
import com.cryptic.imed.fragment.medicine.MedicineListFragment;
import roboguice.activity.RoboFragmentActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

import javax.annotation.Nullable;

/**
 * @author sharafat
 */
@ContentView(R.layout.list)
public class MedicineListActivity extends RoboFragmentActivity {
    @InjectView(R.id.details_container)
    @Nullable
    private LinearLayout detailsContainer;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addMedicineListFragmentToLayout();
    }

    private void addMedicineListFragmentToLayout() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        if (detailsContainer != null) {     //dual pane
            MedicineDetailsFragment medicineDetailsFragment = new MedicineDetailsFragment();
            fragmentTransaction.add(R.id.details_container, medicineDetailsFragment);
        }

        MedicineListFragment medicineListFragment = new MedicineListFragment();
        fragmentTransaction.add(R.id.list_container, medicineListFragment);

        fragmentTransaction.commit();
    }
}
