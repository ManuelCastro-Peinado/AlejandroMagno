package es.studium.alejandromagnoapp.ui.legado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.studium.alejandromagnoapp.R;
import es.studium.alejandromagnoapp.databinding.FragmentLegadoBinding;

public class LegadoFragment extends Fragment {

    private FragmentLegadoBinding binding;
    private LegadoViewModel legadoViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inicializamos el ViewModel
        legadoViewModel = new ViewModelProvider(this).get(LegadoViewModel.class);

        // Inflamos el binding
        binding = FragmentLegadoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Pasamos el texto del strings.xml al ViewModel
        legadoViewModel.setText(getString(R.string.text_legado));

        // Observamos el LiveData y actualizamos el TextView automáticamente
        final TextView textView = binding.textLegado;
        legadoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
