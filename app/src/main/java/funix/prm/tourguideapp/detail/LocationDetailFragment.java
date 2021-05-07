package funix.prm.tourguideapp.detail;

import android.app.Application;
import android.os.Bundle;
import android.content.Context;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import funix.prm.tourguideapp.R;
import funix.prm.tourguideapp.detail.dummy.DummyContent;
import funix.prm.tourguideapp.model.Location;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationDetailFragment extends Fragment {
    //list
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    public LocationDetailFragment() {
        // Required empty public constructor
    }

    public static LocationDetailFragment newInstance(int columnCount) {
        LocationDetailFragment fragment = new LocationDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_location_detail, container, false);

        final ImageView locationImageView = view.findViewById(R.id.detail_location_image_view);
        final TextView locationNameTextView = view.findViewById(R.id.detail_location_name_text_view);

        Application application = requireActivity().getApplication();
        Location location = LocationDetailFragmentArgs.fromBundle(requireArguments()).getDetailFragmentArgs();
        DetailFragmentViewModelFactory factory = new  DetailFragmentViewModelFactory(application, location);
        DetailFragmentViewModel viewModel = ViewModelProviders.of(this, factory).get(DetailFragmentViewModel.class);

        viewModel.getSelectedLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                locationImageView.setImageResource(location.getLocationImage());
                locationNameTextView.setText(location.getLocationName());
            }
        });

        //list
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new AddressRecyclerViewAdapter(DummyContent.ITEMS));
        }

        return view;
    }

}
