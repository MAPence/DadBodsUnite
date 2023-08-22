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

        // Create a list of items (replace this with your actual data)
        List<MenuItem> itemList = createItemList();

        itemAdapter = new ItemAdapter(itemList); // Initialize the adapter with the list
        recyclerView.setAdapter(itemAdapter);

        builder.setView(view);

        return builder.create();
    }

    // Method to create a sample list of items (replace this with your actual data)
    private List<MenuItem> createItemList() {
        // Create and return a list of items
    }
}
