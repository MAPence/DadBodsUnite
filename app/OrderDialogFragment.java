import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;  // Import for List

public class OrderDialogFragment extends DialogFragment {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_order_dialog, null);

        recyclerView = view.findViewById(R.id.itemRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<MenuItem> itemList = createItemList();

        itemAdapter = new ItemAdapter(requireContext(), itemList);
        recyclerView.setAdapter(itemAdapter);

        builder.setView(view);

        return builder.create();
    }

    // Method to create a list of items (replace this with your actual data)
    private List<MenuItem> createItemList() {
        // Create and return a list of items
        // For example:
        List<MenuItem> itemList = new ArrayList<>();
        itemList.add(new MenuItem("Item 1", 10.0));
        itemList.add(new MenuItem("Item 2", 15.0));
        // ... add more items
        return itemList;
    }
}

