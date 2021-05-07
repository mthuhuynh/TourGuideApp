package funix.prm.tourguideapp.detail;

import android.app.Application;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import funix.prm.tourguideapp.R;
import funix.prm.tourguideapp.model.Location;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationDetailFragment extends Fragment {


    public LocationDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_detail, container, false);

        final ImageView locationImageView = view.findViewById(R.id.detail_location_image_view);
        final TextView locationNameTextView = view.findViewById(R.id.detail_location_name_text_view);

        Application application = Objects.requireNonNull(getActivity()).getApplication();
        Location location = LocationDetailFragmentArgs.fromBundle(Objects.requireNonNull(getArguments())).getDetailFragmentArgs();
        DetailFragmentViewModelFactory factory = new  DetailFragmentViewModelFactory(application, location);
        DetailFragmentViewModel viewModel = ViewModelProviders.of(this, factory).get(DetailFragmentViewModel.class);

        viewModel.getSelectedLocation().observe(this, new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                locationImageView.setImageResource(location.getLocationImage());
                locationNameTextView.setText(location.getLocationName());
            }
        });

        return view;
    }

}
