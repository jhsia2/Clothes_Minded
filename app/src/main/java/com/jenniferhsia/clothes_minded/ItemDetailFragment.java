package com.jenniferhsia.clothes_minded;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jenniferhsia.clothes_minded.ListContent;

import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Item mItem;

    private List<String> bioList = new ArrayList<String>();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bioList.add("Cotton");
        bioList.add("Linen");
        bioList.add("Hemp");
        bioList.add("Bamboo");
        bioList.add("Rayon");
        bioList.add("Lyocell");
        bioList.add("Wool");
        bioList.add("Cashmere");
        bioList.add("Silk");

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = ListContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.name); //title page
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            StringBuilder builder = new StringBuilder();
            builder.append("\nSize: " + mItem.size);
            builder.append("\nColor: " + mItem.color);
            builder.append("\nOriginal price: $" + mItem.price);
            builder.append("\nMaterials: ");
            Map<String, Float> composition = mItem.composition;
            Iterator<Map.Entry<String,Float>> itr = composition.entrySet().iterator();
            float biopercent = 0.0f;
            while(itr.hasNext())
            {
                Map.Entry<String, Float> entry = itr.next();
                String key = entry.getKey();
                float value = entry.getValue();
                //if (key.equals("Cotton")|| key.equals("Wool"))
                if (bioList.contains(key))
                {
                    biopercent += value;
                }
                builder.append("\n     "+key +
                        " " + value + "%");
            }

            builder.append("\nBiodegradable: "+biopercent+"%");
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(builder.toString());
        }

        return rootView;
    }
}
