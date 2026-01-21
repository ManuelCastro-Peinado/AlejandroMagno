package es.studium.alejandromagnoapp.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.studium.alejandromagnoapp.R;
import es.studium.alejandromagnoapp.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    private SlideshowViewModel slideshowViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inicializamos el ViewModel
        slideshowViewModel = new ViewModelProvider(this).get(SlideshowViewModel.class);

        // Inflamos el binding
        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Pasamos el texto del strings.xml al ViewModel
        slideshowViewModel.setText(getString(R.string.text_slideshow));

        // Observamos el LiveData y actualizamos el TextView automáticamente
        final TextView textView = binding.textSlideshow;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
