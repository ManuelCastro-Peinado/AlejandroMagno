package es.studium.alejandromagnoapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.studium.alejandromagnoapp.R;
import es.studium.alejandromagnoapp.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private GalleryViewModel galleryViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Inicializamos el ViewModel
        galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);

        // Inflamos el binding
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Pasamos el texto del strings.xml al ViewModel
        galleryViewModel.setText(getString(R.string.text_gallery));

        // Observamos el LiveData y actualizamos el TextView automáticamente
        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}