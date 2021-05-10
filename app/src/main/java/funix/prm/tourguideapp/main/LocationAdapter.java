package funix.prm.tourguideapp.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import funix.prm.tourguideapp.R;
import funix.prm.tourguideapp.model.Location;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.LocationViewHolder> {

    private final Context mContext;
    private final List<Location> mLocationList;
    private final LocationAdapterListener mListener;

    /**
     * Constructor for our adapter class
     */
    LocationAdapter(Context context, List<Location> locationList, LocationAdapterListener listener) {
        this.mContext = context;
        this.mLocationList = locationList;
        this.mListener = listener;
    }

    /**
     * The interface that receives onClick listener.
     */
    public interface LocationAdapterListener {
        void onLocationSelected(Location location, View view);
    }

    /**
     * Children views for location data
     */
    class LocationViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mLocationImageView;
        private final TextView mLocationNameTextView;

        LocationViewHolder(@NonNull final View itemView) {
            super(itemView);
            mLocationImageView = itemView.findViewById(R.id.location_image_item_view);
            mLocationNameTextView = itemView.findViewById(R.id.location_name_text_item_view);

            itemView.setOnClickListener(view -> mListener.onLocationSelected(mLocationList.get(getAbsoluteAdapterPosition()), itemView));
        }
    }

    /**
     * Called when RecyclerView needs a new {@link LocationViewHolder} of the given type to represent
     * an item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_location, parent, false);
        return new LocationViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link LocationViewHolder#itemView} to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        Location location = mLocationList.get(position);
        holder.mLocationImageView.setImageResource(location.getLocationImage());
        holder.mLocationNameTextView.setText(location.getLocationName());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mLocationList.size();
    }
}

