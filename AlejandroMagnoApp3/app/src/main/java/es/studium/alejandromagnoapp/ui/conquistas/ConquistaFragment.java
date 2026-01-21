package es.studium.alejandromagnoapp.ui.conquistas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.studium.alejandromagnoapp.R;
import es.studium.alejandromagnoapp.databinding.FragmentConquistasBinding;

public class ConquistaFragment extends Fragment {

    private FragmentConquistasBinding binding;
    private ConquistaViewModel conquistaViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inicializamos el ViewModel
        conquistaViewModel = new ViewModelProvider(this).get(ConquistaViewModel.class);

        // Inflamos el binding
        binding = FragmentConquistasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Pasamos el texto del strings.xml al ViewModel
        conquistaViewModel.setText(getString(R.string.text_conquista));

        // Observamos el LiveData y actualizamos el TextView automáticamente
        final TextView textView = binding.textConquista;
        conquistaViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
